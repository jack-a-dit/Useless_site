# 🌍 Serveur Useless Site

## 📋 Description

**Useless Site** est une application backend Spring Boot qui fournit une API REST permettant d'obtenir des informations aléatoires sur les pays du monde.

L'application communique avec l'API publique [REST Countries](https://restcountries.com/) pour récupérer des données actualisées sur tous les pays, et expose ces données via un endpoint REST simple.

### Version
- **Version**: 0.0.1-SNAPSHOT
- **Java**: 17
- **Spring Boot**: 4.0.5

---

## 🎯 Utilité

Ce serveur est idéal pour:

✅ **Apprendre Spring Boot** - Architecture claire avec contrôleurs, services et clients  
✅ **Démonstration d'API REST** - Exemple d'intégration avec une API externe  
✅ **Test et développement** - Application simple pour tester des outils ou technologies  
✅ **Frontend intégration** - Fournit les données à une interface utilisateur (ex: Angular, React)  

### Fonctionnalités principales

- 🌐 **Endpoint API REST** pour récupérer les pays aléatoires
- 🔀 **Sélection aléatoire** parmi tous les pays mondiaux
- 📊 **Données richeskij** : nom, capitale, population, lien Google Maps
- 🧪 **Tests unitaires** inclus avec assertions complètes
- 📝 **Code bien commenté** en français pour faciliter la compréhension

---

## � Prérequis système

Avant d'installer et lancer l'application, assurez-vous que votre système respecte les exigences suivantes:

### 🔧 Logiciels requis

#### 1. Java Development Kit (JDK) 17 ou supérieur
```bash
# Vérifier la version installée
java -version

# Sortie attendue (exemple):
# openjdk version "17.0.12" 2024-07-16 LTS
# OpenJDK Runtime Environment (build 17.0.12+7-LTS)
# OpenJDK 64-Bit Server VM (build 17.0.12+7-LTS, mixed mode, sharing)
```

**Installation:**


### 🔍 Vérification de l'environnement

Exécutez cette commande pour vérifier que tout est correctement installé:

```bash
# Vérifier Java
java -version

# Vérifier Git
git --version

# Vérifier que Maven Wrapper fonctionne
.\mvnw.cmd --version  # Windows
# ou
./mvnw --version      # Linux/Mac
```

Si toutes les commandes s'exécutent sans erreur, votre environnement est prêt!

---

## 📦 Installation

### Prérequis

Avant de commencer, assurez-vous d'avoir installé:

- **Java Development Kit (JDK) 17+**  
  Vérifiez : `java -version`

- **Git** (pour cloner le repository)  
  Vérifiez : `git --version`

Maven n'est pas requis - le projet inclut **Maven Wrapper** (`mvnw.cmd` sur Windows, `mvnw` sur Linux/Mac)

### Étapes d'installation

#### 1. Cloner le repository
```bash
git clone <url-repo>
cd Useless_site/server
```

#### 2. Vérifier la version Java
```bash
java -version
# Doit afficher Java 17 ou supérieur
```

#### 3. Construire le projet
```bash
# Sur Windows
.\mvnw.cmd clean install

# Sur Linux/Mac
./mvnw clean install
```

Cette commande:
- Télécharge les dépendances automatiquement
- Compile le code source
- Exécute les tests
- Crée un fichier JAR

#### 4. Vérifier l'installation
Si tout fonctionne correctement, vous devriez voir:
```
[INFO] BUILD SUCCESS
[INFO] Total time: X.XXX s
```

---

## 🚀 Lancer l'application

### Méthode 1: Avec Maven Wrapper (Recommandé)

#### Sur Windows:
```bash
cd Votre\Path\Absolue\Useless_site\server
.\mvnw.cmd spring-boot:run
```

#### Sur Linux/Mac:
```bash
cd Votre/Path/Absolue/Useless_site/server
./mvnw spring-boot:run
```

### Méthode 2: Avec Java directement

```bash
# D'abord, construire le projet
.\mvnw.cmd clean install

# Puis lancer le JAR
java -jar target/Useless-site-0.0.1-SNAPSHOT.jar
```

### Vérifier que le serveur est lancé

Vous devriez voir dans la console:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.0.5)

