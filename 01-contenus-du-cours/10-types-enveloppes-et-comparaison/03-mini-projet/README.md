# Types enveloppes et comparaison d'objets - Mini-projet (partie 6)

Bienvenue dans la sixième partie du mini-projet sur la gestion de jardin
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
- [Vérifier equals() et hashCode() dans PlantBase](#vérifier-equals-et-hashcode-dans-plantbase)
  - [Étape 1 : observer equals() et hashCode() existants](#étape-1--observer-equals-et-hashcode-existants)
  - [Étape 2 : exploiter equals() dans la parcelle](#étape-2--exploiter-equals-dans-la-parcelle)
- [Ajouter equals() et hashCode() dans Gardener](#ajouter-equals-et-hashcode-dans-gardener)
  - [Étape 3 : redéfinir equals() et hashCode() dans Gardener](#étape-3--redéfinir-equals-et-hashcode-dans-gardener)
- [Implémenter Comparable dans PlantBase](#implémenter-comparable-dans-plantbase)
  - [Étape 4 : implémenter Comparable&lt;PlantBase&gt;](#étape-4--implémenter-comparableplantbase)
  - [Étape 5 : trier les plantes d'une parcelle](#étape-5--trier-les-plantes-dune-parcelle)
- [Mettre à jour le programme principal](#mettre-à-jour-le-programme-principal)
  - [Étape 6 : mettre à jour GardenManagementSystem](#étape-6--mettre-à-jour-gardenmanagementsystem)
- [Test du projet](#test-du-projet)
  - [Compilation et exécution en ligne de commande](#compilation-et-exécution-en-ligne-de-commande)
  - [Sortie attendue](#sortie-attendue)

## Présentation du mini-projet

Dans cette sixième partie du mini-projet, nous allons enrichir notre système de
gestion de jardin communautaire en appliquant les mécanismes de comparaison
d'objets et de tri vus dans ce chapitre.

Lors des sessions précédentes, nous avons :

- **Partie 1** : créé des classes de base avec des attributs et méthodes
  publics.
- **Partie 2** : appliqué l'encapsulation et l'héritage avec une hiérarchie de
  plantes.
- **Partie 3** : utilisé le polymorphisme avec des interfaces et la redéfinition
  de méthodes.
- **Partie 4** : intégré les collections Java (`ArrayList`, `HashSet`,
  `HashMap`).
- **Partie 5** : généralisé le code avec les génériques Java
  (`FilterResult<T>`).

Dans cette session, nous allons :

1. Découvrir que `PlantBase` possède déjà `equals()` et `hashCode()` et les
   exploiter pour éviter les doublons dans la parcelle.
2. Ajouter `equals()` et `hashCode()` dans `Gardener`.
3. Faire implémenter `Comparable<PlantBase>` à `PlantBase` pour trier les
   plantes par taille.
4. Trier les plantes d'une parcelle avec `Collections.sort()`.

## Objectifs de cette session

À l'issue de cette session, les personnes qui étudient devraient avoir pu :

- Observer et comprendre une implémentation existante de `equals()` et
  `hashCode()`.
- Exploiter `equals()` pour éviter les doublons dans une collection.
- Implémenter `equals()` et `hashCode()` dans une nouvelle classe.
- Implémenter `Comparable<T>` dans une classe existante.
- Trier une liste avec `Collections.sort()`.

## Structure du projet

Pour cette partie du mini-projet, nous allons modifier des classes existantes.
Aucun nouveau fichier n'est nécessaire.

```text
10-types-enveloppes-et-comparaison/
└── 03-mini-projet/
    ├── src/                             (code de départ - copie de la partie 5)
    │   ├── Harvestable.java
    │   ├── Waterable.java
    │   ├── Growable.java
    │   ├── PlantBase.java               (à modifier : ajouter Comparable)
    │   ├── VegetablePlant.java
    │   ├── FlowerPlant.java
    │   ├── TreePlant.java
    │   ├── Plot.java                    (à modifier : prévenir doublons + trier)
    │   ├── Gardener.java                (à modifier : ajouter equals/hashCode)
    │   ├── GardenTask.java
    │   ├── GardenCatalog.java
    │   ├── GardenRegistry.java
    │   ├── FilterResult.java
    │   └── GardenManagementSystem.java  (à modifier : démos)
    └── solution/
        └── src/                         (solution complète)
```

> [!IMPORTANT]
>
> Cette partie fait suite à la partie 5. Le dossier `src/` contient déjà toutes
> les classes de la solution de la partie 5.
>
> Si vous n'avez pas terminé la partie 5, vous pouvez utiliser le code fourni
> dans `src/` directement.

## Vérifier equals() et hashCode() dans PlantBase

### Étape 1 : observer equals() et hashCode() existants

Avant d'écrire quoi que ce soit, ouvrez `PlantBase.java` et recherchez les
méthodes `equals()` et `hashCode()`. Elles y sont déjà ! En voici un extrait :

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    PlantBase other = (PlantBase) obj;
    return name.equals(other.name) && species.equals(other.species);
}

@Override
public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + species.hashCode();
    return result;
}
```

Ces méthodes ont été introduites dans la partie 2 pour permettre la comparaison
des plantes par leur nom et leur espèce. Deux plantes sont considérées
identiques si elles ont le même nom et la même espèce botanique.

Répondez à ces questions avant de continuer :

1. Quels champs sont utilisés dans `equals()` ?
2. Les mêmes champs sont-ils utilisés dans `hashCode()` ?
3. Pourquoi utilise-t-on `31` comme multiplicateur dans `hashCode()` ?

### Étape 2 : exploiter equals() dans la parcelle

Actuellement, la méthode `addPlant()` dans `Plot` ajoute une plante sans
vérifier si elle est déjà présente :

```java
public void addPlant(PlantBase plant) {
    plants.add(plant);
    System.out.println(plant.getName() + " ajoutée à la parcelle "
            + number + ".");
}
```

Grâce à `equals()` et `hashCode()`, `ArrayList.contains()` peut maintenant
détecter les doublons. Modifiez `addPlant()` pour refuser les doublons :

```java
public void addPlant(PlantBase plant) {
    if (plants.contains(plant)) {
        System.out.println(plant.getName() + " est déjà dans la "
                + "parcelle " + number + ". Ajout ignoré.");
        return;
    }
    plants.add(plant);
    System.out.println(plant.getName() + " ajoutée à la parcelle "
            + number + ".");
}
```

> [!NOTE]
>
> `ArrayList.contains()` utilise `equals()` pour comparer les éléments. Sans
> `equals()` redéfini, la comparaison serait faite par référence (`==`) et le
> doublon ne serait pas détecté si l'objet n'est pas la même instance.

## Ajouter equals() et hashCode() dans Gardener

### Étape 3 : redéfinir equals() et hashCode() dans Gardener

La classe `Gardener` n'a pas encore de `equals()` ni de `hashCode()`. Deux
jardinières sont identiques si elles ont la même adresse email (identifiant
unique dans le système).

Ajoutez ces deux méthodes à la fin de `Gardener.java`, avant la dernière
accolade fermante :

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Gardener other = (Gardener) obj;
    return email.equals(other.email);
}

@Override
public int hashCode() {
    return email.hashCode();
}
```

Avec ces méthodes, on peut maintenant utiliser un `HashSet<Gardener>` pour
stocker les jardinières sans doublons, ou les utiliser comme clés dans une
`HashMap`.

## Implémenter Comparable dans PlantBase

### Étape 4 : implémenter Comparable&lt;PlantBase&gt;

Nous allons faire implémenter `Comparable<PlantBase>` à `PlantBase` pour définir
un ordre naturel : les plantes sont triées par taille croissante (de la plus
petite à la plus grande).

Modifiez la déclaration de classe pour qu'elle implémente
`Comparable<PlantBase>` :

```java
public abstract class PlantBase implements Comparable<PlantBase> {
```

Puis ajoutez la méthode `compareTo()` dans `PlantBase`, après `hashCode()` :

```java
@Override
public int compareTo(PlantBase other) {
    // Ordre croissant par taille (de la plus petite à la plus grande)
    return Double.compare(this.size, other.size);
}
```

> [!NOTE]
>
> `Double.compare(a, b)` est la façon recommandée pour comparer des `double`.
> Elle retourne un entier négatif si `a < b`, 0 si `a == b`, un entier positif
> si `a > b`. Ici, `size` est un `double` primitif, pas un `Double` : on utilise
> donc directement `Double.compare()` avec les deux valeurs primitives.

### Étape 5 : trier les plantes d'une parcelle

Ajoutez l'import de `Collections` en haut de `Plot.java` (si ce n'est pas déjà
fait) :

```java
import java.util.Collections;
```

Puis ajoutez une nouvelle méthode `displayPlantsSorted()` dans `Plot.java` :

```java
/**
 * Affiche les plantes de la parcelle triées par taille croissante.
 */
public void displayPlantsSorted() {
    ArrayList<PlantBase> sorted = new ArrayList<>(plants);
    Collections.sort(sorted);
    System.out.println("Parcelle " + number + " (" + location
            + ") - plantes par taille croissante :");
    for (PlantBase plant : sorted) {
        System.out.printf("  %5.1f cm - %s%n",
                plant.getSize(), plant.getName());
    }
}
```

> [!NOTE]
>
> On crée une copie de la liste avec `new ArrayList<>(plants)` pour ne pas
> modifier l'ordre original de la parcelle. `Collections.sort()` trie en place ;
> sans copie, l'ordre des plantes dans `plants` serait modifié de façon
> permanente.

## Mettre à jour le programme principal

### Étape 6 : mettre à jour GardenManagementSystem

Remplacez le contenu de `GardenManagementSystem.java` par le code suivant, qui
démontre toutes les nouvelles fonctionnalités :

```java
import java.util.HashSet;

public class GardenManagementSystem {

    public static void main(String[] args) {
        System.out.println("=== Système de gestion de jardin "
                + "communautaire ===");
        System.out.println("Partie 6 : Types enveloppes et "
                + "comparaison d'objets\n");

        // --- Création des plantes et des parcelles ---
        System.out.println("--- Création des parcelles ---");
        Plot plot1 = new Plot(1, 25.0, "Zone Nord");

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
        plot1.addPlant(rose);
        plot1.addPlant(appleTree);
        System.out.println();

        // --- Test de la détection des doublons ---
        System.out.println("--- Détection des doublons (equals + hashCode) ---");
        // Tentative d'ajouter une plante avec le même nom et la même espèce
        VegetablePlant tomatoCopy = new VegetablePlant(
                "Tomate cerise", "Solanum lycopersicum",
                "2026-05-01", 10.0, 15);  // même nom+espèce, data différentes
        plot1.addPlant(tomatoCopy);  // doit être refusé
        System.out.println();

        // --- equals() sur les plantes ---
        System.out.println("--- equals() sur les plantes ---");
        System.out.println("tomato == tomatoCopy : "
                + (tomato == tomatoCopy));
        System.out.println("tomato.equals(tomatoCopy) : "
                + tomato.equals(tomatoCopy));
        System.out.println();

        // --- equals() et hashCode() sur Gardener ---
        System.out.println("--- equals() et hashCode() sur Gardener ---");
        Gardener g1 = new Gardener("Alice Martin", "alice@jardin.ch", 5);
        Gardener g2 = new Gardener("Alice M.", "alice@jardin.ch", 3);
        System.out.println("g1 == g2 : " + (g1 == g2));
        System.out.println("g1.equals(g2) : " + g1.equals(g2));

        HashSet<Gardener> gardeners = new HashSet<>();
        gardeners.add(g1);
        gardeners.add(g2);  // doublon : même email
        System.out.println("Taille du HashSet (attendu 1) : "
                + gardeners.size());
        System.out.println();

        // --- Tri par taille croissante ---
        System.out.println("--- Tri des plantes par taille croissante ---");
        plot1.displayPlants();
        System.out.println();
        plot1.displayPlantsSorted();
    }
}
```

## Test du projet

### Compilation et exécution en ligne de commande

Pour compiler et exécuter le projet, naviguez dans le dossier `src/` et exécutez
ces commandes :

```bash
cd src
javac *.java
java GardenManagementSystem
```

### Sortie attendue

```text
=== Système de gestion de jardin communautaire ===
Partie 6 : Types enveloppes et comparaison d'objets

--- Création des parcelles ---
Tomate cerise ajoutée à la parcelle 1.
Carotte ajoutée à la parcelle 1.
Rose ajoutée à la parcelle 1.
Pommier ajoutée à la parcelle 1.

--- Détection des doublons (equals + hashCode) ---
Tomate cerise est déjà dans la parcelle 1. Ajout ignoré.

--- equals() sur les plantes ---
tomato == tomatoCopy : false
tomato.equals(tomatoCopy) : true

--- equals() et hashCode() sur Gardener ---
g1 == g2 : false
g1.equals(g2) : true
Taille du HashSet (attendu 1) : 1

--- Tri des plantes par taille croissante ---
Parcelle 1 (Zone Nord, 25.0 m2) - 4 plante(s) :
  - Tomate cerise (Solanum lycopersicum) - 45.5 cm - Planté le 2026-03-15 [Légume - Récolte dans 0 jours]
  - Carotte (Daucus carota) - 12.0 cm - Planté le 2026-03-20 [Légume - Récolte dans 30 jours]
  - Rose (Rosa) - 35.0 cm - Planté le 2026-04-01 [Fleur Rouge - Pas encore en fleurs]
  - Pommier (Malus domestica) - 180.0 cm - Planté le 2026-02-01 [Arbre - Âge: 3 ans]

Parcelle 1 (Zone Nord) - plantes par taille croissante :
   12.0 cm - Carotte
   35.0 cm - Rose
   45.5 cm - Tomate cerise
  180.0 cm - Pommier
```

> [!TIP]
>
> Si vous obtenez une erreur de compilation sur `Comparable`, vérifiez que vous
> avez bien modifié la déclaration de classe :
> `public abstract class PlantBase implements Comparable<PlantBase>`.
>
> Si `addPlant()` ne refuse pas les doublons, vérifiez que votre méthode appelle
> bien `plants.contains(plant)` avant d'ajouter.
