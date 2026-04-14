package com.example.Useless.site.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe de configuration Spring pour l'application UselessSite
 * 
 * Cette classe enregistre les beans Spring utiles comme RestTemplate
 * pour que les services puissent les utiliser via l'injection de dépendances
 */
@Configuration
public class AppConfig {

    /**
     * Crée et enregistre un bean RestTemplate
     * 
     * RestTemplate est utilisé pour effectuer des requêtes HTTP
     * vers l'API externe RestCountries
     * 
     * @return Une nouvelle instance de RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }

}
