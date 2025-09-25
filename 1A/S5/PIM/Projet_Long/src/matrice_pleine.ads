with Types;               use Types;

generic
    Noeud : Integer;
    Alpha : in Float;
    Indice_k : in Integer;
    Epsilon : in Float;



package matrice_pleine is

    type T_Matrice is array(0..Noeud-1, 0..Noeud-1) of Float;
    
    Type T_Vecteur is array(0..Noeud-1) of Float;
    
    Type T_Vecteur_int is array(0..Noeud-1) of Integer;
    
    procedure initialisation_rank(rank : in out T_Vecteur_int); 

    procedure Initialisation_matrice_adjacence(A : out T_Matrice);
    
    procedure creation_matrice_adjacence(Sda : in LCA_test.T_LCA; A : out T_Matrice);
    
    procedure creation_matrice_SG(A : in T_Matrice; S : out T_Matrice; G : out T_Matrice);

    procedure max(pi : in T_Vecteur; indice_debut : in Integer; indice_fin : in Integer; val_max : out Float; indice_max : out Integer);
    
    procedure tri(pi : in out T_Vecteur; Noeud : in Integer; rank : in out T_Vecteur_int);
    
    function comparaison(pi : in T_Vecteur; Noeud : in Integer; Epsilon : in Float) return boolean;
    
    procedure calcul_poids(pi : in out T_Vecteur; G : in T_matrice; Indice_k : in Integer; Epsilon : in Float; Noeud : in Integer);
    


end matrice_pleine;
