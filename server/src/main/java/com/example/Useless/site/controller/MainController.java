package com.example.Useless.site.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String home() {
        return "Application UselessSite est en cours d'exécution. Accédez à /api/country/random_country pour obtenir des informations sur un pays aléatoire.";
    }

    @RequestMapping("/**")
    public String fallback() {
        return "404 - Route introuvable. Veuillez vérifier l'URL et réessayer.";
    }
}
