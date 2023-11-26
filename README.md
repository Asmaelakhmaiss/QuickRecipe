<h1 align="center">QuickRecipe </h1>


<br><br><br> <br>
 **Membres du groupe**  <br>
&nbsp;&nbsp;&nbsp;&nbsp;LAKHMAISS Asmae<br>
&nbsp;&nbsp;&nbsp;&nbsp;OUCHAIB Nouha<br>
&nbsp;&nbsp;&nbsp;&nbsp;AIT ALI SAID Khaoula <br>

 **Filière** <br>
&nbsp;&nbsp;&nbsp;&nbsp;DATA INE2

<h4 align="right">Encadré par&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h4>
<p align="right">Professeur: EL HAMLAOUI Mahmoud.</p> <br> <br> <br>

<h4 align="center">Année universitaire 2023/2024</h4>



---
## Table des Matières

1. [Introduction](#Introduction)
2. [Installation et Configuration](#installation-et-configuration)
   - [Environnement de Développement](#environnement-de-développement)
   - [Configuration du Projet](#configuration-du-projet)
   - [Base de Données](#base-de-données)
   - [Dépendances et Bibliothèques](#dépendances-et-bibliothèques)
   - [Lancement et Test](#lancement-et-test)
3. [Fonctionnalités](#fonctionnalités)
   - [Pour les Utilisateurs](#pour-les-utilisateurs)
   - [Pour l’Administrateur](#pour-ladministrateur)
4. [Technologies Utilisées](#technologies-utilisées)
   - [Gestion des Données avec MySQL](#gestion-des-données-avec-mysql)
   - [Développement Back-End](#développement-back-end)
   - [Développement Front-End](#développement-front-end)
5. [Fonctionnement des Composants](#fonctionnement-des-composants)
   - [Package recetteController](#package-recettecontroller)
   - [Package UserController](#package-usercontroller)
   - [Package management_recette](#package-management_recette)
   - [Fonctionnalités Utilisateurs Connectés](#Fonctionnalités-Utilisateurs_Connectés)
   - [Fonctionnalités Administrateur](#Fonctionnalités-Administrateur)
6. [Conclusion](#conclusion)

## Introduction
**QuickRecipe** est une plateforme web interactive destinée aux amateurs de cuisine de tous niveaux. Ce site vise à simplifier le processus de découverte de nouvelles recettes, permettant aux utilisateurs de trouver rapidement et facilement des recettes basées sur des ingrédients spécifiques. Avec une interface utilisateur intuitive, **QuickRecipe** est plus qu'un simple répertoire de recettes ; c'est également une communauté pour les passionnés de cuisine où partager et noter les recettes.

Notre site propose des fonctionnalités interactives telles que la création de compte utilisateur, la soumission de recettes personnelles, ainsi que la possibilité d'évaluer les recettes des autres.

## Installation et Configuration

Dans le cadre du développement du projet **QuickRecipe**, les étapes suivantes ont été réalisées pour mettre en place l'environnement de développement et configurer le projet :

### Environnement de Développement
- **Eclipse IDE** a été utilisé pour le développement. Il a été choisi pour sa compatibilité étendue avec Java EE et sa facilité d'intégration avec divers serveurs et outils.
- **Apache Tomcat 10.1** a été installé comme serveur pour le déploiement et le test de l'application web.
- **MySQL** a été choisi comme système de gestion de base de données pour stocker et gérer les données de l'application.

### Configuration du Projet
- Un **projet dynamique web** a été créé dans Eclipse. Cette structure de projet est idéale pour le développement d'applications web basées sur Java EE.
- **Maven** a été utilisé pour la gestion des dépendances. Cela a permis une gestion efficace et centralisée des bibliothèques nécessaires au projet.

### Base de Données
- Des **tables nécessaires pour le projet** ont été créées et configurées dans MySQL.
- La **connexion entre l'application et la base de données** a été établie, permettant une interaction fluide avec les données.

### Dépendances et Bibliothèques
- Les dépendances requises, telles que les pilotes JDBC, les frameworks et les bibliothèques d'assistance, ont été définies dans le fichier `pom.xml` de Maven et automatiquement gérées par celui-ci.

### Lancement et Test
- L'application a été régulièrement déployée et testée sur le serveur Tomcat local via Eclipse, assurant un flux de travail de développement efficace et continu.

Cette configuration et ces outils ont contribué à la création d'un environnement de développement flexible pour **QuickRecipe**, facilitant le développement, les tests et la maintenance de l'application.

## Fonctionnalités

Le projet **QuickRecipe** offre une gamme de fonctionnalités destinées à améliorer l'expérience des utilisateurs et de l’administrateur. Voici un aperçu détaillé des fonctionnalités clés :

### Pour les Utilisateurs
- **Création de Compte** : Les utilisateurs peuvent s'inscrire pour créer un compte personnel sur la plateforme.
- **Authentification** : Les utilisateurs enregistrés peuvent se connecter pour accéder à des fonctionnalités supplémentaires.
- **Recherche de Recettes** : Rechercher et trouver des recettes en fonction de certains critères.
- **Consultation de Recettes** : Accéder à une variété de recettes avec des instructions détaillées et des informations sur les ingrédients.
- **Navigation dans les Menus** : Explorer la page d'accueil pour découvrir des suggestions et des sélections de recettes.
- **Interaction avec le Site** : Les utilisateurs connectés peuvent ajouter leurs propres recettes, ainsi qu'évaluer les recettes existantes.

### Pour l’Administrateur
- **Gestion des Recettes Soumises** : L’administrateur a la capacité de passer en revue les recettes soumises par les utilisateurs et de décider de les confirmer ou de les rejeter.
- **Modification et Suppression de Recettes** : Gérer les recettes existantes en apportant des modifications ou en supprimant celles qui ne sont plus appropriées ou pertinentes.
- **Navigation et Aperçu des Recettes** : L’administrateur peut également naviguer dans le site pour voir des propositions de recettes et s'assurer de la qualité du contenu proposé.

Ces fonctionnalités, bien que complètes en elles-mêmes, offrent une base solide pour des extensions et améliorations futures. Il est envisageable d'ajouter d'autres fonctionnalités pour rendre le site encore plus interactif et répondre aux besoins changeants des utilisateurs. Ces améliorations pourraient inclure de nouvelles manières d'interagir avec les recettes, des outils de personnalisation avancés pour les utilisateurs, ou des fonctionnalités de réseautage social pour renforcer la communauté de cuisiniers amateurs et professionnels. L'objectif est de continuer à développer **QuickRecipe** en une plateforme encore plus dynamique et engageante pour tous les passionnés de cuisine.

## Technologies Utilisées

Le projet **QuickRecipe** a intégré une diversité de technologies et outils pour assurer une performance optimale, à la fois en back-end et en front-end.

### Gestion des Données avec MySQL
- **Deux Bases de Données Séparées** :
  - Une base de données **Gestion des Utilisateurs** :
    - Table `utilisateurs` pour les informations de connexion et de récupération des comptes.
    - Les mots de passe sont sécurisés par hashage.
  - Une base de données **Gestion des Recettes** :
    - Table pour stocker les **recettes disponibles**.
    - Table pour les **recettes soumises par les utilisateurs**.
    - Table pour gérer les **actions des utilisateurs** sur les recettes.

### Développement Back-End
- Utilisation de **Java EE** pour la logique côté serveur.
- **Classes DAO (Data Access Object)** pour encapsuler l'accès à la base de données et les opérations CRUD.
- **Servlets** pour la gestion des requêtes et des réponses HTTP.
- **JSP (JavaServer Pages)** pour générer dynamiquement des pages HTML.

### Développement Front-End
- **JSP et CSS** pour la conception et la stylisation de l'interface utilisateur.
- **JavaScript** pour enrichir l'interface avec des fonctionnalités interactives et intuitives.

Cette combinaison de technologies a permis de développer notre application web, combinant une gestion efficace des données côté serveur avec une interface utilisateur réactive. 

## Fonctionnement des Composants

Le site web **QuickRecipe** intègre divers composants et technologies Java EE pour offrir une expérience utilisateur dynamique. Voici une description détaillée de ces composants, organisée par package et fonctionnalité :

### Package `recetteController`
- **accueil.jsp** : La page d'accueil dynamique qui s'adapte selon l'état de connexion de l'utilisateur, affichant un menu de recettes.
- **SingleConnexion.java** : Établit la connexion avec la base de données `quickrecipe`.
- **recette.java** : Représente une recette dans le système.
- **recetteDAO.java** : Fournit des méthodes pour interroger et manipuler la table `quickrecipe`.
- **rechercheServlet.java** : Traite les critères de recherche des utilisateurs et affiche les résultats sur `recherche.jsp`.
- **detailsServlet.java** : Récupère et affiche les détails d'une recette spécifique sur `details.jsp`.

### Package `UserController`
- **signup.jsp** : Permet aux nouveaux utilisateurs de s'inscrire.
- **InscriptionServlet.java** : Gère le processus d'inscription et les validations associées.
- **login.jsp** : Formulaire de connexion pour les utilisateurs enregistrés.
- **ConnectionServlet.java** : Authentifie les utilisateurs et gère les erreurs de connexion.

### Package `management_recette`
- **Recette.java** : Représente les recettes soumises par les utilisateurs.
- **SingleConnexion.java** : Gère la connexion à la base de données pour les recettes soumises.
- **RecipeDAO.java** : Contient des méthodes pour interagir avec la table `recettes_temp`.
- **add_recipe.jsp** : Un formulaire pour permettre aux utilisateurs de soumettre de nouvelles recettes.
- **add_recipeServlet.java** : Traite les nouvelles recettes et les stocke dans la base de données.

### Fonctionnalités Utilisateurs Connectés
- **LikeDislikeServlet.java** (du package `recetteController`) : Permet aux utilisateurs de liker ou disliker des recettes. Les votes sont enregistrés dans la table `votes`.
- **LogoutServlet.java** : Permet aux utilisateurs de se déconnecter du site.

### Fonctionnalités Administrateur
- **AfficherTableServlet.java** (du package `management_recette`) : Affiche les recettes soumises par les utilisateurs pour examen par l'administrateur.
- **admin_Recipe_Validation.jsp** :  Interface pour que l'administrateur confirme ou rejette les recettes soumises.
- **ConfirmServlet.java** et **DeleteServlet.java** : Gèrent respectivement la confirmation et la suppression des recettes.
- **AfficherTableServlet2.java** (du package `recetteController`) : Affiche les recettes disponibles pour la gestion.
- **admin_Recipe_Management.jsp** : Interface pour que l'administrateur modifie ou supprime les recettes existantes.
- **EditServlet.java** : Gère la modification des recettes à travers le formulaire présenté dans `edit.jsp`.
- **Delet1Servlet.java** : Permet à l'administrateur de supprimer des recettes existantes.

Chaque composant de **QuickRecipe** joue un rôle clé dans l'interaction de l'utilisateur avec le site, que ce soit pour la navigation, la gestion des recettes, ou la participation à la communauté en ligne.

## Conclusion

Le projet **QuickRecipe** démontre l'efficacité de l'utilisation de Java EE dans le développement d'applications web. À travers ce projet, nous avons réussi à construire une plateforme interactive et fonctionnelle, centrée sur le partage et la découverte de recettes culinaires. Les défis rencontrés et les solutions apportées témoignent de la flexibilité de Java EE en tant que cadre de développement.

---




