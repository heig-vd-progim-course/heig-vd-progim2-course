# Solution - Mini-projet (partie 1)

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence
[CC BY-SA 4.0](https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md).

## Structure du projet

```text
solution/
└── src/
    ├── Plant.java
    ├── Plot.java
    ├── Gardener.java
    └── GardenManagementSystem.java
```

## Fichiers de la solution

### Plant.java

[Voir le code source](./src/Plant.java)

Cette classe représente une plante dans le jardin avec les attributs suivants :

- `name` : le nom de la plante.
- `species` : l'espèce de la plante.
- `plantingDate` : la date de plantation.
- `size` : la taille de la plante en centimètres.
- `isHarvested` : indique si la plante a été récoltée (booléen).

La classe contient un constructeur pour initialiser tous les attributs (avec
`isHarvested` initialisé à `false` par défaut), une méthode `displayInfo()`
pour afficher les informations de la plante, et une méthode `harvest()` pour
récolter la plante.

### Plot.java

[Voir le code source](./src/Plot.java)

Cette classe représente une parcelle dans le jardin communautaire avec les
attributs suivants :

- `plotNumber` : le numéro de la parcelle.
- `size` : la taille de la parcelle en mètres carrés.
- `location` : la localisation de la parcelle.

La classe contient un constructeur pour initialiser tous les attributs et une
méthode `displayInfo()` pour afficher les informations de la parcelle.

### Gardener.java

[Voir le code source](./src/Gardener.java)

Cette classe représente un jardinier qui cultive une parcelle avec les attributs
suivants :

- `name` : le nom du jardinier.
- `email` : l'adresse email du jardinier.
- `experienceYears` : le nombre d'années d'expérience.

La classe contient un constructeur pour initialiser tous les attributs et une
méthode `displayInfo()` pour afficher les informations du jardinier.

### GardenManagementSystem.java

[Voir le code source](./src/GardenManagementSystem.java)

Cette classe principale contient la méthode `main()` qui permet de tester les
trois autres classes. Elle crée plusieurs objets (plantes, parcelles,
jardiniers), affiche leurs informations, et démontre l'utilisation de la
méthode `harvest()` pour récolter des plantes.

## Compilation et exécution

Pour compiler et exécuter la solution, placez-vous dans le dossier `src/` et
exécutez les commandes suivantes :

```bash
# Compilation de tous les fichiers Java
javac *.java

# Exécution de la classe principale
java GardenManagementSystem
```

## Sortie attendue

```text
=== Système de gestion de jardin communautaire ===

--- Plantes du jardin ---
=== Informations de la plante ===
Nom: Tomate cerise
Espèce: Solanum lycopersicum
Date de plantation: 2025-04-15
Taille: 45.5 cm
Récoltée: Non

=== Informations de la plante ===
Nom: Carotte
Espèce: Daucus carota
Date de plantation: 2025-03-20
Taille: 12.0 cm
Récoltée: Non

=== Informations de la plante ===
Nom: Basilic
Espèce: Ocimum basilicum
Date de plantation: 2025-05-01
Taille: 25.3 cm
Récoltée: Non

--- Parcelles du jardin ---
=== Informations de la parcelle ===
Numéro: 1
Taille: 10.5 m²
Localisation: Zone Nord

=== Informations de la parcelle ===
Numéro: 2
Taille: 15.0 m²
Localisation: Zone Sud

--- Jardiniers du jardin ---
=== Informations du jardinier ===
Nom: Alice Dupont
Email: alice.dupont@example.com
Expérience: 3 ans

=== Informations du jardinier ===
Nom: Bob Martin
Email: bob.martin@example.com
Expérience: 5 ans

--- Mise à jour de la taille de la tomate ---
=== Informations de la plante ===
Nom: Tomate cerise
Espèce: Solanum lycopersicum
Date de plantation: 2025-04-15
Taille: 52.7 cm
Récoltée: Non

--- Récolte des plantes ---
La plante Tomate cerise a été récoltée avec succès !
La plante Carotte a été récoltée avec succès !

--- État des plantes après récolte ---
=== Informations de la plante ===
Nom: Tomate cerise
Espèce: Solanum lycopersicum
Date de plantation: 2025-04-15
Taille: 52.7 cm
Récoltée: Oui

=== Informations de la plante ===
Nom: Carotte
Espèce: Daucus carota
Date de plantation: 2025-03-20
Taille: 12.0 cm
Récoltée: Oui

--- Tentative de récolte de la tomate à nouveau ---
La plante Tomate cerise a déjà été récoltée.
```

