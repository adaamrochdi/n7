package allumettes;
import java.util.Random;

public class StrategieNaif implements Strategie {


	@Override
	public int getPrise(Jeu jeu) {
		Random alea = new Random();
		int priseAlea = alea.nextInt(Jeu.PRISE_MAX) + 1;
		return priseAlea;
	}

}
