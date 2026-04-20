---
marp: true
theme: "custom-marp-theme"
size: "16:9"
paginate: "true"
author: "V. Guidoux, avec l'aide de GitHub Copilot"
description:
  "Collections Java - Lambda et génériques pour le cours ProgIM2 enseigné à la
  HEIG-VD, Suisse"
lang: "fr"
url: "https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/09-collections-java-lambda-et-generiques/presentation.html"
header:
  "[**Collections Java : Lambda et génériques**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Collections Java : Lambda et génériques

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

## Objectifs (1/2)

- Expliquer ce qu'est une expression lambda et une interface fonctionnelle en
  Java.
- Identifier les interfaces fonctionnelles courantes (`Predicate`, `Function`,
  `Consumer`, `Supplier`).
- Créer des expressions lambda pour des interfaces fonctionnelles.
- Utiliser les lambdas avec les collections (`forEach`, `removeIf`, `sort`).

![bg right:40%][illustration-objectifs]

## Objectifs (2/2)

- Expliquer l'utilité des génériques pour la sécurité de type.
- Créer des classes et des méthodes génériques avec des paramètres de type.
- Utiliser les wildcards (`<? extends T>`, `<? super T>`) pour écrire du code
  flexible.
- Appliquer les génériques avec les collections pour éviter les erreurs de type
  à la compilation.

![bg right:40%][illustration-objectifs]

## Les expressions lambda

<!-- _class: lead -->

### Le problème : trop de code

Pour trier une liste de plantes par nom, il faut créer une classe entière :

```java
public class PlantNameComparator implements Comparator<PlantBase> {
    @Override
    public int compare(PlantBase a, PlantBase b) {
        return a.getName().compareTo(b.getName());
    }
}
```

Puis l'utiliser :

```java
plants.sort(new PlantNameComparator());
```

C'est beaucoup de code pour une simple comparaison.

### La solution : les lambdas

Avec une lambda, tout tient en une ligne :

```java
plants.sort((a, b) -> a.getName().compareTo(b.getName()));
```

Une expression lambda est une **fonction anonyme** (sans nom) qui peut être
passée en paramètre d'une méthode.

Syntaxe : `(paramètres) -> expression`

### Différentes formes de lambdas

```java
// Sans paramètre
Runnable task = () -> System.out.println("Tâche exécutée");

// Un seul paramètre (parenthèses optionnelles)
Consumer<String> printer = name ->
        System.out.println("Plante : " + name);

// Plusieurs paramètres
Comparator<PlantBase> byName =
        (a, b) -> a.getName().compareTo(b.getName());
```

Les types des paramètres sont **inférés** automatiquement par Java.

### Bloc avec plusieurs instructions

Si le corps de la lambda contient plusieurs lignes, on utilise des accolades et
un `return` explicite si nécessaire :

```java
Consumer<PlantBase> detailedPrinter = plant -> {
    System.out.println("Nom : " + plant.getName());
    System.out.println("Espèce : " + plant.getSpecies());
};
```

## Les interfaces fonctionnelles

<!-- _class: lead -->

### Qu'est-ce qu'une interface fonctionnelle ?

Une interface fonctionnelle est une interface avec **une seule méthode
abstraite**.

```java
@FunctionalInterface
public interface PlantFilter {
    boolean test(PlantBase plant);
}
```

L'annotation `@FunctionalInterface` est optionnelle mais recommandée : le
compilateur vérifie qu'il n'y a bien qu'une seule méthode abstraite.

### Utiliser une interface fonctionnelle avec une lambda

```java
PlantFilter isReady = plant ->
        plant instanceof Harvestable
                && ((Harvestable) plant).isReadyToHarvest();

PlantFilter isLarge = plant -> plant.getSize() > 50.0;
```

La lambda **implémente** la méthode `test()` de l'interface `PlantFilter`.

### Les quatre interfaces fonctionnelles de Java (1/2)

Java fournit des interfaces fonctionnelles prédéfinies dans `java.util.function`
:

| Interface        | Méthode             | Description                  |
| :--------------- | :------------------ | :--------------------------- |
| `Predicate<T>`   | `boolean test(T t)` | Teste une condition.         |
| `Function<T, R>` | `R apply(T t)`      | Transforme un `T` en un `R`. |
| `Consumer<T>`    | `void accept(T t)`  | Consomme un `T` sans retour. |
| `Supplier<T>`    | `T get()`           | Fournit un `T` sans entrée.  |

### Les quatre interfaces fonctionnelles de Java (2/2)

```java
// Predicate : teste une condition
Predicate<PlantBase> isLarge = plant -> plant.getSize() > 50.0;

// Function : transforme un objet
Function<PlantBase, String> toName = plant -> plant.getName();

// Consumer : effectue une action
Consumer<PlantBase> print = plant ->
        System.out.println(plant.getName());

// Supplier : fournit un objet
Supplier<PlantBase> create = () ->
        new VegetablePlant("Laitue", "Lactuca", "2026-05-01", 5, 60);
```

## Lambdas avec les collections

<!-- _class: lead -->

### forEach : appliquer une action

```java
// Avant : boucle for-each
for (PlantBase plant : plants) {
    System.out.println(plant.getName());
}

// Après : avec forEach
plants.forEach(plant -> System.out.println(plant.getName()));
```

