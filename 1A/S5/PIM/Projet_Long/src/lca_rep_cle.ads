
generic
	type T_Cle is private;
	type T_Valeur is private;

package LCA_rep_cle is

    type T_LCA is limited private;


    procedure Initialiser(Sda: out T_LCA);
    
    

	procedure Detruire (Sda : in out T_LCA);



	procedure Enregistrer (Sda : in out T_LCA ; Cle : in T_Cle ; Valeur : in T_Valeur);


    function Present (Sda : in T_LCA ; Cle : in T_Cle ; Valeur : in T_Valeur) return boolean;


	generic
		with procedure Traiter (Cle : in T_Cle; Valeur: in T_Valeur);
	procedure Pour_Chaque (Sda : in T_LCA);



private

    type T_Cellule;
    
    type T_LCA is access T_Cellule;
    
    type T_Cellule is
        record
            Cle : T_Cle;
            Valeur : T_Valeur;
            Suivant : T_LCA;
        end record;
	

end LCA_rep_cle;
