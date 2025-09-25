package allumettes;

/** Procuration qui évite la triche
 * @author Adam Rochdi
 */

public class Proxy implements Jeu {
	/** le jeu réel*/
	private Jeu jeu;

	/** Construire la procuration à partir du jeu qui est non null bien sûr.
	 * @param jeu le jeu
	 */
	public Proxy(Jeu jeu) {
		assert (jeu != null);
		this.jeu = jeu;
	}

	//Pour les autres méthodes, la procuration appelle simplement l’opération correspondante du sujet réel.
	@Override
	public int getNombreAllumettes() {
		return this.jeu.getNombreAllumettes();
	}

	//Si le joueur appelle la méthode retirer de la procuration, la procuration lèvera
	//une exception OperationInterditeException.
	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {
			throw new OperationInterditeException("l'operation interdit");
	}

}
