package com.btssio.convertisseurs;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ConvertisseurGlobalTest {

	@Test
	void testCreationEtAjout() throws DeviseNomException {
		ConvertisseurGlobal convert = new ConvertisseurGlobal();
		Devise euro = new Devise("EUR", 2);
		Boolean check = convert.ajouterDevise(euro);
		// System.out.print(check);
		assertEquals(check, true);

		ArrayList<Devise> devisesAjoutes = convert.getLesDevises();
		assertEquals(devisesAjoutes.size(), 2);
	}

	@Test
	void testRechercheDevise() throws DeviseNomException {
		ConvertisseurGlobal convert = new ConvertisseurGlobal();
		Devise euro = new Devise("EURO", 2);
		Boolean check = convert.ajouterDevise(euro);
		Devise recherche = convert.rechercheDevise("EURO");
		assertEquals(euro, recherche);
		assertEquals(check, true);
	}

	@Test
	void testRechercheDeviseNull() throws DeviseNomException {
		ConvertisseurGlobal convert = new ConvertisseurGlobal();
		Devise recherche = convert.rechercheDevise("YENS");
		assertNull(recherche);
	}

	@Test
	void testAjouterDevise_nonOk_deviseDejaExistante() throws DeviseNomException {
		ConvertisseurGlobal convert = new ConvertisseurGlobal();
		Devise euro = new Devise("EURO", 2);
		Boolean check = convert.ajouterDevise(euro);
		Boolean check2 = convert.ajouterDevise(euro);
		assertFalse(check2);

	}

	@Test
	void testConvertir() throws DeviseNomException {
		ConvertisseurGlobal convert = new ConvertisseurGlobal();
		Devise euro = new Devise("EURO", 0.9);
		Devise yen = new Devise("YENS", 110.20);
		Boolean check = convert.ajouterDevise(euro);
		Boolean check2 = convert.ajouterDevise(yen);
		double resultat1 = convert.convertir(0, "EURO", "YENS");
		double resultat2 = convert.convertir(1, "EURO", "USD");
		double resultat3 = convert.convertir(1.11, "USDD", "YENS");
		double resultat4 = convert.convertir(1, "EURO", "YENS");
		double resultatAttendu1 = 0;
		double resultatAttendu2 = 1.11;
		double resultatAttendu3 = 122.32;
		double resultatAttendu4 = 122.32;
		assertEquals(resultat1, resultatAttendu1);
		assertEquals(resultat2, resultatAttendu2);
		assertEquals(resultat3, resultatAttendu3);
		assertEquals(resultat4, resultatAttendu4, 0.5);
	}

}
