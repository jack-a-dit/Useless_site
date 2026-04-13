package com.example.Useless.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale de l'application UselessSite
 * 
 * Cette application Spring Boot fournit une API REST pour obtenir
 * des informations sur des pays aléatoires via le service REST Countries API.
 * 
 * Endpoints disponibles:
 * - GET /api/country/random_country : Retourne les informations d'un pays aléatoire
 */
@SpringBootApplication
public class UselessSiteApplication {

	/**
	 * Méthode principale - point d'entrée de l'application
	 * @param args Arguments de la ligne de commande
	 */
	public static void main(String[] args) {
		SpringApplication.run(UselessSiteApplication.class, args);
	}

}
