package allumettes;

public class StrategieTricheur implements Strategie {
	
	@Override
	public int getPrise(Jeu jeu) throws CoupInvalideException {
	    System.out.println("[Je triche...]");
		while (jeu.getNombreAllumettes() != 2) {
			jeu.retirer(1);
		}
		System.out.println("[Allumettes restantes : 2]");
		return 1;
	}

}
