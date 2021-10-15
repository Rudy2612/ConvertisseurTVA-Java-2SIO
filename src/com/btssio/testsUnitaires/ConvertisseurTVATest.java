package com.btssio.testsUnitaires;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.btssio.convertisseurs.ConvertisseurTVA;

class ConvertisseurTVATest {

	@Test
	void testGetTauxTVA() {
		ConvertisseurTVA instance = new ConvertisseurTVA(0.2);
		double result = instance.getTauxTVA();
		double resultAttendu = 0.2;
		assertEquals(result, resultAttendu);
	}

	@Test
	void testSetTauxTVA() {
		ConvertisseurTVA instance = new ConvertisseurTVA(0.2);
		instance.setTauxTVA(2);
		double result = instance.getTauxTVA();
		double resultAttendu = 0;
		assertEquals(result, resultAttendu);
	}

	@Test
	void testConvertisseurTVA() {
		System.out.println("testConvertisseurTVA");
		double resultatAttendu = 0.2;
		ConvertisseurTVA instance = new ConvertisseurTVA(0.2);
		double resultat = instance.getTauxTVA();
		assertEquals(resultatAttendu, resultat);
	}

	@Test
	void testConvertisseurTVA_tauxTVA_faux_unitie_zero() {
		System.out.println("testConvertisseurTVA_tauxTVA_faux_unitie_zero");
		double resultatAttendu = 0.0;
		double resultat1, resultat2;
		ConvertisseurTVA instance = new ConvertisseurTVA(5);
		resultat1 = instance.getTauxTVA();
		instance = new ConvertisseurTVA(-0.05);
		resultat2 = instance.getTauxTVA();
		assertEquals(resultatAttendu, resultat1);
		assertEquals(resultatAttendu, resultat2);
	}

	@Test
	void testConvertirEnTTC() {
		System.out.println("testConvertirEnTTC");
		// création de variable
		double t_TVA = 0.2;
		double montantHT = 100;
		double resultatAttendu = 120;
		double resultatAttendu2 = -120;
		double resultat, resultat2;
		// création d'une instace et test de conversion
		ConvertisseurTVA instance = new ConvertisseurTVA(t_TVA);
		resultat = instance.convertirEnTTC(montantHT);
		resultat2 = instance.convertirEnTTC(-100);
		// compare les valeurs
		assertEquals(resultatAttendu, resultat);
		assertEquals(resultatAttendu2, resultat2);
	}

	@Test
	void testConvertirEnHT() {
		System.out.println("testConvertirEnTTC");
		// création de variable
		double t_TVA = 0.2;
		double montantTTC = 12;
		double resultatAttendu = 10;
		double resultatAttendu2 = 20;
		double resultat, resultat2;
		// création d'une instace et test de conversion
		ConvertisseurTVA instance = new ConvertisseurTVA(t_TVA);
		resultat = instance.convertirEnHT(montantTTC);
		resultat2 = instance.convertirEnHT(24);
		// compare les valeurs
		assertEquals(resultatAttendu, resultat);
		assertEquals(resultatAttendu2, resultat2);
	}

}
