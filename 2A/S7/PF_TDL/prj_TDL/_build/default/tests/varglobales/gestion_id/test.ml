open Rat
open Compilateur
open Exceptions

exception ErreurNonDetectee

(* Chemin d'accès aux fichiers Rat *)
let pathFichiersRat = "../../../../../tests/varglobales/gestion_id/"

(* TESTS *)

(* Test de double déclaration de variables globales *)
let%test_unit "test1" = 
  try 
    let _ = compiler (pathFichiersRat ^ "1.rat") in
    raise ErreurNonDetectee
  with
  | DoubleDeclaration("x") -> ()

(* Test d'accès valide à une variable globale *)
let%test_unit "test2" = 
  let _ = compiler (pathFichiersRat ^ "2.rat") in ()

(* Test d'utilisation invalide d'une variable globale *)
let%test_unit "test3" = 
  try 
    let _ = compiler (pathFichiersRat ^ "3.rat") in
    raise ErreurNonDetectee
  with
  | IdentifiantNonDeclare("z") -> ()

(* Test de fonction accédant à une variable globale *)
let%test_unit "test4" = 
  let _ = compiler (pathFichiersRat ^ "4.rat") in ()


