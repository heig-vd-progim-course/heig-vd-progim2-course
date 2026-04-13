# Collections Java : Listes, sets et maps - Mini-projet (partie 5)

Bienvenue dans la cinquième partie du mini-projet sur la gestion de jardin
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
  - [Étape 6 : supprimer des éléments pendant l'itération](#étape-6--supprimer-des-éléments-pendant-litération)
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

Dans cette cinquième partie du mini-projet, nous allons intégrer les collections
Java dans notre système de gestion de jardin communautaire.

Lors des sessions précédentes, nous avons :

- **Partie 1** : créé des classes de base avec des attributs et méthodes
  publics.
- **Partie 2** : appliqué l'encapsulation et l'héritage avec une hiérarchie de
  plantes.
- **Partie 3** : utilisé le polymorphisme avec des interfaces et la redéfinition
  de méthodes.
- **Partie 4** : trié les plantes avec des algorithmes de tri et des
  comparateurs.

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
> la partie 4, récupérez le code de la solution avant de continuer.
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

    private String name;
    private double area;
    private List<PlantBase> plants;

    /**
     * Constructeur pour créer une parcelle.
     *
     * @param name le nom de la parcelle
     * @param area la surface en mètres carrés
     */
    public Plot(String name, double area) {
        this.name = name;
        this.area = area;
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
                + name + ".");
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
                    + name + ".");
        } else {
            System.out.println(plant.getName() + " non trouvée dans la "
                    + "parcelle " + name + ".");
        }
        return removed;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
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
}
```

Prenez un moment pour observer les différences avec la version précédente :

- Le champ `plants` est maintenant de type `List<PlantBase>` au lieu d'un
  tableau.
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
        System.out.println("Parcelle " + name + " (" + area + " m2) - "
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
                    + plot.getName() + " (ancienne : "
                    + previous.getName() + ").");
        } else {
            System.out.println(gardenerName
                    + " est assignée à la parcelle "
                    + plot.getName() + ".");
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
                    + removed.getName() + ").");
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
            System.out.println("  " + entry.getKey() + " -> "
                    + entry.getValue().getName());
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
                result.add(entry.getValue().getName());
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

### Étape 6 : supprimer des éléments pendant l'itération

Ajoutons une méthode dans la classe `Plot` qui supprime toutes les plantes
récoltées de la parcelle. Cette opération nécessite de modifier la liste pendant
le parcours : nous devons utiliser un itérateur.

Ajoutez cette méthode dans la classe `Plot` :

```java
import java.util.Iterator;
```

```java
    /**
     * Supprime toutes les plantes qui ont été récoltées.
     *
     * @return le nombre de plantes supprimées
     */
    public int removeHarvestedPlants() {
        int count = 0;
        Iterator<PlantBase> it = plants.iterator();
        while (it.hasNext()) {
            PlantBase plant = it.next();
            if (plant instanceof Harvestable) {
                Harvestable harvestable = (Harvestable) plant;
                if (!harvestable.isReadyToHarvest()) {
                    continue;
                }
                System.out.println("Retrait de " + plant.getName()
                        + " (récoltée).");
                it.remove();
                count++;
            }
        }
        System.out.println(count + " plante(s) récoltée(s) retirée(s) de "
                + name + ".");
        return count;
    }
