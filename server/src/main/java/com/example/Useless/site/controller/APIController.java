package com.example.Useless.site.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Useless.site.model.CountryModel;
import com.example.Useless.site.service.CountryServices;

/**
 * Contrôleur REST pour la gestion des endpoints liés aux pays
 * Gère les requêtes HTTP et les oriente vers le service approprié
 */
@RestController
@RequestMapping("/api/country")
public class APIController {

    @Autowired
    private CountryServices countryServices;

    /**
     * Constructeur du contrôleur
     * @param countryServices Service d'accès aux données des pays
     */
    public APIController(CountryServices countryServices) {
        this.countryServices = countryServices;
    }

    /**
     * Endpoint pour récupérer les informations d'un pays aléatoire
     * 
     * @return CountryModel contenant les données du pays (nom, capitale, population, carte)
     * @throws Exception Si une erreur se produit lors de la récupération des données
     */
    @GetMapping("/random_country")
    public CountryModel getRandomCountry() throws Exception {
        return countryServices.getRandomCountry();
    }
}