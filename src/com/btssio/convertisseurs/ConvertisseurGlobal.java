package com.btssio.convertisseurs;

import java.util.ArrayList;

public class ConvertisseurGlobal {
	/**
	 * liste des devises du convertisseur global
	 */
	private ArrayList<Devise> lesDevises;

	/**
	 * constructeur qui instancie la liste et cree la devise "USD" dollar US
	 * 
	 * @throws DeviseNomException
	 */
	public ConvertisseurGlobal() throws DeviseNomException {
		lesDevises = new ArrayList<Devise>();
		lesDevises.add(new Devise("USDD", 1));
	}

	/**
	 * ajoute la devise à la liste des devises
	 * 
	 * @param uneDevise devise à ajouter à la liste
	 * @return renvoie vrai si ok faux dans le cas contraire
	 */
	public boolean ajouterDevise(Devise uneDevise) {
		String name = uneDevise.getNom();
		if (!lesDevises.contains(uneDevise)) {
			lesDevises.add(uneDevise);
			return true;
		} else {
			return false;
		}

	}

	// public boolean ajouterDevise(Devise uneDevise) {
	// lesDevises.add(uneDevise);
	// return true;
	// }

	/**
	 * renvoie la devise correspondant au nom de devise
	 * 
	 * @param nomDevise prorpité Nom de la devise recherchée en 3 lettres
	 * @return null si pas trouvée
	 */
	public Devise rechercheDevise(String nomDevise) {
		Devise laDevise = null;
		int i = 0;
		while (i < lesDevises.size() && laDevise == null) {
			if (lesDevises.get(i).getNom().equals(nomDevise))
				laDevise = lesDevises.get(i);
			i++;
		}
		return laDevise;
	}

	public ArrayList<Devise> getLesDevises() {
		return lesDevises;
	}

	/**
	 * renvoie le montant converti en devise cible
	 * 
	 * @param montant      somme qui doit être convertie
	 * @param deviseSource devise dans laquelle est exprimé le montant
	 * @param deviseCible  devise dans laquelle sera exprimé le montant retourné
	 * @return zéro si une des deux devises n'existent pas.
	 */
	public double convertir(double montant, String deviseSource, String deviseCible) {
		double resultat = montant;
		if (rechercheDevise(deviseSource) != null && rechercheDevise(deviseCible) != null) {
			// convertir la devise de départ en dollar
			resultat = resultat / rechercheDevise(deviseSource).getTauxChange();
			// convertir les dollars en devise cible
			resultat = resultat * rechercheDevise(deviseCible).getTauxChange();
		} else
			resultat = 0;
		return Math.round(resultat * 100.0) / 100.0;
	}

}