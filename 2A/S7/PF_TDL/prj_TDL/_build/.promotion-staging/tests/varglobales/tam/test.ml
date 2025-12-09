open Rat
open Compilateur

(* Changer le chemin d'accès du jar. *)
let runtamcmde = "java -jar ../../../../../tests/runtam.jar"
(* let runtamcmde = "java -jar /mnt/n7fs/.../tools/runtam/runtam.jar" *)

(* Execute the TAM code obtained from the rat file and return the ouptut of this code *)
let runtamcode cmde ratfile =
  let tamcode = compiler ratfile in
  let (tamfile, chan) = Filename.open_temp_file "test" ".tam" in
  output_string chan tamcode;
  close_out chan;
  let ic = Unix.open_process_in (cmde ^ " " ^ tamfile) in
  let printed = input_line ic in
  close_in ic;
  Sys.remove tamfile;    (* à commenter si on veut étudier le code TAM. *)
  String.trim printed

(* Compile and run ratfile, then print its output *)
let runtam ratfile =
  print_string (runtamcode runtamcmde ratfile)

(****************************************)
(** Chemin d'accès aux fichiers de test *)
(****************************************)

let pathFichiersRat = "../../../../../tests/varglobales/tam/"

(**********)
(*  TESTS *)
(**********)

(* requires ppx_expect in jbuild, and `opam install ppx_expect` *)
let%expect_test "test1" =
  runtam (pathFichiersRat^"test1.rat");
  [%expect.unreachable]
[@@expect.uncaught_exn {|
  (* CR expect_test_collector: This test expectation appears to contain a backtrace.
     This is strongly discouraged as backtraces are fragile.
     Please change this test to not include a backtrace. *)

  (Rat.Parser.MenhirBasics.Error)
  Raised at Rat__Parser.MenhirBasics._eRR in file "parser.ml" (inlined), line 8, characters 6-17
  Called from Rat__Parser._menhir_run_075 in file "parser.ml", line 1626, characters 10-17
  Called from Rat__Compilateur.compiler in file "compilateur.ml", line 94, characters 14-45
  Re-raised at Rat__Compilateur.compiler in file "compilateur.ml", line 102, characters 6-13
  Called from Tamvg__Test.runtamcode in file "tests/varglobales/tam/test.ml", line 10, characters 16-32
  Called from Tamvg__Test.runtam in file "tests/varglobales/tam/test.ml" (inlined), line 22, characters 15-46
  Called from Tamvg__Test.(fun) in file "tests/varglobales/tam/test.ml", line 36, characters 2-38
  Called from Expect_test_collector.Make.Instance_io.exec in file "collector/expect_test_collector.ml", line 262, characters 12-19

  Trailing output
  ---------------
  File "../../../../../tests/varglobales/tam/test1.rat", line 2, characters 3-9: syntax error. |}]