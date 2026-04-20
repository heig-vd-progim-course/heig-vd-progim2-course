# Collections Java : Les génériques - Mini-projet (partie 5)

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
- [Créer une classe générique réutilisable](#créer-une-classe-générique-réutilisable)
  - [Étape 1 : créer la classe générique FilterResult](#étape-1--créer-la-classe-générique-filterresult)
  - [Étape 2 : ajouter des méthodes de filtrage dans Plot](#étape-2--ajouter-des-méthodes-de-filtrage-dans-plot)
- [Mettre à jour le programme principal](#mettre-à-jour-le-programme-principal)
  - [Étape 3 : mettre à jour GardenManagementSystem](#étape-3--mettre-à-jour-gardenmanagementsystem)
- [Test du projet](#test-du-projet)
  - [Compilation et exécution en ligne de commande](#compilation-et-exécution-en-ligne-de-commande)
  - [Sortie attendue](#sortie-attendue)

## Présentation du mini-projet

Dans cette cinquième partie du mini-projet, nous allons généraliser le code de
notre système de gestion de jardin communautaire en utilisant les génériques
Java.

Lors des sessions précédentes, nous avons :

- **Partie 1** : créé des classes de base avec des attributs et méthodes
  publics.
- **Partie 2** : appliqué l'encapsulation et l'héritage avec une hiérarchie de
  plantes.
- **Partie 3** : utilisé le polymorphisme avec des interfaces et la redéfinition
  de méthodes.
- **Partie 4** : intégré les collections Java (`ArrayList`, `HashSet`,
  `HashMap`).

Dans la partie 4, nous avons utilisé des listes et des maps pour gérer les
données. Cependant, quand nous filtrons des plantes (par taille, par type,
etc.), nous obtenons simplement une liste de résultats sans information
supplémentaire : combien d'éléments ont été testés ? Quel critère a été utilisé
?

Dans cette session, nous allons créer une classe générique `FilterResult<T>` qui
encapsule ces informations de façon réutilisable, et l'utiliser pour enrichir
les méthodes de filtrage de notre parcelle.

## Objectifs de cette session

À l'issue de cette session, les personnes qui étudient devraient avoir pu :

- Créer une classe générique avec un paramètre de type `<T>`.
- Utiliser un type générique pour encapsuler des résultats typés.
- Comprendre comment les génériques assurent la sécurité des types sans
  duplication de code.

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

## Créer une classe générique réutilisable

### Étape 1 : créer la classe générique FilterResult

Quand on filtre une collection, on obtient souvent une simple liste de
résultats. Mais on aimerait aussi connaître le nombre total d'éléments testés et
le critère utilisé. Créons une classe générique `FilterResult<T>` qui encapsule
ces informations.

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
     * @param criteriaDescription la description du critère
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
        for (T item : matchingItems) {
            System.out.println("  - " + item);
        }
    }
}
```

Observez comment le paramètre de type `<T>` est utilisé :

- Le champ `matchingItems` est de type `List<T>`.
- Les getters retournent `List<T>` et `T` implicitement via la liste.
- La méthode `displaySummary()` parcourt les éléments avec une boucle
  `for-each`, quelle que soit leur type.

Cette classe peut contenir des plantes (`FilterResult<PlantBase>`), des chaînes
de caractères (`FilterResult<String>`), ou n'importe quel autre type. C'est
justement l'avantage des génériques : **une seule classe pour tous les types**.

### Étape 2 : ajouter des méthodes de filtrage dans Plot

Ajoutons des méthodes dans la classe `Plot` qui utilisent `FilterResult` pour
retourner des résultats de filtrage détaillés.

Ajoutez les imports nécessaires en haut du fichier :

```java
import java.util.ArrayList;
import java.util.List;
```

Puis ajoutez les méthodes de filtrage suivantes dans la classe `Plot` :

```java
    /**
     * Filtre les plantes par taille minimale.
     *
     * @param minSize la taille minimale en cm
     * @return un FilterResult contenant les plantes correspondantes
     */
    public FilterResult<PlantBase> filterPlantsByMinSize(
            double minSize) {
        List<PlantBase> result = new ArrayList<>();
        for (PlantBase plant : plants) {
            if (plant.getSize() >= minSize) {
                result.add(plant);
            }
        }
        return new FilterResult<>(result, plants.size(),
                "Plantes >= " + minSize + " cm");
    }

    /**
     * Filtre les plantes récoltables.
     *
     * @return un FilterResult contenant les plantes récoltables
     */
    public FilterResult<PlantBase> filterHarvestablePlants() {
        List<PlantBase> result = new ArrayList<>();
        for (PlantBase plant : plants) {
            if (plant instanceof Harvestable) {
                result.add(plant);
            }
        }
        return new FilterResult<>(result, plants.size(),
                "Plantes récoltables");
    }

    /**
     * Filtre les plantes selon leur type (VegetablePlant,
     * FlowerPlant, TreePlant).
     *
     * @param typeName le nom simple de la classe à filtrer
     * @return un FilterResult contenant les plantes du type donné
     */
    public FilterResult<PlantBase> filterPlantsByType(
            String typeName) {
        List<PlantBase> result = new ArrayList<>();
        for (PlantBase plant : plants) {
            if (plant.getClass().getSimpleName()
                    .equals(typeName)) {
                result.add(plant);
            }
        }
        return new FilterResult<>(result, plants.size(),
                "Plantes de type " + typeName);
    }
```

Chaque méthode retourne un `FilterResult<PlantBase>` qui contient :

- La liste des plantes correspondant au critère.
- Le nombre total de plantes testées.
- Une description textuelle du critère.

> [!NOTE]
>
> Sans les génériques, nous aurions dû créer une classe `FilterResultPlantBase`,
> puis une `FilterResultString`, etc. Avec `FilterResult<T>`, une seule classe
> suffit pour tous les types.

## Mettre à jour le programme principal

### Étape 3 : mettre à jour GardenManagementSystem

Remplacez le programme principal pour utiliser `FilterResult`. Ouvrez le fichier
`GardenManagementSystem.java` et remplacez son contenu :

```java
/**
 * Programme principal du système de gestion de jardin communautaire.
 */
public class GardenManagementSystem {

    public static void main(String[] args) {
        System.out.println("=== Système de gestion de jardin "
                + "communautaire ===");
        System.out.println("Partie 5 : Les génériques\n");

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

        // --- Affichage des parcelles ---
        System.out.println("--- Affichage des parcelles ---");
        plot1.displayPlants();
        System.out.println();
        plot2.displayPlants();
        System.out.println();

        // --- FilterResult générique ---
        System.out.println("--- FilterResult générique ---");

        // Filtrer par taille minimale
        FilterResult<PlantBase> largePlants =
                plot1.filterPlantsByMinSize(30.0);
        largePlants.displaySummary();
        System.out.println();

        // Filtrer les plantes récoltables
        FilterResult<PlantBase> harvestableResult =
                plot1.filterHarvestablePlants();
        harvestableResult.displaySummary();
        System.out.println();

        // Filtrer par type dans la parcelle 2
        FilterResult<PlantBase> treeResult =
                plot2.filterPlantsByType("TreePlant");
        treeResult.displaySummary();
        System.out.println();

        // --- Démonstration de la réutilisabilité ---
        System.out.println(
                "--- Réutilisabilité de FilterResult ---");
        FilterResult<String> tagResult = new FilterResult<>(
                java.util.List.of("bio", "local"),
                5,
                "Étiquettes sélectionnées");
        tagResult.displaySummary();
        System.out.println();

        // --- Récolte et nettoyage ---
        System.out.println("--- Récolte et nettoyage ---");
        plot1.harvestAndRemoveReadyPlants();
        System.out.println();
        plot1.displayPlants();
    }
}
```

Remarquez comment `FilterResult` est utilisé avec deux types différents :

- `FilterResult<PlantBase>` pour les résultats de filtrage de plantes.
- `FilterResult<String>` pour démontrer que la même classe fonctionne avec
  n'importe quel type.

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
Partie 5 : Les génériques

--- Création des parcelles ---
Tomate cerise ajoutée à la parcelle 1.
Carotte ajoutée à la parcelle 1.
Rose ajoutée à la parcelle 2.
Pommier ajoutée à la parcelle 2.

--- Affichage des parcelles ---
Parcelle 1 (Zone Nord, 25.0 m2) - 2 plante(s) :
  - Tomate cerise (Solanum lycopersicum) - 45.5 cm - Planté le 2026-03-15 [Légume - Récolte dans 0 jours]
  - Carotte (Daucus carota) - 12.0 cm - Planté le 2026-03-20 [Légume - Récolte dans 30 jours]

Parcelle 2 (Zone Sud, 30.0 m2) - 2 plante(s) :
  - Rose (Rosa) - 35.0 cm - Planté le 2026-04-01 [Fleur Rouge - Pas encore en fleurs]
  - Pommier (Malus domestica) - 180.0 cm - Planté le 2026-02-01 [Arbre - Âge: 3 ans]

--- FilterResult générique ---
Filtrage : Plantes >= 30.0 cm
Résultat : 1/2 élément(s).
  - Tomate cerise (Solanum lycopersicum) - 45.5 cm - Planté le 2026-03-15 [Légume - Récolte dans 0 jours]

Filtrage : Plantes récoltables
Résultat : 2/2 élément(s).
  - Tomate cerise (Solanum lycopersicum) - 45.5 cm - Planté le 2026-03-15 [Légume - Récolte dans 0 jours]
  - Carotte (Daucus carota) - 12.0 cm - Planté le 2026-03-20 [Légume - Récolte dans 30 jours]

Filtrage : Plantes de type TreePlant
Résultat : 1/2 élément(s).
  - Pommier (Malus domestica) - 180.0 cm - Planté le 2026-02-01 [Arbre - Âge: 3 ans]

--- Réutilisabilité de FilterResult ---
Filtrage : Étiquettes sélectionnées
Résultat : 2/5 élément(s).
  - bio
  - local

--- Récolte et nettoyage ---
Récolte de Tomate cerise : 4.55 kg
1 plante(s) récoltée(s) et retirée(s) de la parcelle 1.

Parcelle 1 (Zone Nord, 25.0 m2) - 1 plante(s) :
  - Carotte (Daucus carota) - 12.0 cm - Planté le 2026-03-20 [Légume - Récolte dans 30 jours]
```

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

- Créer une classe générique `FilterResult<T>` réutilisable avec différents
  types.
- Utiliser le paramètre de type `<T>` pour typer les champs, les paramètres et
  les valeurs de retour.
- Démontrer la réutilisabilité d'une classe générique avec
  `FilterResult<PlantBase>` et `FilterResult<String>`.

Les génériques rendent le code plus flexible et réutilisable. La classe
`FilterResult` fonctionne avec n'importe quel type sans duplication de code,
tout en conservant la sécurité des types à la compilation.

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

- Créez une classe générique `Pair<K, V>` pour associer une plante à son
  propriétaire.
- Ajoutez une méthode générique dans `Plot` qui retourne le plus grand élément
  d'une liste selon un critère donné.
- Créez une classe `Registry<T>` générique qui remplace `GardenCatalog` et
  `GardenRegistry` avec une seule implémentation.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
