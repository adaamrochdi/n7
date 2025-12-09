(* Module de la passe de gestion des identifiants *)
(* doit être conforme à l'interface Passe *)
open Tds
open Exceptions
open Ast

type t1 = Ast.AstSyntax.programme
type t2 = Ast.AstTds.programme

(* fhad l passe bdlt analyser dyal programme w zdt analyse_tds_vglobales*)
(*kadir map 3la ga3 les variables glob li kaynin w katshof wach kayna double declaration
w kat creer info dyalhom (b7al l code dyal declaration )*)



(* analyse_tds_expression : tds -> AstSyntax.expression -> AstTds.expression *)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre e : l'expression à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme l'expression
en une expression de type AstTds.expression *)
(* Erreur si mauvaise utilisation des identifiants *)
let rec analyse_tds_affectable tds  a modif=
  match a with
  (* Déférencement : on traite récursivement l'affectable pointé *)
  | AstSyntax.Deref a -> AstTds.Deref (analyse_tds_affectable tds a modif)

  (* Identifiant : on vérifie qu'il est déclaré et qu'il est de type approprié *)
  | AstSyntax.Ident n -> 
      begin 
      match chercherGlobalement tds n with
      | None -> raise (IdentifiantNonDeclare n)
      | Some info -> (
          match info_ast_to_info info with
          | InfoVar _ | InfoConst _ | InfoGlobal _->
              if modif && (match info_ast_to_info info with InfoConst _ -> true | _ -> false)
              then raise (MauvaiseUtilisationIdentifiant n)
              else AstTds.Ident(info)
          | _ -> raise (MauvaiseUtilisationIdentifiant n))
      end
and  analyse_tds_expression tds e =
  match e with 
  | AstSyntax.Binaire (b, e1, e2) ->
      let ne1 = analyse_tds_expression tds e1 in
      let ne2 = analyse_tds_expression tds e2 in
      AstTds.Binaire (b, ne1, ne2)
  | AstSyntax.Unaire (op, e1) -> 
      let ne = analyse_tds_expression tds e1 in
      AstTds.Unaire (op, ne)
  | AstSyntax.Booleen b -> 
      AstTds.Booleen b
  | AstSyntax.Entier n -> 
      AstTds.Entier n
  | AstSyntax.Affectable a-> AstTds.Affectable (analyse_tds_affectable tds a false )
  | AstSyntax.Null -> AstTds.Null 
  | AstSyntax.New t -> AstTds.New(t)
  | AstSyntax.Adresse n -> 
    begin 
      match chercherGlobalement tds n with 
      |None -> raise(IdentifiantNonDeclare n)
      |Some ia -> match info_ast_to_info ia with 
        |InfoVar _ -> AstTds.Adresse(ia)
        |_ -> raise(MauvaiseUtilisationIdentifiant "idk")
    end 

  | AstSyntax.AppelFonction (s, args) ->
    begin
      match chercherGlobalement tds s with
      | None ->
          raise (IdentifiantNonDeclare s)
      | Some info ->
          begin
            match info_ast_to_info info with
            | InfoFun _ ->
                let nargs = List.map (analyse_tds_expression tds) args in
                AstTds.AppelFonction (info, nargs)
            | _ ->
                raise (MauvaiseUtilisationIdentifiant s)
          end
    end


let analyse_tds_vglobales tds vars =
  List.map (fun (AstSyntax.Globale (t, nom, expr)) ->
    match chercherLocalement tds nom with
    | Some _ -> raise (DoubleDeclaration nom)
    | None ->
        let ne = analyse_tds_expression tds expr in
        let info_global = info_to_info_ast (InfoGlobal (nom,Undefined,0)) in
        ajouter tds nom info_global;
        AstTds.Globale (t, info_global, ne)
  ) vars


(* analyse_tds_instruction : tds -> info_ast option -> AstSyntax.instruction -> AstTds.instruction *)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre oia : None si l'instruction i est dans le bloc principal,
                   Some ia où ia est l'information associée à la fonction dans laquelle est l'instruction i sinon *)
