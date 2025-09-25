with Ada.IO_Exceptions;
with Ada.Float_Text_IO;		use Ada.Float_Text_IO;
with Ada.Integer_Text_IO;	use Ada.Integer_Text_IO;
with Ada.Command_line;		use Ada.Command_line;

with Ada.Text_IO;            use Ada.Text_IO;
with Ada.Unchecked_Deallocation;
with Ada.Strings.Unbounded;     use Ada.Strings.Unbounded;
with Ada.Text_IO.Unbounded_IO;  use  Ada.Text_IO.Unbounded_IO;

with Types;               use Types;
with matrice_pleine;
with matrice_creuse;


procedure pagerank is
    
    Sda : LCA_test.T_LCA;


    Choix_Methode : Boolean := True;
    Alpha : Float := 0.85;
    Indice_k : Integer := 150;
    Epsilon : Float := 0.0;
    Nom_Fichier_a_renvoyer : Unbounded_String := To_Unbounded_String("nompardefaut");
    Nom_Fichier: Unbounded_String;

    Noeud : Integer;
    
    Nom_fichier_pr : Unbounded_String;
    Nom_fichier_prw : Unbounded_String;
    






    procedure Lire_Fichier(Nom_Fichier : in Unbounded_String; Noeud : out Integer; Sda : out LCA_test.T_LCA) is
    
        Colonne1, Colonne2 : Integer;
        File : Ada.Text_IO.File_Type;

    begin
        Open(File, In_File, To_String(Nom_Fichier));

        Get (File, Noeud);
    
        while not End_Of_File(File) loop
            Get(File, Colonne1);
            Get(File, Colonne2);
            LCA_test.Enregistrer (Sda, Colonne1, Colonne2);
        end loop;
   
        Close(File);
   
   end Lire_Fichier;
   
   
   
   
   
    
    
    
    procedure methode_pleine(Noeud : in Integer; Alpha : in Float; Indice_k : in Integer; Epsilon : in Float; Sda : in LCA_test.T_LCA) is
    
        package matrice_pleine_test is new matrice_pleine (Noeud, Alpha, Indice_k, Epsilon);
        use matrice_pleine_test;
        
        File : Ada.Text_IO.File_Type;
        
        pi : T_Vecteur;
        rank : T_Vecteur_int;
        A, S, G :T_Matrice;
        
    begin
        initialisation_rank(rank);
        creation_matrice_adjacence(Sda, A);
    
        --Calcul matrice H, S, G
        creation_matrice_SG(A, S, G);

        --fonction calcul poids
        calcul_poids(pi, G, Indice_k, Epsilon, Noeud);

        --faire les tris
        tri(pi, Noeud, rank);
        
        --ecrire les fichiers
        Nom_fichier_pr := Nom_Fichier_a_renvoyer;
	    Append (Nom_fichier_pr, ".pr");
	    Create (File, Out_File, To_String (Nom_fichier_pr));
	    
	    for i in 0..Noeud-1 loop
	        Put (File, rank(i));
	        New_Line (File);
	    end loop;
	    Close (File);
	    
	    Nom_fichier_prw := Nom_Fichier_a_renvoyer;
	    Append (Nom_fichier_prw, ".prw");
	    Create (File, Out_File, To_String (Nom_fichier_prw));

	    Put (File, Noeud);
	    Put (File, Alpha, Fore => 1, Aft =>2, Exp => 0);
	    Put (File, Indice_k);
	    New_Line (File);
	    for i in 0..Noeud-1 loop
	        Put (File, pi(i), Fore => 1, Aft =>2, Exp => 0);
	        New_Line (File);
	    end loop;
	    Close (File);
	    
        
    end methode_pleine;
    
    
    
    
    
    
    
    procedure methode_creuse(Noeud : in Integer; Alpha : in Float; Indice_k : in Integer; Epsilon : in Float; Sda : in LCA_test.T_LCA) is
    
        package matrice_creuse_test is new matrice_creuse (Noeud, Alpha, Indice_k, Epsilon);
        use matrice_creuse_test;
        
        File : Ada.Text_IO.File_Type;
        
        pi : T_Vecteur;
        rank, n : T_Vecteur_int;
        
    begin
        initialisation_rank(rank);
        initialisation_n(n);
        creation_n(Sda, n);

        --fonction calcul poids
        calcul_poids(Sda, pi, n, Indice_k, Epsilon, Noeud);

        --faire les tris
        tri(pi, Noeud, rank);
        
        --ecrire les fichiers
        Nom_fichier_pr := Nom_Fichier_a_renvoyer;
	    Append (Nom_fichier_pr, ".pr");
	    Create (File, Out_File, To_String (Nom_fichier_pr));
	    
	    for i in 0..Noeud-1 loop
	        Put (File, rank(i));
	        New_Line (File);
	    end loop;
	    Close (File);
	    
	    Nom_fichier_prw := Nom_Fichier_a_renvoyer;
	    Append (Nom_fichier_prw, ".prw");
	    Create (File, Out_File, To_String (Nom_fichier_prw));

	    Put (File, Noeud);
	    Put (File, Alpha, Fore => 1, Aft =>2, Exp => 0);
	    Put (File, Indice_k);
	    New_Line (File);
	    for i in 0..Noeud-1 loop
	        Put (File, pi(i), Fore => 1, Aft =>2, Exp => 0);
	        New_Line (File);
	    end loop;
	    Close (File);
	    
        
    end methode_creuse;




begin

    --Lire la ligne de commande
    for i in 1..Argument_Count loop

        if i = Argument_Count then
            Nom_Fichier := To_Unbounded_String(Argument (i));
        elsif Argument (i) = "-A" then
            Alpha := Float'Value (Argument (i+1));
        elsif Argument (i) = "-K" then
            Indice_k := Integer'Value (Argument (i+1));
        elsif Argument (i) = "-E" then
            Epsilon := Float'Value (Argument (i+1));
        elsif Argument (i) = "-P" then
            Choix_Methode := False;
        elsif Argument (i) = "-R" then
            Nom_Fichier_a_renvoyer := To_Unbounded_String(Argument (i+1));
        else
            Null;
        end if;

    end loop;


    --Lecture des fichiers
    Lire_Fichier(Nom_Fichier, Noeud, Sda);
    --Nb_Noeud(Nom_Fichier, Noeud);
    
    --faire tous les calculs et créer les fichiers
    if Choix_Methode then
        --methode matrice creuse
        methode_creuse(Noeud, Alpha, Indice_k, Epsilon, Sda);
    else
        --methode matrice pleine
        methode_pleine(Noeud, Alpha, Indice_k, Epsilon, Sda);
    end if;


end pagerank;
