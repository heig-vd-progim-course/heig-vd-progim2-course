# Collections Java : Listes, sets et maps - Mini-projet (partie 4)

Bienvenue dans la quatrième partie du mini-projet sur la gestion de jardin
communautaire !

> [!TIP]
>
> Toutes les informations relatives à ce contenu sont décrites dans le
> [support de cours principal](../).

## Table des matières

- [Table des matières](#table-des-matières)
- [Présentation du mini-projet](#présentation-du-mini-projet)
- [Objectifs de cette session](#objectifs-de-cette-session)
- [Structure du projet](#structure-du-projet)
- [Remplacer les tableaux par des listes](#remplacer-les-tableaux-par-des-listes)
  - [Étape 1 : modifier la classe Plot pour utiliser une ArrayList](#étape-1--modifier-la-classe-plot-pour-utiliser-une-arraylist)
  - [Étape 2 : adapter les méthodes de Plot](#étape-2--adapter-les-méthodes-de-plot)
- [Gérer les espèces uniques avec un ensemble](#gérer-les-espèces-uniques-avec-un-ensemble)
  - [Étape 3 : créer la classe GardenCatalog](#étape-3--créer-la-classe-gardencatalog)
- [Associer des jardinières à des parcelles avec une map](#associer-des-jardinières-à-des-parcelles-avec-une-map)
  - [Étape 4 : créer la classe GardenRegistry](#étape-4--créer-la-classe-gardenregistry)
- [Parcourir et manipuler les collections](#parcourir-et-manipuler-les-collections)
  - [Étape 5 : ajouter des méthodes de recherche à GardenRegistry](#étape-5--ajouter-des-méthodes-de-recherche-à-gardenregistry)
  - [Étape 6 : récolter et supprimer des plantes pendant l'itération](#étape-6--récolter-et-supprimer-des-plantes-pendant-litération)
- [Mettre à jour le programme principal](#mettre-à-jour-le-programme-principal)
  - [Étape 7 : mettre à jour GardenManagementSystem](#étape-7--mettre-à-jour-gardenmanagementsystem)
- [Test du projet](#test-du-projet)
  - [Compilation et exécution en ligne de commande](#compilation-et-exécution-en-ligne-de-commande)
  - [Sortie attendue](#sortie-attendue)
- [Solution](#solution)
- [Conclusion](#conclusion)
  - [Prochaine étape](#prochaine-étape)
- [Aller plus loin](#aller-plus-loin)

## Présentation du mini-projet

Dans cette quatrième partie du mini-projet, nous allons intégrer les collections
Java dans notre système de gestion de jardin communautaire.

Lors des sessions précédentes, nous avons :

- **Partie 1** : créé des classes de base avec des attributs et méthodes
  publics.
- **Partie 2** : appliqué l'encapsulation et l'héritage avec une hiérarchie de
  plantes.
- **Partie 3** : utilisé le polymorphisme avec des interfaces et la redéfinition
  de méthodes.

Jusqu'ici, nous avons utilisé des tableaux pour stocker nos plantes et nos
parcelles. Les tableaux nous ont bien servi, mais ils montrent leurs limites :
ajouter ou supprimer une plante demande de gérer manuellement la taille, il n'y
a pas de moyen simple de vérifier si une espèce est déjà présente, et retrouver
la parcelle d'une jardinière nécessite de parcourir tout le tableau.

Dans cette session, nous allons remplacer ces tableaux par des collections
adaptées à chaque besoin :

- Une `ArrayList` pour gérer les plantes d'une parcelle (ordre et doublons
  possibles).
- Un `HashSet` pour maintenir un catalogue d'espèces uniques.
- Une `HashMap` pour associer chaque jardinière à sa parcelle.

## Objectifs de cette session

À l'issue de cette session, les personnes qui étudient devraient avoir pu :

- Remplacer des tableaux par des `ArrayList` dans une classe existante.
- Utiliser un `HashSet` pour garantir l'unicité des éléments.
- Utiliser une `HashMap` pour associer des clés à des valeurs.
- Parcourir des collections avec la boucle `for-each`.
- Supprimer des éléments pendant l'itération avec un itérateur.
- Choisir la collection adaptée en fonction du besoin.

## Structure du projet

Pour cette partie du mini-projet, nous allons modifier des classes existantes et
en créer de nouvelles :

```text
08-collections-java-listes-sets-et-maps/
└── 03-mini-projet/
    └── src/
        ├── Harvestable.java
        ├── Waterable.java
        ├── Growable.java
        ├── PlantBase.java
        ├── VegetablePlant.java
        ├── FlowerPlant.java
        ├── TreePlant.java
        ├── Plot.java                    (modifiée)
        ├── Gardener.java
        ├── GardenTask.java
        ├── GardenCatalog.java           (nouvelle classe)
        ├── GardenRegistry.java          (nouvelle classe)
        └── GardenManagementSystem.java  (mise à jour)
```

> [!IMPORTANT]
>
> Cette partie fait suite aux sessions précédentes. Si vous n'avez pas terminé
> la partie 3, récupérez le code de la solution avant de continuer.
>
> Votre projet doit contenir toutes les classes des parties précédentes.

## Remplacer les tableaux par des listes

Commençons par le changement le plus direct : remplacer le tableau de plantes
dans la classe `Plot` par une `ArrayList`.

### Étape 1 : modifier la classe Plot pour utiliser une ArrayList

Dans la version actuelle, `Plot` utilise un tableau pour stocker ses plantes.
L'ajout et la suppression d'une plante nécessitent de gérer la taille
manuellement. Avec une `ArrayList`, tout cela disparaît.

Ouvrez le fichier `Plot.java` et modifiez-le pour utiliser une `ArrayList` :

```java
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une parcelle du jardin communautaire.
 */
public class Plot {

    private int number;
    private double size;
    private String location;
    private List<PlantBase> plants;

    /**
     * Constructeur pour créer une parcelle.
     *
     * @param number le numéro de la parcelle
     * @param size la taille en mètres carrés
     * @param location la localisation
     */
    public Plot(int number, double size, String location) {
        setNumber(number);
        setSize(size);
        setLocation(location);
        this.plants = new ArrayList<>();
    }

    /**
     * Ajoute une plante à la parcelle.
     *
     * @param plant la plante à ajouter
     */
    public void addPlant(PlantBase plant) {
        plants.add(plant);
        System.out.println(plant.getName() + " ajoutée à la parcelle "
                + number + ".");
    }

    /**
     * Supprime une plante de la parcelle.
     *
     * @param plant la plante à supprimer
     * @return true si la plante a été supprimée, false sinon
     */
    public boolean removePlant(PlantBase plant) {
        boolean removed = plants.remove(plant);
        if (removed) {
            System.out.println(plant.getName() + " retirée de la parcelle "
                    + number + ".");
        } else {
            System.out.println(plant.getName() + " non trouvée dans la "
                    + "parcelle " + number + ".");
        }
        return removed;
    }

    // Getters
    public int getNumber() {
        return number;
    }

    public double getSize() {
        return size;
    }

    public String getLocation() {
        return location;
    }

    public List<PlantBase> getPlants() {
        return plants;
    }

    /**
     * Retourne le nombre de plantes dans la parcelle.
     *
     * @return le nombre de plantes
     */
    public int getPlantCount() {
        return plants.size();
    }

    // Setters avec validation (inchangés depuis la partie 2)
    public void setNumber(int number) {
        if (number <= 0) {
            System.out.println(
                    "Erreur : le numéro de parcelle doit être positif.");
            return;
        }
        this.number = number;
    }

    public void setSize(double size) {
        if (size <= 0) {
            System.out.println(
                    "Erreur : la taille doit être positive.");
            return;
        }
        this.size = size;
    }

    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            System.out.println(
                    "Erreur : la localisation ne peut pas être vide.");
            return;
        }
        this.location = location;
    }
}
```

Prenez un moment pour observer les différences avec la version précédente :

- Un nouveau champ `plants` de type `List<PlantBase>` a été ajouté. Les
  attributs existants (`number`, `size`, `location`) restent inchangés.
- Le constructeur initialise une `ArrayList` vide, sans besoin de spécifier une
  taille.
- `addPlant()` utilise simplement `plants.add(plant)` sans se soucier de la
  taille.
- `removePlant()` utilise `plants.remove(plant)` qui retourne un booléen.
- `getPlantCount()` utilise `plants.size()` au lieu de gérer un compteur
  manuellement.

> [!NOTE]
>
> La méthode `remove()` de l'`ArrayList` utilise la méthode `equals()` de la
> classe `PlantBase` pour trouver l'élément à supprimer. C'est pour cela que
> nous avons redéfini `equals()` et `hashCode()` dans la partie 3 du
> mini-projet.

### Étape 2 : adapter les méthodes de Plot

Ajoutons quelques méthodes utiles qui tirent parti de l'`ArrayList` :

```java
    /**
     * Vérifie si la parcelle contient une plante donnée.
     *
     * @param plant la plante à rechercher
     * @return true si la plante est présente, false sinon
     */
    public boolean containsPlant(PlantBase plant) {
        return plants.contains(plant);
    }

    /**
     * Affiche toutes les plantes de la parcelle.
     */
    public void displayPlants() {
        System.out.println("Parcelle " + number + " (" + location
                + ", " + size + " m2) - "
                + plants.size() + " plante(s) :");
        for (PlantBase plant : plants) {
            System.out.println("  - " + plant);
        }
    }
```

Ajoutez ces méthodes dans la classe `Plot`, après les getters.

La méthode `containsPlant()` utilise `contains()` de l'`ArrayList`, qui parcourt
la liste et compare chaque élément avec `equals()`.

La méthode `displayPlants()` utilise une boucle `for-each` pour parcourir toutes
les plantes. Remarquez que `plant` est de type `PlantBase` : grâce au
polymorphisme, la méthode `toString()` appelée par `System.out.println()` sera
celle de la sous-classe concrète (`VegetablePlant`, `FlowerPlant` ou
`TreePlant`).

## Gérer les espèces uniques avec un ensemble

Dans notre jardin, nous voulons maintenir un catalogue des espèces disponibles.
Chaque espèce ne doit apparaître qu'une seule fois, même si plusieurs plantes de
la même espèce sont cultivées sur différentes parcelles.

Un `HashSet` est parfait pour cela : il garantit l'unicité des éléments et
permet de vérifier rapidement si une espèce existe déjà.

### Étape 3 : créer la classe GardenCatalog

Créez un fichier `GardenCatalog.java` dans le dossier `src/` :

```java
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Catalogue des espèces disponibles dans le jardin communautaire.
 * Chaque espèce n'apparaît qu'une seule fois.
 */
public class GardenCatalog {

    private Set<String> species;

    /**
     * Constructeur pour créer un catalogue vide.
     */
    public GardenCatalog() {
        this.species = new HashSet<>();
    }

    /**
     * Ajoute une espèce au catalogue.
     *
     * @param speciesName le nom de l'espèce à ajouter
     * @return true si l'espèce a été ajoutée, false si elle existait déjà
     */
    public boolean addSpecies(String speciesName) {
        boolean added = species.add(speciesName);
        if (added) {
            System.out.println("Espèce ajoutée au catalogue : "
                    + speciesName + ".");
        } else {
            System.out.println("L'espèce " + speciesName
                    + " est déjà dans le catalogue.");
        }
        return added;
    }

    /**
     * Vérifie si une espèce est dans le catalogue.
     *
     * @param speciesName le nom de l'espèce à rechercher
     * @return true si l'espèce est dans le catalogue, false sinon
     */
    public boolean hasSpecies(String speciesName) {
        return species.contains(speciesName);
    }

    /**
     * Retourne le nombre d'espèces dans le catalogue.
     *
     * @return le nombre d'espèces
     */
    public int getSpeciesCount() {
        return species.size();
    }

    /**
     * Affiche toutes les espèces du catalogue par ordre alphabétique.
     */
    public void displayCatalog() {
        System.out.println("Catalogue du jardin (" + species.size()
                + " espèce(s)) :");
        Set<String> sorted = new TreeSet<>(species);
        for (String s : sorted) {
            System.out.println("  - " + s);
        }
    }
}
```

Observez quelques points importants :

- La méthode `addSpecies()` retourne le résultat de `species.add()`. La méthode
  `add()` d'un `Set` retourne `true` si l'élément a été ajouté, `false` s'il
  existait déjà. Pas besoin de vérifier manuellement avant d'ajouter.
- La méthode `displayCatalog()` crée un `TreeSet` à partir du `HashSet` pour
  afficher les espèces triées par ordre alphabétique. Le `HashSet` ne garantit
  pas l'ordre, mais le `TreeSet` trie automatiquement.

> [!TIP]
>
> Vous remarquez que nous construisons un `TreeSet` temporaire juste pour
> l'affichage. Une alternative serait de déclarer `species` directement comme un
> `TreeSet` dès le départ. Le choix dépend de ce qui est le plus important : la
> vitesse d'ajout et de recherche (`HashSet`) ou l'ordre permanent (`TreeSet`).

## Associer des jardinières à des parcelles avec une map

Nous voulons maintenant pouvoir associer chaque jardinière à une parcelle et
retrouver rapidement la parcelle d'une jardinière à partir de son nom. C'est
exactement le rôle d'une `HashMap`.

### Étape 4 : créer la classe GardenRegistry

Créez un fichier `GardenRegistry.java` dans le dossier `src/` :

```java
import java.util.HashMap;
import java.util.Map;

/**
 * Registre du jardin communautaire.
 * Associe chaque jardinière (par son nom) à sa parcelle.
 */
public class GardenRegistry {

    private Map<String, Plot> assignments;

    /**
     * Constructeur pour créer un registre vide.
     */
    public GardenRegistry() {
        this.assignments = new HashMap<>();
    }

    /**
     * Assigne une parcelle à une jardinière.
     * Si la jardinière avait déjà une parcelle, l'ancienne est remplacée.
     *
     * @param gardenerName le nom de la jardinière
     * @param plot la parcelle à assigner
     */
    public void assignPlot(String gardenerName, Plot plot) {
        Plot previous = assignments.put(gardenerName, plot);
        if (previous != null) {
            System.out.println(gardenerName
                    + " est maintenant assignée à la parcelle "
                    + plot.getNumber() + " (ancienne : "
                    + previous.getNumber() + ").");
        } else {
            System.out.println(gardenerName
                    + " est assignée à la parcelle "
                    + plot.getNumber() + ".");
        }
    }

    /**
     * Retrouve la parcelle d'une jardinière.
     *
     * @param gardenerName le nom de la jardinière
     * @return la parcelle associée, ou null si la jardinière n'est pas inscrite
     */
    public Plot getPlot(String gardenerName) {
        return assignments.get(gardenerName);
    }

    /**
     * Vérifie si une jardinière est inscrite au registre.
     *
     * @param gardenerName le nom de la jardinière
     * @return true si la jardinière est inscrite, false sinon
     */
    public boolean isRegistered(String gardenerName) {
        return assignments.containsKey(gardenerName);
    }

    /**
     * Retire une jardinière du registre.
     *
     * @param gardenerName le nom de la jardinière à retirer
     * @return la parcelle qui était associée, ou null si non inscrite
     */
    public Plot unregister(String gardenerName) {
        Plot removed = assignments.remove(gardenerName);
        if (removed != null) {
            System.out.println(gardenerName
                    + " a été retirée du registre (parcelle "
                    + removed.getNumber() + ").");
        }
        return removed;
    }

    /**
     * Affiche toutes les associations jardinière-parcelle.
     */
    public void displayAssignments() {
        System.out.println("Registre du jardin ("
                + assignments.size() + " inscription(s)) :");
        for (Map.Entry<String, Plot> entry : assignments.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> Parcelle "
                    + entry.getValue().getNumber());
        }
    }
}
```

Observez comment la `HashMap` simplifie le code :

- `put()` gère à la fois l'ajout et la mise à jour. Elle retourne l'ancienne
  valeur si la clé existait déjà, ou `null` si c'est un nouvel ajout. On utilise
  ce retour pour afficher un message adapté.
- `get()` retourne la valeur associée à une clé, ou `null` si la clé n'existe
  pas.
- `containsKey()` permet de vérifier l'existence d'une clé sans récupérer la
  valeur.
- `entrySet()` retourne un ensemble de paires clé-valeur que l'on peut parcourir
  avec une boucle `for-each`.

## Parcourir et manipuler les collections

### Étape 5 : ajouter des méthodes de recherche à GardenRegistry

Ajoutons des méthodes qui exploitent le parcours des collections. Ajoutez ces
méthodes dans la classe `GardenRegistry` :

```java
    /**
     * Retourne le nombre total de plantes dans toutes les parcelles.
     *
     * @return le nombre total de plantes
     */
    public int getTotalPlantCount() {
        int total = 0;
        for (Plot plot : assignments.values()) {
            total += plot.getPlantCount();
        }
        return total;
    }

    /**
     * Recherche toutes les parcelles contenant une plante donnée.
     *
     * @param plant la plante à rechercher
     * @return la liste des noms de parcelles contenant la plante
     */
    public List<String> findPlotsWithPlant(PlantBase plant) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Plot> entry : assignments.entrySet()) {
            if (entry.getValue().containsPlant(plant)) {
                result.add("Parcelle " + entry.getValue().getNumber());
            }
        }
        return result;
    }
```

> [!NOTE]
>
> N'oubliez pas d'ajouter les imports nécessaires en haut du fichier :
>
> ```java
> import java.util.ArrayList;
> import java.util.List;
> ```

La méthode `getTotalPlantCount()` parcourt les valeurs de la map avec
`assignments.values()` et additionne le nombre de plantes de chaque parcelle.

La méthode `findPlotsWithPlant()` parcourt toutes les entrées de la map avec
`entrySet()` et construit une liste de résultats. Remarquez que cette méthode
retourne une `List<String>` : une nouvelle collection créée à partir du parcours
d'une autre collection. C'est un usage très courant.

### Étape 6 : récolter et supprimer des plantes pendant l'itération

Ajoutons une méthode dans la classe `Plot` qui récolte et supprime toutes les
plantes prêtes à être récoltées. Cette opération nécessite de modifier la liste
pendant le parcours : nous devons utiliser un itérateur.

Ajoutez cette méthode dans la classe `Plot` :

```java
import java.util.Iterator;
```

```java
    /**
     * Récolte et supprime toutes les plantes prêtes à être récoltées.
     *
     * @return le nombre de plantes récoltées et supprimées
     */
    public int harvestAndRemoveReadyPlants() {
        int count = 0;
        Iterator<PlantBase> it = plants.iterator();
        while (it.hasNext()) {
            PlantBase plant = it.next();
            if (plant instanceof Harvestable) {
                Harvestable harvestable = (Harvestable) plant;
                if (harvestable.isReadyToHarvest()) {
                    harvestable.harvest();
                    System.out.println("Retrait de " + plant.getName()
                            + " de la parcelle " + number + ".");
                    it.remove();
                    count++;
                }
            }
        }
        System.out.println(count
                + " plante(s) récoltée(s) et retirée(s) de la parcelle "
                + number + ".");
        return count;
    }
```

Cette méthode illustre le cas où l'itérateur est indispensable :

- On parcourt la liste avec `it.hasNext()` et `it.next()`.
- On utilise `instanceof` pour vérifier si la plante implémente `Harvestable`
  (polymorphisme).
- On vérifie avec `isReadyToHarvest()` si la plante est prête, on la récolte
  avec `harvest()`, puis on la retire avec `it.remove()`.
- Si nous avions utilisé `plants.remove()` pendant une boucle `for-each`, une
  `ConcurrentModificationException` serait levée.

> [!WARNING]
>
> Rappel : ne jamais utiliser `collection.remove()` à l'intérieur d'une boucle
> `for-each`. Utilisez `iterator.remove()` à la place.

## Mettre à jour le programme principal

### Étape 7 : mettre à jour GardenManagementSystem

Remplaçons le programme principal pour utiliser toutes nos nouvelles
collections. Ouvrez le fichier `GardenManagementSystem.java` et remplacez son
contenu :

```java
import java.util.List;

/**
 * Programme principal du système de gestion de jardin communautaire.
 */
public class GardenManagementSystem {

    public static void main(String[] args) {
        System.out.println("=== Système de gestion de jardin "
                + "communautaire ===");
        System.out.println("Partie 4 : Collections\n");

        // --- Créer le catalogue d'espèces ---
        System.out.println("--- Catalogue des espèces ---");
        GardenCatalog catalog = new GardenCatalog();
        catalog.addSpecies("Solanum lycopersicum");
        catalog.addSpecies("Daucus carota");
        catalog.addSpecies("Rosa");
        catalog.addSpecies("Malus domestica");
        catalog.addSpecies("Solanum lycopersicum"); // Doublon
        System.out.println();
        catalog.displayCatalog();
        System.out.println();

        // --- Créer des parcelles avec des listes ---
        System.out.println("--- Création des parcelles ---");
        Plot plot1 = new Plot(1, 25.0, "Zone Nord");
        Plot plot2 = new Plot(2, 30.0, "Zone Sud");

        VegetablePlant tomato = new VegetablePlant(
                "Tomate cerise", "Solanum lycopersicum",
                "2026-03-15", 45.5, 0);
        VegetablePlant carrot = new VegetablePlant(
                "Carotte", "Daucus carota",
                "2026-03-20", 12.0, 30);
        FlowerPlant rose = new FlowerPlant(
                "Rose", "Rosa",
                "2026-04-01", 35.0, "Rouge");
        TreePlant appleTree = new TreePlant(
                "Pommier", "Malus domestica",
                "2026-02-01", 180.0, 3, 3);

        plot1.addPlant(tomato);
        plot1.addPlant(carrot);
        plot2.addPlant(rose);
        plot2.addPlant(appleTree);
        System.out.println();

        plot1.displayPlants();
        System.out.println();
        plot2.displayPlants();
        System.out.println();

        // --- Créer le registre jardinière-parcelle ---
        System.out.println("--- Registre du jardin ---");
        GardenRegistry registry = new GardenRegistry();
        registry.assignPlot("Alice", plot1);
        registry.assignPlot("Bob", plot2);
        System.out.println();

        registry.displayAssignments();
        System.out.println();

        // --- Rechercher des informations ---
        System.out.println("--- Recherches ---");
        System.out.println("Nombre total de plantes : "
                + registry.getTotalPlantCount());

        Plot alicePlot = registry.getPlot("Alice");
        if (alicePlot != null) {
            System.out.println("Parcelle d'Alice : "
                    + alicePlot.getNumber());
        }

        System.out.println("Bob est inscrit : "
                + registry.isRegistered("Bob"));
        System.out.println("Clara est inscrite : "
                + registry.isRegistered("Clara"));
        System.out.println();

        List<String> plotsWithTomato =
                registry.findPlotsWithPlant(tomato);
        System.out.println("Parcelles avec des tomates : "
                + plotsWithTomato);
        System.out.println();

        // --- Vérifier si une plante existe dans la parcelle ---
        System.out.println("--- Vérifications ---");
        System.out.println("Parcelle 1 contient la tomate : "
                + plot1.containsPlant(tomato));
        System.out.println("Parcelle 2 contient la tomate : "
                + plot2.containsPlant(tomato));
        System.out.println();

        // --- Récolter et supprimer des plantes ---
        System.out.println("--- Récolte et nettoyage ---");
        plot1.harvestAndRemoveReadyPlants();
        System.out.println();
        plot1.displayPlants();
    }
}
```

> [!TIP]
>
> Prenez le temps de lire le programme principal du début à la fin. Remarquez
> comment chaque collection répond à un besoin différent :
>
> - Le `GardenCatalog` (basé sur un `HashSet`) gère les espèces uniques.
> - Le `Plot` (basé sur une `ArrayList`) gère les plantes ordonnées d'une
>   parcelle.
> - Le `GardenRegistry` (basé sur une `HashMap`) associe les jardinières à leurs
>   parcelles.

## Test du projet

### Compilation et exécution en ligne de commande

Pour compiler et exécuter le projet, ouvrez un terminal dans le dossier `src/`
et exécutez les commandes suivantes :

```bash
javac *.java
java GardenManagementSystem
```

### Sortie attendue

Le résultat devrait ressembler à ceci (l'ordre de certains éléments peut varier
car les `HashSet` et `HashMap` ne garantissent pas l'ordre) :

```text
=== Système de gestion de jardin communautaire ===
Partie 4 : Collections

--- Catalogue des espèces ---
Espèce ajoutée au catalogue : Solanum lycopersicum.
Espèce ajoutée au catalogue : Daucus carota.
Espèce ajoutée au catalogue : Rosa.
Espèce ajoutée au catalogue : Malus domestica.
L'espèce Solanum lycopersicum est déjà dans le catalogue.

Catalogue du jardin (4 espèce(s)) :
  - Daucus carota
  - Malus domestica
  - Rosa
  - Solanum lycopersicum

--- Création des parcelles ---
Tomate cerise ajoutée à la parcelle 1.
Carotte ajoutée à la parcelle 1.
Rose ajoutée à la parcelle 2.
Pommier ajoutée à la parcelle 2.

Parcelle 1 (Zone Nord, 25.0 m2) - 2 plante(s) :
  - Tomate cerise (Solanum lycopersicum) - 45.5 cm - Planté le 2026-03-15 [Légume - Récolte dans 0 jours]
  - Carotte (Daucus carota) - 12.0 cm - Planté le 2026-03-20 [Légume - Récolte dans 30 jours]

Parcelle 2 (Zone Sud, 30.0 m2) - 2 plante(s) :
  - Rose (Rosa) - 35.0 cm - Planté le 2026-04-01 [Fleur Rouge - Pas encore en fleurs]
  - Pommier (Malus domestica) - 180.0 cm - Planté le 2026-02-01 [Arbre - Âge: 3 ans]

--- Registre du jardin ---
Alice est assignée à la parcelle 1.
Bob est assignée à la parcelle 2.

Registre du jardin (2 inscription(s)) :
  Alice -> Parcelle 1
  Bob -> Parcelle 2

--- Recherches ---
Nombre total de plantes : 4
Parcelle d'Alice : 1
Bob est inscrit : true
Clara est inscrite : false

Parcelles avec des tomates : [Parcelle 1]

--- Vérifications ---
Parcelle 1 contient la tomate : true
Parcelle 2 contient la tomate : false

--- Récolte et nettoyage ---
Récolte de Tomate cerise : 4.55 kg
Retrait de Tomate cerise de la parcelle 1.
1 plante(s) récoltée(s) et retirée(s) de la parcelle 1.

Parcelle 1 (Zone Nord, 25.0 m2) - 1 plante(s) :
  - Carotte (Daucus carota) - 12.0 cm - Planté le 2026-03-20 [Légume - Récolte dans 30 jours]
```

> [!NOTE]
>
> La sortie exacte peut varier légèrement selon votre implémentation des
> méthodes `toString()` et `harvest()` dans les classes des parties précédentes.
> L'important est que la logique des collections fonctionne correctement : les
> doublons sont rejetés par le catalogue, les associations jardinière-parcelle
> sont retrouvées, et la récolte pendant l'itération s'effectue sans erreur.

## Solution

Vous pouvez trouver la solution complète du mini-projet à l'adresse suivante :
[`solution`](./solution/).

> [!NOTE]
>
> La solution est fournie à titre indicatif uniquement. Il est fortement
> recommandé de développer votre propre version du mini-projet avant de
> consulter la solution.
>
> Il existe souvent plusieurs façons de résoudre un même problème. Cette
> solution illustre une approche possible, mais ce n'est pas nécessairement la
> seule solution correcte.

## Conclusion

Dans cette quatrième partie du mini-projet, vous avez appris à :

- Ajouter un champ `List<PlantBase>` dans la classe `Plot` pour gérer les
  plantes avec une `ArrayList`.
- Utiliser un `HashSet` pour maintenir un catalogue d'éléments uniques.
- Utiliser une `HashMap` pour créer des associations clé-valeur et retrouver
  rapidement des informations.
- Parcourir des collections avec la boucle `for-each` et avec `entrySet()`.
- Utiliser un itérateur pour récolter et supprimer des éléments de manière
  sécurisée pendant le parcours.
- Choisir la bonne collection en fonction du besoin.

Le passage des tableaux aux collections est une étape importante. Le code est
plus lisible, plus sûr et plus facile à faire évoluer. Chaque collection a son
rôle et ses forces : les listes pour l'ordre, les ensembles pour l'unicité, les
maps pour les associations.

### Prochaine étape

Dans la prochaine partie du mini-projet, nous explorerons :

- Les expressions lambda pour simplifier le parcours et le filtrage des
  collections.
- Les génériques pour créer des classes réutilisables avec différents types.

> [!TIP]
>
> Conservez votre code ! Vous en aurez besoin pour les prochaines sessions du
> mini-projet.

## Aller plus loin

> [!TIP]
>
> Cette section est optionnelle.
>
> Vous pouvez y revenir si vous avez du temps ou si vous souhaitez approfondir
> vos connaissances après avoir terminé le mini-projet.

Voici quelques pistes pour enrichir votre projet :

- Ajoutez une méthode dans `GardenRegistry` qui retourne la parcelle contenant
  le plus de plantes.
- Créez une méthode dans `GardenCatalog` qui supprime les espèces dont aucune
  plante n'est cultivée dans aucune parcelle.
- Ajoutez un `HashMap<String, List<String>>` dans `GardenCatalog` pour associer
  chaque espèce à ses variétés.
- Implémentez une méthode `transferPlant()` dans `GardenRegistry` qui déplace
  une plante d'une parcelle à une autre.
- Ajoutez un historique des événements du jardin sous forme de `List<String>`
  dans `GardenRegistry`.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
