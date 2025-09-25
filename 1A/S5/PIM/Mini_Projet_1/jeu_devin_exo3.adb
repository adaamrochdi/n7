with Text_Io;              use Text_Io;
with Ada.Integer_Text_Io;  use Ada.Integer_Text_Io;
with Jeu_Devin_Exo1;
with Jeu_Devin_Exo2;

-- Auteur : Clément Demazure
--

procedure Jeu_Devin_Exo3 is
	Val_Input: Integer;-- Entier pour stocker le choix dans le menu principale de l'utilisateur
	Val_Input_Chr: Character;-- Entier pour stocker le choix dans le menu pour rejouer de l'utilisateur
	Quitter: Boolean;
begin     --Jouez au jeu du devin
	--Initialiser le jeu
	Put_Line("Bienvenue sur le fameux jeu du devin");
	Put_Line("Le but du jeu est d'essayer de deviner un nombre mystère compris entre 1 et 999, avec pour seuls indices les positions relatives des précédentes propositions");
	loop
		--Afficher le menu principal
		Put_Line("Sélectionnez votre mode de jeu");
		Put_Line("Pour que l'ordinateur choisisse le nombre mystère taper 1");
		Put_Line("Pour que l'ordinateur devine votre nombre mystère taper 2");
		Put_Line("Pour quitter le jeu taper 0");
		--Choisir le mode de jeu
		Get(Val_Input); 
		case Val_Input is
		when 0 => Quitter := True;
		when 1 => Jeu_Devin_Exo1;
		when 2 => Jeu_Devin_Exo2;
		when others => Put_Line("La valeur renseignée est incorrecte. Voulez vous quitter le jeu ?");
		end case;
		--"Quitter le jeu ?"
		Put_Line("Continuer de jouer ? (o/*)");
		Get(Val_Input_Chr);
		if Val_Input_Chr = 'o' then
			Quitter := False;
		else
			Quitter := True ;
		end if;
		exit when Quitter;
	end loop;
--Terminer le jeu
Put_Line("Merci d'avoir jouer, et à la prochaine");
Put_Line("Crédits :");
Put_Line("cet excellent jeu vous a été fourni par Adam Rochdi et Clément Demazure");
end Jeu_Devin_Exo3;