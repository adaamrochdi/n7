package body matrice_pleine is





    procedure initialisation_rank(rank : in out T_Vecteur_int) is
    begin
        for i in 0..Noeud-1 loop
            rank(i) := i;
        end loop;
    end initialisation_rank;   
    
    
    
    
    

    procedure Initialisation_matrice_adjacence(A : out T_Matrice) is
    begin
        for i in 0..Noeud-1 loop
            for j in 0..Noeud-1 loop
                A(i,j) := 0.0;
            end loop;
        end loop;
    end Initialisation_matrice_adjacence;   
        
        
        
    
    

    procedure creation_matrice_adjacence(Sda : in LCA_test.T_LCA; A : out T_Matrice) is
        procedure Implementer(Colonne1: Integer; Colonne2: Integer) is
        begin
            A(Colonne1, Colonne2) := 1.0;
        end Implementer;

        procedure Chaque is new LCA_test.Pour_Chaque(Implementer);
    begin
        Initialisation_matrice_adjacence(A);
        Chaque(Sda);
    end creation_matrice_adjacence;
    
    
    
    
    
    
    
    procedure creation_matrice_SG(A : in T_Matrice; S : out T_Matrice; G : out T_Matrice) is
        n : Float;
    begin

        S := A;
        G := A;
        for i in 0..Noeud-1 loop
    
            n := 0.0;
            for j in 0..Noeud-1 loop
                n := n + A(i,j);
            end loop;
        
            if n /= 0.0 then
                for j in 0..Noeud-1 loop
                    S(i,j) := A(i,j)/n;
                    G(i,j) := Alpha*S(i,j) + (1.0 - Alpha)/Float(Noeud);
                end loop;
            else
                for j in 0..Noeud-1 loop
                    S(i,j) := 1.0/Float(Noeud);
                    G(i,j) := Alpha*S(i,j) + (1.0 - Alpha)/Float(Noeud);
                end loop;
            end if;
            
        end loop;
        
    end creation_matrice_SG;



    procedure max(pi : in T_Vecteur; indice_debut : in Integer; indice_fin : in Integer; val_max : out Float; indice_max : out Integer) is 
    begin
        val_max := 0.0;
        for i in indice_debut..indice_fin loop
            if pi(i) > val_max then
                val_max := pi(i);
                indice_max := i;
            else
                null;
            end if;
        end loop;
    end max;
    
    
    
    procedure tri(pi : in out T_Vecteur; Noeud : in Integer; rank : in out T_Vecteur_int) is 
        val_max : Float;
        indice_max : Integer;
        memoire_int : Integer;
        memoire_float : Float;
    begin
        for i in 0..Noeud-2 loop
            max(pi, i, Noeud-1, val_max, indice_max);
            
            memoire_int := rank(i);
            rank(i) := rank(indice_max);
            rank(indice_max) := memoire_int;
            
            memoire_float := pi(i);
            pi(i) := pi(indice_max);
            pi(indice_max) := memoire_float;
        end loop;
    end tri;
    
    
    
    function comparaison(pi : in T_Vecteur; Noeud : in Integer; Epsilon : in Float) return boolean is
    begin
        for i in 0..Noeud-1 loop
            if pi(i) < Epsilon then
                null;
            else
                return True;
            end if;
        end loop;
        return False;
    end comparaison;
    
    
    procedure calcul_poids(pi : in out T_Vecteur; G : in T_matrice; Indice_k : in Integer; Epsilon : in Float; Noeud : in Integer) is
        Iteration : Integer := 0;
        s : Float;
    begin
        for i in 0..Noeud-1 loop
            pi(i) := 1.0/Float(Noeud);
        end loop;
        while Iteration <= indice_k and comparaison(pi, Noeud, Epsilon) loop
            for i in 0..Noeud-1 loop
                s := 0.0;
                for j in 0..Noeud-1 loop
                    s := s + pi(j)*G(j,i);
                end loop;
                pi(i) := s;
            end loop;
            Iteration := Iteration + 1;
        end loop;
    end calcul_poids;
    
    

end matrice_pleine;
