package com.btssio.convertisseurs;

public class ConvertisseurTVA {

	private double tauxTVA;

	// permet d'afficher le taux de TVA actuellement défini
	public double getTauxTVA() {
		return tauxTVA;
	}

	// Permet de set un taux de TVA
	public void setTauxTVA(double tauxTVA) {
		// Le taux de TVA doit être compris entre 0 et 1 (exclu) pour être prit en
		// compte
		double taux = tauxTVA;
		if (tauxTVA > 1 || tauxTVA < 0)
			taux = 0;
		this.tauxTVA = taux;
	}

	public ConvertisseurTVA(double tauxTVA) {
		super();
		// Le taux de TVA doit être compris entre 0 et 1 (exclu) pour être pris en
		// compte
		double taux = tauxTVA;
		if (tauxTVA > 1 || tauxTVA < 0)
			taux = 0;
		this.tauxTVA = taux;
	}

	// converti un montant Hors taxe en montant TTC
	public double convertirEnTTC(double montantHT) {
		return montantHT * (1 + tauxTVA);
	}

	// converti un montant TTC en montant Hors taxe
	public double convertirEnHT(double montantTTC) {
		// si le montant est supérieur à 0 on traite la conversion; sinon retourne 0
		return montantTTC / (1 + tauxTVA);
	}

	public static void main(String[] args) {

		double taux = 0.2;
		ConvertisseurTVA convert = new ConvertisseurTVA(taux);

		double val1TTC = -12;
		double val1HT = convert.convertirEnTTC(val1TTC);
		System.out.println("TTC: " + val1TTC + " HT: " + val1HT);

	}

}
