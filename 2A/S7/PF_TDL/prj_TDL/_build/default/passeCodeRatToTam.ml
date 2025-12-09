(* Module de la passe de génération de code *)
(* doit être conforme à l'interface Passe *)
open Tds
open Exceptions
open Ast
open Type
open Tam
open Code
open List

type t1 = Ast.AstPlacement.programme
type t2 = string

(* Helper function to concatenate list of strings with newline *)
let concat_with_newline lst =
  String.concat "\n" lst



let rec analyse_code_affectable a modif =
  match a with
  |AstType.Ident ia -> 
    begin
      match info_ast_to_info  ia with 
      |InfoVar(_, t, dep,reg) ->
        let taille_type =  getTaille t in 
        if modif then store taille_type dep reg
      else load taille_type dep reg
            | InfoGlobal (_, t, dep) ->
          let taille_type = getTaille t in
          if modif then store taille_type dep "SB"
          else load taille_type dep "SB"
      |InfoConst (_,n) -> loadl_int n 
      |_ -> failwith"error"
      end
  | AstType.Deref aff -> 
    begin 
      (* Générer le code pour accéder à l'adresse du pointeur *)
      let code_aff = analyse_code_affectable aff false in
      (* Récupérer la taille en analysant récursivement l'affectable *)
      let rec get_taille_affectable aff =
        match aff with
        | AstType.Ident ia -> 
          begin
            match info_ast_to_info ia with
            | InfoVar(_, t, _, _) -> getTaille t
            | _ -> failwith "Erreur : Type non supporté pour Ident dans Deref"
          end
        | AstType.Deref aff_nested -> 
          (* Continuer à descendre dans l'arbre *)
          get_taille_affectable aff_nested
      in
      let taille_type = get_taille_affectable aff in
      if modif then 
        code_aff ^ (storei taille_type)
      else 
        code_aff ^ (loadi taille_type)
    end
(* Expression code generation *)
and analyse_code_expression e =
  match e with
  | AstType.Affectable a ->
    let code = analyse_code_affectable a false in code
  | AstType.Null -> loadl_int (-1)
  | AstType.New t ->
    let t = getTaille t in (loadl_int t) ^ (subr "Malloc")
  | AstType.Adresse a -> 
    begin 
      match info_ast_to_info a with 
          | InfoVar(_,t,dep,reg)-> loada dep reg
          |_-> failwith "err"
    end
  | AstType.Entier n ->
      loadl_int n
  | AstType.Unaire (op, ex) ->
      let ne = analyse_code_expression ex in
      (match op with
      | AstType.Numerateur -> ne ^ pop 0 1
      | AstType.Denominateur -> ne ^ pop 1 1)
  | AstType.Binaire (b, e1, e2) ->
      let ne1 = analyse_code_expression e1 in
      let ne2 = analyse_code_expression e2 in
      (match b with
      | AstType.Fraction -> ne1 ^ ne2 ^ call "SB" "Norm"
      | AstType.PlusInt -> ne1 ^ ne2 ^ subr "IAdd"
      | AstType.PlusRat -> ne1 ^ ne2 ^ call "SB" "RAdd"
      | AstType.MultInt -> ne1 ^ ne2 ^ subr "IMul"
      | AstType.MultRat -> ne1 ^ ne2 ^ call "SB" "RMul"
      | AstType.EquInt -> ne1 ^ ne2 ^ subr "IEq"
      | AstType.EquBool -> ne1 ^ ne2 ^ subr "IEq"
      | AstType.Inf -> ne1 ^ ne2 ^ subr "ILss")
  | AstType.Booleen n ->
      (match n with
      | false -> loadl_int 0
      | true -> loadl_int 1)
  | AstType.AppelFonction (ia, le) ->
    let rec analyse_code_parametres params =
      match params with
      | [] -> ""
      | t::q -> analyse_code_expression t ^ analyse_code_parametres q
    in
    let code_parametres = analyse_code_parametres le in
    (match info_ast_to_info ia with
    | InfoFun (nom, _, _) -> 
        code_parametres ^ call "LB" nom 
    | _ -> raise (MauvaiseUtilisationIdentifiant "Idk"))

  | _ -> failwith "Unhandled case in match expression"

  let analyse_code_vglobales vglobales =
    List.map (fun (AstPlacement.Globale (info, expr, addr)) ->
      match info_ast_to_info info with
      | InfoGlobal (_, t, _) ->
          let code_init = analyse_code_expression expr in
          let taille = getTaille t in
          (* Générer le code TAM pour l'initialisation de la variable globale *)
          code_init ^ store taille addr "SB"
      | _ -> failwith "Erreur interne : InfoGlobal attendu"
    ) vglobales
    |> concat_with_newline
  

(* Instruction code generation *)
let rec analyse_code_instruction i =
  begin
  match i with
  | AstPlacement.Declaration (info, e) ->
      let ne = analyse_code_expression e in
      (match info_ast_to_info info with
      | InfoVar (_, t, depl, reg) -> push (getTaille t) ^ ne ^ store (getTaille t) depl reg
      | _ -> raise (MauvaiseUtilisationIdentifiant "Invalid variable declaration"))
  | AstPlacement.Affectation (a, e) ->
      let ne = analyse_code_expression e in
      let na = analyse_code_affectable a true in ne ^ na 
  | AstPlacement.AffichageInt e -> 
      let ne = analyse_code_expression e in
      ne ^ subr "Iout"
  | AstPlacement.AffichageRat e -> 
      let ne = analyse_code_expression e in
      ne ^ call "SB" "Rout"
  | AstPlacement.AffichageBool e -> 
      let ne = analyse_code_expression e in
      ne ^ subr "Bout"
  | AstPlacement.TantQue (c, b) ->
      let debut = getEtiquette() in
      let fin = getEtiquette() in
      let ne = analyse_code_expression c in
      let nb = analyse_code_bloc  b  in
      label debut ^ ne ^ jumpif 0 fin ^ nb ^ jump debut ^ label fin
  | AstPlacement.Conditionnelle (c, t, e) ->
      let nc = analyse_code_expression c in
      let nt = analyse_code_bloc t  in
      let ne = analyse_code_bloc e  in
      let sinon = getEtiquette() in
      let fin = getEtiquette() in
      nc ^ jumpif 0 sinon ^ nt ^ jump fin ^ label sinon ^ ne ^ label fin
  | AstPlacement.Empty -> ""
  | AstPlacement.Retour(e,n,p) ->
    let ne = analyse_code_expression e  in
    ne^return n p 
  end
  and analyse_code_bloc(li, taille) =
  let nli = List.map analyse_code_instruction li in
  let r = concat_with_newline nli in
  r ^ pop 0 taille

 let analyse_code_fonction (AstPlacement.Fonction (info, _, (li,_))) =
  begin 
    let nli = List.map analyse_code_instruction li in
    let r = concat_with_newline nli in
    match info_ast_to_info info with 
    |InfoFun(nom,_,_)-> label nom ^ r ^ halt 
    |_-> raise(MauvaiseUtilisationIdentifiant"idk")
  end
  
let analyser (AstPlacement.Programme (vars,fonctions, prog)) =
  let code_globales = analyse_code_vglobales vars in
  let nfonctions = List.map analyse_code_fonction fonctions in
  let r = concat_with_newline nfonctions in  
  getEntete () ^ code_globales ^ r ^ label "main" ^ analyse_code_bloc prog ^ halt





    

    

    









      
