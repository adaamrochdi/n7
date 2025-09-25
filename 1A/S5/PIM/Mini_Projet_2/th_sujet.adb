with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with TH;


procedure TH_sujet is
    package TH_string is
            new TH (Capacity => 11, T_Cle => Unbounded_String, T_Valeur => Integer, Hachage => Length);
    use TH_string;


	function Avec_Guillemets (Cle: Unbounded_String) return String is
	begin
		return '"' & To_String (Cle) & '"';
    end;


    procedure Afficher_Cle_Valeur (Cle : in Unbounded_String ; Valeur : in Integer) is
    begin
        Put("-->[");
        Put (Avec_Guillemets (Cle));
        Put (" : ");
        Put(Valeur,0);
        Put ("]");
        Put("--E");
    end Afficher_Cle_Valeur;


    procedure Afficher is
            new Pour_Chaque_TH(Afficher_Cle_Valeur); --selon le traitement declaré en opération 9
    Valeur : T_TH ;

begin
    Initialiser(Valeur);

    Enregistrer(Valeur, To_Unbounded_String("un"), 1);
    Enregistrer(Valeur, To_Unbounded_String("deux"), 2);
    Enregistrer(Valeur, To_Unbounded_String("trois"), 3);
    Enregistrer(Valeur, To_Unbounded_String("quatre"), 4);
    Enregistrer(Valeur, To_Unbounded_String("cinq"), 5);
    Enregistrer(Valeur, To_Unbounded_String("vingt-et-un"), 21);
    Enregistrer(Valeur, To_Unbounded_String("quatre-vingt-dix-neuf"), 99);


    Afficher(Valeur);
    Detruire (Valeur);

end TH_sujet;
