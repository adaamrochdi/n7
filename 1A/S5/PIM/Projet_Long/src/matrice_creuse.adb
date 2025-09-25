package body matrice_creuse is





    procedure initialisation_rank(rank : in out T_Vecteur_int) is
    begin
        for i in 0..Noeud-1 loop
            rank(i) := i;
        end loop;
    end initialisation_rank;   
    
    
    procedure initialisation_n(n : in out T_Vecteur_int) is
    begin
        for i in 0..Noeud-1 loop
            n(i) := 0;
        end loop;
    end initialisation_n; 
    
    
    
    
    

   
    
    
    
    
    
    
    
    
    
    
    procedure creation_n(Sda : in LCA_test.T_LCA; n : in out T_Vecteur_int) is
        procedure Implementer(Colonne1: Integer; Colonne2: Integer) is
        begin
            n(Colonne1) := n(Colonne1) + 1;
        end Implementer;

        procedure Chaque is new LCA_test.Pour_Chaque(Implementer);
    begin
        initialisation_n(n);
        Chaque(Sda);
    end creation_n;
    
    
    
    
    
    
    
    
    
    
    



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
    
    
    procedure calcul_poids(Sda : in LCA_test.T_LCA; pi : in out T_Vecteur; n : in T_Vecteur_int; Indice_k : in Integer; Epsilon : in Float; Noeud : in Integer) is
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
                    if n(j) = 0 then
                        s := s + pi(j)/Float(Noeud);
                    elsif LCA_test.Present(Sda, j, i) then
                        s := s + pi(j)*( (Alpha/Float(n(j))) + (1.0 - Alpha)/Float(Noeud) );
                    else
                        s := s + pi(j)*( (1.0 - Alpha)/Float(Noeud) );
                    end if;
                end loop;
                pi(i) := s;
            end loop;
            Iteration := Iteration + 1;
        end loop;
    end calcul_poids;
    
    

end matrice_creuse;
