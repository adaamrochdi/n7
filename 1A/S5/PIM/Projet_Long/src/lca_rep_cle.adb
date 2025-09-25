with Ada.Text_IO;            use Ada.Text_IO;
with SDA_Exceptions;         use SDA_Exceptions;
with Ada.Unchecked_Deallocation;

package body LCA_rep_cle is

	procedure Free is new Ada.Unchecked_Deallocation (Object => T_Cellule, Name => T_LCA);

    procedure Initialiser(Sda: out T_LCA) is
	begin
		Sda := Null;
	end Initialiser;
	
	

	procedure Detruire (Sda : in out T_LCA) is
	begin
		if Sda /= Null then
			Detruire (Sda.all.Suivant);
			Free (Sda);
		else
			Null;
		end if;
	end Detruire;



    procedure Enregistrer (Sda : in out T_LCA ; Cle : in T_Cle ; Valeur : in T_Valeur) is
    begin
        if Sda = null then
            Sda := new T_Cellule'(Cle => Cle, Valeur => Valeur, Suivant => null);
        else
            Enregistrer(Sda.all.suivant, Cle, Valeur);
        end if;
    end Enregistrer;


    function Present (Sda : in T_LCA ; Cle : in T_Cle ; Valeur : in T_Valeur) return boolean is
    begin
        if Sda = Null then
            return False ;
        else
            if Sda.all.Cle = Cle and then Sda.all.Valeur = Valeur then
                return True ;
            else
                return Present(Sda.all.Suivant, Cle, Valeur) ;
            end if;
        end if;
	end Present;


    procedure Pour_Chaque (Sda : in T_LCA) is
    begin
        if Sda /= null then
            Traiter(Sda.all.Cle, Sda.all.valeur);
            Pour_Chaque(Sda.all.Suivant);
        end if;
    exception
        when others => Put("Le programme a rencontre un probleme.");Pour_Chaque(Sda.all.Suivant);
    end Pour_Chaque;


end LCA_rep_cle;
