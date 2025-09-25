
import java.awt.Color;
import java.lang.reflect.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/*
 * Code du test en Mini-Projet 1
 * @author ROCHDI Adam 
 * Groupe E
 */

public class CercleTest {

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
	
	static void memesCoordonnees(String message, Point p1, Point p2) {
		assertEquals(message + " (x)", p1.getX(), p2.getX(), EPSILON);
		assertEquals(message + " (y)", p1.getY(), p2.getY(), EPSILON);
	}
	
	/*Creer un cercle de 2 points diametralement opposés de couleur bleue, 
	 * càd le centre doit être le milieu de ces 2 point 
	 * et le diamètre sera la distance entre eux
	 */
	
	@Test public void testerE12(){
		assertEquals(C1.getDiametre(),C.distance(D), EPSILON );
		assertEquals(Color.blue, C1.getCouleur());
		memesCoordonnees("E12 : Centre de C3 incorrect", new Point(6,1), C1.getCentre());
	}
	/*
	 * c'est la même chose que E12 sauf que c'est à nous de choisir la couleur du cercle
	 */
	
	@Test public void testerE13(){
		assertEquals(C2.getDiametre(),A.distance(B), EPSILON );
		assertEquals(Color.green, C2.getCouleur());
		memesCoordonnees("E12 : Centre de C3 incorrect", new Point(2,2), C2.getCentre());	
    }
	/*
	 * ici on doit créer un cercle de couleur bleue à partir de deux points : le premier est le centre et le deuxieme est un point de 
	 * sa circonférence
	 * Donc le rayon sera la distance entre ces deux points 
	 */
  
	@Test public void testerE14(){
		assertEquals(C3.getRayon(),A.distance(B), EPSILON );
		assertEquals(Color.blue, C3.getCouleur());
		memesCoordonnees("E12 : Centre de C3 incorrect", A, C3.getCentre());	
    }
 }
