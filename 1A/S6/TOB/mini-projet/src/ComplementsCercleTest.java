import java.awt.Color;
import java.lang.reflect.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/*
 * Code du complément de test en Mini-Projet 1
 * @author ROCHDI Adam 
 * Groupe E
 */

public class ComplementsCercleTest {

	// précision pour les comparaisons réelle
	public final static double EPSILON = 0.001;

	// Les points du test
	private Point A, B, C, D, E;

	// Les cercles du test
	private Cercle C1, C2, C3;

	@Before public void setUp() {
		// Construire les points
		A = new Point(0, 0);
		B = new Point(4, 4);
		C = new Point(4, 1);
		D = new Point(8, 1);

		// Construire les cercles
        C1 = new Cercle (C, D);		
		C2 = new Cercle ( new Point(0,0) , new Point (4,4), Color.green);
		
        C3 = Cercle.creerCercle(A , B);
	}

    /*
     * D'après E8 un cercle doit posséder une couleur
     */
	@Test public void testerE8(){
    assert(C1.getCouleur() != null);
    assert(C2.getCouleur() != null);
    assert(C3.getCouleur() != null);
    }

    @Test public void testerE18() {
        C2.translater(10.0, 10.0);
        assertEquals("E18 : Abscisse du centre incorrect",
                12.0, C2.getCentre().getX(), EPSILON);
        assertEquals("E18 : Ordonnée du centre incorrect",
                12.0, C2.getCentre().getY(), EPSILON);
    }

}