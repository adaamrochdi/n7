package allumettes;

/** Le sujet réel du jeu comme indiqué à l'énoncé.
 * @author Adam Rochdi
 */

public class JeuReel implements Jeu {

	/** nombre d'allumettes restantes dans le jeu*/
	private int allumRestantes;

	/**le nombre d'allumttes initiale du jeu*/
	private int  nbreAllum;
	
	/** Nombre initiale d'allumettes du jeu par defaut. */
	private static final int maxAllum = 13;

	/** constructeur qui intialise le nombre d'allumettes restantes dans le jeu .
	 */
	public JeuReel() {
		this.allumRestantes = maxAllum;
		this.nbreAllum = maxAllum;
	}

	/** construire le jeu à partir du nombre d'allumettes avec lequel on veut jouer.
	 * @param  nb_allum le nombre intiale d'allumettes du jeu
	 */
	public JeuReel(int nbreAllum) {
		this.allumRestantes = nbreAllum;
		this.nbreAllum = nbreAllum;
	}

	@Override
	public int getNombreAllumettes() {
		return this.allumRestantes;
	}

	@Override
	public void retirer(int allumPrises) throws CoupInvalideException {
		if (allumPrises > this.allumRestantes) {
			String probleme = " (> " + this.allumRestantes + ")";
			throw new  CoupInvalideException(allumPrises, allumPrises + probleme);
		}
		if (allumPrises > Jeu.PRISE_MAX) {
			throw new  CoupInvalideException(allumPrises, allumPrises 
					                          + " (> " + Jeu.PRISE_MAX + ")"); 
		}
		if (allumPrises < 1) {
			throw new  CoupInvalideException(allumPrises, allumPrises + " (< 1)");
		}
        this.allumRestantes = this.allumRestantes - allumPrises;
	}
}
