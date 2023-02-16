package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum, int nbEtals) {
		this.marche = new Marche(nbEtals);
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef " + chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom() + " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}

	public String installerVendeur(Gaulois vendeur, String produit, int nbProduit) {
		StringBuilder textCherche = new StringBuilder(vendeur.getNom() + " cherche un endroit pour vendre " + nbProduit + produit);
		StringBuilde textTrouve = new StringBuilder();
		int posEtal = marche.trouverEtalLibre();
		if (posEtal == -1) {
			
		}
		textCherche.append(null)
		
	}

	/* ================= Classe interne Marche ================= */

	private static class Marche {
		private Etal[] etals;
		private int nbEtals;

		private Marche(int nbEtals) {
			this.nbEtals = nbEtals;
			this.etals = new Etal[nbEtals];
			for (int i = 0; i < nbEtals; i++) {
				etals[i] = new Etal();
			}
		}

		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
		}

		private int trouverEtalLibre() {
			int ind = 0;
			while (etals[ind].isEtalOccupe() && ind < etals.length) {
				ind++;
			}
			return (ind == etals.length ? -1 : ind);
		}

		private Etal[] trouverEtals(String produit) {
			Etal[] listeEtals = new Etal[nbEtals];
			int ind = 0;
			for (int i = 0; i < etals.length; i++) {
				if (etals[i].isEtalOccupe() && etals[i].contientProduit(produit)) {
					listeEtals[ind] = etals[i];
					ind++;
				}
			}
			return listeEtals;
		}

		private Etal trouverVendeur(Gaulois gaulois) {
			for (int i = 0; i < etals.length; i++) {
				if (etals[i].getVendeur() == gaulois)
					return etals[i];
			}
			return null;
		}

		private String afficherMarche() {
			String message = "";
			int nbEtalVide = 0;
			for (int i = 0; i < etals.length; i++) {
				if (etals[i].isEtalOccupe()) {
					message.concat(etals[i].afficherEtal());
					message.concat("\n");
				} else
					nbEtalVide++;
			}
			message.concat("Il reste " + nbEtalVide + " étals non utilisés dans le marché.\n");
			return message;
		}

	}

	/* ================= Fin Classe interne Marche ================= */

}