---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  Quiz sur le contenu Collections Java - Lambda et génériques pour le cours
  ProgIM2 enseigné à la HEIG-VD, Suisse
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/09-collections-java-lambda-et-generiques/quiz.html
header:
  "[**Collections Java : Lambda et génériques -
  Quiz**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Collections Java : Lambda et génériques - Quiz

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

**Complétion : forEach avec lambda**

Complétez le code pour afficher chaque élément de la liste :

```java
List<String> fruits = new ArrayList<>();
fruits.add("Pomme");
fruits.add("Poire");

fruits.______(fruit -> System.out.println(fruit));
```

- **A.** `for`
- **B.** `forEach`
- **C.** `each`
- **D.** `loop`

## Question 1 - Réponse

**Réponse correcte : B** - `forEach`

```java
fruits.forEach(fruit -> System.out.println(fruit));
```

La méthode `forEach` prend un `Consumer<T>` en paramètre. La lambda
`fruit -> System.out.println(fruit)` est un `Consumer<String>` : elle prend un
`String` et ne retourne rien.

## Question 2 - Donnée

**Prédiction : removeIf**

Quel est le contenu de la liste après l'exécution ?

```java
List<Integer> numbers = new ArrayList<>();
numbers.add(5);
numbers.add(12);
numbers.add(3);
numbers.add(8);
numbers.add(15);

numbers.removeIf(n -> n > 10);
System.out.println(numbers);
```

- **A.** `[12, 15]`
- **B.** `[5, 3, 8]`
- **C.** `[5, 12, 3, 8, 15]`
- **D.** `[]`

## Question 2 - Réponse

**Réponse correcte : B** - `[5, 3, 8]`

```java
numbers.removeIf(n -> n > 10);
// Supprime 12 (12 > 10) et 15 (15 > 10)
// Garde 5, 3, 8 (tous <= 10)
```

`removeIf` supprime tous les éléments pour lesquels le `Predicate` retourne
`true`. Ici, les éléments **supérieurs à 10** sont supprimés.

## Question 3 - Donnée

**Complétion : sort avec lambda**

Complétez le code pour trier la liste par ordre alphabétique :

```java
List<String> cities = new ArrayList<>();
cities.add("Zurich");
cities.add("Berne");
cities.add("Genève");

cities.sort(______ -> a.compareTo(b));
```

- **A.** `(a, b)`
- **B.** `a, b`
- **C.** `(String a, String b)`
- **D.** A et C sont corrects

## Question 3 - Réponse

**Réponse correcte : D** - A et C sont corrects

```java
// Forme courte (types inférés)
cities.sort((a, b) -> a.compareTo(b));

// Forme longue (types explicites)
cities.sort((String a, String b) -> a.compareTo(b));
```

Les deux formes sont valides. Java peut **inférer les types** des paramètres
grâce au type de la liste (`List<String>`). La forme courte `(a, b)` est
préférée car plus concise.

## Question 4 - Donnée

**Prédiction : interface fonctionnelle**

Quel est le type de chaque variable ?

```java
_______ isLong = s -> s.length() > 5;
_______ toUpper = s -> s.toUpperCase();
_______ printer = s -> System.out.println(s);
```

- **A.** `Predicate<String>`, `Function<String, String>`, `Consumer<String>`
- **B.** `Function<String, Boolean>`, `Function<String, String>`,
  `Consumer<String>`
- **C.** `Consumer<String>`, `Function<String, String>`, `Predicate<String>`
- **D.** `Predicate<String>`, `Consumer<String>`, `Function<String, String>`

## Question 4 - Réponse

**Réponse correcte : A**

```java
Predicate<String> isLong = s -> s.length() > 5;
// Prend un String, retourne boolean -> Predicate

Function<String, String> toUpper = s -> s.toUpperCase();
// Prend un String, retourne un String -> Function

Consumer<String> printer = s -> System.out.println(s);
// Prend un String, ne retourne rien -> Consumer
```

Les trois interfaces sont dans `java.util.function` :

