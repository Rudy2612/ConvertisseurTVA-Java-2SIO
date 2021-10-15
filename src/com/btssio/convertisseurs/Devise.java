package com.btssio.convertisseurs;

public class Devise {
	private String nom;
	private double tauxChange;
	private final static int LONGEURNOM = 3;

	// constructeur devise
	public Devise(String nom, double tauxChange) throws DeviseNomException {

		if (nom.length() != LONGEURNOM) {
			String message = String.format("Le nom de la devise doit comporter %d caractères", LONGEURNOM);
			throw new DeviseNomException(message);
		}

		this.nom = nom;
		this.tauxChange = tauxChange;
	}

	// retour le nom de la devise
	public String getNom() {
		return nom;
	}

	// permet de définir un nouveau nom pour une deivse
	public void setNom(String nom) {
		this.nom = nom;
	}

	// permet d'obtenir le taux de change de la devise
	public double getTauxChange() {
		return tauxChange;
	}

	// permet de changer le taux de change de la devise
	public void setTauxChange(double tauxChange) {
		double taux = tauxChange;
		this.tauxChange = taux;
	}

}