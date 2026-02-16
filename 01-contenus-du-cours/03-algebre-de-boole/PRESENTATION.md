---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  Algèbre de Boole pour le cours ProgIM2 enseigné à la HEIG-VD, Suisse
lang: fr
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/03-algebre-de-boole/presentation.html
header: "[**Algèbre de Boole**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Algèbre de Boole

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

## Objectifs

- Lister les opérateurs logiques de base (AND, OR, NOT, XOR).
- Évaluer des expressions booléennes simples et complexes.
- Appliquer les tables de vérité pour valider des expressions logiques.
- Simplifier des expressions booléennes en utilisant les lois de De Morgan.
- Construire des conditions complexes pour contrôler le flux d'un programme.

![bg right:40%][illustration-objectifs]

## Introduction à l'algèbre de Boole

L'algèbre de Boole manipule des valeurs de vérité : **vrai** (`true`) ou
**faux** (`false`).

Nommée d'après George Boole (1815-1864), elle est fondamentale en programmation
pour :

- Prendre des décisions (`if`, `else`)
- Contrôler des boucles (`while`, `for`)
- Valider des données
- Filtrer des informations

![bg right:40%][illustration-introduction]

## Le type boolean en Java

Une variable de type `boolean` ne peut prendre que deux valeurs : `true` ou
`false`.

```java
boolean isConnected = true;
boolean hasError = false;
boolean isValidInput = true;
```

Ce type primitif permet de stocker des états logiques et de construire des
expressions conditionnelles.

## Opérateur NOT (!)

L'opérateur `!` inverse une valeur booléenne.

```java
boolean isActive = true;
boolean isInactive = !isActive;  // false
```

**Table de vérité**

| a     | !a    |
| ----- | ----- |
| true  | false |
| false | true  |

## Opérateur AND (&&)

L'opérateur `&&` retourne `true` seulement si **les deux** opérandes sont
`true`.

```java
boolean hasPermission = true;
boolean isOwner = false;

boolean canEdit = hasPermission && isOwner;  // false
```

**Table de vérité**

| a     | b     | a && b |
| ----- | ----- | ------ |
| false | false | false  |
| false | true  | false  |
| true  | false | false  |
| true  | true  | true   |

## Opérateur OR (||)

L'opérateur `||` retourne `true` si **au moins un** des opérandes est `true`.

```java
boolean isAdmin = false;
boolean isModerator = true;

boolean hasAccess = isAdmin || isModerator;  // true
```

**Table de vérité**

| a     | b     | a \|\| b |
| ----- | ----- | -------- |
| false | false | false    |
| false | true  | true     |
| true  | false | true     |
| true  | true  | true     |

## Opérateur XOR (^)

L'opérateur `^` retourne `true` si **exactement un** des opérandes est `true`.

```java
boolean option1 = true;
boolean option2 = true;

boolean exclusiveChoice = option1 ^ option2;  // false
```

**Table de vérité**

| a     | b     | a ^ b |
| ----- | ----- | ----- |
| false | false | false |
| false | true  | true  |
| true  | false | true  |
| true  | true  | false |

## Expressions booléennes avec comparaisons

Les opérateurs de comparaison produisent des valeurs booléennes.

```java
int age = 25;
boolean isAdult = (age >= 18);  // true

String status = "active";
boolean isActive = status.equals("active");  // true

int score = 85;
boolean hasPassedWithHonors = (score >= 90);  // false
```

## Court-circuit des opérateurs (1/2)

Les opérateurs `&&` et `||` utilisent l'**évaluation court-circuit** : la
deuxième expression n'est évaluée que si nécessaire.

**Avec AND (&&)**

```java
boolean result = (x != 0) && (10 / x > 2);
```

Si `x == 0`, la première condition est `false`. La division `10 / x` n'est
**jamais exécutée**, évitant une erreur de division par zéro.

## Court-circuit des opérateurs (2/2)

**Avec OR (||)**

```java
String text = null;
boolean isValid = (text != null) || (text.length() > 0);
```

Si `text == null`, la première condition est `false` mais la deuxième **n'est
pas évaluée**, évitant une `NullPointerException`.

**Important** : l'ordre des conditions est crucial pour éviter les erreurs
d'exécution.

## Priorité des opérateurs

Java définit une priorité entre les opérateurs logiques :

1. `!` (NOT) - priorité la plus élevée
2. `&&` (AND)
3. `||` (OR)
4. `^` (XOR) - priorité la plus basse

**Recommandation** : toujours utiliser des parenthèses pour rendre l'ordre
d'évaluation explicite.

```java
boolean result = (a || b) && c;  // Clair et lisible
```

## Lois de De Morgan (1/2)

Les lois de De Morgan permettent de transformer des expressions logiques.

**Première loi**

```java
!(a && b)  ≡  (!a || !b)
```

La négation d'un AND devient un OR de négations.

**Exemple**

```java
!(isAdmin && hasPermission)  ≡  (!isAdmin || !hasPermission)
```

## Lois de De Morgan (2/2)

**Deuxième loi**

```java
!(a || b)  ≡  (!a && !b)
```

La négation d'un OR devient un AND de négations.

**Exemple**

```java
!(isWeekend || isHoliday)  ≡  (!isWeekend && !isHoliday)
```

Ces lois sont utiles pour simplifier ou restructurer des conditions complexes.

## Applications pratiques : structures conditionnelles

Les expressions booléennes permettent de contrôler le flux d'exécution.

