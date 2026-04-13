package com.example.Useless.site.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.Useless.site.client.CountryClient;
import com.example.Useless.site.model.CountryModel;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Service métier pour la gestion des informations sur les pays
 * 
 * Ce service gère les opérations liées aux pays:
 * - Récupération de la liste de tous les pays
 * - Récupération des détails d'un pays spécifique
 * - Sélection d'un pays aléatoire
 */
@Service
public class CountryServices {
    
    // Client REST utilisé pour communiquer avec l'API Countries
    @Autowired
    private CountryClient countryClient;

    // Constructeur alternatif avec RestTemplate
    public CountryServices(RestTemplate restTemplate) {
        this.countryClient = new CountryClient(restTemplate);
    }

    // Constructeur par défaut
    public CountryServices() {
        this.countryClient = new CountryClient(new RestTemplate());
    }

    /**
     * Récupère la liste des noms de tous les pays disponibles
     * 
     * @return Liste contenant les noms de tous les pays
     * @throws Exception Si une erreur se produit lors de l'appel à l'API
     */
    private List<String> GetlistOfCountriesNames() throws Exception {
        // Appel au client pour récupérer toutes les données des pays
        JsonNode allCountries = countryClient.GetAllCountries();
        List<String> names = new ArrayList<>();

        // Parcours de la réponse et extraction des noms de pays
        for (JsonNode country : allCountries) {
            String countryName = country.get("name").get("common").asText();
            names.add(countryName);
        }
        return names;
    }

    /**
     * Récupère les détails complètes d'un pays par son nom
     * 
     * @param name Nom du pays recherché
     * @return CountryModel contenant les informations détaillées du pays
     * @throws Exception Si le pays n'est pas trouvé ou erreur API
     */
    private CountryModel GetCountryByName(String name) throws Exception {
        // Appel au client pour récupérer les données du pays
        JsonNode country = countryClient.GetCountryByName(name).get(0);
        
        // Extraction des informations spécifiques du pays
        String capital = country.get("capital").get(0).asText();
        long population = country.get("population").asLong();
        String map = country.get("maps").get("openStreetMaps").asText();

        // Retour d'un objet CountryModel avec les informations
        return new CountryModel(name, capital, population, map);
    }

    /**
     * Méthode publique pour récupérer un pays aléatoire
     * 
     * Processus:
     * 1. Récupère la liste de tous les pays
     * 2. Sélectionne un pays aléatoire
     * 3. Récupère les détails de ce pays
     * 
     * @return CountryModel contenant les informations du pays sélectionné aléatoirement
     * @throws Exception Si une erreur se produit durant le processus
     */
    public CountryModel getRandomCountry() throws Exception {
        // Générateur de nombres aléatoires
        Random random = new Random();
        
        // Récupération de la liste de tous les pays
        List<String> names = GetlistOfCountriesNames();
        
        // Sélection d'un index aléatoire dans la liste
        String randomName = names.get(random.nextInt(names.size()));

        // Récupération et retour des détails du pays sélectionné
        return GetCountryByName(randomName);
    }
}
