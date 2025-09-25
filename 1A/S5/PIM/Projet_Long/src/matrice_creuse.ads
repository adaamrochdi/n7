with Types;               use Types;

generic
    Noeud : in Integer;
    Alpha : in Float;
    Indice_k : in Integer;
    Epsilon : in Float;



package matrice_creuse is
    
    Type T_Vecteur is array(0..Noeud-1) of Float;
    
    Type T_Vecteur_int is array(0..Noeud-1) of Integer;
    
    procedure initialisation_rank(rank : in out T_Vecteur_int); 
    
    procedure initialisation_n(n : in out T_Vecteur_int);
    
    procedure creation_n(Sda : in LCA_test.T_LCA; n : in out T_Vecteur_int);

    --procedure max(pi : in T_Vecteur; indice_debut : in Integer; indice_fin : in Integer; val_max : out Float; indice_max : out Integer);
    
    procedure tri(pi : in out T_Vecteur; Noeud : in Integer; rank : in out T_Vecteur_int);
    
    --function comparaison(pi : in T_Vecteur; Noeud : in Integer; Epsilon : in Float) return boolean;
    
    procedure calcul_poids(Sda : in LCA_test.T_LCA; pi : in out T_Vecteur; n : in T_Vecteur_int; Indice_k : in Integer; Epsilon : in Float; Noeud : in Integer);
    


end matrice_creuse;
