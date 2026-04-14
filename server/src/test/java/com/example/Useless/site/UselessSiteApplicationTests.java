package com.example.Useless.site;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

import com.example.Useless.site.controller.APIController;
import com.example.Useless.site.model.CountryModel;

/**
 * Classe de test pour l'application UselessSite
 * 
 * Tests inclus:
 * 1. Vérification que le contexte Spring Boot se charge correctement
 * 2. Vérification que le contrôleur API est bien créé et injecté
 * 3. Vérification que le service retourne des données valides
 */
@SpringBootTest
class UselessSiteApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private APIController apiController;

	/**
	 * Teste que le contexte Spring Boot se charge correctement
	 * 
	 * Ce test vérifie que toutes les configurations Spring sont valides
	 * et que le contexte a pu être initialisé sans erreur
	 */
	@Test
	void contextLoads() {
		// Le test passe si le contexte ApplicationContext n'est pas null
		assertNotNull(applicationContext, "Le contexte Spring Boot ne devrait pas être null");
	}

	/**
	 * Teste que le contrôleur API est bien créé et disponible
	 * 
	 * Ce test vérifie que le bean APIController a bien été créé
	 * et injecté dans le contexte Spring
	 */
	@Test
	void apiControllerBeanLoads() {
		// Vérifie que le contrôleur API a bien été créé
		assertNotNull(apiController, "Le contrôleur APIController devrait être créé et injecté");
	}

	/**
	 * Teste que le contrôleur peut retourner les données d'un pays
	 * 
	 * Ce test appelle la méthode getRandomCountry du contrôleur
	 * et vérifie qu'elle retourne un objet CountryModel avec les données requises
	 */
	@Test
	void testGetRandomCountryReturnsValidData() throws Exception {
		// Appel au contrôleur pour récupérer un pays aléatoire
		CountryModel country = apiController.getRandomCountry();

		// Vérifications que le pays retourné n'est pas null
		assertNotNull(country, "Le pays retourné ne devrait pas être null");

		// Vérifications que les propriétés du pays sont valides (non null et non vides)
		assertNotNull(country.getName(), "Le nom du pays ne devrait pas être null");
		assertFalse(country.getName().isEmpty(), "Le nom du pays ne devrait pas être vide");

		assertNotNull(country.getCapital(), "La capitale ne devrait pas être null");
		assertFalse(country.getCapital().isEmpty(), "La capitale ne devrait pas être vide");

		// Vérification que la population est positive
		assertTrue(country.getPopulation() > 0, "La population devrait être positive");

		// Vérification que l'URL de la carte est valide (non null et non vide)
//		assertNotNull(country.getMap(), "L'URL de la carte ne devrait pas être null");
//		assertFalse(country.getMap().isEmpty(), "L'URL de la carte ne devrait pas être vide");
//		assertTrue(country.getMap().startsWith("http"), "L'URL de la carte devrait être une URL valide");
	}

}
