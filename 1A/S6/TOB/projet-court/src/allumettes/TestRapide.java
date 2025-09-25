package allumettes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestRapide {
	//les jeux du testes.
	private Jeu jeu1 ,jeu2 ,jeu3;
	
	// le joueur
	private Joueur joueur;
	
	
	@Before public void setUp() {
		// Construire les jeux
		jeu1 = new JeuReel();
		
	    jeu2 = new JeuReel(2);
	    jeu3 = new JeuReel(3);
	    // construire le joueur
		joueur = new Joueur("testeur", new StrategieRapide());
	}
	
	@Test public void testerJeu1() throws CoupInvalideException {
		int prise = joueur.getPrise(jeu1);
		assertEquals("E12 : nombre d'allumettes incorrecte", 3, prise);
		jeu1.retirer(prise);
		assertEquals("E12: le nombre dallumttes restantes est incorrecte",10,jeu1.getNombreAllumettes());
	}
	
	@Test public void testerJeu2() throws CoupInvalideException {
		int prise = joueur.getPrise(jeu2);
		assertEquals("E12 : nombre d'allumettes incorrecte", 2, prise);
		jeu2.retirer(prise);
		assertEquals("E12: le nombre dallumttes restantes est incorrecte",0,jeu2.getNombreAllumettes());
	}
	
	@Test public void testerJeu3() throws CoupInvalideException {
		int prise = joueur.getPrise(jeu3);
		assertEquals("E12 : nombre d'allumettes incorrecte", 3, prise);
		jeu3.retirer(prise);
		assertEquals("E12: le nombre dallumttes restantes est incorrecte",0,jeu3.getNombreAllumettes());
	}
	
	

}
