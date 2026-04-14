package com.example.Useless.site.model;

import com.example.Useless.site.model.CoordinateModel;

/**
 * Modèle de données représentant un pays
 * 
 * Cette classe contient les informations essentielles d'un pays:
 * - Nom du pays
 * - Capitale
 * - Population
 * - Lien Google Maps
 */
public class CountryModel {
    // Nom du pays
    String name;
    
    // Capitale du pays
    String capital;
    
    // Population totale du pays
    long population;
    
    // URL Google Maps du pays
    CoordinateModel map;

    /**
     * Constructeur pour initialiser un objet CountryModel
     * @param name Nom du pays
     * @param capital Capitale du pays
     * @param population Population du pays
     * @param map URL Google Maps
     */
    public CountryModel(String name, String capital, long population, CoordinateModel map) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.map = map;
    }

    /**
     * Retourne le nom du pays
     * @return Le nom du pays
     */
    public String getName() {
        return name;
    }

    /**
     * Définit le nom du pays
     * @param name Le nom à définir
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retourne la capitale du pays
     * @return La capitale du pays
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Définit la capitale du pays
     * @param capital La capitale à définir
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * Retourne la population du pays
     * @return La population du pays
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Définit la population du pays
     * @param population La population à définir
     */
    public void setPopulation(long population) {
        this.population = population;
    }

    /**
     * Retourne le lien Google Maps
     * @return L'URL Google Maps
     */
    public CoordinateModel getMap() {
        return map;
    }

    /**
     * Définit le lien Google Maps
     * @param map L'URL Google Maps à définir
     */
    public void setMap(CoordinateModel map) {
        this.map = map;
    }

}



