package com.btssio.convertisseurs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeviseTest {

	@Test
	void testNewDeviseWithChangementTaux() throws DeviseNomException {
		Devise nouvelle = new Devise("USD", 0.1);
		nouvelle.setTauxChange(0.5);
		double result = nouvelle.getTauxChange();
		assertEquals(result, 0.5);
	}

	@Test
	void testChangementsTaux() throws DeviseNomException {
		Devise nouvelle = new Devise("USD", 5);
		nouvelle.setTauxChange(2);
		double result = nouvelle.getTauxChange();
		assertEquals(result, 2);
	}

	@Test
	void testChangementDeNom() throws DeviseNomException {
		Devise nouvelle = new Devise("USD", 5);
		nouvelle.setNom("USB");
		String nom = nouvelle.getNom();
		String nomAttendu = "USB";
		assertEquals(nom, nomAttendu);
	}

	@Test
	void testDeviseDeviseNomExceptionAttenduNomIncorrect() throws Exception {
		System.out.println("testDevise nom à 4 caractères");
		// premier argument : la classe exception attendue
		// second argument la partie de code executable qui doit planter
		Assertions.assertThrows(DeviseNomException.class, () -> {
			Devise instance = new Devise("EURO", 1);
		});
	}

}