- `Predicate<T>` : `T -> boolean` (méthode `test()`).
- `Function<T, R>` : `T -> R` (méthode `apply()`).
- `Consumer<T>` : `T -> void` (méthode `accept()`).

## Question 5 - Donnée

**Prédiction : référence de méthode**

Ces deux lignes produisent-elles le même résultat ?

```java
// Ligne A
list.forEach(s -> System.out.println(s));

// Ligne B
list.forEach(System.out::println);
```

- **A.** Oui, les deux affichent chaque élément.
- **B.** Non, la ligne B provoque une erreur de compilation.
- **C.** Non, la ligne B affiche les éléments dans un ordre différent.
- **D.** Oui, mais la ligne B est plus lente.

## Question 5 - Réponse

**Réponse correcte : A** - Oui, les deux affichent chaque élément.

`System.out::println` est une **référence de méthode**. C'est un raccourci pour
une lambda qui ne fait que transmettre son argument à une méthode existante.

La règle : quand une lambda a la forme `x -> method(x)`, on peut la remplacer
par `object::method` ou `Class::method`.

## Question 6 - Donnée

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

## Question 6 - Réponse

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

## Question 7 - Donnée

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

## Question 7 - Réponse

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

## Question 8 - Donnée

**Comparaison : wildcard extends vs super**

Quelle est la différence entre ces deux signatures ?

```java
// Méthode A
public double sum(List<? extends Number> list) { ... }

// Méthode B
public void addInts(List<? super Integer> list) { ... }
```

- **A.** A peut lire des `Number`, B peut écrire des `Integer`.
- **B.** A peut écrire des `Number`, B peut lire des `Integer`.
- **C.** Les deux sont identiques.
- **D.** Aucune des deux ne compile.

## Question 8 - Réponse

**Réponse correcte : A**

`<? extends Number>` (producteur) :

- Accepte `List<Integer>`, `List<Double>`, `List<Number>`.
- On peut **lire** les éléments comme `Number`.
- On **ne peut pas écrire** dedans (sauf `null`).

`<? super Integer>` (consommateur) :

- Accepte `List<Integer>`, `List<Number>`, `List<Object>`.
- On peut **écrire** des `Integer` dedans.
- La lecture retourne `Object`.

C'est le principe **PECS** : _Producer Extends, Consumer Super_.

## Question 9 - Donnée

**Prédiction : Predicate en paramètre**

Quel est le résultat de ce code ?

```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
names.add("Charlotte");
names.add("Eve");

Predicate<String> isShort = s -> s.length() <= 3;
names.removeIf(isShort);
System.out.println(names);
```

- **A.** `[Alice, Charlotte]`
- **B.** `[Bob, Eve]`
- **C.** `[Alice, Bob, Charlotte, Eve]`
- **D.** `[Alice, Charlotte, Eve]`

## Question 9 - Réponse

**Réponse correcte : A** - `[Alice, Charlotte]`

```java
Predicate<String> isShort = s -> s.length() <= 3;
names.removeIf(isShort);
// Bob (3 lettres, 3 <= 3 -> true) : supprimé
// Eve (3 lettres, 3 <= 3 -> true) : supprimé
// Alice (5 lettres, 5 <= 3 -> false) : conservé
// Charlotte (9 lettres, 9 <= 3 -> false) : conservé
```

Le `Predicate` peut être stocké dans une variable et réutilisé. On le passe
ensuite à `removeIf` qui appelle `test()` sur chaque élément.

## Question 10 - Donnée

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

## Question 10 - Réponse

**Réponse correcte : C** - Compile mais `ClassCastException` à l'exécution.

```java
List rawList = new ArrayList();  // Type brut : pas de vérification
rawList.add("Hello");            // OK
rawList.add(42);                 // OK (pas de vérification de type)

for (Object item : rawList) {
    String s = (String) item;    // ClassCastException sur 42 !
}
```

Sans paramètre de type (`List` au lieu de `List<String>`), Java ne peut pas
vérifier les types à la compilation. Le cast `(String)` échoue quand l'élément
est un `Integer`.

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
