---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  "Quiz sur le contenu Collections Java - Les génériques pour le cours ProgIM2
  enseigné à la HEIG-VD, Suisse"
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/09-collections-java-lambda-et-generiques/quiz.html
header:
  "[**Collections Java : Les génériques - Quiz**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Collections Java : Les génériques - Quiz

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

**Complétion : classe générique**

Complétez la déclaration de cette classe générique :

```java
public class Box______  {
    private ______ value;

    public Box(______ value) {
        this.value = value;
    }

    public ______ getValue() {
        return value;
    }
}
```

- **A.** `<T>`, `T`, `T`, `T`
- **B.** `<Object>`, `Object`, `Object`, `Object`
- **C.** `<String>`, `String`, `String`, `String`
- **D.** `<T>`, `Object`, `Object`, `T`

## Question 1 - Réponse

**Réponse correcte : A** - `<T>`, `T`, `T`, `T`

```java
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```

Le paramètre de type `T` est déclaré après le nom de la classe (`Box<T>`) et
utilisé partout où le type concret sera substitué. À l'utilisation,
`Box<String>` remplace tous les `T` par `String`.

## Question 2 - Donnée

**Complétion : opérateur diamant**

Quelle ligne utilise correctement l'opérateur diamant `<>` ?

```java
// Ligne A
Box<String> box = new Box<String>("Hello");

// Ligne B
Box<String> box = new Box<>("Hello");

// Ligne C
Box<> box = new Box<String>("Hello");

// Ligne D
Box box = new Box<>("Hello");
```

- **A.** Uniquement A.
- **B.** Uniquement B.
- **C.** A et B sont correctes.
- **D.** A, B et D sont correctes.

## Question 2 - Réponse

**Réponse correcte : C** - A et B sont correctes.

```java
// A : correct (type explicite des deux côtés)
Box<String> box = new Box<String>("Hello");

// B : correct (diamant : type inféré à droite)
Box<String> box = new Box<>("Hello");

// C : ERREUR - le diamant doit être à droite, pas à gauche
// D : WARNING - type brut à gauche (perte de sécurité)
```

L'opérateur diamant `<>` permet à Java d'inférer le type à partir de la
déclaration. La ligne D compile avec un avertissement mais utilise un type brut.

## Question 3 - Donnée

**Complétion : méthode générique**

Complétez cette méthode générique qui retourne le premier élément d'une liste :

```java
public static ______ ______ getFirst(List<T> items) {
    if (items.isEmpty()) {
        return null;
    }
    return items.get(0);
}
```

- **A.** `T`, `<T>`
- **B.** `<T>`, `T`
- **C.** `Object`, `<T>`
- **D.** `<T>`, `Object`

## Question 3 - Réponse

**Réponse correcte : B** - `<T>`, `T`

```java
public static <T> T getFirst(List<T> items) {
    if (items.isEmpty()) {
        return null;
    }
    return items.get(0);
}
```

Pour une méthode générique, le paramètre de type `<T>` est déclaré **avant** le
type de retour. L'ordre est : modificateurs, `<T>`, type de retour, nom de la
méthode. Le type de retour est `T` (pas `Object`), ce qui conserve la sécurité
des types.

## Question 4 - Donnée

**Prédiction : effacement de type**

Quel est le résultat de ce code ?

```java
Box<String> box1 = new Box<>("Hello");
Box<Integer> box2 = new Box<>(42);
System.out.println(box1.getClass() == box2.getClass());
```

- **A.** `true`
- **B.** `false`
- **C.** Erreur de compilation.
- **D.** `ClassCastException` à l'exécution.

## Question 4 - Réponse

**Réponse correcte : A** - `true`

```java
System.out.println(
        box1.getClass() == box2.getClass());  // true
```

À cause de l'**effacement de type** (type erasure), les paramètres de type sont
supprimés à la compilation. À l'exécution, `Box<String>` et `Box<Integer>`
deviennent simplement `Box`.

Il n'existe pas de classe `Box<String>` distincte de `Box<Integer>` à
l'exécution.

## Question 5 - Donnée

**Prédiction : sécurité de type**

Quelles lignes provoquent une erreur de compilation ?

```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add(42);                       // Ligne A

List<Object> objects = new ArrayList<>();
objects.add("Texte");
objects.add(42);                     // Ligne B

List<String> copy = names;
Integer n = copy.get(0);             // Ligne C
```

- **A.** Lignes A et C uniquement.
- **B.** Lignes A, B et C.
- **C.** Ligne A uniquement.
- **D.** Aucune erreur de compilation.

## Question 5 - Réponse

**Réponse correcte : A** - Lignes A et C uniquement.

- **Ligne A** : erreur. `names` est de type `List<String>`, on ne peut pas
  ajouter un `int`.
- **Ligne B** : pas d'erreur. `List<Object>` accepte `String` et `Integer` (les
  deux héritent de `Object`).
- **Ligne C** : erreur. `copy.get(0)` retourne un `String`, pas un `Integer`. Le
  compilateur refuse l'affectation.

Les génériques détectent les erreurs de type **avant** l'exécution.

## Question 6 - Donnée

**Comparaison : génériques vs polymorphisme**

Quelle affirmation décrit correctement la différence entre les génériques et le
polymorphisme de sous-typage ?

```java
// Code A (polymorphisme)
PlantBase plant = new VegetablePlant(...);
plant.toString(); // Appelle VegetablePlant.toString()

// Code B (génériques)
Box<String> box = new Box<>("Tomate");
box.get(); // Retourne un String
```

- **A.** Le polymorphisme varie le comportement selon le sous-type, les
  génériques gardent un comportement identique pour tous les types.
