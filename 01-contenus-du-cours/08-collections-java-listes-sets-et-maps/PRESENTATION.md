---
marp: true
theme: "custom-marp-theme"
size: "16:9"
paginate: "true"
author: "V. Guidoux, avec l'aide de GitHub Copilot"
description:
  "Collections Java - Listes, sets et maps pour le cours ProgIM2 enseigné à la
  HEIG-VD, Suisse"
lang: "fr"
url: "https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/08-collections-java-listes-sets-et-maps/presentation.html"
header:
  "[**Collections Java : Listes, sets et maps**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Collections Java : Listes, sets et maps

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-progim-course/heig-vd-progim2-course>

Visualiser le contenu complet sur GitHub [à cette
adresse][contenu-complet-sur-github].

<small>V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).</small>

<small>Ce travail est sous licence [CC BY-SA 4.0][licence].</small>

![bg opacity:0.1][illustration-principale]

## Plus de détails sur GitHub

<!-- _class: lead -->

_Cette présentation est un résumé du contenu complet disponible sur GitHub._

_Pour plus de détails, consulter le [contenu complet sur
GitHub][contenu-complet-sur-github] ou en cliquant sur l'en-tête de ce
document._

## Objectifs (1/4)

- Expliquer ce qu'est une collection et pourquoi les tableaux ne suffisent pas
  toujours.
- Différencier les trois types de collections : liste, ensemble et association
  clé-valeur (map).
- Sélectionner le type de collection approprié selon le besoin.

![bg right:40%][illustration-objectifs]

## Objectifs (2/4)

- Utiliser les listes (`ArrayList`, `LinkedList`) pour stocker des éléments
  ordonnés.
- Utiliser les ensembles (`HashSet`, `TreeSet`) pour stocker des éléments
  uniques.
- Utiliser les maps (`HashMap`, `TreeMap`) pour associer des clés à des valeurs.

![bg right:40%][illustration-objectifs]

## Objectifs (3/4)

- Appliquer les opérations courantes sur les collections : ajout, suppression,
  recherche et parcours.
- Parcourir une collection avec une boucle `for-each` et un itérateur.
- Différencier les implémentations d'une même interface en termes de performance
  et de comportement.

## Objectifs (4/4)

- Modifier une collection pendant l'itération de manière sécurisée.
- Justifier le choix d'une collection dans une situation donnée.

![bg right:40%][illustration-objectifs]

## Au-delà des tableaux

<!-- _class: lead -->

### Ce que les tableaux font bien

Les tableaux sont simples et efficaces pour des situations bien définies :

- Stocker un nombre **fixe** d'éléments connus à l'avance.
- Accéder rapidement à un élément par son index.
- Travailler avec des types primitifs (`int[]`, `double[]`, etc.).

```java
double[] grades = new double[25];
grades[0] = 5.5;
grades[1] = 4.0;
```

### Les limites des tableaux (1/2)

Imaginons que nous gérons les plantes d'un jardin communautaire. Le nombre de
plantes change constamment.

```java
PlantBase[] plants = new PlantBase[10];
plants[0] = new VegetablePlant("Tomate", "Solanum", "2026-03-15", 0, 90);
plants[1] = new FlowerPlant("Rose", "Rosa", "2026-04-01", 0, "Rouge");
```

Que se passe-t-il si on veut ajouter une **11e plante** ?

### Les limites des tableaux (2/2)

Il faut créer un nouveau tableau, tout copier, puis ajouter :

```java
PlantBase[] newPlants = new PlantBase[20];
for (int i = 0; i < plants.length; i++) {
    newPlants[i] = plants[i];
}
plants = newPlants;
```

Et pour **supprimer** un élément au milieu ? Il faut décaler tous les éléments
suivants. C'est laborieux et source d'erreurs.

### Les collections : une réponse flexible

Une **collection** est une structure de données qui :

- S'adapte **automatiquement** en taille.
- Offre des **méthodes** pour ajouter, supprimer, rechercher.
- Propose **différentes organisations** selon le besoin.

Le framework Collections de Java fournit un ensemble de classes et d'interfaces
prêtes à l'emploi dans le package `java.util`.

## Le framework Collections

<!-- _class: lead -->

### Trois grandes familles

| Famille  | Interface | Ce qu'elle fait         |
| :------- | :-------- | :---------------------- |
| Liste    | `List`    | Éléments ordonnés       |
| Ensemble | `Set`     | Éléments uniques        |
| Map      | `Map`     | Associations clé-valeur |

