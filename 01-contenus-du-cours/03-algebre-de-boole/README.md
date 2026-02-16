# Algèbre de Boole

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

> [!TIP]
>
> Voici quelques informations relatives à ce contenu.
>
> **Ressources annexes**
>
> - Autres formats du support de cours : [Présentation (web)][presentation-web]
>   · [Présentation (PDF)][presentation-pdf]
> - Exemples de code : [Accéder au contenu](./01-exemples-de-code/README.md)
> - Exercices : [Accéder au contenu](./02-exercices/README.md)
> - Mini-projet : [Accéder au contenu](./03-mini-projet/README.md)
>
> **Objectifs**
>
> À l'issue de cette séance, les personnes qui étudient devraient être capables
> de :
>
> - Lister les opérateurs logiques de base (AND, OR, NOT, XOR).
> - Évaluer des expressions booléennes simples et complexes.
> - Appliquer les tables de vérité pour valider des expressions logiques.
> - Simplifier des expressions booléennes en utilisant les lois de De Morgan.
> - Construire des conditions complexes pour contrôler le flux d'un programme.
>
> **Méthodes d'enseignement et d'apprentissage**
>
> Les méthodes d'enseignement et d'apprentissage utilisées pour animer la séance
> sont les suivantes :
>
> - Présentation magistrale.
> - Discussions collectives.
> - Travail en autonomie.
>
> **Méthodes d'évaluation**
>
> L'évaluation prend la forme d'exercices et d'un mini-projet à réaliser en
> autonomie en classe ou à la maison.
>
> L'évaluation se fait en utilisant les critères suivants :
>
> - Capacité à répondre avec justesse.
> - Capacité à argumenter.
> - Capacité à réaliser les tâches demandées.
> - Capacité à s'approprier les exemples de code.
> - Capacité à appliquer les exemples de code à des situations similaires.
>
> Les retours se font de la manière suivante :
>
> - Corrigé des exercices.
> - Corrigé du mini-projet.
>
> L'évaluation ne donne pas lieu à une note.

## Introduction à l'algèbre de Boole

L'algèbre de Boole, nommée d'après le mathématicien britannique George Boole
(1815-1864), est un système mathématique qui manipule des valeurs de vérité. En
programmation, cette algèbre est fondamentale car elle permet de construire des
conditions logiques et de contrôler le flux d'exécution des programmes.

### Pourquoi est-ce important en programmation ?

L'algèbre de Boole est omniprésente en programmation. Elle permet de :

- Prendre des décisions (structures conditionnelles `if`, `else`)
- Contrôler des boucles (`while`, `for`)
- Valider des données
- Filtrer des informations
- Construire des algorithmes complexes

Sans l'algèbre de Boole, il serait impossible de créer des programmes qui
s'adaptent à différentes situations ou qui réagissent aux entrées de
l'utilisatrice.

### Le type `boolean` en Java

En Java, le type de données `boolean` représente une valeur logique. Une
variable de type `boolean` ne peut prendre que deux valeurs possibles : `true`
(vrai) ou `false` (faux).

```java
boolean isConnected = true;
boolean hasError = false;
boolean isValidInput = true;
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de trois variables de type booléen : `isConnected`
à `true`, `hasError` à `false`, et `isValidInput` à `true`.

</details>

Le type `boolean` est un type primitif en Java, au même titre que `int`,
`double` ou `char`.

## Les valeurs booléennes

Une valeur booléenne est une valeur qui ne peut être que vraie (`true`) ou
fausse (`false`). Ces deux valeurs sont les seules constantes booléennes en Java
et dans la plupart des langages de programmation.

### Utilisation en Java

Les valeurs booléennes peuvent être utilisées de plusieurs manières :

**Déclaration et initialisation**

```java
boolean isReady = true;
boolean isFinished = false;
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable de type booléen `isReady` à `true`.

Déclaration et initialisation d'une variable de type booléen `isFinished` à
`false`.

</details>

**Résultat d'une comparaison**

```java
int age = 18;
boolean isAdult = (age >= 18);  // true
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable entière `age` à `18`.

Déclaration et initialisation de la variable booléenne `isAdult` par évaluation
d'une expression de comparaison (opérateur `>=`) entre `age` et `18`.

</details>

**Utilisation dans des conditions**

```java
if (isReady) {
    System.out.println("Le système est prêt.");
}
```

<details>
<summary>Description du code</summary>

Structure conditionnelle `if` testant la variable booléenne `isReady`.

Dans le bloc conditionnel : appel de la méthode statique `System.out.println()`
avec la chaîne de caractères `"Le système est prêt."` en argument.

</details>

**Retour d'une méthode**

```java
public boolean isEven(int number) {
    return (number % 2 == 0);
}
```

<details>
<summary>Description du code</summary>

Déclaration d'une méthode publique `isEven` avec un paramètre de type `int` nomé
`number` et un type de retour `boolean`.

Dans le corps de la méthode : instruction `return` renvoyant le résultat d'une
comparaison (opérateur `==`) entre le résultat de l'opération modulo (opérateur
`%`) appliquée à `number` avec `2`, et la valeur `0`.

</details>

## Les opérateurs logiques

Les opérateurs logiques permettent de combiner ou de modifier des expressions
booléennes. Java propose quatre opérateurs logiques principaux.

### L'opérateur NOT (`!`) - Négation

L'opérateur `!` inverse la valeur d'une expression booléenne. Si l'expression
est vraie, elle devient fausse, et vice versa.

**Syntaxe**

```java
!expression
```

<details>
<summary>Description du code</summary>

Syntaxe de l'opérateur NOT : le symbole `!` placé devant une expression
booléenne inverse sa valeur.

</details>

**Exemples**

```java
boolean isConnected = true;
boolean isDisconnected = !isConnected;  // false

boolean hasError = false;
boolean isOk = !hasError;  // true
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de la variable booléenne `isConnected` à `true`.

Déclaration et initialisation de la variable booléenne `isDisconnected` par
application de l'opérateur de négation (symbole `!`) à `isConnected`.

Déclaration et initialisation de la variable booléenne `hasError` à `false`.

Déclaration et initialisation de la variable booléenne `isOk` par application de
l'opérateur de négation (symbole `!`) à `hasError`.

</details>

**Application pratique**

