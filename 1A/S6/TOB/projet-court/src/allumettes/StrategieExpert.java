package allumettes;

public class StrategieExpert implements Strategie {

	@Override
	public int getPrise(Jeu jeu)  {
		int x = (jeu.getNombreAllumettes() - 1) % (Jeu.PRISE_MAX + 1);
		return (jeu.getNombreAllumettes() % (Jeu.PRISE_MAX + 1)) != 1 ? x : 1;
	}

}
