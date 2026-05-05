---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  "Quiz sur la gestion des exceptions pour le cours ProgIM2 enseigné à la
  HEIG-VD, Suisse"
url: "https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/11-gestion-des-exceptions/quiz.html"
header: "[**Gestion des exceptions - Quiz**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Gestion des exceptions - Quiz

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

## Structure du quiz

<!-- _class: lead -->

**Répartition des questions :**

- Questions 1-5 : gestion des exceptions (chapitre actuel).
- Question 6 : révision de la programmation orientée objet.
- Question 7 : mise en lien de plusieurs concepts.

## Question 1 - Donnée

**Complétion : mots-clés try-catch**

Complétez le code pour lire un pH et gérer un format invalide :

```java
String raw = "abc";

___(___) {
    double ph = Double.parseDouble(raw);
    System.out.println("pH : " + ph);
} ___ (NumberFormatException e) {
    System.out.println("Format invalide : " + e.getMessage());
}
System.out.println("Fin de lecture.");
```

Quels mots-clés remplacent les `___` ?

## Question 1 - Réponse

**Réponse correcte : `try` et `catch`**

```java
String raw = "abc";

try {
    double ph = Double.parseDouble(raw);
    System.out.println("pH : " + ph);
} catch (NumberFormatException e) {
    System.out.println("Format invalide : " + e.getMessage());
}
System.out.println("Fin de lecture.");
// Format invalide : For input string: "abc"
// Fin de lecture.
```

## Question 2 - Donnée

**Prédiction : bloc finally**

Que va afficher ce code ?

```java
try {
    System.out.println("A");
    int result = 10 / 0;
    System.out.println("B");
} catch (ArithmeticException e) {
    System.out.println("C");
} finally {
    System.out.println("D");
}
System.out.println("E");
```

## Question 2 - Réponse

**Réponse correcte :** `A`, `C`, `D`, `E`

- `"A"` : affiché avant l'erreur.
- `"B"` : jamais atteint (division par zéro).
- `"C"` : `ArithmeticException` capturée.
- `"D"` : `finally` s'exécute **toujours**, succès ou erreur.
- `"E"` : le programme continue normalement après le bloc.

## Question 3 - Donnée

**Comparaison : exceptions vérifiées et non vérifiées**

Laquelle de ces affirmations est correcte ?

- **A.** `NullPointerException` est une exception vérifiée.
- **B.** `IOException` est une exception vérifiée.
- **C.** `ArrayIndexOutOfBoundsException` est une exception vérifiée.
- **D.** Toutes les sous-classes d'`Exception` sont vérifiées.

## Question 3 - Réponse

**Réponse correcte : B**

| Classe                           | Type         | Héritage           |
| :------------------------------- | :----------- | :----------------- |
| `IOException`                    | Vérifiée     | `Exception`        |
| `NullPointerException`           | Non vérifiée | `RuntimeException` |
| `ArrayIndexOutOfBoundsException` | Non vérifiée | `RuntimeException` |

Les exceptions non vérifiées héritent de `RuntimeException`.

## Question 4 - Donnée

**Prédiction : ordre des blocs catch**

Ce code compile-t-il ? Si oui, que s'affiche-t-il quand `raw = "abc"` ?

```java
try {
    double ph = Double.parseDouble(raw);
    System.out.println("pH : " + ph);
} catch (Exception e) {
    System.out.println("Erreur générale.");
} catch (NumberFormatException e) {
    System.out.println("Format invalide.");
}
```

## Question 4 - Réponse

**Le code ne compile pas.**

```
error: exception NumberFormatException has already been caught
```

`NumberFormatException` hérite d'`Exception`. Le premier `catch` capture déjà
**toutes** les exceptions. Le second bloc est donc **mort** (_unreachable_).

Les types les **plus spécifiques** doivent toujours être placés en premier.

## Question 5 - Donnée

**Complétion : créer une exception personnalisée**

Complétez la classe pour qu'elle soit une exception **vérifiée** :

```java
class InvalidPhException extends ________ {

    public InvalidPhException(String sensorId, double value) {
        ________("pH invalide pour " + sensorId + " : " + value);
    }
}
```

Quels mots remplacent les `________` ?

## Question 5 - Réponse

**Réponse correcte : `Exception` et `super`**

```java
class InvalidPhException extends Exception {

    public InvalidPhException(String sensorId, double value) {
        super("pH invalide pour " + sensorId + " : " + value);
    }
}
```

Hériter d'`Exception` (pas de `RuntimeException`) rend l'exception **vérifiée**.
`super(...)` transmet le message à la classe parente.

## Question 6 - Donnée

**Révision : héritage et relation IS-A**

Si `InvalidPhException extends Exception`, laquelle de ces instructions est
vraie ?

- **A.** `InvalidPhException` IS-A `Exception`.
- **B.** `InvalidPhException` IS-A `RuntimeException`.
- **C.** `Exception` IS-A `InvalidPhException`.
- **D.** `InvalidPhException` IS-A `Error`.

## Question 6 - Réponse

**Réponse correcte : A**

`InvalidPhException` hérite d'`Exception` : elle **est** une `Exception`.

```java
Exception e = new InvalidPhException("PH-01", 13.5); // valide
```

On peut ainsi capturer toutes les exceptions avec `catch (Exception e)`. Les
réponses B, C et D sont fausses : il n'y a pas de lien IS-A entre ces types.

## Question 7 - Donnée

**Connexion : throw, throws et propagation**

Que produit l'exécution de ce programme complet ?

```java
static void read(String raw) throws Exception {
    if (raw == null) throw new Exception("Valeur nulle.");
    System.out.println("Valeur : " + raw);
}
public static void main(String[] args) {
    try {
        read("7.2");
        read(null);
        read("8.1");
    } catch (Exception e) {
        System.out.println("Erreur : " + e.getMessage());
    }
}
```

## Question 7 - Réponse (1/2)

**Sortie :**

```
Valeur : 7.2
Erreur : Valeur nulle.
```

`read("8.1")` n'est **jamais appelé** : l'exception arrête le flux dans le
`try`.

## Question 7 - Réponse (2/2)

**Mécanisme :**

1. `read("7.2")` : s'exécute sans erreur → affiche `"Valeur : 7.2"`.
2. `read(null)` : lance `Exception("Valeur nulle.")` avec `throw`.
3. L'exception remonte immédiatement vers le `catch` dans `main`.
4. `catch (Exception e)` la capture → affiche `"Erreur : Valeur nulle."`.
5. `read("8.1")` n'est jamais atteint.

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## Sources

- [Illustration principale][illustration-principale] par
  [Claudio Schwarz](https://unsplash.com/@purzlbaum) sur
  [Unsplash](https://unsplash.com/photos/a-close-up-of-a-faucet-with-water-running-out-of-it-fyeOxvYvIyY)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/11-gestion-des-exceptions/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1558618666-fcd25c85cd64?fit=crop&h=720
