with Ada.Text_IO;            use Ada.Text_IO;
with SDA_Exceptions;         use SDA_Exceptions;
with Ada.Unchecked_Deallocation;

package body LCA is

	procedure Free is
		new Ada.Unchecked_Deallocation (Object => T_Cellule, Name => T_LCA);


	procedure Initialiser(Sda: out T_LCA) is
	begin
        Sda :=null;
	end Initialiser;


    procedure Detruire (Sda : in out T_LCA) is
        --On va procéder récursivement
	begin
	if Sda/=null then
            Detruire(Sda.all.Suivant);
            Free(sda);
        else
            Null;
    end if;
    end Detruire;



	procedure Afficher_Debug (Sda : in T_LCA) is
    begin
        null;
             if Sda = null then
                 Put ("--E");
               else

                   Put ("-->[ ");
                   Afficher_Cle(Sda.all.Cle);
                   Put (" | ");
                   Afficher_Donnee(Sda.all.Valeur);
                   Put (" ] ");

                  --Pour afficher le reste :
                  Afficher_debug (Sda.all.Suivant);
              end if;
    end Afficher_Debug;




	function Est_Vide (Sda : T_LCA) return Boolean is
	begin
		return Sda=null;
    end;



	function Taille (Sda : in T_LCA) return Integer is
	begin
        if Est_Vide(Sda) then
            return 0;
        else
            return 1+Taille(Sda.all.Suivant);
        end if;
    end Taille;



	procedure Enregistrer (Sda : in out T_LCA ; Cle : in T_Cle ; Valeur : in T_Valeur) is
    Pointeur_aux1 : T_LCA; --C'est un pointeur auxiliaire pour faciliter la tâche
    begin
	    if Sda = Null then
	        Pointeur_aux1 := new T_Cellule;
		    Pointeur_aux1.all.Cle := Cle;
		    Pointeur_aux1.all.Valeur := Valeur;
		    Pointeur_aux1.all.Suivant := Null;
		    Sda := Pointeur_aux1;
		else
		    if Sda.all.Cle = Cle then
	            Sda.all.Valeur := Valeur;
		    else
		        Enregistrer(Sda.all.Suivant, Cle , Valeur);
		    end if;
		end if;
    end Enregistrer;



	function Cle_Presente (Sda : in T_LCA ; Cle : in T_Cle) return Boolean is
	begin
		if Sda = Null then
		    return FALSE;
		elsif Sda.all.Cle = Cle then
		    return TRUE;
		else
            return Cle_Presente (Sda.all.Suivant , Cle);
       end if;
    end;



	function La_Valeur (Sda : in T_LCA ; Cle : in T_Cle) return T_Valeur is
	begin
           if Est_Vide(Sda) then
              raise Cle_Absente_Exception;

           elsif Sda.all.cle=cle then
              return Sda.all.valeur;
           else
              return La_Valeur(Sda.all.suivant,Cle);
           end if;
    end La_Valeur;



	procedure Supprimer (Sda : in out T_LCA ; Cle : in T_Cle) is
        LCA_temporaire : T_LCA;
    begin

        if Sda = Null then
              raise Cle_Absente_Exception;
        elsif Sda.all.Cle = Cle  then
            -- On l'a trouvé et on le supprime
            LCA_temporaire := Sda;
            Sda := Sda.all.Suivant;
            Free (LCA_temporaire);
        else
            Supprimer (Sda.all.Suivant, Cle);
        end if;
    end Supprimer;



   procedure Pour_Chaque (Sda : in T_LCA) is
    Sda1 : T_LCA;
    begin
       Sda1 := Sda;
        while Sda1 /= null loop
            -- même si on a une exception, on continue à traiter les suivants
            begin
                Traiter(Sda1.all.Cle,Sda1.all.Valeur);
            exception
                when others =>
                    null;
            end;
            Sda1 := Sda1.all.Suivant;
            end loop;
	end Pour_Chaque;



end LCA;
