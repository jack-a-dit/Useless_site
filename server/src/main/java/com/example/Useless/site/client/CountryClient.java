package com.example.Useless.site.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Client REST pour l'API RestCountries
 * 
 * Ce client gére la communication avec l'API https://restcountries.com/
 * qui fournit des informations détaillées sur tous les pays du monde.
 * 
 * Principales fonctionnalités:
 * - Récupération de tous les pays
 * - Recherche d'un pays par son nom
 */
@Component
public class CountryClient {

    // Client HTTP d'utilisation pour les requêtes REST
    private final RestTemplate restTemplate;
    
    // Mappeur JSON pour parser les réponses API
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Constructeur du client Rest Countries
     * @param restTemplate Le template REST injecté par Spring
     */
    public CountryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Récupère la liste complète de tous les pays disponibles
     * 
     * @return JsonNode contenant toutes les données des pays
     * @throws Exception Si la requête HTTP échoue ou le JSON ne peut pas être traversé
     */
    public JsonNode GetAllCountries() throws Exception {
        // URL de l'API REST Countries pour récupérer tous les pays
        // Les paramètres fields spécifient les données requises pour chaque pays
        String url = "https://restcountries.com/v3.1/all?fields=name";
        
        // Effectue une requête GET et récupère la réponse en tant que String
        String response = restTemplate.getForObject(url, String.class);
        
        // Parse la réponse JSON en structure JsonNode
        return mapper.readTree(response);
    }

    /**
     * Recherche un pays spécifique par son nom
     * 
     * @param name Le nom du pays à rechercher
     * @return JsonNode contenant les données du pays trouvé
     * @throws Exception Si la requête HTTP échoue, le pays n'existe pas, ou le JSON ne peut pas être traversé
     */
    public JsonNode GetCountryByName(String name) throws Exception {
        // URL de l'API REST Countries pour rechercher un pays par nom
        String url = "https://restcountries.com/v3.1/name/" + name;
        
        // Effectue une requête GET et récupère la réponse en tant que String
        String response = restTemplate.getForObject(url, String.class);
        
        // Parse la réponse JSON en structure JsonNode
        return mapper.readTree(response);
    }
}
