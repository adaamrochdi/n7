package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Jouer {
	//nbres des arguments max.


	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments(args);
			verifArgs(args);

			Jeu jeu = new JeuReel();
			if (args.length == (3)) {                 // si nous avons 3 arguments donc nous avons -confiant 
				String[] joueur1 = getjoueur(args[1]);
				String[] joueur2 = getjoueur(args[2]);
				Joueur j1 = creerJoueur(joueur1);
				Joueur j2 = creerJoueur(joueur2);
				Arbitre arbitre =  new Arbitre(j1, j2, true);
				arbitre.arbitrer(jeu);
			} else {                                     //on a pas 3 args donc pas de -confiant
				String[] joueur1 = getjoueur(args[0]);
				String[] joueur2 = getjoueur(args[1]);
				Joueur j1 = creerJoueur(joueur1);
				Joueur j2 = creerJoueur(joueur2);
				Arbitre arbitre =  new Arbitre(j1, j2, false);
				arbitre.arbitrer(jeu);
			}
		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
	}


	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}

    /**creer un joueur à parir de son nom et de sa strategie.
     *
     * @param joueur tableau contenant le nom du joueur et sa strategie
     * @return le joueur
     */
	public static Joueur creerJoueur(String[] joueur) {
		if (joueur[1].equals("humain")) {
			return new Joueur(joueur[0], new StrategieHumain(joueur[0]));
		} else if (joueur[1].equals("expert")) {
			return new Joueur(joueur[0], new StrategieExpert());
		} else if (joueur[1].equals("naif")) {
			return new Joueur(joueur[0], new StrategieNaif());
		} else if (joueur[1].equals("rapide")) {
			return new Joueur(joueur[0], new StrategieRapide());
		} else {
			return new Joueur(joueur[0], new StrategieTricheur());
		}
	}




    /**obtenir le nom et la strategie d'un joueur à partir d'une chaine de caractère de type nom@strategie.
     *
     * @param argument la chaine de caractère
     * @return tableau contenat  le  nom et la strategie
     */
	public static String[] getjoueur(String argument) {
		return argument.split("@");
	}


	public static void verifArgs(String[] args) {
		if (args.length == 3) {
			verifEstConfiant(args[0]);
			verifJoueur(args[1]);
			verifJoueur(args[2]);
		} else {
			verifJoueur(args[0]);
			verifJoueur(args[1]);
		}
	}

	/**Verifier que l'argument de la ligne de commande est  bien ecrit sous la forme de nom@strategie et vérifier les strategies.
	 *
	 * @param argument l'argument de la ligne de commande à verifier
	 * @throws ConfigurationException si argument n'est pas conforme donc different
	 * de la forme nom@strategie
	 */
	private static void verifJoueur(String argument) {
		 String[] joueur = getjoueur(argument);
		 if (joueur.length != 2) {
			 throw new ConfigurationException("il faut ecrire nom@stratégie");
		 } else {
			switch (joueur[1]) {
				case("tricheur"):
				case("rapide"):
				case("expert"):
				case("naif"):
				case("humain"): break;
				default :
					throw new ConfigurationException("le nom de la strategie incorrecte");
		        }
		 }
	}

	/** Verifier que la chaine de caractère donnée en paramétre
	 * est égal a confiant.
	 * @param argument la chaine à verifier
	 * @throws ConfigurationExceptio lorsque le paramétre est
	 * different de condfiant.
	 */
	private static void verifEstConfiant(String argument) {
		if (!argument.equals("-confiant")) {
			 throw new ConfigurationException("il faut ecrire confiant");
		}
	}
}
