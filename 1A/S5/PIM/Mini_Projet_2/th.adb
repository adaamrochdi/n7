

package body TH is


    function Carac(Cle : in T_Cle) return integer is
    begin
        return (Hachage(Cle)-1) mod Capacity + 1;
    end Carac;


    --Le principe de toutes ces procédures est de considerer un TH commme un tableau des LCA, donc à chaque fois on revient aux procédures de lca.adb
    -- ET grâce à la notion de surcharge, le programme est capable de distinguer entre la procédure de T_TH et de T_LCA



    --On initialise chaque LCA dans la tableau

	procedure Initialiser(Sda: out T_TH) is
	begin
        for i in 1..Capacity loop
            Initialiser(SDA(i));
        end loop;
    end Initialiser;


    --On détruit chaque LCA dans le tableau
    procedure Detruire (Sda : in out T_TH) is
    begin
        for i in 1..Capacity loop
                Detruire(Sda(i));
        end loop;
    end Detruire;


    --cette procédure utilise deux autres procédures, donc on doit distinguer entre eux^pour ne pas avoir des erreurs
    procedure Afficher_Debug_TH (Sda : in T_TH) is
        procedure Afficher_Debug_SDA is new Afficher_Debug(Afficher_Cle => Afficher_Cle_TH,Afficher_Donnee=>Afficher_Donnee_TH);

    begin
        for i in 1..Capacity loop
            Afficher_Debug_SDA(Sda(i));
        end loop;
    end Afficher_Debug_TH;



    --Un TH est vide si tous ses éléments sont vides
    function Est_Vide (Sda : T_TH) return Boolean is
    begin
        for i in 1..Capacity loop
            if not Est_Vide(Sda(i))then
                                return False;
            end if;
        end loop;
        return True;
    end Est_Vide;


    --On doit retourner la somme des taille des LCA dans le TH
    function Taille (Sda : in T_TH) return Integer is
    t : Integer;
	begin
        if Est_Vide(Sda) then
            return 0;
        else
            t := 0;
            for i in 1..Capacity loop
                  t := t + Taille(Sda(i));
            end loop;
            return t;
        end if;
    end Taille;


    --On doit enregistrer selon la taille de la clé
    procedure Enregistrer (Sda : in out T_TH ; Cle : in T_Cle ; Valeur : in T_Valeur) is
    s :integer;
    begin
         s := Carac(Cle);
         Enregistrer(Sda(s) , Cle , Valeur);
    end Enregistrer;


    --Le classement selon la taille de la clé nous facilite la tâche
	function Cle_Presente (Sda : in T_TH ; Cle : in T_Cle) return Boolean is
    s: integer;
    begin
         s := Carac(Cle);
        return Cle_Presente(Sda(s), Cle);
    end Cle_Presente;



    --Idem
	function La_Valeur (Sda : in T_TH ; Cle : in T_Cle) return T_Valeur is
    s: integer;
    begin
         s := Carac(Cle);
        return La_Valeur(Sda(s), Cle);
    end La_Valeur;



    --Idem
	procedure Supprimer (Sda : in out T_TH ; Cle : in T_Cle) is
    s: integer;
    begin
         s := Carac(Cle);
         Supprimer(Sda(s), Cle);
    end Supprimer;


    --Idem Afficher_Debug_TH
    procedure Pour_Chaque_TH (Sda : in T_TH) is
       procedure Pour_Chaque_LCA is new Pour_Chaque (Traiter => Traiter_TH);
    begin
        for i in 1..Capacity loop
             Pour_Chaque_LCA(Sda(i));
        end loop;

	end Pour_Chaque_TH;



end TH;