`forEach` accepte un `Consumer<T>`.

### removeIf : supprimer selon une condition

```java
// Supprimer les plantes de moins de 20 cm
plants.removeIf(plant -> plant.getSize() < 20.0);
```

`removeIf` accepte un `Predicate<T>`.

C'est une alternative plus concise à la boucle avec `Iterator` et `it.remove()`.

### sort : trier selon un critère

```java
// Trier par nom (ordre alphabétique)
plants.sort((a, b) -> a.getName().compareTo(b.getName()));

// Trier par taille (croissant)
plants.sort((a, b) -> Double.compare(a.getSize(), b.getSize()));
```

`sort` accepte un `Comparator<T>`.

### Références de méthodes

Quand une lambda appelle simplement une méthode existante, on peut utiliser
l'opérateur `::` :

```java
// Lambda
plants.forEach(plant -> System.out.println(plant));

// Référence de méthode (équivalent)
plants.forEach(System.out::println);
```

| Type               | Syntaxe           | Exemple               |
| :----------------- | :---------------- | :-------------------- |
| Méthode statique   | `Classe::méthode` | `Math::abs`           |
| Méthode d'instance | `objet::méthode`  | `System.out::println` |
| Constructeur       | `Classe::new`     | `ArrayList::new`      |

## Les génériques

<!-- _class: lead -->

### Le problème : sans génériques (1/2)

Avant les génériques, les collections stockaient des `Object` :

```java
List plants = new ArrayList();
plants.add(new VegetablePlant("Tomate", "Solanum",
        "2026-03-15", 45.5, 0));
plants.add("Ceci n'est pas une plante"); // Pas d'erreur !
```

Aucune vérification de type à la compilation.

### Le problème : sans génériques (2/2)

Il fallait caster manuellement :

```java
PlantBase plant = (PlantBase) plants.get(0); // OK
PlantBase oops = (PlantBase) plants.get(1);
// ClassCastException à l'exécution !
```

L'erreur n'apparaît qu'à l'**exécution**, pas à la **compilation**.

### Les classes génériques

Un paramètre de type `<T>` est remplacé par un type concret à l'utilisation :

```java
public class Box<T> {
    private T value;
    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
```

Utilisation :

```java
Box<String> stringBox = new Box<>();
stringBox.set("Tomate");
String name = stringBox.get(); // Pas de cast
```

### Sécurité de type à la compilation

```java
Box<String> stringBox = new Box<>();
stringBox.set("Tomate");    // OK
// stringBox.set(42);       // Erreur de compilation !

Box<Integer> intBox = new Box<>();
intBox.set(42);             // OK
int value = intBox.get();   // Auto-unboxing
```

Les erreurs de type sont détectées **à la compilation**, pas à l'exécution.

### Plusieurs paramètres de type

```java
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}
```

Conventions : `T` (type), `E` (element), `K` (key), `V` (value).

### Les méthodes génériques

Le paramètre de type est déclaré **avant** le type de retour :

```java
public static <T> void printAll(List<T> items) {
    for (T item : items) {
        System.out.println(item);
    }
}

public static <T> T getFirst(List<T> items) {
    if (items.isEmpty()) { return null; }
    return items.get(0);
}
```

Le type `T` est **inféré** lors de l'appel.

## Les wildcards

<!-- _class: lead -->

### Wildcard non borné : `<?>`

Accepte n'importe quel type :

```java
public static void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}
```

Fonctionne avec `List<String>`, `List<PlantBase>`, etc.

### Wildcard borné supérieurement : `<? extends T>`

Accepte `T` ou un **sous-type** de `T`. Utile pour **lire** :

```java
public static double totalSize(
        List<? extends PlantBase> plants) {
    double total = 0;
    for (PlantBase plant : plants) {
        total += plant.getSize();
    }
    return total;
}
```

Fonctionne avec `List<PlantBase>`, `List<VegetablePlant>`, etc.

### Wildcard borné inférieurement : `<? super T>`

Accepte `T` ou un **super-type** de `T`. Utile pour **écrire** :

```java
public static void addDefaults(
        List<? super VegetablePlant> list) {
    list.add(new VegetablePlant("Laitue", "Lactuca",
            "2026-05-01", 5.0, 45));
}
```

Fonctionne avec `List<VegetablePlant>`, `List<PlantBase>`, `List<Object>`.

### Règle PECS

**P**roducer **E**xtends, **C**onsumer **S**uper :

- **Lire** des éléments => `<? extends T>`.
- **Écrire** des éléments => `<? super T>`.

### Limitations des génériques

- Pas de types primitifs : `List<int>` est interdit, utiliser `List<Integer>`.
- Pas d'instanciation : `new T()` est interdit.
- Pas de tableau générique : `new T[10]` est interdit.

Ces restrictions viennent de l'**effacement de type** (type erasure) : les
génériques n'existent qu'à la compilation, pas à l'exécution.

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## À vous de jouer !

- (Re)lire le contenu de cours.
- Lire les exemples de code et les descriptions.
- Faire les exercices. Faire le mini-projet. Poser des questions si nécessaire.

[Visualiser le contenu complet sur GitHub.][contenu-complet-sur-github]

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
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/09-collections-java-lambda-et-generiques/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
