(* Module de la passe de typage *)
(* doit être conforme à l'interface Passe *)
open Tds
open Exceptions
open Ast
open Type

type t1 = Ast.AstTds.programme
type t2 = Ast.AstType.programme




let rec  analyse_type_affectable a =
  match a with 
  |AstTds.Ident info -> 
    begin
      match (info_ast_to_info info) with
      | InfoVar(_,t,_,_) -> (AstType.Ident(info),t)
      | InfoConst _ -> (AstType.Ident(info),Int)
      | InfoGlobal(_, t, _) -> (AstType.Ident(info), t) 
      | _ -> failwith ("Internal error")
    end
  |AstTds.Deref aff -> 
    begin
      let (naff,t) = analyse_type_affectable aff in
      match t with
      |Pointeur tp -> (AstType.Deref naff,tp)
      | _ ->  raise (TypeInattendu (t,Pointeur Undefined))
    end
and analyse_type_expression = function
  | AstTds.Affectable a ->
      begin
        let (na,t) = analyse_type_affectable a in (AstType.Affectable na,t)
      end
  | AstTds.Binaire (f, e1, e2) ->
      let (ne1, te1) = analyse_type_expression e1 in
      let (ne2, te2) = analyse_type_expression e2 in
      let determine_binaire_type f te1 te2 =
        match (f, te1, te2) with
        | AstSyntax.Fraction, Int, Int -> (AstType.Fraction, Rat)
        | AstSyntax.Plus, Int, Int -> (AstType.PlusInt, Int)
        | AstSyntax.Plus, Rat, Rat -> (AstType.PlusRat, Rat)
        | AstSyntax.Mult, Int, Int -> (AstType.MultInt, Int)
        | AstSyntax.Mult, Rat, Rat -> (AstType.MultRat, Rat)
        | AstSyntax.Equ, Int, Int -> (AstType.EquInt, Bool)
        | AstSyntax.Equ, Bool, Bool -> (AstType.EquBool, Bool)
        | AstSyntax.Inf, Int, Int -> (AstType.Inf, Bool)
        | _ -> raise (TypeBinaireInattendu (f, te1, te2))
      in
      let n_binaire, tr = determine_binaire_type f te1 te2 in
      (AstType.Binaire (n_binaire, ne1, ne2), tr)
  | AstTds.Unaire (u, e) ->
      let n_unaire = 
        match u with
        | AstSyntax.Numerateur -> AstType.Numerateur
        | AstSyntax.Denominateur -> AstType.Denominateur
      in
      let ne, te = analyse_type_expression e in
      if est_compatible te Rat 
      then (AstType.Unaire (n_unaire, ne), Int)
      else raise (TypeInattendu (te, Rat))
  | AstTds.Booleen b -> (AstType.Booleen b, Bool)
  | AstTds.Entier n -> (AstType.Entier n, Int)
  | AstTds.AppelFonction (s, args) ->
      begin
        match info_ast_to_info s with
      | InfoFun (_, t, typl) ->
          let args_analyzes = List.map analyse_type_expression args in
          let fl = List.map fst args_analyzes in
          let sl = List.map snd args_analyzes in
          if est_compatible_list typl sl 
          then (AstType.AppelFonction (s, fl), t)
          else raise (TypesParametresInattendus (typl, sl))
      | _ -> raise (MauvaiseUtilisationIdentifiant "info")
      end 
      
  |AstTds.Null ->(AstType.Null,Pointeur (Undefined))
  |AstTds.New t -> (AstType.New t,Pointeur(t))
  |AstTds.Adresse info -> 
    begin 
      match info_ast_to_info info with 
      |InfoVar(_,t,_,_)->( AstType.Adresse(info),Pointeur t)
      |_-> raise(MauvaiseUtilisationIdentifiant"idk")
    end 
  
let analyse_type_vglobales vars =
  List.map (fun (AstTds.Globale (t, infog, expr)) ->
    let (ne, nt) = analyse_type_expression expr in
    if est_compatible t nt then
      let () = modifier_type_variable t infog in
      AstType.Globale (infog, ne)
    else
      raise (TypeInattendu (t, nt))
  ) vars
    

let rec analyse_type_instruction i = 
  match i with 
  | AstTds.Declaration (t, info, e) ->
      let (ne, nt) = analyse_type_expression e in
      if est_compatible t nt 
      then 
        let () = modifier_type_variable t info in
        AstType.Declaration (info, ne)
      else raise (TypeInattendu (nt, t))
  | AstTds.Affectation (a, e) ->
      let (ne, nt) = analyse_type_expression e in
      let (na,nta) = analyse_type_affectable a in
      begin
        if est_compatible nt nta
          then AstType.Affectation (na, ne)
          else raise (TypeInattendu (nt, nta))
      end
  | AstTds.Affichage e ->
      let (ne, nt) = analyse_type_expression e in
      begin
        match nt with
        | Int -> AstType.AffichageInt ne
        | Bool -> AstType.AffichageBool ne
        | Rat -> AstType.AffichageRat ne
        | _ -> raise (TypeInattendu (nt, nt))
      end
  | AstTds.TantQue (e, bloc) ->
      let (ne, nt) = analyse_type_expression e in
      if nt = Bool 
      then 
        let nbloc = analyse_type_bloc bloc in
        AstType.TantQue (ne, nbloc)
      else raise (TypeInattendu (nt, Bool))
  | AstTds.Conditionnelle (c, t, e) ->
      let (nc, nt) = analyse_type_expression c in
      if nt = Bool 
      then 
        let nt_bloc = analyse_type_bloc t in
        let ne_bloc = analyse_type_bloc e in
        AstType.Conditionnelle (nc, nt_bloc, ne_bloc)
      else raise (TypeInattendu (nt, Bool))
  | AstTds.Retour (e, ia) ->
    begin
     let (ne, nt) = analyse_type_expression e in
      match info_ast_to_info ia with
      |InfoFun(_,t,_)-> if est_compatible nt t then AstType.Retour (ne, ia)
      else raise (TypeInattendu(nt,t))
      |_-> raise(MauvaiseUtilisationIdentifiant"idk")
    end
  |AstTds.Empty -> Empty

and analyse_type_bloc li =
  List.map analyse_type_instruction li

let analyse_type_fonction (AstTds.Fonction (t, info, lp, li)) =
  let fl = List.map fst lp in
  let () = modifier_type_fonction t fl info in
  let nli = analyse_type_bloc li in
  let scd = List.map snd lp in
  AstType.Fonction (info, scd, nli)

let analyse_type_fonctions lf =
  List.map analyse_type_fonction lf

let analyser (AstTds.Programme (vars,fonctions, prog)) =
  let nvg = analyse_type_vglobales vars in
  let nf = analyse_type_fonctions fonctions in
  let nb = analyse_type_bloc prog in
  AstType.Programme (nvg,nf, nb)