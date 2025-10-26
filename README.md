# Atelier3 
# Application Web E-Commerce avec JSF et JPA

## Description

Application web de simulation d'un site e-commerce développée avec les technologies JSF (JavaServer Faces) et JPA (Java Persistence API).

## Objectif

Maîtriser l'API JPA (Java Persistence API) et le Framework JSF par la mise en place d'une application web qui simule le comportement d'un site web e-commerce.

## Technologies Utilisées

- **IDE** : IntelliJ IDEA
- **Gestion de projet** : Maven
- **Serveur d'application** : Wildfly
- **Base de données** : MySQL
- **Framework web** : JSF 4.0
- **Persistance** : JPA 3.0
- **ORM** : Hibernate / EclipseLink
- **Injection de dépendances** : CDI
- **Bibliothèque UI** : PrimeFaces

## Architecture

L'application se concentre sur la gestion de trois modules principaux :
- **Panier** : Gestion du panier d'achat des utilisateurs
- **Vitrine** : Affichage des produits disponibles
- **Internaute** : Gestion des utilisateurs/clients

## Étapes de Développement

### Étape 1 : Conception
Créer un diagramme de classes représentant la gestion du site e-commerce, en se concentrant particulièrement sur :
- La gestion du panier
- La vitrine de produits
- Les internautes (utilisateurs)

### Étape 2 : Création du Projet
Créer un projet web Maven contenant les modules suivants :
- JSF (JavaServer Faces)
- JPA (Java Persistence API)
- CDI (Contexts and Dependency Injection)
- EclipseLink (ou Hibernate)
- Connecteur MySQL

### Étape 3 : Couche de Persistance
- Créer les entités JPA correspondant au modèle de données
- Configurer les transactions JPA
- Générer automatiquement la base de données MySQL à partir des entités
- Mettre en place les fichiers de configuration nécessaires :
  - `persistence.xml`
  - Configuration de la source de données

### Étape 4 : Couche Présentation
Pour chaque module de gestion :
- Créer une classe Bean (Managed Bean)
- Développer plusieurs composants XHTML basés sur JSF
- Intégrer la bibliothèque de composants UI PrimeFaces

## Configuration Requise

### Base de Données
- MySQL installé et configuré
- Créer une base de données dédiée pour l'application

### Serveur d'Application
- Wildfly correctement configuré
- Déploiement de l'application sur Wildfly

### Dépendances Maven
Ajouter les dépendances suivantes dans le `pom.xml` :
- JSF 4.0
- JPA 3.0
- Hibernate ou EclipseLink
- MySQL Connector
- PrimeFaces

## Ressources

- **PrimeFaces** : [https://www.primefaces.org/](https://www.primefaces.org/)
- Documentation officielle JSF
- Documentation JPA/Hibernate

## Structure du Projet
src/
├── main/
│   ├── java/
│   │   └── ma.fstt.atelier3/
│   │       ├── beans/
│   │       │   ├── CartBean.java
│   │       │   ├── ProductBean.java
│   │       │   └── ProductManager.java
│   │       ├── init/
│   │       │   └── DatabaseInitializer.java
│   │       ├── model/
│   │       │   ├── CartItem.java
│   │       │   └── Product.java
│   │       └── service/
│   │           ├── ProductService.java
│   │           └── HelloServlet.java
│   ├── resources/
│   │   └── META-INF/
│   │       ├── beans.xml
│   │       └── persistence.xml
│   └── webapp/
│       ├── META-INF/
│       ├── WEB-INF/
│       │   ├── beans.xml
│       │   ├── h2-ds.xml
│       │   └── web.xml
│       ├── cart.xhtml
│       ├── index.xhtml
│       └── products.xhtml

## Installation et Démarrage

1. Cloner le projet
2. Configurer la base de données MySQL
3. Mettre à jour les paramètres de connexion dans `persistence.xml`
4. Compiler le projet avec Maven : `mvn clean install`
5. Déployer le WAR généré sur Wildfly
6. Accéder à l'application via le navigateur