- **B.** Les génériques varient le comportement selon le type, le polymorphisme
  garde un comportement identique.
- **C.** Les deux sont identiques, seule la syntaxe change.
- **D.** Les génériques remplacent le polymorphisme en Java.
- **C.** Les deux sont identiques.
- **D.** Aucune des deux ne compile.

## Question 6 - Réponse

**Réponse correcte : A**

- **Polymorphisme de sous-typage** : le comportement est déterminé à l'exécution
  par le type réel de l'objet. `plant.toString()` appelle la version redéfinie
  dans `VegetablePlant`. Chaque sous-type peut répondre différemment.

- **Génériques (polymorphisme paramétrique)** : le comportement est identique
  pour tous les types. `Box<String>` et `Box<Integer>` utilisent exactement le
  même code. Seul le type paramétré change.

Les deux mécanismes sont complémentaires, pas interchangeables.

## Question 7 - Donnée

**Prédiction : List&lt;String&gt; et List&lt;Object&gt;**

Ce code compile-t-il ?

```java
List<String> names = new ArrayList<>();
names.add("Alice");

List<Object> objects = names;
```

- **A.** Oui, `String` hérite de `Object`.
- **B.** Non, erreur de compilation.
- **C.** Oui, mais avertissement du compilateur.
- **D.** Oui, mais `ClassCastException` à l'exécution.

## Question 7 - Réponse

**Réponse correcte : B** - Non, erreur de compilation.

Même si `String` hérite de `Object`, `List<String>` **n'est pas** un sous-type
de `List<Object>`. Les génériques sont **invariants**.

Si c'était permis, on pourrait écrire :

```java
List<Object> objects = names;  // Si c'était permis...
objects.add(42);               // Ajout d'un Integer !
String s = names.get(1);      // ClassCastException !
```

Pour accepter les deux, il faudrait utiliser des mécanismes plus avancés comme
les wildcards (hors du cadre de ce chapitre).

## Question 8 - Donnée

**Prédiction : type brut**

Le code suivant compile-t-il ? Si oui, que se passe-t-il à l'exécution ?

```java
List rawList = new ArrayList();
rawList.add("Hello");
rawList.add(42);

for (Object item : rawList) {
    String s = (String) item;
}
```

- **A.** Erreur de compilation.
- **B.** Compile et s'exécute sans erreur.
- **C.** Compile mais `ClassCastException` à l'exécution.
- **D.** Compile mais `NullPointerException` à l'exécution.

## Question 8 - Réponse

**Réponse correcte : C** - Compile mais `ClassCastException` à l'exécution.

```java
List rawList = new ArrayList();  // Type brut
rawList.add("Hello");            // OK
rawList.add(42);                 // OK (pas de vérification)

for (Object item : rawList) {
    String s = (String) item;    // ClassCastException sur 42 !
}
```

Sans paramètre de type (`List` au lieu de `List<String>`), Java ne peut pas
vérifier les types à la compilation. Le cast `(String)` échoue quand l'élément
est un `Integer`.

## Question 9 - Donnée

**Prédiction : Pair générique**

Quel est le résultat de ce code ?

```java
Pair<String, Integer> p = new Pair<>("Alice", 22);
System.out.println(p.getKey());
System.out.println(p.getValue());
System.out.println(p.getKey().getClass().getSimpleName());
System.out.println(p.getValue().getClass().getSimpleName());
```

- **A.** `Alice`, `22`, `String`, `Integer`
- **B.** `Alice`, `22`, `Object`, `Object`
- **C.** Erreur de compilation.
- **D.** `Alice`, `22`, `String`, `int`

## Question 9 - Réponse

**Réponse correcte : A** - `Alice`, `22`, `String`, `Integer`

```java
System.out.println(p.getKey());    // Alice
System.out.println(p.getValue());  // 22
System.out.println(
        p.getKey().getClass().getSimpleName());    // String
System.out.println(
        p.getValue().getClass().getSimpleName());  // Integer
```

Les génériques conservent le type à la compilation. `getKey()` retourne un
`String` et `getValue()` retourne un `Integer` (pas `int` car `getClass()`
s'appelle sur l'objet wrapper, pas sur le type primitif).

## Question 10 - Donnée

**Prédiction : limitations des génériques**

Lequel de ces codes provoque une erreur de compilation ?

```java
// Code A
Box<int> box = new Box<>(42);

// Code B
Box<String> box = new Box<>(null);

// Code C
Box<String>[] boxes = new Box<String>[10];
```

- **A.** A uniquement.
- **B.** A et C.
- **C.** A, B et C.
- **D.** Aucun.

## Question 10 - Réponse

**Réponse correcte : B** - A et C.

- **Code A** : erreur. Les génériques ne fonctionnent pas avec les types
  primitifs (`int`, `double`, etc.). Il faut utiliser `Box<Integer>`.
- **Code B** : pas d'erreur. On peut passer `null` à un constructeur générique.
- **Code C** : erreur. On ne peut pas créer un tableau de type générique en
  Java. C'est une limitation de l'effacement de type.

Les types primitifs et les tableaux de génériques sont deux limitations
importantes à connaître.

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions sur le quiz ou le contenu ?

## Sources

- [Illustration principale][illustration-principale] par
  [Markus Spiske](https://unsplash.com/@markusspiske) sur
  [Unsplash](https://unsplash.com/photos/blue-and-white-logo-guessing-game-iar-afB0QQw)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/09-collections-java-lambda-et-generiques/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1611519541067-46c8f2d05f11?fit=crop&h=720