```java
boolean isBatteryLow = true;

if (!isBatteryLow) {
    System.out.println("La batterie est suffisante.");
} else {
    System.out.println("Veuillez recharger l'appareil.");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de la variable booléenne `isBatteryLow` à `true`.

Structure conditionnelle `if-else` avec une expression booléenne : négation
(opérateur `!`) de la variable `isBatteryLow`.

Dans le bloc `if` : appel de la méthode statique `System.out.println()` avec la
chaîne de caractères `"La batterie est suffisante."` en argument.

Dans le bloc `else` : appel de la méthode statique `System.out.println()` avec
la chaîne de caractères `"Veuillez recharger l'appareil."` en argument.

</details>

**Table de vérité**

L'opérateur NOT n'a qu'une seule entrée.

| A     | !A    |
| ----- | ----- |
| true  | false |
| false | true  |

> [!TIP]
>
> **À propos des tables de vérité**
>
> Une table de vérité est un outil qui permet de visualiser toutes les
> combinaisons possibles de valeurs d'entrée et les résultats correspondants
> pour une opération logique. C'est un moyen systématique de comprendre et de
> valider le comportement des opérateurs logiques.
>
> Les tables de vérité sont utiles pour :
>
> - Comprendre le comportement exact d'un opérateur.
> - Vérifier qu'une expression logique complexe fonctionne comme prévu.
> - Documenter la logique d'un algorithme.
> - Déboguer des conditions qui ne se comportent pas comme attendu.

### L'opérateur AND (`&&`) - Conjonction

L'opérateur `&&` retourne `true` uniquement si les deux expressions sont vraies.
Si au moins une expression est fausse, le résultat est `false`.

**Syntaxe**

```java
expression1 && expression2
```

<details>
<summary>Description du code</summary>

Syntaxe de l'opérateur AND : deux expressions booléennes séparées par `&&`. Le
résultat est `true` uniquement si les deux expressions sont vraies.

</details>

**Exemples**

```java
boolean hasInternet = true;
boolean hasSubscription = true;
boolean canStream = hasInternet && hasSubscription;  // true

boolean isWeekend = false;
boolean hasFreeTime = true;
boolean canRelax = isWeekend && hasFreeTime;  // false
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables booléennes : `hasInternet` à
`true` et `hasSubscription` à `true`.

Déclaration et initialisation de la variable booléenne `canStream` par
évaluation d'une expression combinant `hasInternet` et `hasSubscription` avec
l'opérateur AND (symbole `&&`).

Déclaration et initialisation de deux variables booléennes : `isWeekend` à
`false` et `hasFreeTime` à `true`.

Déclaration et initialisation de la variable booléenne `canRelax` par évaluation
d'une expression combinant `isWeekend` et `hasFreeTime` avec l'opérateur AND
(symbole `&&`).

</details>

**Application pratique**

```java
int temperature = 22;
boolean isSunny = true;

if ((temperature > 20) && isSunny) {
    System.out.println("Conditions idéales pour une sortie vélo.");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable entière `temperature` à `22`.

Déclaration et initialisation d'une variable booléenne `isSunny` à `true`.

Structure conditionnelle `if` avec une expression booléenne combinant une
comparaison (opérateur `>`) entre `temperature` et `20`, et la variable
`isSunny`, avec l'opérateur AND (symbole `&&`).

Dans le bloc conditionnel : appel de la méthode statique `System.out.println()`
avec la chaîne de caractères `"Conditions idéales pour une sortie vélo."` en
argument.

</details>

**Comportement court-circuit**

L'opérateur `&&` est un opérateur court-circuit : si la première expression est
`false`, la deuxième expression n'est pas évaluée car le résultat sera forcément
`false`. Cela permet d'optimiser les performances et d'éviter des erreurs
potentielles.

```java
String username = null;

// La deuxième condition n'est pas évaluée si username est null
if ((username != null) && (username.length() > 0)) {
    System.out.println("Nom d'utilisatrice valide.");
}
```

> [!NOTE]
>
> **À propos de `null`**
>
> En Java, `null` est une valeur spéciale qui indique l'absence de valeur.

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable de type `String` nommée `username`
à `null`.

Structure conditionnelle `if` avec une expression booléenne combinant deux
conditions avec l'opérateur AND (symbole `&&`) : comparaison (opérateur `!=`)
entre `username` et `null`, et comparaison (opérateur `>`) entre le résultat de
l'appel de méthode `username.length()` et la valeur `0`.

Dans le bloc conditionnel : appel de la méthode statique `System.out.println()`
avec la chaîne de caractères `"Nom d'utilisatrice valide."` en argument.

</details>

**Table de vérité**

L'opérateur AND retourne `true` uniquement si les deux entrées sont `true`.

| A     | B     | A && B |
| ----- | ----- | ------ |
| true  | true  | true   |
| true  | false | false  |
| false | true  | false  |
| false | false | false  |

### L'opérateur OR (`||`) - Disjonction

L'opérateur `||` retourne `true` si au moins une des deux expressions est vraie.
Il retourne `false` uniquement si les deux expressions sont fausses.

**Syntaxe**

```java
expression1 || expression2
```

<details>
<summary>Description du code</summary>

Syntaxe de l'opérateur OR : deux expressions booléennes séparées par `||`. Le
résultat est `true` si au moins une des deux expressions est vraie.

</details>

**Exemples**

```java
boolean hasCard = true;
boolean hasCash = false;
boolean canPay = hasCard || hasCash;  // true

boolean isClosed = true;
boolean isFullyBooked = false;
boolean cannotEnter = isClosed || isFullyBooked;  // true
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables booléennes : `hasCard` à `true`
et `hasCash` à `false`.

Déclaration et initialisation de la variable booléenne `canPay` par évaluation
d'une expression combinant `hasCard` et `hasCash` avec l'opérateur OR (symbole
`||`).

Déclaration et initialisation de deux variables booléennes : `isClosed` à `true`
et `isFullyBooked` à `false`.

Déclaration et initialisation de la variable booléenne `cannotEnter` par
évaluation d'une expression combinant `isClosed` et `isFullyBooked` avec
l'opérateur OR (symbole `||`).

</details>

**Application pratique**

```java
int dayOfWeek = 6;  // Samedi

if ((dayOfWeek == 6) || (dayOfWeek == 7)) {
    System.out.println("C'est le week-end !");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable entière `dayOfWeek` à `6`.

Structure conditionnelle `if` avec une expression booléenne combinant deux
comparaisons (opérateur `==`) avec l'opérateur OR (symbole `||`) : comparaison
entre `dayOfWeek` et `6`, et comparaison entre `dayOfWeek` et `7`.

Dans le bloc conditionnel : appel de la méthode statique `System.out.println()`
avec la chaîne de caractères `"C'est le week-end !"` en argument.

</details>

**Comportement court-circuit**

L'opérateur `||` est également un opérateur court-circuit : si la première
expression est `true`, la deuxième expression n'est pas évaluée car le résultat
sera forcément `true`.

```java
boolean hasAdminRights = true;
boolean hasSpecialPermission = false;

