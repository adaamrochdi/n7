with Text_Io;              use Text_Io;
with Ada.Integer_Text_Io;  use Ada.Integer_Text_Io;
with Alea;

-- Auteur : Clément Demazure
--

procedure Jeu_Devin_Exo1 is
	package Mon_Alea is
			new Alea (2,999); -- générateur de nombre dans l'intervalle [1, 999]
	use Mon_Alea;
	Reussite: Boolean;-- Booléen indique si l'utilisateur a reussi à deviner
	Objectif: Integer;-- Entier indique le nombre que l'utilisateur doit deviner
	Nb_Tentatives: Integer;-- Entier pour compter le nombre de tentatives de l'utilisateur
	Val_Input: Integer;-- Entier pour stocker la dernière tentatives de l'utilisateur
begin -- Faire deviner à nombre généré par ordinateur à un utilisateur
	  -- Initialiser la partie
	Put_Line("J'ai choisit un nombre, bonne chance pour le deviner!");
	Reussite := False;
	Get_Random_Number (Objectif);
	Nb_tentatives := 0;
	loop -- Faire une tentative de nombre
		-- Demander un nombre à l’utilisateur
		Put_Line("Choisissez un nombre");
		Get(Val_Input);
		-- Comparer le résultat avec l'objectif
		case Val_Input is
		when 1..999=> --l'utilisateur a bien essayé un nombre valide
			Nb_tentatives := Nb_tentatives+1;
			if Val_Input = Objectif then--l'utilisateur a gagné
				Reussite := True;
			elsif Val_Input < Objectif then-- Demander un nombre plus grand
				Put_Line("Trop petit, réessayer.");
			elsif Val_Input > Objectif then-- Demander un nombre plus petit
				Put_Line ("Trop grand, réessayer.");
			end if;
		when others => Put_Line("La valeur renseignée est incorrecte. Écrivez un nombre entre 1 et 999.");
		end case;
		exit when Reussite;
	end loop;
	-- Afficher le résultat
	Put("Félicitation, vous avez gagné (en seulement ");
	Put(Nb_tentatives);
	Put_Line("  Tentative.s");
end Jeu_Devin_Exo1;
