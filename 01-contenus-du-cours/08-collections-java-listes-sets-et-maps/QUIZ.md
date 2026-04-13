---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  Quiz sur le contenu Collections Java - Listes, Sets et Maps pour le cours
  ProgIM2 enseigné à la HEIG-VD, Suisse
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/08-collections-java-listes-sets-et-maps/quiz.html
header:
  "[**Collections Java : Listes, Sets et Maps -
  Quiz**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Collections Java : Listes, Sets et Maps - Quiz

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

_Cette présentation est un quiz pour tester ses connaissances sur le chapitre en
cours. Pour plus de détails, consultez le [contenu complet sur
GitHub][contenu-complet-sur-github]._

## Question 1 - Donnée

**Complétion : déclaration d'une ArrayList**

Complétez le code pour créer une liste de plantes :

```java
______<String> plants = new ______<>();
plants.add("Tomate");
plants.add("Carotte");
plants.add("Tomate");
System.out.println(plants.size());
```

- **A.** `ArrayList`, et affiche `2`
- **B.** `ArrayList`, et affiche `3`
- **C.** `HashSet`, et affiche `2`
- **D.** `HashMap`, et affiche `3`

## Question 1 - Réponse

**Réponse correcte : B** - `ArrayList`, et affiche `3`

```java
ArrayList<String> plants = new ArrayList<>();
plants.add("Tomate");
plants.add("Carotte");
plants.add("Tomate");
System.out.println(plants.size());  // 3
```

Une `ArrayList` est une **liste** :

- Elle **préserve l'ordre** d'insertion.
- Elle **autorise les doublons** ("Tomate" apparaît deux fois).
- La taille est donc 3.

## Question 2 - Donnée

**Prédiction : HashSet et doublons**

Que va afficher ce code ?

```java
Set<String> seeds = new HashSet<>();
seeds.add("Tomate");
seeds.add("Carotte");
seeds.add("Tomate");
seeds.add("Basilic");
seeds.add("Carotte");
System.out.println(seeds.size());
```

- **A.** `5`
- **B.** `4`
- **C.** `3`
- **D.** Erreur de compilation

## Question 2 - Réponse

**Réponse correcte : C** - `3`

```java
Set<String> seeds = new HashSet<>();
seeds.add("Tomate");   // ajouté
seeds.add("Carotte");  // ajouté
seeds.add("Tomate");   // ignoré (doublon)
seeds.add("Basilic");  // ajouté
seeds.add("Carotte");  // ignoré (doublon)
System.out.println(seeds.size());  // 3
```

Un `HashSet` **n'autorise pas les doublons**. Il utilise `equals()` et
`hashCode()` pour détecter les éléments identiques. `add()` retourne `false` si
l'élément existe déjà.

## Question 3 - Donnée

**Complétion : HashMap**

Complétez le code pour associer des plantes à leur quantité :

```java
Map<String, Integer> garden = new __________<>();
garden.put("Tomate", 5);
garden.put("Carotte", 3);
garden.put("Tomate", 8);
System.out.println(garden.get("Tomate"));
System.out.println(garden.size());
```

Qu'affiche ce code si on utilise `HashMap` ?

## Question 3 - Réponse

**Sortie :**

```
8
2
```

```java
Map<String, Integer> garden = new HashMap<>();
garden.put("Tomate", 5);   // {"Tomate": 5}
garden.put("Carotte", 3);  // {"Tomate": 5, "Carotte": 3}
garden.put("Tomate", 8);   // {"Tomate": 8, "Carotte": 3}
```

Une `HashMap` associe des **clés** à des **valeurs** :

- Les clés sont **uniques** : `put()` avec une clé existante **remplace** la
  valeur.
- `get("Tomate")` retourne `8` (la dernière valeur).
- La taille est `2` (deux clés distinctes).

## Question 4 - Donnée

**Comparaison : ArrayList vs LinkedList**

Quelle affirmation est correcte ?

- **A.** `ArrayList` est plus rapide pour l'accès par index, `LinkedList` est
  plus rapide pour les insertions/suppressions au milieu.
- **B.** `LinkedList` est plus rapide pour l'accès par index.
- **C.** `ArrayList` et `LinkedList` ont exactement les mêmes performances.
- **D.** `LinkedList` ne peut pas contenir de doublons.

## Question 4 - Réponse

**Réponse correcte : A**

| Opération             | ArrayList | LinkedList |
| :-------------------- | :-------- | :--------- |
| Accès par index       | O(1)      | O(n)       |
| Ajout/suppression fin | O(1)\*    | O(1)       |
| Ajout/suppression     | O(n)      | O(1)\*\*   |

\* Amorti. \*\* Si on a déjà la référence du noeud.

- `ArrayList` : tableau redimensionnable, accès direct par index.
- `LinkedList` : liste chaînée, chaque élément pointe vers le suivant.
- Les deux autorisent les doublons et préservent l'ordre.

## Question 5 - Donnée

**Prédiction : TreeSet et ordre**

Que va afficher ce code ?

```java
Set<String> herbs = new TreeSet<>();
herbs.add("Basilic");
herbs.add("Thym");
herbs.add("Persil");
herbs.add("Ciboulette");
System.out.println(herbs);
```

- **A.** `[Basilic, Thym, Persil, Ciboulette]`
- **B.** `[Basilic, Ciboulette, Persil, Thym]`
- **C.** L'ordre est aléatoire.
- **D.** Erreur de compilation.

## Question 5 - Réponse

**Réponse correcte : B** - `[Basilic, Ciboulette, Persil, Thym]`

Un `TreeSet` trie automatiquement les éléments en **ordre naturel** (ordre
alphabétique pour les `String`).

