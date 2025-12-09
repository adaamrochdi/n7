(* Module de la passe de placement mémoire *)
(* doit être conforme à l'interface Passe *)
open Tds
open Exceptions
open Ast
open Type

type t1 = Ast.AstType.programme
type t2 = Ast.AstPlacement.programme

let get_type ia =
  match info_ast_to_info ia with
  | InfoVar (_, typ, _, _) -> typ
  | InfoFun (_, typ, _) -> typ
  | _ -> raise (MauvaiseUtilisationIdentifiant "Type non défini pour cet identifiant")

let somme_tailles liste_types =
  List.fold_left (fun acc typ -> acc + getTaille typ) 0 liste_types

let analyse_placement_vglobales vars base_depl =
  let rec aux vars depl =
    match vars with
    | [] -> ([], depl)
    | AstType.Globale (info, expr) :: q ->
        begin
          match info_ast_to_info info with
          | InfoGlobal (_, typ, _) ->
              let taille = getTaille typ in
              let _ = modifier_adresse_variable depl "SB" info in
              let nvar = AstPlacement.Globale (info, expr, depl) in
              let (nvars, ndepl) = aux q (depl + taille) in
              (nvar :: nvars, ndepl)
          | _ -> failwith "Une variable globale doit être de type InfoGlobal"
        end
  in
  aux vars base_depl



let rec analyse_placement_instruction i depl reg = 
  match i with 
  |AstType.Declaration(info,e) -> 
    begin 
      match info_ast_to_info info with
      |InfoVar(_,t,_,_)-> modifier_adresse_variable depl reg info;
      (AstPlacement.Declaration(info,e),getTaille t)
      |_->raise(MauvaiseUtilisationIdentifiant "idk" )
    end
  |AstType.Conditionnelle(c,t,e)->
    begin 
      let nt = analyse_placement_bloc t depl reg in 
      let ne = analyse_placement_bloc e depl reg in
      (AstPlacement.Conditionnelle(c,nt,ne),0)
    end 
  |AstType.TantQue(c,b)->
    begin 
      let nb = analyse_placement_bloc b depl reg in 
      (AstPlacement.TantQue(c,nb),0)
    end 
  |AstType.Affectation(a,e)-> (AstPlacement.Affectation(a,e),0)
  |AstType.AffichageInt e -> (AstPlacement.AffichageInt(e),0)
  |AstType.AffichageBool e -> (AstPlacement.AffichageBool(e),0)
  |AstType.AffichageRat e -> (AstPlacement.AffichageRat(e),0)
  |AstType.Empty -> (AstPlacement.Empty,0)
  |AstType.Retour(e,ia)-> 
    begin 
      match info_ast_to_info ia with 
      |InfoFun(_,tr,t)->(AstPlacement.Retour(e,getTaille(tr),somme_tailles(t)),0)
      |_->raise(MauvaiseUtilisationIdentifiant "idk")
    end
and  analyse_placement_bloc li depl reg = 
    begin
      match li with
      |[]->([],0)
      | t :: q ->
        let (ni, ti) = analyse_placement_instruction t depl reg in
        let (nq, tq) = analyse_placement_bloc q (depl + ti) reg in
        (ni :: nq, ti + tq) 
    end 


let analyse_placement_param dep ia =
  let t = getTaille (get_type ia) in
  let ndep = dep - t in
  let _ = modifier_adresse_variable ndep "LB" ia in
  ndep
 let analyse_placement_params dep lp =
    let _ = List.fold_left analyse_placement_param dep lp in
    ()
let rec analyse_placement_fonction (AstType.Fonction (info, lp, li)) =
  analyse_placement_params 0 (List.rev lp);
  let nb =analyse_placement_bloc li 3 "LB" in 
  AstPlacement.Fonction (info, lp, nb)


 
    

  let analyser (AstType.Programme (vars, fonctions, prog)) =
    let (nvars, base_depl) = analyse_placement_vglobales vars 0 in
    let nlf = List.map analyse_placement_fonction fonctions in
    let nb = analyse_placement_bloc prog base_depl "SB" in
    AstPlacement.Programme (nvars, nlf, nb)
  