(* Paramètre i : l'instruction à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme l'instruction
en une instruction de type AstTds.instruction *)
(* Erreur si mauvaise utilisation des identifiants *)
let rec analyse_tds_instruction tds oia i =
  match i with
  | AstSyntax.Declaration (t, n, e) ->
      begin
        match chercherLocalement tds n with
        | None ->
            (* L'identifiant n'est pas trouvé dans la tds locale,
            il n'a donc pas été déclaré dans le bloc courant *)
            (* Vérification de la bonne utilisation des identifiants dans l'expression *)
            (* et obtention de l'expression transformée *)
            let ne = analyse_tds_expression tds e in
            (* Création de l'information associée à l'identfiant *)
            let info = InfoVar (n,Undefined, 0, "") in
            (* Création du pointeur sur l'information *)
            let ia = info_to_info_ast info in
            (* Ajout de l'information (pointeur) dans la tds *)
            ajouter tds n ia;
            (* Renvoie de la nouvelle déclaration où le nom a été remplacé par l'information
            et l'expression remplacée par l'expression issue de l'analyse *)
            AstTds.Declaration (t, ia, ne)
        | Some _ ->
            (* L'identifiant est trouvé dans la tds locale,
            il a donc déjà été déclaré dans le bloc courant *)
            raise (DoubleDeclaration n)
      end
  | AstSyntax.Affectation (a,e) ->
      begin
        let na = analyse_tds_affectable tds  a true in
        let ne = analyse_tds_expression tds e in
        Affectation (na, ne)
      end
  | AstSyntax.Constante (n,v) ->
      begin
        match chercherLocalement tds n with
        | None ->
          (* L'identifiant n'est pas trouvé dans la tds locale,
             il n'a donc pas été déclaré dans le bloc courant *)
          (* Ajout dans la tds de la constante *)
          ajouter tds n (info_to_info_ast (InfoConst (n,v)));
          (* Suppression du noeud de déclaration des constantes devenu inutile *)
          AstTds.Empty
        | Some _ ->
          (* L'identifiant est trouvé dans la tds locale,
          il a donc déjà été déclaré dans le bloc courant *)
          raise (DoubleDeclaration n)
      end
  | AstSyntax.Affichage e ->
      (* Vérification de la bonne utilisation des identifiants dans l'expression *)
      (* et obtention de l'expression transformée *)
      let ne = analyse_tds_expression tds e in
      (* Renvoie du nouvel affichage où l'expression remplacée par l'expression issue de l'analyse *)
      AstTds.Affichage (ne)
  | AstSyntax.Conditionnelle (c,t,e) ->
      (* Analyse de la condition *)
      let nc = analyse_tds_expression tds c in
      (* Analyse du bloc then *)
      let tast = analyse_tds_bloc tds oia t in
      (* Analyse du bloc else *)
      let east = analyse_tds_bloc tds oia e in
      (* Renvoie la nouvelle structure de la conditionnelle *)
      AstTds.Conditionnelle (nc, tast, east)
  | AstSyntax.TantQue (c,b) ->
      (* Analyse de la condition *)
      let nc = analyse_tds_expression tds c in
      (* Analyse du bloc *)
      let bast = analyse_tds_bloc tds oia b in
      (* Renvoie la nouvelle structure de la boucle *)
      AstTds.TantQue (nc, bast)
  | AstSyntax.Retour (e) ->
      begin
      (* On récupère l'information associée à la fonction à laquelle le return est associée *)
      match oia with
        (* Il n'y a pas d'information -> l'instruction est dans le bloc principal : erreur *)
      | None -> raise RetourDansMain
        (* Il y a une information -> l'instruction est dans une fonction *)
      | Some ia ->
        (* Analyse de l'expression *)
        let ne = analyse_tds_expression tds e in
        AstTds.Retour (ne,ia)
      end


(* analyse_tds_bloc : tds -> info_ast option -> AstSyntax.bloc -> AstTds.bloc *)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre oia : None si le bloc li est dans le programme principal,
                   Some ia où ia est l'information associée à la fonction dans laquelle est le bloc li sinon *)
(* Paramètre li : liste d'instructions à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme le bloc en un bloc de type AstTds.bloc *)
(* Erreur si mauvaise utilisation des identifiants *)
and analyse_tds_bloc tds oia li =
  (* Entrée dans un nouveau bloc, donc création d'une nouvelle tds locale
  pointant sur la table du bloc parent *)
  let tdsbloc = creerTDSFille tds in
  (* Analyse des instructions du bloc avec la tds du nouveau bloc.
     Cette tds est modifiée par effet de bord *)
   let nli = List.map (analyse_tds_instruction tdsbloc oia) li in
   (* afficher_locale tdsbloc ; *) (* décommenter pour afficher la table locale *)
   nli


(* analyse_tds_fonction : tds -> AstSyntax.fonction -> AstTds.fonction *)
(* Paramètre tds : la table des symboles courante *)
(* Paramètre : la fonction à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme la fonction
en une fonction de type AstTds.fonction *)
(* Erreur si mauvaise utilisation des identifiants *)
let analyse_tds_fonction maintds (AstSyntax.Fonction(t, n, lp, li)) =

  match chercherLocalement maintds n with
  | Some _ -> raise (DoubleDeclaration n)
  | None ->
      let info_fun = info_to_info_ast (InfoFun (n, t, List.map fst lp)) in
      ajouter maintds n info_fun;
      
      let tds_fonction = creerTDSFille maintds in
      
      let params_info = 
        List.map (fun (typ, nom) ->
          match chercherLocalement tds_fonction nom with
          | Some _ -> raise (DoubleDeclaration nom)
          | None ->
              let info_param = info_to_info_ast (InfoVar (nom, typ, 0, "LB")) in
              ajouter tds_fonction nom info_param;
              (typ, info_param)
        ) lp
      in
      let nli = analyse_tds_bloc tds_fonction (Some info_fun) li in 
      AstTds.Fonction (t, info_fun, params_info, nli)



(* analyser : AstSyntax.programme -> AstTds.programme *)
(* Paramètre : le programme à analyser *)
(* Vérifie la bonne utilisation des identifiants et tranforme le programme
en un programme de type AstTds.programme *)
(* Erreur si mauvaise utilisation des identifiants *)
let analyser (AstSyntax.Programme (vars,fonctions,prog)) =
  let tds = creerTDSMere () in
  let nvg = analyse_tds_vglobales tds vars in 
  let nf = List.map (analyse_tds_fonction tds) fonctions in
  let nb = analyse_tds_bloc tds None prog in
  AstTds.Programme (nvg,nf,nb)