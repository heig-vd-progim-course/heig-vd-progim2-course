# Collections Java : Lambda et génériques - Mini-projet (partie 5)

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
- [Simplifier le code avec des lambdas](#simplifier-le-code-avec-des-lambdas)
  - [Étape 1 : utiliser forEach dans la classe Plot](#étape-1--utiliser-foreach-dans-la-classe-plot)
  - [Étape 2 : utiliser removeIf pour remplacer l'itérateur](#étape-2--utiliser-removeif-pour-remplacer-litérateur)
  - [Étape 3 : ajouter un filtrage par prédicat dans Plot](#étape-3--ajouter-un-filtrage-par-prédicat-dans-plot)
- [Créer une classe générique réutilisable](#créer-une-classe-générique-réutilisable)
  - [Étape 4 : créer la classe générique FilterResult](#étape-4--créer-la-classe-générique-filterresult)
  - [Étape 5 : utiliser FilterResult dans Plot](#étape-5--utiliser-filterresult-dans-plot)
- [Mettre à jour le programme principal](#mettre-à-jour-le-programme-principal)
  - [Étape 6 : mettre à jour GardenManagementSystem](#étape-6--mettre-à-jour-gardenmanagementsystem)
- [Test du projet](#test-du-projet)
  - [Compilation et exécution en ligne de commande](#compilation-et-exécution-en-ligne-de-commande)
  - [Sortie attendue](#sortie-attendue)

## Présentation du mini-projet

Dans cette cinquième partie du mini-projet, nous allons simplifier et
généraliser le code de notre système de gestion de jardin communautaire en
utilisant des expressions lambda et des génériques.

Lors des sessions précédentes, nous avons :

- **Partie 1** : créé des classes de base avec des attributs et méthodes
  publics.
- **Partie 2** : appliqué l'encapsulation et l'héritage avec une hiérarchie de
  plantes.
- **Partie 3** : utilisé le polymorphisme avec des interfaces et la redéfinition
  de méthodes.
- **Partie 4** : intégré les collections Java (`ArrayList`, `HashSet`,
  `HashMap`).

Dans la partie 4, nous avons écrit des boucles `for-each` et un itérateur pour
parcourir, filtrer et modifier les collections. Ce code fonctionne, mais il est
souvent verbeux : pour chaque opération, nous écrivons une boucle complète avec
une condition.

Dans cette session, nous allons :

- Remplacer les boucles par des lambdas (`forEach`, `removeIf`, `sort`).
- Ajouter des méthodes de filtrage paramétrable avec `Predicate`.
- Créer une classe générique `FilterResult<T>` réutilisable pour encapsuler les
  résultats de filtrage.

## Objectifs de cette session

À l'issue de cette session, les personnes qui étudient devraient avoir pu :

- Utiliser `forEach` pour remplacer les boucles `for-each`.
- Utiliser `removeIf` pour remplacer l'itérateur avec suppression.
- Passer un `Predicate` en paramètre pour filtrer des éléments.
- Créer une classe générique avec un paramètre de type `<T>`.
- Utiliser un wildcard borné (`<? extends T>`) pour écrire du code flexible.

## Structure du projet

Pour cette partie du mini-projet, nous allons modifier des classes existantes et
en créer une nouvelle :

```text
09-collections-java-lambda-et-generiques/
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
        ├── GardenCatalog.java
        ├── GardenRegistry.java
        ├── FilterResult.java            (nouvelle classe générique)
        └── GardenManagementSystem.java  (mise à jour)
```

> [!IMPORTANT]
>
> Cette partie fait suite aux sessions précédentes. Si vous n'avez pas terminé
> la partie 4, récupérez le code de la solution avant de continuer.
>
> Votre projet doit contenir toutes les classes des parties précédentes.

## Simplifier le code avec des lambdas

### Étape 1 : utiliser forEach dans la classe Plot

Dans la partie 4, la méthode `displayPlants()` utilise une boucle `for-each` :

```java
public void displayPlants() {
    System.out.println("Parcelle " + number + " (" + location
            + ", " + size + " m2) - "
            + plants.size() + " plante(s) :");
    for (PlantBase plant : plants) {
        System.out.println("  - " + plant);
    }
}
```

Remplacez la boucle `for-each` par un appel à `forEach` avec une lambda :

```java
public void displayPlants() {
    System.out.println("Parcelle " + number + " (" + location
            + ", " + size + " m2) - "
            + plants.size() + " plante(s) :");
    plants.forEach(plant -> System.out.println("  - " + plant));
}
```

Le résultat est identique, mais le code est plus concis. La lambda
`plant -> System.out.println("  - " + plant)` est un `Consumer<PlantBase>` qui
est appliqué à chaque élément de la liste.

### Étape 2 : utiliser removeIf pour remplacer l'itérateur

Dans la partie 4, la méthode `harvestAndRemoveReadyPlants()` utilise un
itérateur pour récolter et supprimer les plantes prêtes :

```java
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

Nous pouvons simplifier cette méthode en collectant d'abord les plantes prêtes à
récolter avec `forEach`, puis en les supprimant avec `removeAll` :

```java
public int harvestAndRemoveReadyPlants() {
    // Identifier les plantes prêtes à récolter
    List<PlantBase> toRemove = new ArrayList<>();
    plants.forEach(plant -> {
        if (plant instanceof Harvestable) {
            Harvestable harvestable = (Harvestable) plant;
            if (harvestable.isReadyToHarvest()) {
                harvestable.harvest();
                toRemove.add(plant);
            }
        }
    });

    // Supprimer les plantes récoltées
    plants.removeAll(toRemove);
    int count = toRemove.size();

    System.out.println(count
            + " plante(s) récoltée(s) et retirée(s) de la parcelle "
            + number + ".");
    return count;
}
```

> [!NOTE]
>
> On collecte d'abord les plantes prêtes dans une liste temporaire `toRemove`,
> ce qui évite le problème de modification de la liste pendant son parcours.
> Ensuite, `removeAll` supprime toutes les plantes récoltées en une seule
> opération.

### Étape 3 : ajouter un filtrage par prédicat dans Plot

Ajoutons une méthode qui permet de filtrer les plantes selon un critère
quelconque, passé sous forme de `Predicate` :

```java
import java.util.function.Predicate;
```

```java
    /**
     * Retourne les plantes qui satisfont un prédicat.
     *
     * @param predicate le critère de filtrage
     * @return la liste des plantes correspondantes
     */
    public List<PlantBase> filterPlants(
            Predicate<PlantBase> predicate) {
        List<PlantBase> result = new ArrayList<>();
        plants.forEach(plant -> {
            if (predicate.test(plant)) {
                result.add(plant);
            }
        });
        return result;
    }
```

Cette méthode est très flexible. On peut l'utiliser avec n'importe quel critère
:

```java
// Plantes de plus de 30 cm
List<PlantBase> largePlants =
        plot.filterPlants(p -> p.getSize() > 30.0);

// Plantes récoltables
List<PlantBase> harvestable =
        plot.filterPlants(p -> p instanceof Harvestable);
```

Le `Predicate<PlantBase>` est une interface fonctionnelle de
`java.util.function`. Sa méthode `test()` retourne `true` ou `false`.

## Créer une classe générique réutilisable

### Étape 4 : créer la classe générique FilterResult

Quand on filtre une collection, on obtient souvent une liste de résultats. Mais
on aimerait aussi connaître le nombre total d'éléments testés et le critère
utilisé. Créons une classe générique `FilterResult<T>` qui encapsule ces
informations.

Créez un fichier `FilterResult.java` dans le dossier `src/` :

```java
import java.util.List;

/**
 * Classe générique encapsulant le résultat d'un filtrage.
 *
 * @param <T> le type des éléments filtrés
 */
public class FilterResult<T> {
    private final List<T> matchingItems;
    private final int totalCount;
    private final String criteriaDescription;

    /**
     * Constructeur pour créer un résultat de filtrage.
     *
     * @param matchingItems les éléments correspondant au critère
     * @param totalCount le nombre total d'éléments testés
     * @param criteriaDescription la description du critère utilisé
     */
    public FilterResult(List<T> matchingItems, int totalCount,
            String criteriaDescription) {
        this.matchingItems = matchingItems;
        this.totalCount = totalCount;
        this.criteriaDescription = criteriaDescription;
    }

    /**
     * Retourne les éléments correspondant au critère.
     *
     * @return la liste des éléments
     */
    public List<T> getMatchingItems() {
        return matchingItems;
    }

    /**
     * Retourne le nombre d'éléments correspondant au critère.
     *
     * @return le nombre de correspondances
     */
    public int getMatchCount() {
        return matchingItems.size();
    }

    /**
     * Retourne le nombre total d'éléments testés.
     *
     * @return le nombre total
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * Retourne la description du critère utilisé.
     *
     * @return la description du critère
     */
    public String getCriteriaDescription() {
        return criteriaDescription;
    }

    /**
     * Affiche un résumé du filtrage.
     */
    public void displaySummary() {
        System.out.println("Filtrage : " + criteriaDescription);
        System.out.println("Résultat : " + getMatchCount()
                + "/" + totalCount + " élément(s).");
        matchingItems.forEach(item ->
                System.out.println("  - " + item));
    }
}
```

Observez comment le paramètre de type `<T>` est utilisé :

- Le champ `matchingItems` est de type `List<T>`.
- Les getters retournent `List<T>` et `T` implicitement via la liste.
- La méthode `displaySummary()` utilise `forEach` avec une lambda pour afficher
  les éléments, quelle que soit leur type.

Cette classe peut contenir des plantes (`FilterResult<PlantBase>`), des chaînes
de caractères (`FilterResult<String>`), ou n'importe quel autre type.

### Étape 5 : utiliser FilterResult dans Plot

Modifions la méthode `filterPlants()` pour qu'elle retourne un
`FilterResult<PlantBase>` :

```java
    /**
     * Filtre les plantes selon un prédicat et retourne un résultat détaillé.
     *
     * @param predicate le critère de filtrage
     * @param description la description du critère
     * @return un FilterResult contenant les plantes correspondantes
     */
    public FilterResult<PlantBase> filterPlantsDetailed(
            Predicate<PlantBase> predicate, String description) {
        List<PlantBase> result = new ArrayList<>();
        plants.forEach(plant -> {
            if (predicate.test(plant)) {
                result.add(plant);
            }
        });
        return new FilterResult<>(result, plants.size(), description);
    }
```

## Mettre à jour le programme principal

### Étape 6 : mettre à jour GardenManagementSystem

Remplacez le programme principal pour utiliser les lambdas et les génériques.
Ouvrez le fichier `GardenManagementSystem.java` et remplacez son contenu :

```java
import java.util.List;

/**
 * Programme principal du système de gestion de jardin communautaire.
 */
public class GardenManagementSystem {

    public static void main(String[] args) {
        System.out.println("=== Système de gestion de jardin "
                + "communautaire ===");
        System.out.println("Partie 5 : Lambda et génériques\n");

        // --- Créer des parcelles avec des plantes ---
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

        // --- Affichage avec forEach (lambda) ---
        System.out.println("--- Affichage avec forEach ---");
        plot1.displayPlants();
        System.out.println();
        plot2.displayPlants();
        System.out.println();

        // --- Trier les plantes par nom ---
        System.out.println("--- Tri par nom ---");
        plot1.getPlants().sort(
                (a, b) -> a.getName().compareTo(b.getName()));
        plot1.displayPlants();
        System.out.println();

        // --- Filtrage avec Predicate ---
        System.out.println("--- Filtrage avec Predicate ---");
        List<PlantBase> largePlants =
                plot1.filterPlants(p -> p.getSize() > 30.0);
        System.out.println("Plantes > 30 cm dans parcelle 1 :");
        largePlants.forEach(p ->
                System.out.println("  - " + p.getName()));
        System.out.println();

        // --- FilterResult générique ---
        System.out.println("--- FilterResult générique ---");
        FilterResult<PlantBase> harvestableResult =
                plot1.filterPlantsDetailed(
                        p -> p instanceof Harvestable,
                        "Plantes récoltables");
        harvestableResult.displaySummary();
        System.out.println();

        FilterResult<PlantBase> treeResult =
                plot2.filterPlantsDetailed(
                        p -> p instanceof TreePlant,
                        "Arbres");
        treeResult.displaySummary();
        System.out.println();

        // --- Récolte et suppression avec lambdas ---
        System.out.println("--- Récolte et nettoyage ---");
        plot1.harvestAndRemoveReadyPlants();
        System.out.println();
        plot1.displayPlants();
    }
}
```

## Test du projet

### Compilation et exécution en ligne de commande

Pour compiler et exécuter le projet, ouvrez un terminal dans le dossier `src/`
et exécutez les commandes suivantes :

```bash
javac *.java
java GardenManagementSystem
```

### Sortie attendue

Le résultat devrait ressembler à ceci :

```text
=== Système de gestion de jardin communautaire ===
Partie 5 : Lambda et génériques

--- Création des parcelles ---
Tomate cerise ajoutée à la parcelle 1.
Carotte ajoutée à la parcelle 1.
Rose ajoutée à la parcelle 2.
Pommier ajoutée à la parcelle 2.

--- Affichage avec forEach ---
Parcelle 1 (Zone Nord, 25.0 m2) - 2 plante(s) :
  - Tomate cerise (Solanum lycopersicum) - 45.5 cm - Planté le 2026-03-15 [Légume - Récolte dans 0 jours]
  - Carotte (Daucus carota) - 12.0 cm - Planté le 2026-03-20 [Légume - Récolte dans 30 jours]

Parcelle 2 (Zone Sud, 30.0 m2) - 2 plante(s) :
  - Rose (Rosa) - 35.0 cm - Planté le 2026-04-01 [Fleur Rouge - Pas encore en fleurs]
  - Pommier (Malus domestica) - 180.0 cm - Planté le 2026-02-01 [Arbre - Âge: 3 ans]

--- Tri par nom ---
Parcelle 1 (Zone Nord, 25.0 m2) - 2 plante(s) :
  - Carotte (Daucus carota) - 12.0 cm - Planté le 2026-03-20 [Légume - Récolte dans 30 jours]
  - Tomate cerise (Solanum lycopersicum) - 45.5 cm - Planté le 2026-03-15 [Légume - Récolte dans 0 jours]

--- Filtrage avec Predicate ---
Plantes > 30 cm dans parcelle 1 :
  - Tomate cerise

--- FilterResult générique ---
Filtrage : Plantes récoltables
Résultat : 2/2 élément(s).
  - Carotte (Daucus carota) - 12.0 cm - Planté le 2026-03-20 [Légume - Récolte dans 30 jours]
  - Tomate cerise (Solanum lycopersicum) - 45.5 cm - Planté le 2026-03-15 [Légume - Récolte dans 0 jours]

Filtrage : Arbres
Résultat : 1/2 élément(s).
  - Pommier (Malus domestica) - 180.0 cm - Planté le 2026-02-01 [Arbre - Âge: 3 ans]

--- Récolte et nettoyage ---
Récolte de Tomate cerise : 4.55 kg
1 plante(s) récoltée(s) et retirée(s) de la parcelle 1.

Parcelle 1 (Zone Nord, 25.0 m2) - 1 plante(s) :
  - Carotte (Daucus carota) - 12.0 cm - Planté le 2026-03-20 [Légume - Récolte dans 30 jours]

> [!NOTE]
>
> Après le tri par nom, "Carotte" apparaît avant "Tomate cerise" car "C" est
> avant "T" dans l'ordre alphabétique.

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

- Remplacer les boucles `for-each` par `forEach` avec des lambdas.
- Remplacer l'itérateur avec suppression par `removeIf`.
- Passer un `Predicate` en paramètre pour créer des méthodes de filtrage
  flexibles.
- Créer une classe générique `FilterResult<T>` réutilisable avec différents
  types.
- Utiliser `forEach` avec des lambdas à l'intérieur des classes génériques.

Les expressions lambda et les génériques rendent le code plus concis, plus
flexible et plus réutilisable. Le filtrage qui nécessitait auparavant une
boucle complète tient maintenant en une seule ligne. La classe `FilterResult`
fonctionne avec n'importe quel type sans duplication de code.

### Prochaine étape

Dans la prochaine partie du mini-projet, nous explorerons :

- La gestion des exceptions pour rendre notre code plus robuste.
- La validation des données avec des exceptions personnalisées.

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

- Ajoutez une méthode `sortPlants(Comparator<PlantBase>)` dans `Plot` qui
  trie les plantes selon un comparateur donné.
- Créez une classe générique `Pair<K, V>` pour associer une plante à son
  propriétaire.
- Ajoutez des méthodes dans `GardenRegistry` qui utilisent des lambdas pour
  trouver la parcelle avec le plus de plantes ou calculer la taille totale.
- Utilisez `Predicate.and()` et `Predicate.or()` pour combiner des filtres
  (par exemple : plantes de plus de 30 cm ET récoltables).

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
```