## Points clés de cette solution

### 1. Structure des classes

Toutes les classes suivent une structure similaire :

- Déclaration des attributs publics.
- Constructeur pour initialiser tous les attributs.
- Méthode `displayInfo()` pour afficher les informations.

Cette structure est un patron courant en programmation orientée objet.

### 2. Utilisation du mot-clé `this`

Dans les constructeurs, le mot-clé `this` permet de différencier les attributs
de la classe des paramètres du constructeur qui portent le même nom :

```java
public Plant(String name, String species, String plantingDate, double size) {
    this.name = name;           // this.name = attribut, name = paramètre
    this.species = species;     // this.species = attribut, species = paramètre
    this.plantingDate = plantingDate;
    this.size = size;
}
```

### 3. Création d'objets avec `new`

Le mot-clé `new` permet de créer une nouvelle instance d'une classe :

```java
Plant tomato = new Plant("Tomate cerise", "Solanum lycopersicum", 
                         "2025-04-15", 45.5);
```

Cette instruction :

1. Alloue de la mémoire pour un nouvel objet de type `Plant`.
2. Appelle le constructeur avec les paramètres fournis.
3. Retourne une référence vers cet objet qui est stockée dans la variable
   `tomato`.

### 4. Accès direct aux attributs publics

Comme les attributs sont publics, on peut les modifier directement :

```java
tomato.size = 52.7;
```

C'est une mauvaise pratique qui sera corrigée dans la prochaine session sur
l'encapsulation.

### 5. Appel de méthodes

Pour appeler une méthode sur un objet, on utilise la notation pointée :

```java
tomato.displayInfo();
```

### 6. Méthode harvest()

La méthode `harvest()` illustre plusieurs concepts importants :

**Modification de l'état** : une méthode peut modifier les attributs d'un objet
:

```java
public void harvest() {
    if (isHarvested) {
        System.out.println("La plante " + name + " a déjà été récoltée.");
    } else {
        isHarvested = true;  // Modification de l'attribut
        System.out.println("La plante " + name + " a été récoltée avec succès !");
    }
}
```

**Logique conditionnelle** : la méthode vérifie l'état actuel avant de modifier
l'objet, ce qui évite des actions incohérentes (récolter une plante déjà
récoltée).

**Affichage contextuel** : le message affiché dépend de l'état de l'objet, ce
qui rend l'interaction avec l'utilisateur plus informative.

## Évolutions futures

Dans les prochaines parties du mini-projet, nous améliorerons ce code :

- **Partie 2** : ajout de l'encapsulation (attributs privés, getters, setters)
  et de l'héritage pour créer différents types de plantes.
- **Partie 3** : introduction du polymorphisme avec des interfaces.
- **Partie 4** : tri des plantes selon différents critères.
- **Partie 5** : utilisation des collections Java pour gérer les données.

## Notes pour l'enseignant

Cette solution illustre volontairement une version simple avec des attributs
publics pour se concentrer sur les concepts de base :

- Définition de classes.
- Déclaration d'attributs de différents types (y compris boolean).
- Création de constructeurs.
- Instanciation d'objets.
- Appel de méthodes.
- Modification de l'état d'un objet par une méthode (`harvest()`).

L'absence d'encapsulation est intentionnelle et sera corrigée dans la prochaine
session où les étudiants verront pourquoi il est important de protéger les
données d'une classe.

La méthode `harvest()` introduit la notion de méthode qui modifie l'état d'un
objet et qui contient de la logique conditionnelle, préparant ainsi les
étudiants aux concepts plus avancés qui seront vus dans les prochaines sessions.
