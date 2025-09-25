package allumettes;
import java.util.Scanner;

public class StrategieHumain implements Strategie {
    private static Scanner sc = new Scanner(System.in);
    private String nom;

    public StrategieHumain(String nom) {
    	this.nom =  nom;
    }

	@Override
	public int getPrise(Jeu jeu) throws CoupInvalideException  {
		String ligne = " ";
		boolean fin = false;
		int prise = 0;
		while (!fin) {
			try {
				System.out.print(this.nom + ", combien d'allumettes ?");
			    ligne = sc.nextLine();
				prise = Integer.parseInt(ligne);
				fin = true;
			} catch (NumberFormatException e) {
				if (ligne.equals("triche")) {
					jeu.retirer(1);
					System.out.println("[Une allumette en moins, plus que " 
					                     + jeu.getNombreAllumettes() + ". Chut !]");
				} else {
					System.out.println("Vous devez donner un entier.");
				}
			}
		}
		return prise;
     }

}

