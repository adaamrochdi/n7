open Rat
open Compilateur
open Exceptions

exception ErreurNonDetectee

(* Chemin d'accès aux fichiers Rat *)
let pathFichiersRat = "../../../../../tests/varglobales/type/"

(* Test 1 : Typage valide *)
let%test_unit "test1" =
  let _ = compiler (pathFichiersRat ^ "1.rat") in ()

(* Test 2 : Typage incompatible global (int = bool) *)
let%test_unit "test2" =
  try
    let _ = compiler (pathFichiersRat ^ "2.rat") in
    raise ErreurNonDetectee
  with
  | TypeInattendu(Int, Bool) -> ()

(* Test 3 : Typage incompatible global (bool = int) *)
let%test_unit w"test3" =
  try
    let _ = compiler (pathFichiersRat ^ "3.rat") in
    raise ErreurNonDetectee
  with
  | TypeInattendu(Bool, Int) -> ()
