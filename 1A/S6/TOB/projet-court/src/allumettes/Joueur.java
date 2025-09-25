package allumettes;

public class Joueur {
	/**Le nom du joueur.*/
	private String nom;
	/**La strategie du joueur.*/
	private Strategie strategie;

	/** Construire un joueur à partir de son nom
	 * et de sa strategie.
	 * @param nom
	 */
	public Joueur(String nom, Strategie strategie) {
		this.nom = nom;
		this.strategie = strategie;
	}

	/** Obtenir le nom du joueur.
	 * 
	 * @return le nom du joueur
	 */
	public String getNom() {
		return this.nom;
	}

	/** Donner le nombre d’allumettes à prendre en fonction de sa stratégie.
	 * 
	 * @param jeu le jeu courant
	 * @return le nombre d'allumettes à prendre
	 */
	public int getPrise(Jeu jeu) throws CoupInvalideException {
		return this.strategie.getPrise(jeu);
	}

	/**Obtenir la strategie du joueur.
	 * 
	 * @return la strategie du joueur
	 */
	public Strategie getStrategie() {
		return this.strategie;
	}

	/**Changer la strategie du joueur.
	 * 
	 * @param nouvelleStrategie la nouvelle startegie
	 */
	public void setStrategie(Strategie nouvelleStrategie) {
		this.strategie = nouvelleStrategie;
	}

}
