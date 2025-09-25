with Text_Io;              use Text_Io;
with Ada.Integer_Text_Io;  use Ada.Integer_Text_Io;


-- Auteur : ROCHDI Adam
--
-- TODO: à compléter...
procedure Jeu_Devin_Exo2 is
    Inf, Sup, Mediane,Essais : Integer;
    Answer : Character;
    Victoire : Boolean;
begin
   Put_Line("Bienvenue au jeu de devinette, choisissez un nombre et laissez le reste sur moi !");
   Inf := 1; 
   Sup := 1000; --Selon l'exercice le nombre est entre 1 et 999
   Victoire := False; --C'est pour quitter la boucle en cas de victoire
   Essais :=1; --Si ce nombre dépasse 9 alors l'utilisateur triche 
   loop 
      Mediane := (Inf + Sup) / 2; --J'ai procédé par la dichotomie
      Put_Line("Le nombre " & Integer'Image(Mediane) & " est-il correct (C), trop petit (P), ou trop grand (G) ?");
        Get(Answer); --Selon la réponse on va savoir quelle borne on doit changer
      case Answer is 
         when 'C'|'c' => Victoire := True; --Je l'ai changer à True pour quitter la boucle
         when 'P'|'p' => Sup := Mediane ; Essais := Essais +1;
         when'G'|'g' => Inf := Mediane ; Essais := Essais +1;
         when others => Put_Line("Saisissez une lettre valide"); --Si l'utilisateur entre par erreur une autre lettre
        end case;
        exit when Victoire or Essais > 9;
    end loop;
    --On quitte la boucle soit à cause de la victoire ou la triche
    if Victoire then 
        Put_Line("WOAH !J'ai trouvé le nombre " & Integer'Image(Mediane) & " en" & Integer'Image(Essais)& " Essais ! ");
    else  
        Put_Line ("Vous avez effectué beaucoup d'essais");
    end if;
    
end Jeu_Devin_Exo2;
