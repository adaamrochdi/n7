open Rat
open Compilateur
open Passe

(* Retourne la liste des adresses des variables d'un programme RAT *)
let getListeDep ratfile =
  let input = open_in ratfile in
  let filebuf = Lexing.from_channel input in
  try
    let ast = Parser.main Lexer.token filebuf in
    let past = CompilateurRat.calculer_placement ast in
    let listeAdresses = VerifPlacement.analyser past in
    listeAdresses
  with
  | Lexer.Error _ as e ->
      report_error ratfile filebuf "lexical error (unexpected character).";
      raise e
  | Parser.Error as e ->
      report_error ratfile filebuf "syntax error.";
      raise e

(* Teste si dans le fichier fichier, dans la fonction fonction (main pour programme principal)
   la variable var à la occurrence occ est à l'adresse dep[registre]
*)
let test fichier fonction (var, occ) (dep, registre) = 
  let l = getListeDep fichier in
  let lmain = List.assoc fonction l in
  let rec aux i lmain = 
    if i = 1 then
      let (d, r) = List.assoc var lmain in
      (d = dep && r = registre)
    else 
      aux (i - 1) (List.remove_assoc var lmain)
  in aux occ lmain

(****************************************)
(** Chemin d'accès aux fichiers de test *)
(****************************************)

let pathFichiersRat = "../../../../../tests/varglobales/placement/"

(**********)
(*  TESTS *)
(**********)

(* Tests pour test1.rat *)
let%test "test1_x" = 
  test (pathFichiersRat^"test1.rat") "main" ("x",1) (0,"SB")

let%test "test1_y" = 
  test (pathFichiersRat^"test1.rat") "main" ("y",1) (1,"SB")

let%test "test1_z" = 
  test (pathFichiersRat^"test1.rat") "main" ("z",1) (2,"SB")

(* Tests pour test2.rat *)
let%test "test2_x" = 
  test (pathFichiersRat^"test2.rat") "main" ("x",1) (0,"SB")

let%test "test2_y" = 
  test (pathFichiersRat^"test2.rat") "main" ("y",1) (1,"SB")

let%test "test2_z" = 
  test (pathFichiersRat^"test2.rat") "main" ("z",1) (2,"SB")

let%test "test2_r" = 
  test (pathFichiersRat^"test2.rat") "main" ("r",1) (4,"SB")

let%test "test2_b" = 
  test (pathFichiersRat^"test2.rat") "main" ("b",1) (6,"SB")

let%test "test2_i" = 
  test (pathFichiersRat^"test2.rat") "main" ("i",1) (7,"SB")

(* Tests pour test3.rat *)
let%test "test3_counter" = 
  test (pathFichiersRat^"test3.rat") "main" ("counter",1) (0,"SB")

let%test "test3_flag" = 
  test (pathFichiersRat^"test3.rat") "main" ("flag",1) (1,"SB")

let%test "test3_x" = 
  test (pathFichiersRat^"test3.rat") "main" ("x",1) (2,"SB")

let%test "test3_y" = 
  test (pathFichiersRat^"test3.rat") "main" ("y",1) (3,"SB")

let%test "test3_z" = 
  test (pathFichiersRat^"test3.rat") "main" ("z",1) (4,"SB")

let%test "test3_x2" = 
  test (pathFichiersRat^"test3.rat") "main" ("x2",1) (5,"SB")