```

Cette méthode illustre le cas où l'itérateur est indispensable :

- On parcourt la liste avec `it.hasNext()` et `it.next()`.
- On utilise `instanceof` pour vérifier si la plante implémente `Harvestable`
  (polymorphisme).
- On appelle `it.remove()` pour supprimer l'élément courant de manière
  sécurisée.
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
        System.out.println();

        // --- Créer le catalogue d'espèces ---
        System.out.println("--- Catalogue des espèces ---");
        GardenCatalog catalog = new GardenCatalog();
        catalog.addSpecies("Solanum lycopersicum");
        catalog.addSpecies("Daucus carota");
        catalog.addSpecies("Rosa gallica");
        catalog.addSpecies("Malus domestica");
        catalog.addSpecies("Solanum lycopersicum"); // Doublon
        System.out.println();
        catalog.displayCatalog();
        System.out.println();

        // --- Créer des parcelles avec des listes ---
        System.out.println("--- Création des parcelles ---");
        Plot plotA = new Plot("Parcelle A", 25.0);
        Plot plotB = new Plot("Parcelle B", 30.0);

        VegetablePlant tomato = new VegetablePlant(
                "Tomate", "Solanum lycopersicum",
                "2026-03-15", 45.0, 0);
        VegetablePlant carrot = new VegetablePlant(
                "Carotte", "Daucus carota",
                "2026-03-20", 20.0, 30);
        FlowerPlant rose = new FlowerPlant(
                "Rose", "Rosa gallica",
                "2026-04-01", 60.0, "Rouge");
        TreePlant appleTree = new TreePlant(
                "Pommier", "Malus domestica",
                "2026-02-01", 150.0, 4);

        plotA.addPlant(tomato);
        plotA.addPlant(carrot);
        plotB.addPlant(rose);
        plotB.addPlant(appleTree);
        System.out.println();

        plotA.displayPlants();
        System.out.println();
        plotB.displayPlants();
        System.out.println();

        // --- Créer le registre jardinière-parcelle ---
        System.out.println("--- Registre du jardin ---");
        GardenRegistry registry = new GardenRegistry();
        registry.assignPlot("Alice", plotA);
        registry.assignPlot("Bob", plotB);
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
                    + alicePlot.getName());
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
        System.out.println("Parcelle A contient la tomate : "
                + plotA.containsPlant(tomato));
        System.out.println("Parcelle B contient la tomate : "
                + plotB.containsPlant(tomato));
        System.out.println();

        // --- Supprimer des plantes récoltées ---
        System.out.println("--- Récolte et nettoyage ---");
        tomato.harvest();
        System.out.println();
        plotA.removeHarvestedPlants();
        System.out.println();
        plotA.displayPlants();
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

--- Catalogue des espèces ---
Espèce ajoutée au catalogue : Solanum lycopersicum.
Espèce ajoutée au catalogue : Daucus carota.
Espèce ajoutée au catalogue : Rosa gallica.
Espèce ajoutée au catalogue : Malus domestica.
L'espèce Solanum lycopersicum est déjà dans le catalogue.

Catalogue du jardin (4 espèce(s)) :
  - Daucus carota
  - Malus domestica
  - Rosa gallica
  - Solanum lycopersicum

--- Création des parcelles ---
Tomate ajoutée à la parcelle Parcelle A.
Carotte ajoutée à la parcelle Parcelle A.
Rose ajoutée à la parcelle Parcelle B.
Pommier ajoutée à la parcelle Parcelle B.

Parcelle Parcelle A (25.0 m2) - 2 plante(s) :
  - Tomate (Solanum lycopersicum) - 45.0 cm
  - Carotte (Daucus carota) - 20.0 cm

Parcelle Parcelle B (30.0 m2) - 2 plante(s) :
  - Rose (Rosa gallica) - 60.0 cm - Couleur : Rouge
  - Pommier (Malus domestica) - 150.0 cm - Âge: 0 ans

--- Registre du jardin ---
Alice est assignée à la parcelle Parcelle A.
Bob est assignée à la parcelle Parcelle B.

Registre du jardin (2 inscription(s)) :
  Alice -> Parcelle A
  Bob -> Parcelle B

--- Recherches ---
Nombre total de plantes : 4
Parcelle d'Alice : Parcelle A
Bob est inscrit : true
Clara est inscrite : false

Parcelles avec des tomates : [Parcelle A]

--- Vérifications ---
Parcelle A contient la tomate : true
Parcelle B contient la tomate : false

--- Récolte et nettoyage ---
Récolte de Tomate : 4.5 kg

Retrait de Tomate (récoltée).
1 plante(s) récoltée(s) retirée(s) de Parcelle A.

Parcelle Parcelle A (25.0 m2) - 1 plante(s) :
  - Carotte (Daucus carota) - 20.0 cm
```

> [!NOTE]
>
> La sortie exacte peut varier légèrement selon votre implémentation des
> méthodes `toString()` et `harvest()` dans les classes des parties précédentes.
> L'important est que la logique des collections fonctionne correctement : les
> doublons sont rejetés par le catalogue, les associations jardinière-parcelle
> sont retrouvées, et la suppression pendant l'itération s'effectue sans erreur.

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

Dans cette cinquième partie du mini-projet, vous avez appris à :

- Remplacer des tableaux par des `ArrayList` pour bénéficier d'une gestion
  automatique de la taille.
- Utiliser un `HashSet` pour maintenir un catalogue d'éléments uniques.
- Utiliser une `HashMap` pour créer des associations clé-valeur et retrouver
  rapidement des informations.
- Parcourir des collections avec la boucle `for-each` et avec `entrySet()`.
- Utiliser un itérateur pour supprimer des éléments de manière sécurisée pendant
  le parcours.
- Choisir la bonne collection en fonction du besoin.

Le passage des tableaux aux collections est une étape importante. Le code est
plus lisible, plus sûr et plus facile à faire évoluer. Chaque collection a son
rôle et ses forces : les listes pour l'ordre, les ensembles pour l'unicité, les
maps pour les associations.

### Prochaine étape

Dans la prochaine partie du mini-projet, nous explorerons :

- Les expressions lambda pour simplifier le parcours et le filtrage des
  collections.
- Les streams pour enchaîner des opérations sur les collections de manière
  concise.
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