```java
boolean hasLocalFiles = true;
boolean hasInternetConnection = false;

if (hasLocalFiles && !hasInternetConnection) {
    System.out.println("Mode hors ligne activé.");
} else if (hasLocalFiles && hasInternetConnection) {
    System.out.println("Synchronisation des fichiers...");
} else {
    System.out.println("Aucun fichier disponible.");
}
```

## Applications pratiques : boucles

Les conditions booléennes contrôlent quand une boucle continue ou s'arrête.

```java
int attempts = 0;
boolean isSuccess = false;
int maxAttempts = 3;

while ((attempts < maxAttempts) && !isSuccess) {
    System.out.println("Tentative " + (attempts + 1));
    isSuccess = tryConnect();
    attempts++;
}
```

## Applications pratiques : conditions complexes

Combiner plusieurs critères pour des décisions sophistiquées.

```java
boolean canUseService = (age >= 18) &&
                        hasValidID &&
                        (hasSubscription || hasTrialPeriod);

if (canUseService) {
    System.out.println("Accès autorisé au service.");
} else {
    System.out.println("Accès refusé.");
}
```

## Bonnes pratiques : utiliser les parenthèses

Toujours utiliser des parenthèses pour rendre l'ordre d'évaluation explicite.

**À éviter**

```java
boolean result = a || b && c;  // Ambigu
```

**À privilégier**

```java
boolean result = a || (b && c);  // Clair
```

Le code est lu plus souvent qu'il n'est écrit.

## Bonnes pratiques : noms de variables explicites

Utiliser des préfixes comme `is`, `has`, `can` pour les variables booléennes.

**Mauvais exemples**

```java
boolean x = true;
boolean flag = false;
```

**Bons exemples**

```java
boolean isConnected = true;
boolean hasPermission = false;
boolean canEdit = (age > 18);
```

## Bonnes pratiques : éviter les comparaisons redondantes

Pas besoin de comparer une variable booléenne à `true` ou `false`.

**À éviter**

```java
if (isReady == true) { }
if (hasError == false) { }
```

**À privilégier**

```java
if (isReady) { }
if (!hasError) { }
```

## Bonnes pratiques : décomposer les expressions complexes

Si une expression devient trop longue, la décomposer en variables
intermédiaires.

**Avant**

```java
if ((user.isActive() && user.hasSubscription() && !user.isBanned()) ||
    (user.isAdmin() && user.hasValidToken())) {
    // ...
}
```

**Après**

```java
boolean isRegularUser = user.isActive() && user.hasSubscription() && !user.isBanned();
boolean isAuthenticatedAdmin = user.isAdmin() && user.hasValidToken();

if (isRegularUser || isAuthenticatedAdmin) {
    // ...
}
```

## Erreurs courantes : confondre = et ==

`=` est l'affectation, `==` est la comparaison.

**Erreur**

```java
if (isActive = false) {  // Affectation !
    System.out.println("Inactif");
}
```

**Correction**

```java
if (!isActive) {  // Comparaison
    System.out.println("Inactif");
}
```

## Erreurs courantes : types non booléens

En Java, les opérateurs logiques ne fonctionnent qu'avec des expressions
booléennes.

**Invalide en Java**

```java
int count = 0;
if (count) {  // ERREUR en Java
    // ...
}
```

**Correction**

```java
if (count != 0) {  // Expression booléenne explicite
    // ...
}
```

## Erreurs courantes : oubli de l'ordre avec court-circuit

L'ordre des conditions avec `&&` ou `||` est crucial.

**Dangereux**

```java
String text = null;
if ((text.length() > 0) && (text != null)) {  // NullPointerException !
    // ...
}
```

**Correct**

```java
if ((text != null) && (text.length() > 0)) {  // Sûr
    // ...
}
```

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## À vous de jouer !

- (Re)lire le contenu de cours.
- Faire les exercices.
- Faire le mini-projet.
- Poser des questions si nécessaire.

➡️ [Visualiser le contenu complet sur GitHub.][contenu-complet-sur-github]

**N'hésitez pas à vous entraider si vous avez des difficultés !**

![bg right:40%][illustration-a-vous-de-jouer]

## Sources

- [Illustration principale][illustration-principale] par
  [Shubham Dhage](https://unsplash.com/@theshubhamdhage) sur
  [Unsplash](https://unsplash.com/photos/blue-and-white-plastic-blocks-_rZnChsIFuQ)
- [Illustration][illustration-objectifs] par
  [Aline de Nadai](https://unsplash.com/@alinedenadai) sur
  [Unsplash](https://unsplash.com/photos/low-angle-view-of-ball-shoots-in-the-ring-j6brni7fpvs)
- [Illustration][illustration-introduction] par
  [Desola Lanre-Ologun](https://unsplash.com/@heydesola) sur
  [Unsplash](https://unsplash.com/photos/white-and-yellow-labeled-box-IgUR1iX0mqM)
- [Illustration][illustration-a-vous-de-jouer] par
  [Nikita Kachanovsky](https://unsplash.com/@nkachanovskyyy) sur
  [Unsplash](https://unsplash.com/photos/white-sony-ps4-dualshock-controller-over-persons-palm-FJFPuE1MAOM)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/03-algebre-de-boole/README.md
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1635070041078-e363dbe005cb?fit=crop&h=720
[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-introduction]:
	https://images.unsplash.com/photo-1558494949-ef010cbdcc31?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
