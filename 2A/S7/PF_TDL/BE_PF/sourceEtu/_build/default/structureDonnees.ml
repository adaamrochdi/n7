(* Pour les tests *)
(* [eq_perm l l'] retourne true ssi [l] et [l']
   sont égales à à permutation près (pour (=)).
   [l'] ne doit pas contenir de doublon. *)
let eq_perm l l' =
  List.length l = List.length l' && List.for_all (fun x -> List.mem x l) l'


module type StructureDonnees =
sig

  (* Type permettant de stocker le dictionnaire *)
  type dico

  (* Dictionnaire vide *)
  val empty : dico

  (* Ajoute un mot et son encodage au dictionnaire *)
  (* premier parametre : l'encodage du mot *)
  (* deuxième paramètre : le mot *)
  (* troisième paramètre : le dictionnaire *)
  val ajouter : int list -> string -> dico -> dico

  (* Cherche tous les mots associés à un encodage dans un dictionnaire *)
  (* premier parametre : l'encodage du mot *)
  (* second paramètre : le dictionnaire *)
  val chercher : int list -> dico -> string list


  (* Calcule le nombre maximum de mots ayant le même encodage dans un
     dictionnaire *)
  (* paramètre : le dictionnaire *)
  val max_mots_code_identique : dico -> int

  (* Liste tous les mots d'un dictionnaire dont un prefixe de l'encodage est donné en paramètre *)
  (* premier paramètre : le prefixe de l'encodage *)
  (* second paramètre : le dictionnaire *)
  val prefixe : int list -> dico -> string list

end

module ListAssoc : StructureDonnees = struct
  type dico = (int list * string list) list

  let empty = []

  let rec ajouter e m d =
    match d with
    | [] -> [(e, [m])]
    | (nombre, mot) :: q ->if nombre = e then (nombre, m :: mot) :: q
        else
          (nombre, mot) :: ajouter e m q

  let rec chercher e d =
    match d with
    | [] -> []
    | (nombre, mot) :: q -> if nombre = e then mot
        else chercher e q
  
  let rec max_mots_code_identique d =
    let rec aux d maxi =
       match d with
        | [] -> maxi
        | (_, l) :: q -> aux q (max (List.length l) maxi)
    in aux d 0

    let rec prefixe e d =
      let rec commence prefix lst =
        match prefix, lst with
        | [], _ -> true
        | _, [] -> false
        | x :: xs, y :: ys -> x = y && commence xs ys
      in
      let rec aux d acc =
        match d with
        | [] -> acc
        | (nombre, mot) :: q -> if commence e nombre then aux q (mot @ acc)
          else aux q acc
      in
      aux d []
  
(*Test pour ajouter*)
let%test _ = eq_perm (ajouter [2;6;6] "bon" [([2;2],["bb";"aa";"cc"]); ([2;7;3;3],["bref"])]) [([2;2],["bb";"aa";"cc"]); ([2;7;3;3],["bref"]);([2;6;6],["bon"])]
let%test _ = eq_perm (ajouter [2;6;6] "bon" []) [[2;6;6],["bon"]]

end

module Arbre : StructureDonnees = struct
  type dico = Noeud of (string list * (int * dico) list)

  let empty = Noeud ([], [])

  let rec ajouter n m arbre =
    match n, arbre with
    | [], Noeud (mots, branches) -> Noeud (m :: mots, branches)
    | e::q, Noeud (mots, branches) -> let sa =
        match List.assoc_opt e branches with
        | Some arbre -> ajouter q m arbre
        | None -> ajouter q m empty
      in
      let branches_mises_a_jour = (e, sa) :: List.remove_assoc e branches in
      Noeud (mots, branches_mises_a_jour)

  let rec chercher e d = 
    match e, d with
    |[], Noeud (mots, _) -> mots
    | t::q, Noeud (_, branches) -> (match List.assoc_opt t branches with
                                  |Some sa -> chercher q sa
                                  | None -> [])


  let max_mots_code_identique d =
    let rec aux (Noeud (mots, branches)) maxi =
      let maxi = max maxi (List.length mots) in
      List.fold_left (fun acc (_, sa) -> aux sa acc) maxi branches
    in aux d 0

  let rec prefixe p d =
    match p, d with
    | [], Noeud (mots, lb) -> mots @ List.flatten (List.map (fun (_, sous_arbre) -> prefixe [] sous_arbre) lb)
    | touche::q, Noeud (_, lb) -> (match List.assoc_opt touche lb with
                                | Some sous_arbre -> prefixe q sous_arbre
                                | None -> [])

end