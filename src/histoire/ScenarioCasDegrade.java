package histoire;

import personnages.Gaulois;
import villagegaulois.Etal;

public class ScenarioCasDegrade {

	public static void main(String[] args) {
		Etal etal = new Etal();
		Gaulois jean = new Gaulois("Jean du pomier", 6);
		etal.acheterProduit(1, jean);
		System.out.println("Fin du test");

	}

}