Le framework sépare **ce qu'une collection fait** (l'interface) de **comment
elle le fait** (l'implémentation). Comme avec nos interfaces `Harvestable`,
`Waterable`, etc.

### Comment choisir ?

Trois questions simples pour guider le choix :

- Les éléments doivent-ils être **ordonnés** ? => Liste.
- Les éléments doivent-ils être **uniques** ? => Ensemble.
- Faut-il retrouver un élément à partir d'une **clé** ? => Map.

## Les listes

<!-- _class: lead -->

### Le concept de liste

Une **liste** est une collection ordonnée d'éléments :

- Chaque élément a une **position** (un index).
- Les **doublons** sont autorisés.
- On peut accéder à un élément par son index.

C'est le type de collection le plus proche du tableau, mais **sans ses
limitations de taille fixe**.

Deux implémentations principales : `ArrayList` et `LinkedList`.

### ArrayList : le choix courant (1/2)

`ArrayList` stocke ses éléments dans un tableau interne qui **grandit
automatiquement**.

```java
import java.util.ArrayList;
import java.util.List;

List<String> plantNames = new ArrayList<>();

plantNames.add("Tomate");
plantNames.add("Carotte");
plantNames.add("Basilic");
plantNames.add("Tomate"); // Doublons autorisés
System.out.println(plantNames); // [Tomate, Carotte, Basilic, Tomate]
```

### ArrayList : le choix courant (2/2)

```java
// Accéder par index
String first = plantNames.get(0); // Tomate

// Supprimer un élément
plantNames.remove("Basilic");

// Taille de la liste
System.out.println(plantNames.size()); // 3

// Vérifier si un élément existe
System.out.println(plantNames.contains("Carotte")); // true
```

### LinkedList : une autre approche

`LinkedList` stocke ses éléments sous forme de **noeuds chaînés** : chaque
élément connaît son voisin précédent et suivant.

```java
List<String> tasks = new LinkedList<>();

tasks.add("Arroser les tomates");
tasks.add("Récolter les carottes");
tasks.add("Planter du basilic");
```

L'utilisation est **identique** à `ArrayList`. La différence est entièrement
interne.

### ArrayList ou LinkedList ?

| Opération                | `ArrayList`           | `LinkedList`    |
| :----------------------- | :-------------------- | :-------------- |
| Accès par index          | Rapide (accès direct) | Lent (parcours) |
| Ajout à la fin           | Rapide                | Rapide          |
| Ajout/suppression milieu | Lent (décalage)       | Rapide (liens)  |
| Recherche                | Lent (parcours)       | Lent (parcours) |

**En cas de doute, utilisez `ArrayList`** : c'est le choix recommandé pour la
grande majorité des cas.

## Les ensembles

<!-- _class: lead -->

### Le concept d'ensemble

Un **ensemble** garantit l'**unicité** de ses éléments :

- Pas de doublons.
- Ordre non garanti (sauf `TreeSet`).
- Inspiré du concept mathématique d'ensemble (algèbre de Boole).

Deux implémentations principales : `HashSet` et `TreeSet`.

### HashSet : rapide et sans ordre

```java
import java.util.HashSet;
import java.util.Set;

Set<String> species = new HashSet<>();

species.add("Tomate");
species.add("Carotte");
species.add("Basilic");
species.add("Tomate"); // Doublon : ignoré !

System.out.println(species.size()); // 3 (pas 4)
System.out.println(species.contains("Tomate")); // true
System.out.println(species.add("Carotte")); // false (déjà présent)
```

### TreeSet : trié automatiquement

`TreeSet` maintient ses éléments **triés** en permanence.

```java
Set<String> sorted = new TreeSet<>();

sorted.add("Tomate");
sorted.add("Basilic");
sorted.add("Carotte");

System.out.println(sorted);
// [Basilic, Carotte, Tomate] (trié alphabétiquement)
```

Les éléments doivent implémenter `Comparable` (comme `String`).

### Pourquoi utiliser un ensemble ?

- Garantir l'**unicité** (les espèces du jardin, pas de doublons).
- Vérifier rapidement si un élément **existe**.
- **Éliminer les doublons** d'une liste :

```java
List<String> withDuplicates = new ArrayList<>(
    List.of("Tomate", "Carotte", "Tomate", "Basilic", "Carotte")
);

Set<String> noDuplicates = new HashSet<>(withDuplicates);
System.out.println(noDuplicates);
// [Carotte, Tomate, Basilic]
```

### equals() et hashCode() : rappel important

Pour que `HashSet` fonctionne avec **vos propres classes** (`PlantBase`, etc.),
il faut obligatoirement redéfinir `equals()` et `hashCode()`.

C'est ce que nous avons fait dans la **partie 3 du mini-projet**.

Sans cela, deux objets identiques pourraient être considérés comme différents
par l'ensemble.

## Les maps

<!-- _class: lead -->

### Le concept de map

Une **map** associe des **clés** à des **valeurs** :

- Chaque clé est **unique**.
- Une clé donne accès **directement** à sa valeur.
- Comme un annuaire : le nom (clé) => le numéro (valeur).

**Exemples** : nom de la jardinière => sa parcelle, nom d'une plante => ses
informations.

Deux implémentations principales : `HashMap` et `TreeMap`.

### HashMap : accès rapide par clé (1/2)

```java
import java.util.HashMap;
import java.util.Map;

Map<String, String> plotAssignments = new HashMap<>();

plotAssignments.put("Alice", "Parcelle A1");
plotAssignments.put("Bob", "Parcelle B2");
plotAssignments.put("Clara", "Parcelle A3");

// Retrouver la parcelle d'Alice
String plot = plotAssignments.get("Alice");
System.out.println(plot); // Parcelle A1
```

### HashMap : accès rapide par clé (2/2)

```java
// Vérifier si une clé existe
plotAssignments.containsKey("Bob"); // true

// Modifier une valeur existante
plotAssignments.put("Alice", "Parcelle C1");
// Écrase l'ancienne valeur

// Supprimer une entrée
plotAssignments.remove("Bob");

// Taille
plotAssignments.size(); // 2
```

### Accéder aux clés et aux valeurs

```java
// Toutes les clés
Set<String> gardeners = plotAssignments.keySet();
// [Alice, Clara]

// Toutes les valeurs
Collection<String> plots = plotAssignments.values();
// [Parcelle C1, Parcelle A3]
```

`keySet()` retourne un `Set` (les clés sont uniques). `values()` retourne une
`Collection` (les valeurs peuvent avoir des doublons).

### TreeMap : triée par clés

`TreeMap` maintient ses entrées **triées par clé**.

```java
Map<String, Integer> plantCounts = new TreeMap<>();

plantCounts.put("Tomate", 12);
plantCounts.put("Basilic", 8);
plantCounts.put("Carotte", 15);

System.out.println(plantCounts);
// {Basilic=8, Carotte=15, Tomate=12}
```

Comme pour `TreeSet`, les clés doivent implémenter `Comparable`.

## Parcourir les collections

<!-- _class: lead -->

### La boucle for-each

La manière la plus simple de parcourir une collection :

```java
List<String> plants = new ArrayList<>(
    List.of("Tomate", "Carotte", "Basilic")
);

for (String plant : plants) {
    System.out.println("Plante : " + plant);
}
```

Fonctionne avec toutes les collections (`List`, `Set`) et les vues d'une `Map`.

### Parcourir une map

Pour une map, on parcourt les **paires clé-valeur** avec `entrySet()` :

```java
Map<String, String> assignments = new HashMap<>();
assignments.put("Alice", "Parcelle A1");
assignments.put("Bob", "Parcelle B2");

for (Map.Entry<String, String> entry : assignments.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

On peut aussi parcourir `keySet()` ou `values()` séparément.

### Les itérateurs

Un **itérateur** parcourt une collection élément par élément :

```java
Iterator<String> it = plants.iterator();

while (it.hasNext()) {
    String plant = it.next();
    System.out.println("Plante : " + plant);
}
```

- `hasNext()` : reste-t-il des éléments ?
- `next()` : élément courant, puis avance.

### Modifier pendant l'itération : le piège

La boucle `for-each` est préférable dans la plupart des cas. Mais l'itérateur
est **indispensable** dans un cas précis...

```java
// ATTENTION : ConcurrentModificationException !
for (String plant : plants) {
    if (plant.equals("Tomate")) {
        plants.remove(plant); // Erreur à l'exécution
    }
}
```

**Ne jamais utiliser `collection.remove()` dans une boucle `for-each`**

### Modifier pendant l'itération : la solution

Utiliser la méthode `remove()` de l'**itérateur** :

```java
Iterator<String> it = plants.iterator();

while (it.hasNext()) {
    String plant = it.next();
    if (plant.equals("Tomate")) {
        it.remove(); // Suppression sécurisée
    }
}
```

`it.remove()` est la **seule façon sûre** de supprimer pendant un parcours.

## Choisir la bonne collection

<!-- _class: lead -->

### Tableau récapitulatif

| Besoin                                | Collection   |
| :------------------------------------ | :----------- |
| Liste ordonnée, accès par index       | `ArrayList`  |
| Insertions/suppressions au milieu     | `LinkedList` |
| Éléments uniques, ordre non important | `HashSet`    |
| Éléments uniques et triés             | `TreeSet`    |
| Associer des clés à des valeurs       | `HashMap`    |
| Associations triées par clé           | `TreeMap`    |

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## À vous de jouer !

- (Re)lire le contenu de cours.
- Lire les exemples de code et les descriptions.
- Faire les exercices. Faire le mini-projet. Poser des questions si nécessaire.

➡️ [Visualiser le contenu complet sur GitHub.][contenu-complet-sur-github]

**N'hésitez pas à vous entraider si vous avez des difficultés !**

![bg right:30%][illustration-a-vous-de-jouer]

## Sources

- [Illustration][illustration-objectifs] par
  [Aline de Nadai](https://unsplash.com/@alinedenadai) sur
  [Unsplash](https://unsplash.com/photos/low-angle-view-of-ball-shoots-in-the-ring-j6brni7fpvs)
- [Illustration][illustration-a-vous-de-jouer] par
  [Nikita Kachanovsky](https://unsplash.com/@nkachanovskyyy) sur
  [Unsplash](https://unsplash.com/photos/white-sony-ps4-dualshock-controller-over-persons-palm-FJFPuE1MAOM)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/08-collections-java-listes-sets-et-maps/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