Started UselessSiteApplication in X.XXX seconds
```

Le serveur est maintenant accessible à: **http://localhost:8080**

---

## 🔌 Utilisation de l'API

### Endpoint disponible

#### Récupérer un pays aléatoire

**Requête:**
```http
GET http://localhost:8080/api/country/random_country
```

**Réponse (JSON):**
```json
{
  "name": "France",
  "capital": "Paris",
  "population": 67750000,
  "map": "https://goo.gl/maps/..."
}
```

**Exemple avec cURL:**
```bash
curl http://localhost:8080/api/country/random_country
```

**Exemple avec Postman:**
1. Ouvrir Postman
2. Créer une nouvelle requête GET
3. URL: `http://localhost:8080/api/country/random_country`
4. Cliquer sur "Send"

**Exemple avec JavaScript (Frontend):**
```javascript
fetch('http://localhost:8080/api/country/random_country')
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error('Erreur:', error));
```

---

## 🧪 Exécuter les tests

### Lancer tous les tests

#### Sur Windows:
```bash
.\mvnw.cmd test
```

#### Sur Linux/Mac:
```bash
./mvnw test
```

### Résultats attendus

L'output devrait afficher:
```
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] BUILD SUCCESS
```

### Types de tests inclus

1. **contextLoads** - Vérifie que Spring Boot se charge correctement
2. **apiControllerBeanLoads** - Vérifie que le contrôleur est créé
3. **testGetRandomCountryReturnsValidData** - Teste que l'API retourne des données valides

---

## 📁 Structure du projet

```
server/
├── src/
│   ├── main/
│   │   ├── java/com/example/Useless/site/
│   │   │   ├── UselessSiteApplication.java       # Point d'entrée
│   │   │   ├── config/
│   │   │   │   └── AppConfig.java                # Configuration Spring
│   │   │   ├── controller/
│   │   │   │   └── APIController.java            # Endpoints REST
│   │   │   ├── service/
│   │   │   │   └── CountryServices.java          # Logique métier
│   │   │   ├── client/
│   │   │   │   └── CountryClient.java            # Appels API externe
│   │   │   └── model/
│   │   │       └── CountryModel.java             # Modèle de données
│   │   └── resources/
│   │       └── application.properties            # Configuration
│   └── test/
│       └── java/...
│           └── UselessSiteApplicationTests.java  # Tests unitaires
├── pom.xml                                        # Configuration Maven
├── mvnw.cmd                                       # Maven Wrapper (Windows)
├── mvnw                                          # Maven Wrapper (Linux/Mac)
└── README.md                                      # Ce fichier
```

---

## ⚙️ Configuration

### Port par défaut
L'application écoute sur le port **8080** par défaut.

### Dépendances principales

- **Spring Boot Web Starter** - Framework REST
- **Jackson** - Sérialisation JSON
- **JUnit 5** - Framework de test
- **Spring Boot Test** - Tests Spring Boot

---

## 📚 Ressources utiles

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [REST Countries API](https://restcountries.com/)
- [Maven Guide](https://maven.apache.org/guides/getting-started/)
- [Java 17 Documentation](https://docs.oracle.com/en/java/javase/17/)

---

## 👨‍💻 Développé avec

- Java 17
- Spring Boot 4.0.5
- Maven
- JUnit 5

---

## 📄 License

Ce projet est fourni à titre d'exemple éducatif.

---

## 💬 Support

Pour toute question ou problème, consultez la section **Dépannage** ci-dessus ou les fichiers commentés du projet.

---

**Dernière mise à jour**: Avril 2026  
**Statut**: En développement ✅