| Type            | Ordre garanti ?             | Doublons ? |
| :-------------- | :-------------------------- | :--------- |
| `HashSet`       | Non (ordre imprévisible)    | Non        |
| `TreeSet`       | Oui (ordre naturel/comparé) | Non        |
| `LinkedHashSet` | Oui (ordre d'insertion)     | Non        |

## Question 6 - Donnée

**Prédiction : itération sur une Map**

Que va afficher ce code ?

```java
Map<String, Integer> stock = new TreeMap<>();
stock.put("Tomate", 10);
stock.put("Carotte", 5);
stock.put("Basilic", 8);

for (Map.Entry<String, Integer> entry : stock.entrySet()) {
    System.out.println(entry.getKey() + " : " + entry.getValue());
}
```

- **A.** L'ordre d'insertion : Tomate, Carotte, Basilic
- **B.** L'ordre alphabétique : Basilic, Carotte, Tomate
- **C.** L'ordre est aléatoire
- **D.** Erreur de compilation

## Question 6 - Réponse

**Réponse correcte : B** - Ordre alphabétique

```
Basilic : 8
Carotte : 5
Tomate : 10
```

`TreeMap` trie les entrées par **clé** en ordre naturel (alphabétique pour les
`String`). On utilise `entrySet()` pour parcourir les paires clé-valeur.

- `HashMap` : ordre imprévisible.
- `TreeMap` : trié par clé.
- `LinkedHashMap` : ordre d'insertion.

## Question 7 - Donnée

**Prédiction : ConcurrentModificationException**

Que se passe-t-il à l'exécution de ce code ?

```java
List<String> plants = new ArrayList<>();
plants.add("Tomate");
plants.add("Mauvaise herbe");
plants.add("Carotte");

for (String plant : plants) {
    if (plant.equals("Mauvaise herbe")) {
        plants.remove(plant);
    }
}
```

- **A.** Supprime "Mauvaise herbe" correctement.
- **B.** Lance une `ConcurrentModificationException`.
- **C.** Erreur de compilation.
- **D.** Ne supprime rien.

## Question 7 - Réponse

**Réponse correcte : B** - `ConcurrentModificationException`

On ne peut **pas modifier une collection pendant qu'on l'itère** avec un
`for-each`. La solution est d'utiliser un `Iterator` :

```java
Iterator<String> iterator = plants.iterator();
while (iterator.hasNext()) {
    String plant = iterator.next();
    if (plant.equals("Mauvaise herbe")) {
        iterator.remove();  // Suppression sûre
    }
}
```

Autre solution : `plants.removeIf(p -> p.equals("Mauvaise herbe"));`

## Question 8 - Donnée

**Complétion : parcours d'une liste**

Quel est le résultat de ce code ?

```java
List<Integer> numbers = new ArrayList<>();
numbers.add(10);
numbers.add(20);
numbers.add(30);

int total = 0;
for (int n : numbers) {
    total += n;
}
System.out.println(total);
```

- **A.** `10`
- **B.** `30`
- **C.** `60`
- **D.** Erreur de compilation

## Question 8 - Réponse

**Réponse correcte : C** - `60`

```java
// Itération 1 : total = 0 + 10 = 10
// Itération 2 : total = 10 + 20 = 30
// Itération 3 : total = 30 + 30 = 60
```

La boucle `for-each` parcourt chaque élément de la liste dans l'ordre. C'est la
manière la plus simple et lisible de parcourir une collection en Java.

## Question 9 - Donnée

**Comparaison : choisir la bonne collection**

Quel type de collection est le plus adapté pour chacun de ces besoins ?

1. Stocker une liste de tâches **dans l'ordre** avec possibilité de doublons.
2. Stocker des **identifiants uniques** sans ordre particulier.
3. Associer un **nom de plante** à sa **date de plantation**.

## Question 9 - Réponse

**Réponses :**

1. **`ArrayList`** : préserve l'ordre, autorise les doublons, accès par index.
2. **`HashSet`** : unicité garantie, performances optimales en O(1).
3. **`HashMap`** : association clé (nom) -> valeur (date).

Résumé pour choisir :

| Besoin                    | Collection  |
| :------------------------ | :---------- |
| Éléments ordonnés         | `ArrayList` |
| Éléments uniques          | `HashSet`   |
| Éléments uniques et triés | `TreeSet`   |
| Associations clé-valeur   | `HashMap`   |

## Question 10 - Donnée

**Prédiction : HashMap et null**

Que va afficher ce code ?

```java
Map<String, Integer> map = new HashMap<>();
map.put("Tomate", 5);

Integer quantity = map.get("Concombre");
System.out.println(quantity);
```

- **A.** `0`
- **B.** `null`
- **C.** Lance une `NullPointerException`.
- **D.** Erreur de compilation.

## Question 10 - Réponse

**Réponse correcte : B** - `null`

```java
Integer quantity = map.get("Concombre");  // clé absente -> null
System.out.println(quantity);              // affiche "null"
```

`get()` retourne `null` si la clé n'existe pas. Pour éviter les surprises :

```java
// Vérifier avant d'utiliser
if (map.containsKey("Concombre")) { ... }

// Ou utiliser getOrDefault
int qty = map.getOrDefault("Concombre", 0);
```

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions sur le quiz ou le contenu ?

## Sources

- [Illustration principale][illustration-principale] par
  [Markus Spiske](https://unsplash.com/@markusspiske) sur
  [Unsplash](https://unsplash.com/photos/blue-and-white-logo-guessing-game-iar-afB0QQw)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/08-collections-java-listes-sets-et-maps/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1611519541067-46c8f2d05f11?fit=crop&h=720