// La deuxième condition n'est pas évaluée
if (hasAdminRights || hasSpecialPermission) {
    System.out.println("Accès autorisé.");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables booléennes : `hasAdminRights` à
`true` et `hasSpecialPermission` à `false`.

Structure conditionnelle `if` avec une expression booléenne combinant les deux
variables avec l'opérateur OR (symbole `||`).

Dans le bloc conditionnel : appel de la méthode statique `System.out.println()`
avec la chaîne de caractères `"Accès autorisé."` en argument.

</details>

**Table de vérité**

L'opérateur OR retourne `true` si au moins une entrée est `true`.

| A     | B     | A \|\| B |
| ----- | ----- | -------- |
| true  | true  | true     |
| true  | false | true     |
| false | true  | true     |
| false | false | false    |

### L'opérateur XOR (`^`) - Ou exclusif

L'opérateur `^` retourne `true` si une et une seule des deux expressions est
vraie. Si les deux expressions ont la même valeur (toutes deux vraies ou toutes
deux fausses), le résultat est `false`.

**Syntaxe**

```java
expression1 ^ expression2
```

<details>
<summary>Description du code</summary>

Syntaxe de l'opérateur XOR : deux expressions booléennes séparées par `^`. Le
résultat est `true` si et seulement si une seule des deux expressions est vraie.

</details>

**Exemples**

```java
boolean isDay = true;
boolean isNight = false;
boolean result1 = isDay ^ isNight;  // true

boolean option1 = true;
boolean option2 = true;
boolean result2 = option1 ^ option2;  // false
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables booléennes : `isDay` à `true` et
`isNight` à `false`.

Déclaration et initialisation de la variable booléenne `result1` par évaluation
d'une expression combinant `isDay` et `isNight` avec l'opérateur XOR (symbole
`^`).

Déclaration et initialisation de deux variables booléennes : `option1` à `true`
et `option2` à `true`.

Déclaration et initialisation de la variable booléenne `result2` par évaluation
d'une expression combinant `option1` et `option2` avec l'opérateur XOR (symbole
`^`).

</details>

**Application pratique**

```java
boolean usesSolarPower = true;
boolean usesGridPower = false;

// Vérifie qu'une seule source d'énergie est utilisée
if (usesSolarPower ^ usesGridPower) {
    System.out.println("Une source d'énergie unique est utilisée.");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables booléennes : `usesSolarPower` à
`true` et `usesGridPower` à `false`.

Structure conditionnelle `if` avec une expression booléenne combinant les deux
variables avec l'opérateur XOR (symbole `^`).

Dans le bloc conditionnel : appel de la méthode statique `System.out.println()`
avec la chaîne de caractères `"Une source d'énergie unique est utilisée."` en
argument.

</details>

**Table de vérité**

L'opérateur XOR retourne `true` si les entrées sont différentes.

| A     | B     | A ^ B |
| ----- | ----- | ----- |
| true  | true  | false |
| true  | false | true  |
| false | true  | true  |
| false | false | false |

## Évaluation d'expressions booléennes

L'évaluation d'expressions booléennes consiste à calculer la valeur finale (true
ou false) d'une expression logique en fonction des valeurs de ses composants.

### Expressions simples

Une expression simple utilise un seul opérateur.

```java
boolean a = true;
boolean b = false;

boolean result1 = !a;           // false
boolean result2 = a && b;       // false
boolean result3 = a || b;       // true
boolean result4 = a ^ b;        // true
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables booléennes : `a` à `true` et `b`
à `false`.

Déclaration et initialisation de quatre variables booléennes par évaluation
d'expressions utilisant différents opérateurs logiques : `result1` utilise
l'opérateur NOT (symbole `!`) sur `a`, `result2` utilise l'opérateur AND
(symbole `&&`) entre `a` et `b`, `result3` utilise l'opérateur OR (symbole `||`)
entre `a` et `b`, `result4` utilise l'opérateur XOR (symbole `^`) entre `a` et
`b`.

</details>

### Expressions complexes

Une expression complexe combine plusieurs opérateurs. L'utilisation de
parenthèses permet de rendre l'ordre d'évaluation explicite.

```java
boolean hasAccount = true;
boolean isVerified = false;
boolean hasInvitation = true;

// Évaluation pas à pas
boolean canAccess = (hasAccount && isVerified) || hasInvitation;

// Étape 1 : évaluation de (hasAccount && isVerified)
// true && false = false

// Étape 2 : évaluation de false || hasInvitation
// false || true = true

// Résultat : canAccess = true
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de trois variables booléennes : `hasAccount` à
`true`, `isVerified` à `false`, et `hasInvitation` à `true`.

Déclaration et initialisation de la variable booléenne `canAccess` par
évaluation d'une expression booléenne complexe combinant une conjonction
(opérateur `&&`) entre parenthèses et une disjonction (opérateur `||`) avec la
variable `hasInvitation`.

</details>

### Exemples d'évaluation pas à pas

**Exemple 1 : Validation d'un formulaire**

```java
boolean hasUsername = true;
boolean hasPassword = true;
boolean hasEmail = false;
boolean acceptedTerms = true;

boolean isFormValid = ((hasUsername && hasPassword) && hasEmail) && acceptedTerms;

// Étape 1 : (hasUsername && hasPassword)
// true && true = true

// Étape 2 : true && hasEmail
// true && false = false

// Étape 3 : false && acceptedTerms
// Grâce au court-circuit, acceptedTerms n'est pas évalué car le résultat
// est déjà connu : false && (n'importe quoi) = false

// Résultat : isFormValid = false
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de quatre variables booléennes : `hasUsername`,
`hasPassword`, `hasEmail` et `acceptedTerms` avec leurs valeurs respectives.

Déclaration et initialisation de la variable `isFormValid` par évaluation d'une
expression booléenne complexe combinant les quatre variables avec l'opérateur
AND (symbole `&&`), avec parenthèses pour grouper les opérations.

</details>

**Exemple 2 : Contrôle d'accès**

```java
boolean isOwner = false;
boolean isAdmin = true;
boolean isPublic = false;

boolean canView = isOwner || (isAdmin || isPublic);

// Étape 1 : (isAdmin || isPublic)
// true || false = true

// Étape 2 : isOwner || true
// false || true = true

// Résultat : canView = true
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de trois variables booléennes : `isOwner` à
`false`, `isAdmin` à `true`, et `isPublic` à `false`.

Déclaration et initialisation de la variable `canView` par évaluation d'une
expression booléenne combinant les trois variables avec l'opérateur OR (symbole
`||`), avec parenthèses autour de `(isAdmin || isPublic)`.

</details>

**Exemple 3 : Vérification de plage**

```java
int temperature = 25;

boolean isComfortable = (temperature >= 20) && (temperature <= 26);

// Étape 1 : (temperature >= 20)
// 25 >= 20 = true

// Étape 2 : (temperature <= 26)
// 25 <= 26 = true

// Étape 3 : true && true
// true

// Résultat : isComfortable = true
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable entière `temperature` à `25`.

Déclaration et initialisation de la variable booléenne `isComfortable` par
évaluation d'une expression combinant deux comparaisons (opérateurs `>=` et
`<=`) avec l'opérateur AND (symbole `&&`).

</details>

## Lois de simplification

L'algèbre de Boole possède des lois qui permettent de simplifier des expressions
logiques. Connaître ces lois aide à écrire du code plus lisible et plus
efficace.

### Les lois de De Morgan

Les lois de De Morgan sont deux règles fondamentales qui permettent de
transformer la négation d'une expression complexe.

**Première loi de De Morgan**

La négation d'une conjonction (AND) est équivalente à la disjonction (OR) des
négations.

```
!(A && B) = !A || !B
```

> [!TIP]
>
> **Allez, on répète après moi**
>
> _"La négation d'une conjonction est équivalente à la disjonction des
> négations."_
>
> Cette phrase peut sembler compliquée, mais elle devient naturelle avec la
> pratique. C'est l'une des lois les plus utiles pour simplifier des conditions
> complexes en programmation.

**Exemple en Java**

```java
boolean hasInternet = true;
boolean hasData = false;

// Expression originale
boolean condition1 = !(hasInternet && hasData);

// Expression équivalente selon De Morgan
boolean condition2 = !hasInternet || !hasData;

// Les deux expressions ont la même valeur : true
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables booléennes : `hasInternet` à
`true` et `hasData` à `false`.

Déclaration et initialisation de la variable booléenne `condition1` par
application de l'opérateur de négation (symbole `!`) à une expression combinant
`hasInternet` et `hasData` avec l'opérateur AND (symbole `&&`).

Déclaration et initialisation de la variable booléenne `condition2` par
évaluation d'une expression combinant les négations (opérateur `!`) de
`hasInternet` et `hasData` avec l'opérateur OR (symbole `||`).

</details>

**Deuxième loi de De Morgan**

La négation d'une disjonction (OR) est équivalente à la conjonction (AND) des
négations.

```
!(A || B) = !A && !B
```

> [!TIP]
>
> **Allez, on répète après moi**
>
> _"La négation d'une disjonction est équivalente à la conjonction des
> négations."_

**Exemple en Java**

```java
boolean isClosed = false;
boolean isFullyBooked = false;

// Expression originale
boolean canEnter1 = !(isClosed || isFullyBooked);

// Expression équivalente selon De Morgan
boolean canEnter2 = !isClosed && !isFullyBooked;

// Les deux expressions ont la même valeur : true
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables booléennes : `isClosed` à
`false` et `isFullyBooked` à `false`.

Déclaration et initialisation de la variable booléenne `canEnter1` par
application de l'opérateur de négation (symbole `!`) à une expression combinant
`isClosed` et `isFullyBooked` avec l'opérateur OR (symbole `||`).

Déclaration et initialisation de la variable booléenne `canEnter2` par
évaluation d'une expression combinant les négations (opérateur `!`) de
`isClosed` et `isFullyBooked` avec l'opérateur AND (symbole `&&`).

</details>

### Autres lois utiles

**Loi de commutativité**

L'ordre des opérandes n'affecte pas le résultat.

```
A && B = B && A
A || B = B || A
```

**Loi d'associativité**

Le regroupement des opérandes n'affecte pas le résultat (pour un même
opérateur).

```
(A && B) && C = A && (B && C)
(A || B) || C = A || (B || C)
```

**Loi de distributivité**

```
A && (B || C) = (A && B) || (A && C)
A || (B && C) = (A || B) && (A || C)
```

**Loi de double négation**

```
!!A = A
```

**Exemple en Java**

```java
boolean isActive = true;
boolean result1 = !!isActive;  // true
boolean result2 = isActive;    // true
// result1 et result2 ont la même valeur
```

<details>
<summary>Description du code</summary>

Démonstration de la loi de double négation.

Appliquer NOT deux fois à une valeur revient à la valeur originale : `!!true` =
`!false` = `true`.

</details>

### Application pratique de la simplification

Simplifier une expression peut rendre le code plus lisible.

**Avant simplification**

```java
if (!(hasError || hasWarning)) {
    System.out.println("Tout est en ordre.");
}
```

<details>
<summary>Description du code</summary>

Structure conditionnelle `if` avec une expression booléenne composée de :
négation (opérateur `!`) d'une disjonction (opérateur `||`) entre deux variables
booléennes `hasError` et `hasWarning`.

Dans le bloc conditionnel : appel de la méthode statique `System.out.println()`
avec la chaîne de caractères `"Tout est en ordre."` en argument.

</details>

**Après simplification avec De Morgan**

```java
if (!hasError && !hasWarning) {
    System.out.println("Tout est en ordre.");
}
```

<details>
<summary>Description du code</summary>

Structure conditionnelle `if` avec une expression booléenne composée de :
conjonction (opérateur `&&`) entre deux négations (opérateur `!`) appliquées aux
variables booléennes `hasError` et `hasWarning`.

Dans le bloc conditionnel : appel de la méthode statique `System.out.println()`
avec la chaîne de caractères `"Tout est en ordre."` en argument.

</details>

La deuxième version est souvent plus facile à comprendre : "pas d'erreur ET pas
d'avertissement".

## Application pratique en programmation

Les expressions booléennes sont la base des structures de contrôle qui
permettent aux programmes de prendre des décisions et de s'adapter à différentes
situations.

### Conditions dans les structures if/else

Les expressions booléennes sont utilisées pour déterminer quelle branche de code
exécuter.

**Exemple simple**

```java
int batteryLevel = 15;

if (batteryLevel < 20) {
    System.out.println("Batterie faible, veuillez recharger.");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable de type `int` nommée `batteryLevel`
avec la valeur `15`.

Structure conditionnelle `if` avec une expression booléenne : comparaison
(opérateur `<`) entre la variable `batteryLevel` et la valeur `20`.

Dans le bloc conditionnel : appel de la méthode statique `System.out.println()`
avec la chaîne de caractères `"Batterie faible, veuillez recharger."` en
argument.

</details>

**Exemple avec plusieurs conditions**

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

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables booléennes : `hasLocalFiles` à
`true` et `hasInternetConnection` à `false`.

Structure conditionnelle `if-else if-else` avec trois branches :

Première branche : condition composée d'une conjonction (opérateur `&&`) entre
`hasLocalFiles` et la négation (opérateur `!`) de `hasInternetConnection`. Bloc
exécutant `System.out.println("Mode hors ligne activé.")`.

Deuxième branche : condition composée d'une conjonction (opérateur `&&`) entre
`hasLocalFiles` et `hasInternetConnection`. Bloc exécutant
`System.out.println("Synchronisation des fichiers...")`.

Troisième branche (else) : bloc exécutant
`System.out.println("Aucun fichier disponible.")`.

</details>

**Exemple de validation complexe**

```java
String password = "MySecurePassword123";
boolean hasMinLength = (password.length() >= 8);
boolean hasUpperCase = !password.equals(password.toLowerCase());
boolean hasNumber = password.matches(".*\\d.*");

if (hasMinLength && hasUpperCase && hasNumber) {
    System.out.println("Mot de passe valide.");
} else {
    System.out.println("Le mot de passe ne respecte pas les critères.");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable de type `String` nommée `password`
avec la chaîne de caractères littérale `"MySecurePassword123"`.

Déclaration et initialisation de la variable booléenne `hasMinLength` par
évaluation d'une expression : comparaison (opérateur `>=`) entre le résultat de
l'appel de méthode `password.length()` et la valeur `8`.

Déclaration et initialisation de la variable booléenne `hasUpperCase` par
négation (opérateur `!`) du résultat de l'appel de méthode
`password.equals(password.toLowerCase())`.

Déclaration et initialisation de la variable booléenne `hasNumber` par appel de
la méthode `password.matches()` avec l'expression régulière `".*\\d.*"` en
argument.

Structure conditionnelle `if-else` avec une condition composée d'une double
conjonction (opérateur `&&`) entre `hasMinLength`, `hasUpperCase` et
`hasNumber`. Bloc `if` exécutant `System.out.println("Mot de passe valide.")`.
Bloc `else` exécutant
`System.out.println("Le mot de passe ne respecte pas les critères.")`.

</details>

### Conditions dans les boucles

Les expressions booléennes déterminent quand une boucle doit continuer ou
s'arrêter.

**Boucle while**

```java
int attempts = 0;
boolean isSuccess = false;
int maxAttempts = 3;

while ((attempts < maxAttempts) && !isSuccess) {
    System.out.println("Tentative " + (attempts + 1));
    // Simuler une tentative
    isSuccess = tryConnect();
    attempts++;
}

if (isSuccess) {
    System.out.println("Connexion réussie.");
} else {
    System.out.println("Échec après " + maxAttempts + " tentatives.");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de trois variables : `attempts` (type `int`) à
`0`, `isSuccess` (type `boolean`) à `false`, et `maxAttempts` (type `int`) à
`3`.

Boucle `while` avec une condition composée d'une conjonction (opérateur `&&`)
entre une comparaison `(attempts < maxAttempts)` et la négation (opérateur `!`)
de `isSuccess`.

Corps de la boucle : appel de `System.out.println()` avec concaténation de
chaînes, affectation du résultat de `tryConnect()` à `isSuccess`, et
incrémentation (opérateur `++`) de `attempts`.

Structure conditionnelle `if-else` après la boucle : branche `if` testant
`isSuccess` et exécutant `System.out.println("Connexion réussie.")`, branche
`else` exécutant `System.out.println()` avec concaténation incluant la variable
`maxAttempts`.

</details>

**Boucle for avec condition complexe**

```java
int[] temperatures = {18, 22, 25, 19, 21, 23};
boolean foundOptimal = false;

for (int i = 0; (i < temperatures.length) && !foundOptimal; i++) {
    if ((temperatures[i] >= 20) && (temperatures[i] <= 22)) {
        System.out.println("Température optimale trouvée : " + temperatures[i]);
        foundOptimal = true;
    }
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'un tableau d'entiers `temperatures` contenant
six valeurs.

Déclaration et initialisation de la variable booléenne `foundOptimal` à `false`.

Boucle `for` avec initialisation de la variable `i` à `0`, condition de
continuation combinant deux comparaisons avec l'opérateur AND (symbole `&&`), et
incrémentation (opérateur `++`) de `i`.

Dans le corps de la boucle : structure conditionnelle `if` avec une expression
booléenne combinant deux comparaisons (opérateurs `>=` et `<=`) avec l'opérateur
AND (symbole `&&`). Dans le bloc conditionnel : appel de la méthode statique
`System.out.println()` avec concaténation de chaînes, et affectation de `true` à
la variable `foundOptimal`.

</details>

### Construction de conditions complexes

Les conditions complexes combinent plusieurs critères pour prendre des décisions
sophistiquées.

**Exemple : éligibilité à un service**

```java
int age = 25;
boolean hasValidID = true;
boolean hasSubscription = false;
boolean hasTrialPeriod = true;

boolean canUseService = (age >= 18) &&
                        hasValidID &&
                        (hasSubscription || hasTrialPeriod);

if (canUseService) {
    System.out.println("Accès autorisé au service.");
} else {
    System.out.println("Accès refusé.");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable entière `age` à `25`, et de trois
variables booléennes : `hasValidID` à `true`, `hasSubscription` à `false`, et
`hasTrialPeriod` à `true`.

Déclaration et initialisation de la variable booléenne `canUseService` par
évaluation d'une expression combinant une comparaison (opérateur `>=`) et trois
variables booléennes avec les opérateurs AND (symbole `&&`) et OR (symbole
`||`).

Structure conditionnelle `if-else` testant la variable `canUseService`. Dans le
bloc `if` : appel de la méthode statique `System.out.println()` avec la chaîne
`"Accès autorisé au service."`. Dans le bloc `else` : appel de
`System.out.println()` avec la chaîne `"Accès refusé."`.

</details>

**Exemple : gestion d'un système de réservation**

```java
boolean isAvailable = true;
boolean hasConflict = false;
int participantCount = 5;
int roomCapacity = 10;

boolean canBook = isAvailable &&
                  !hasConflict &&
                  (participantCount <= roomCapacity);

if (canBook) {
    System.out.println("Réservation confirmée.");
} else {
    System.out.println("Impossible de réserver.");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables booléennes : `isAvailable` à
`true` et `hasConflict` à `false`, et de deux variables entières :
`participantCount` à `5` et `roomCapacity` à `10`.

Déclaration et initialisation de la variable booléenne `canBook` par évaluation
d'une expression combinant la variable `isAvailable`, la négation (opérateur
`!`) de `hasConflict`, et une comparaison (opérateur `<=`), avec l'opérateur AND
(symbole `&&`).

Structure conditionnelle `if-else` testant la variable `canBook`. Dans le bloc
`if` : appel de la méthode statique `System.out.println()` avec la chaîne
`"Réservation confirmée."`. Dans le bloc `else` : appel de
`System.out.println()` avec la chaîne `"Impossible de réserver."`.

</details>

**Exemple : contrôle d'un appareil électronique**

```java
int solarPower = 80;      // Pourcentage
int batteryLevel = 30;     // Pourcentage
boolean isNightMode = false;

boolean useSolarPower = (solarPower > 50) && !isNightMode;
boolean useBattery = (batteryLevel > 20) && (!useSolarPower || isNightMode);

if (useSolarPower) {
    System.out.println("Utilisation de l'énergie solaire.");
} else if (useBattery) {
    System.out.println("Utilisation de la batterie.");
} else {
    System.out.println("Énergie insuffisante.");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables entières : `solarPower` à `80`
et `batteryLevel` à `30`, et d'une variable booléenne `isNightMode` à `false`.

Déclaration et initialisation de la variable booléenne `useSolarPower` par
évaluation d'une expression combinant une comparaison (opérateur `>`) et la
négation (opérateur `!`) de `isNightMode` avec l'opérateur AND (symbole `&&`).

Déclaration et initialisation de la variable booléenne `useBattery` par
évaluation d'une expression combinant une comparaison (opérateur `>`) et une
expression entre parenthèses avec l'opérateur AND (symbole `&&`).

Structure conditionnelle `if-else if-else` avec trois branches testant
successivement `useSolarPower` et `useBattery`. Dans chaque bloc : appel de la
méthode statique `System.out.println()` avec des chaînes de caractères
différentes.

</details>

## Bonnes pratiques et lisibilité du code

Écrire des expressions booléennes claires et compréhensibles est essentiel pour
maintenir un code de qualité. Voici quelques recommandations.

### Privilégier l'explicite : utiliser les parenthèses

Même si Java définit une priorité entre les opérateurs logiques, il est
fortement recommandé d'utiliser des parenthèses pour rendre l'ordre d'évaluation
explicite. Cela améliore la lisibilité et évite les ambiguïtés.

**À éviter : ordre d'évaluation implicite**

```java
boolean result = a || b && c;  // Quel opérateur est évalué en premier ?
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de la variable booléenne `result` par évaluation
d'une expression booléenne combinant les variables `a`, `b` et `c` avec les
opérateurs OR (symbole `||`) et AND (symbole `&&`), sans parenthèses pour
expliciter l'ordre d'évaluation.

</details>

**À privilégier : ordre d'évaluation explicite**

```java
boolean result = a || (b && c);  // Intention claire
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de la variable booléenne `result` par évaluation
d'une expression booléenne combinant les variables `a`, `b` et `c` avec les
opérateurs OR (symbole `||`) et AND (symbole `&&`), avec des parenthèses autour
de `(b && c)` pour expliciter l'ordre d'évaluation.

</details>

Le code est lu bien plus souvent qu'il n'est écrit. Les parenthèses aident les
personnes qui lisent le code (y compris vous-même dans quelques mois) à
comprendre immédiatement l'intention sans avoir à se souvenir des règles de
priorité.

**Exemple avec plusieurs opérateurs**

```java
// Difficile à comprendre
boolean canAccess = isOwner || isAdmin && hasPermission || isPublic;

// Clair et explicite
boolean canAccess = isOwner || (isAdmin && hasPermission) || isPublic;
```

<details>
<summary>Description du code</summary>

Première déclaration et initialisation de la variable booléenne `canAccess` par
évaluation d'une expression combinant quatre variables avec les opérateurs OR
(symbole `||`) et AND (symbole `&&`), sans parenthèses.

Deuxième déclaration et initialisation de la variable `canAccess` par évaluation
de la même expression logique, avec des parenthèses autour de
`(isAdmin && hasPermission)` pour expliciter l'ordre d'évaluation.

</details>

### Utiliser des noms de variables explicites

Les noms de variables booléennes doivent clairement indiquer ce qu'elles
représentent. Utiliser des préfixes comme `is`, `has`, `can`, `should` rend le
code plus lisible.

**Mauvais exemples**

```java
boolean x = true;
boolean flag = false;
boolean temp = (age > 18);
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de trois variables booléennes : `x` à `true`,
`flag` à `false`, et `temp` au résultat de la comparaison (opérateur `>`) entre
la variable `age` et la valeur `18`.

</details>

**Bons exemples**

```java
boolean isConnected = true;
boolean hasPermission = false;
boolean isAdult = (age > 18);
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de trois variables booléennes : `isConnected` à
`true`, `hasPermission` à `false`, et `isAdult` au résultat de la comparaison
(opérateur `>`) entre la variable `age` et la valeur `18`.

</details>

### Éviter les expressions trop complexes

Si une expression booléenne devient trop longue ou complexe, il est préférable
de la décomposer en plusieurs variables intermédiaires.

**Avant décomposition**

```java
if ((user.isActive() && user.hasSubscription() && !user.isBanned()) ||
    (user.isAdmin() && user.hasValidToken()) ||
    (config.isPublicMode() && !config.requiresAuth())) {
    // Autoriser l'accès
}
```

<details>
<summary>Description du code</summary>

Structure conditionnelle `if` avec une expression booléenne complexe combinant
trois groupes de conditions avec l'opérateur OR (symbole `||`). Chaque groupe
utilise des appels de méthodes sur les objets `user` et `config`, combinés avec
les opérateurs AND (symbole `&&`) et NOT (symbole `!`).

</details>

**Après décomposition**

```java
boolean isRegularUser = user.isActive() &&
                        user.hasSubscription() &&
                        !user.isBanned();

boolean isAuthenticatedAdmin = user.isAdmin() && user.hasValidToken();

boolean isPublicAccess = config.isPublicMode() && !config.requiresAuth();

if (isRegularUser || isAuthenticatedAdmin || isPublicAccess) {
    // Autoriser l'accès
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de trois variables booléennes intermédiaires
(`isRegularUser`, `isAuthenticatedAdmin`, `isPublicAccess`) par évaluation
d'expressions complexes faisant appel à des méthodes sur des objets `user` et
`config`.

Structure conditionnelle `if` utilisant une expression booléenne simplifiée
combinant les trois variables avec l'opérateur OR. Cette décomposition rend le
code plus lisible, testable et maintenable.

</details>

La deuxième version est plus facile à comprendre, à tester et à maintenir.

### Éviter les comparaisons redondantes

Il n'est pas nécessaire de comparer explicitement une valeur booléenne à `true`
ou `false`.

**À éviter**

```java
if (isReady == true) {
    // ...
}

if (hasError == false) {
    // ...
}
```

<details>
<summary>Description du code</summary>

Première structure conditionnelle `if` avec une comparaison (opérateur `==`)
entre la variable booléenne `isReady` et la valeur littérale `true`.

Deuxième structure conditionnelle `if` avec une comparaison (opérateur `==`)
entre la variable booléenne `hasError` et la valeur littérale `false`.

</details>

**À privilégier**

```java
if (isReady) {
    // ...
}

if (!hasError) {
    // ...
}
```

<details>
<summary>Description du code</summary>

Première structure conditionnelle `if` testant directement la variable booléenne
`isReady`.

Deuxième structure conditionnelle `if` testant la négation (opérateur `!`) de la
variable booléenne `hasError`.

</details>

### Utiliser des méthodes pour encapsuler la logique

Lorsqu'une condition est utilisée à plusieurs endroits ou qu'elle est complexe,
il est judicieux de l'encapsuler dans une méthode avec un nom descriptif.

**Exemple**

```java
public boolean isEligibleForDiscount(User user) {
    boolean isStudent = user.hasStudentStatus();
    boolean isSenior = (user.getAge() >= 65);
    boolean hasLowIncome = (user.getIncome() < 20000);

    return isStudent || isSenior || hasLowIncome;
}

// Utilisation
if (isEligibleForDiscount(currentUser)) {
    applyDiscount();
}
```

<details>
<summary>Description du code</summary>

Déclaration d'une méthode publique `isEligibleForDiscount` qui prend un objet
`User` en paramètre et retourne un booléen.

Dans le corps de la méthode : déclaration et initialisation de trois variables
booléennes par appel de méthodes sur l'objet `user` et comparaison de valeurs.

Instruction `return` renvoyant le résultat de l'évaluation d'une expression
combinant les trois variables avec l'opérateur OR.

Dans la section utilisation : appel de la méthode dans une structure
conditionnelle `if`. Cette encapsulation rend le code réutilisable et facilite
la maintenance.

</details>

### Commenter les expressions complexes

Si une expression logique implémente une règle métier complexe, un commentaire
peut aider à comprendre l'intention.

```java
// Une personne peut voter si elle a 18 ans ou plus
// ET si elle possède une pièce d'identité valide
boolean canVote = (age >= 18) && hasValidID;

// L'accès est autorisé en mode dégradé si le système principal
// est indisponible ET qu'il existe un système de secours
boolean allowFallbackAccess = !isPrimarySystemAvailable &&
                              hasBackupSystem;
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de la variable booléenne `canVote` par évaluation
d'une expression combinant une comparaison (opérateur `>=`) entre `age` et `18`,
et la variable booléenne `hasValidID`, avec l'opérateur AND (symbole `&&`).

Déclaration et initialisation de la variable booléenne `allowFallbackAccess` par
évaluation d'une expression combinant la négation (opérateur `!`) de la variable
`isPrimarySystemAvailable` et la variable `hasBackupSystem`, avec l'opérateur
AND (symbole `&&`).

</details>

## Pièges et erreurs courantes

Voici quelques erreurs fréquentes à éviter lors de l'utilisation d'expressions
booléennes.

### Confondre = et ==

L'opérateur `=` est l'opérateur d'affectation, tandis que `==` est l'opérateur
de comparaison.

**Erreur**

```java
boolean isActive = true;

if (isActive = false) {  // Affectation au lieu de comparaison !
    System.out.println("Inactif");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de la variable booléenne `isActive` à `true`.

Structure conditionnelle `if` avec une affectation (opérateur `=`) de la valeur
`false` à la variable `isActive` dans l'expression de condition. L'expression
évalue ensuite la valeur affectée (`false`).

Appel de la méthode statique `System.out.println()` avec la chaîne de caractères
`"Inactif"` en argument.

</details>

Dans cet exemple, `isActive` est modifié et prend la valeur `false`, puis la
condition évalue cette valeur. Ce n'est généralement pas l'intention.

**Correction**

```java
if (isActive == false) {  // Comparaison
    System.out.println("Inactif");
}

// Ou mieux encore
if (!isActive) {
    System.out.println("Inactif");
}
```

<details>
<summary>Description du code</summary>

Première structure conditionnelle `if` avec une comparaison (opérateur `==`)
entre la variable booléenne `isActive` et la valeur littérale `false`.

Deuxième structure conditionnelle `if` avec la négation (opérateur `!`) de la
variable booléenne `isActive`.

Dans chaque bloc conditionnel : appel de la méthode statique
`System.out.println()` avec la chaîne de caractères `"Inactif"` en argument.

</details>

### Utiliser && ou || avec des types non booléens

En Java, les opérateurs logiques ne fonctionnent qu'avec des expressions
booléennes. Il n'est pas possible d'utiliser directement des nombres ou d'autres
types.

**Valide en C (mais pas en Java)**

```c
int count = 0;
if (count) {  // Ceci fonctionne en C mais PAS en Java
    // ...
}
```

<details>
<summary>Description du code</summary>

Code en langage C.

Déclaration et initialisation d'une variable entière `count` à `0`.

Structure conditionnelle `if` utilisant directement la variable `count` comme
expression de condition (syntaxe valide en C, invalide en Java).

</details>

**En Java**

```java
int count = 0;
if (count != 0) {  // Il faut une expression booléenne explicite
    // ...
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable entière `count` à `0`.

Structure conditionnelle `if` avec une expression booléenne obtenue par
comparaison (opérateur `!=`) entre la variable `count` et la valeur `0`.

</details>

### Oublier les parenthèses dans les expressions complexes

Sans parenthèses, l'ordre d'évaluation peut ne pas correspondre à ce qui est
attendu.

**Exemple ambigu**

```java
boolean result = a || b && c;
// Est-ce (a || b) && c ou a || (b && c) ?
```

<details>
<summary>Description du code</summary>

Expression ambiguë sans parenthèses. Impossible de savoir sans connaître les
règles de priorité quel opérateur est évalué en premier.

</details>

**Solution**

```java
boolean result = a || (b && c);  // Intention claire
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de la variable booléenne `result` par évaluation
d'une expression booléenne combinant les variables `a`, `b` et `c` avec les
opérateurs OR (symbole `||`) et AND (symbole `&&`), avec des parenthèses autour
de `(b && c)` pour expliciter l'ordre d'évaluation.

</details>

### Ignorer le comportement court-circuit

Le comportement court-circuit peut être une source d'erreurs si on ne le
comprend pas bien.

**Exemple problématique**

```java
String text = null;

// Si text est null, text.length() ne sera jamais appelé grâce au court-circuit
if ((text != null) && (text.length() > 0)) {
    System.out.println("Texte valide");
}

// ERREUR : si on inverse l'ordre, NullPointerException !
if ((text.length() > 0) && (text != null)) {  // Dangereux !
    System.out.println("Texte valide");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable de type `String` nommée `text` à
`null`.

Première structure conditionnelle `if` avec une expression booléenne combinant
deux conditions avec l'opérateur AND (symbole `&&`) : comparaison (opérateur
`!=`) entre `text` et `null`, puis comparaison (opérateur `>`) entre le résultat
de l'appel de méthode `text.length()` et la valeur `0`.

Deuxième structure conditionnelle `if` avec les mêmes conditions dans l'ordre
inverse : d'abord la comparaison avec `text.length()`, puis la comparaison avec
`null`.

Dans chaque bloc conditionnel : appel de la méthode statique
`System.out.println()` avec la chaîne de caractères `"Texte valide"` en
argument.

</details>

L'ordre des conditions est important lorsqu'on utilise `&&` ou `||`.

### Utiliser des négations multiples

Les négations multiples rendent le code difficile à lire et à comprendre.

**À éviter**

```java
if (!(!isActive)) {
    // ...
}

if (!(!(hasPermission || isAdmin))) {
    // ...
}
```

<details>
<summary>Description du code</summary>

Première structure conditionnelle `if` avec deux négations successives
(opérateur `!`) appliquées à la variable booléenne `isActive`.

Deuxième structure conditionnelle `if` avec deux négations successives
(opérateur `!`) appliquées à une expression booléenne combinant les variables
`hasPermission` et `isAdmin` avec l'opérateur OR (symbole `||`).

</details>

**À privilégier**

```java
if (isActive) {
    // ...
}

// Appliquer De Morgan pour simplifier
if (!hasPermission && !isAdmin) {
    // ...
}
```

<details>
<summary>Description du code</summary>

Première structure conditionnelle `if` testant directement la variable booléenne
`isActive`.

Deuxième structure conditionnelle `if` avec une expression booléenne combinant
les négations (opérateur `!`) des variables `hasPermission` et `isAdmin` avec
l'opérateur AND (symbole `&&`).

</details>

### Comparer des valeurs flottantes avec ==

Ce n'est pas directement lié à l'algèbre de Boole, mais c'est une erreur
courante lors de la construction d'expressions booléennes.

**À éviter**

```java
double value = 0.1 + 0.2;
if (value == 0.3) {  // Peut être faux à cause de l'imprécision des flottants
    System.out.println("Égal");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable de type `double` nommée `value` par
évaluation de l'addition (opérateur `+`) entre `0.1` et `0.2`.

Structure conditionnelle `if` avec une comparaison d'égalité (opérateur `==`)
entre la variable `value` et la valeur `0.3`.

Appel de la méthode statique `System.out.println()` avec la chaîne de caractères
`"Égal"` en argument.

</details>

**À privilégier**

```java
double value = 0.1 + 0.2;
double epsilon = 0.0001;
if (Math.abs(value - 0.3) < epsilon) {
    System.out.println("Approximativement égal");
}
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable de type `double` nommée `value` par
évaluation de l'addition (opérateur `+`) entre `0.1` et `0.2`.

Déclaration et initialisation d'une variable de type `double` nommée `epsilon` à
`0.0001`.

Structure conditionnelle `if` avec une comparaison (opérateur `<`) entre l'appel
de la méthode statique `Math.abs()` avec l'argument `(value - 0.3)` et la
variable `epsilon`.

Appel de la méthode statique `System.out.println()` avec la chaîne de caractères
`"Approximativement égal"` en argument.

</details>

<details>
<summary>Pour aller plus loin</summary>

### Priorité des opérateurs

Bien qu'il soit recommandé d'utiliser des parenthèses pour rendre l'ordre
d'évaluation explicite, Java définit une priorité entre les opérateurs logiques.

**Ordre de priorité (du plus prioritaire au moins prioritaire)**

1. `!` (NOT)
2. `&&` (AND)
3. `||` (OR)
4. `^` (XOR)

**Exemple**

```java
boolean a = true;
boolean b = false;
boolean c = true;

// Sans parenthèses
boolean result1 = a || b && c;  // Évalué comme : a || (b && c)

// Avec parenthèses pour plus de clarté
boolean result2 = a || (b && c);

// result1 et result2 ont la même valeur : true
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de trois variables booléennes : `a` à `true`, `b`
à `false`, et `c` à `true`.

Déclaration et initialisation de la variable booléenne `result1` par évaluation
d'une expression combinant les variables `a`, `b` et `c` avec les opérateurs OR
(symbole `||`) et AND (symbole `&&`), sans parenthèses.

Déclaration et initialisation de la variable booléenne `result2` par évaluation
de la même expression avec des parenthèses autour de `(b && c)`.

</details>

Même si cette priorité existe, il est préférable de toujours utiliser des
parenthèses pour rendre le code plus lisible et éviter toute ambiguïté.

### Opérateurs bit à bit vs opérateurs logiques

Java propose également des opérateurs bit à bit (`&`, `|`, `^`) qui fonctionnent
sur les bits individuels des nombres entiers. Ces opérateurs peuvent aussi être
utilisés avec des booléens, mais contrairement à `&&` et `||`, ils n'ont pas de
comportement court-circuit.

**Différence**

```java
boolean a = false;
boolean b = true;

// Avec court-circuit : la deuxième expression n'est pas évaluée
boolean result1 = a && expensiveOperation();

// Sans court-circuit : les deux expressions sont toujours évaluées
boolean result2 = a & expensiveOperation();
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation de deux variables booléennes : `a` à `false` et
`b` à `true`.

Déclaration et initialisation de la variable booléenne `result1` par évaluation
d'une expression combinant la variable `a` et l'appel de méthode
`expensiveOperation()` avec l'opérateur AND court-circuit (symbole `&&`).

Déclaration et initialisation de la variable booléenne `result2` par évaluation
d'une expression combinant la variable `a` et l'appel de méthode
`expensiveOperation()` avec l'opérateur AND standard (symbole `&`).

</details>

Pour des expressions booléennes logiques, il est recommandé d'utiliser `&&` et
`||` plutôt que `&` et `|`.

### Algèbre de Boole et circuits logiques

L'algèbre de Boole est également utilisée dans la conception de circuits
électroniques numériques. Les portes logiques (AND, OR, NOT, XOR) sont les
composants de base des processeurs et de tous les systèmes numériques.

Comprendre l'algèbre de Boole en programmation aide également à comprendre
comment fonctionnent les ordinateurs au niveau matériel.

### Quantificateurs et logique du premier ordre

L'algèbre de Boole peut être étendue avec des quantificateurs comme "pour tout"
(∀) et "il existe" (∃). Cette extension est appelée logique du premier ordre et
est utilisée en mathématiques, en intelligence artificielle et dans certains
langages de programmation logique comme Prolog.

### Ressources complémentaires

Pour approfondir vos connaissances sur l'algèbre de Boole :

- [Java Booleans - W3Schools](https://www.w3schools.com/java/java_booleans.asp)
- [Java Booleans Real Life Examples - W3Schools](https://www.w3schools.com/java/java_booleans_reallife.asp)
- [Algèbre de Boole - Wikipédia](<https://fr.wikipedia.org/wiki/Alg%C3%A8bre_de_Boole_(logique)>)
- [Documentation officielle Java sur les opérateurs](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)

</details>

---

## Conclusion

L'algèbre de Boole est un pilier fondamental de la programmation. Maîtriser les
opérateurs logiques (`!`, `&&`, `||`, `^`), comprendre les tables de vérité et
savoir construire des expressions booléennes claires vous permettra de créer des
programmes plus robustes et maintenables.

Les points clés à retenir :

- Les opérateurs `&&` et `||` utilisent le court-circuit pour optimiser
  l'évaluation et éviter les erreurs.
- Les parenthèses rendent le code plus lisible, même si la priorité des
  opérateurs est définie.
- Les lois de De Morgan permettent de simplifier des expressions complexes.
- Des noms de variables explicites (`isActive`, `hasPermission`) améliorent la
  compréhension du code.

Continuez à pratiquer en appliquant ces concepts dans vos programmes. Plus vous
utiliserez les expressions booléennes de manière réfléchie, plus elles
deviendront naturelles dans votre approche de résolution de problèmes.

## Exercices

Nous vous invitons maintenant à réaliser les exercices de la séance afin de
mettre en pratique les concepts abordés.

Vous trouverez les exercices et leur corrigé ici :
[Exercices](./02-exercices/README.md).

## Mini-projet

Nous vous invitons maintenant à réaliser le mini-projet de la séance afin de
mettre en pratique les concepts abordés.

Vous trouverez les détails du mini-projet ici :
[Mini-projet](./03-mini-projet/README.md).

## À faire pour la prochaine séance

Chaque personne est libre de gérer son temps comme elle le souhaite. Cependant,
il est recommandé pour la prochaine séance de :

- Relire le support de cours si nécessaire.
- Relire les exemples de code et leur description pour bien comprendre les
  concepts.
- Finaliser les exercices qui n'ont pas été terminés en classe.
- Finaliser la partie du mini-projet qui n'a pas été terminée en classe.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
[presentation-web]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/03-algebre-de-boole/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/03-algebre-de-boole/03-algebre-de-boole-presentation.pdf
