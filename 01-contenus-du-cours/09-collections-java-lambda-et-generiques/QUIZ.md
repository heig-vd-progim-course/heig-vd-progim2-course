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

## Question 1 - Réponse

**Réponse correcte :** `<T>`, `T`, `T`, `T`

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

## Question 2 - Donnée

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

## Question 3 - Réponse

**Réponse correcte :** - `<T>`, `T`

```java
public static <T> T getFirst(List<T> items) {
    if (items.isEmpty()) {
        return null;
    }
    return items.get(0);
}
```

## Question 4 - Donnée

Quel est le résultat de ce code ?

```java
Box<String> box1 = new Box<>("Hello");
Box<Integer> box2 = new Box<>(42);
System.out.println(box1.getClass() == box2.getClass());
```

## Question 4 - Réponse

**Réponse correcte :** `true`

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

## Question 5 - Réponse

**Réponse correcte : A** - Lignes A et C uniquement.

- **Ligne A** : erreur. `names` est de type `List<String>`, on ne peut pas
  ajouter un `int`.
- **Ligne B** : pas d'erreur. `List<Object>` accepte `String` et `Integer` (les
  deux héritent de `Object`).
- **Ligne C** : erreur. `copy.get(0)` retourne un `String`, pas un `Integer`. Le
  compilateur refuse l'affectation.

Les génériques détectent les erreurs de type **avant** l'exécution.

<!--
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
importantes à connaître. -->

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
