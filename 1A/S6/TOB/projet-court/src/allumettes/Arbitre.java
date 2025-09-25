package allumettes;

/**Arbite qui suit le déroulement du jeu .
 * @author Adam Rochdi
 */

public class Arbitre {
	/** estConfiant =true si l'arbitre est confiant est egal a false sinon.*/
	private boolean estConfiant;
	/**Le premier joueur.*/
	private Joueur j1;
	/**Le deuxiéme joueur.*/
	private Joueur j2;

	/** Construire l'arbitre à partir des deux joueurs  qui vont s’affronter .
	 * @param j1 le premier joueur
	 * @param j2 le deuxiéme joueur
	 */
	public Arbitre(Joueur j1, Joueur j2) {
		this.j1 = j1;
		this.j2 = j2;
		this.estConfiant = false;

	}

	/** Construire un arbitre de 2 joueurs et le parametre estConfiant.
	 * 
	 * @param j1 le premier joueur
	 * @param j2 le deuxiéme joueur
	 * @param estConfiant égal à true si on veut que l'arbitre
	 *  ne détecte pas la triche et false sinon
	 */
	public Arbitre(Joueur j1, Joueur j2, boolean estConfiant) {
		this(j1, j2);
		this.estConfiant = estConfiant;
	}


    public void changerStartegie() {
        // Cette méthode ne fait rien
    	// C'est pour changer la stratégie mai pas encore programmmé.
    }

	/** Commencer le jeu à tour de rôle.
	 * @boolean tour qui grâce à lui on peut changer les rôles
	 *  @param jeu le jeu à jouer
	 */
	public void arbitrer(Jeu jeu) {
		boolean tour = true ;  // indique le tour de quel joueur.
		try {
			do {
				if (tour) {
					jouer(this.j1, jeu);
				} else {
					jouer(this.j2, jeu);
				}
				tour = !tour;
				System.out.println();
			} while (jeu.getNombreAllumettes() != 0);
			if (!tour) {
				System.out.println(this.j1.getNom() + " perd !");
				System.out.println(this.j2.getNom() + " gagne !");
			} else {
				System.out.println(this.j2.getNom() + " perd !");
				System.out.println(this.j1.getNom() + " gagne !");
			}
		} catch (OperationInterditeException e) {
			String nom = tour ? this.j1.getNom() : this.j2.getNom();
			System.out.println("Abandon de la partie car " + nom + " triche !");
		}
	}

	/** Methode qui commande le jeu, prendre retirer des allumettes.
	 * 
	 * @param joueur le joueur qui doit jouer
	 * @param jeu le jeu joué
	 */
	private void jouer(Joueur joueur, Jeu jeu) {
		boolean termine = false;
		int prise = 0;
		do {
			try {
				System.out.println("Allumettes restantes : " + jeu.getNombreAllumettes());
				prise = this.nballumettes(jeu, joueur);
				this.afficher(joueur, prise);
				jeu.retirer(prise);
				termine = true;
			}catch (CoupInvalideException e) {
				System.out.println("Impossible ! Nombre invalide : " + e.getProbleme());
				System.out.println();
				}
			 } while (!termine);
	}

	/** Afficher nombre d'allumettes que le joueur souhaite prendre.
	 * 
	 * @param joueur le joueur qui a joué
	 * @param prise nombre d'allumettes que le joueur souhaite prendre
	 */
	public void afficher(Joueur joueur, int prise) {
		if (prise > 1) {
			System.out.println(joueur.getNom() + " prend " + prise + " allumettes.");
		} else {
			System.out.println(joueur.getNom() + " prend " + prise + " allumette.");
		}
	}

	private int nballumettes(Jeu jeu, Joueur joueur) throws CoupInvalideException {
		return this.estConfiant ? joueur.getPrise(jeu) : joueur.getPrise(new Proxy(jeu));
	}

}
