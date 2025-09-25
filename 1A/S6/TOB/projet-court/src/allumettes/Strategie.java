package allumettes;

/** Interface qui regroupe les strategies avec une exeption.
 * @author	Adam ROCHDI
 */

public interface Strategie {
	/** Donner le nombre d’allumettes à prendre en fonction de la stratégie du joueur.
	 * @param jeu le jeu courant
	 * @return le nombre d'allumettes à prendre
	 */
	int getPrise(Jeu jeu) throws CoupInvalideException;

}
