---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  Quiz sur le contenu Algèbre de Boole pour le cours ProgIM2 enseigné à la
  HEIG-VD, Suisse
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/02-algebre-de-boole/quiz.html
header: "[**Algèbre de Boole - Quiz**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Algèbre de Boole - Quiz

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

**Complétion : Déclaration de variable booléenne**

Quel code déclare correctement une variable booléenne `isActive` initialisée à
vrai ?

- **A.** `boolean isActive = 1;`
- **B.** `boolean isActive = true;`
- **C.** `bool isActive = true;`
- **D.** `Boolean isActive = "true";`

## Question 1 - Réponse

**Réponse correcte : B**

```java
boolean isActive = true;
```

**Explications :**

- **A** : `1` n'est pas une valeur booléenne valide en Java
- **C** : le type est `boolean`, pas `bool`
- **D** : `"true"` est une chaîne de caractères, pas une valeur booléenne

## Question 2 - Donnée

**Complétion : Opérateur logique manquant**

Complétez le code pour vérifier qu'une personne a accès SI elle a un badge
**ET** un code valide :

```java
boolean hasBadge = true;
boolean hasValidCode = true;
boolean hasAccess = hasBadge ___ hasValidCode;
```

**A.** `||` **B.** `&&` **C.** `!` **D.** `^`

## Question 2 - Réponse

**Réponse correcte : B**

```java
boolean hasAccess = hasBadge && hasValidCode;
```

**Explications :**

- **&&** (AND) : les **deux** conditions doivent être vraies
- **||** (OR) : au moins une condition doit être vraie
- **!** (NOT) : inverse la valeur
- **^** (XOR) : vrai si les valeurs sont différentes

## Question 3 - Donnée

**Complétion : Application de la loi de De Morgan**

Quelle expression est équivalente à `!(isOffline || hasError)` ?

- **A.** `isOffline || hasError`
- **B.** `!isOffline || !hasError`
- **C.** `!isOffline && !hasError`
- **D.** `isOffline && hasError`

## Question 3 - Réponse

**Réponse correcte : C**

```java
!(isOffline || hasError)  équivaut à  !isOffline && !hasError
```

**Loi de De Morgan :**

- `!(A || B)` = `!A && !B`
- On retire la négation globale
- On inverse l'opérateur (`||` → `&&`)
- On ajoute une négation à chaque terme

## Question 4 - Donnée

**Prédiction : Évaluation**

Que vaut `result` après l'exécution de ce code ?

<div class="two-columns">
<div>

```java
boolean a = false;
boolean b = true;
boolean result = a && b;
```

</div>
<div>

- **A.** `true`
- **B.** `false`
- **C.** Le code ne compile pas
- **D.** Une exception est levée

</div>
</div>

## Question 4 - Réponse

**Réponse correcte : B**

```java
boolean result = a && b; // result vaut false
```

**Explications :**

- L'opérateur `&&` évalue à `true` uniquement si les deux conditions sont vraies
- Ici, `a` est `false`, donc le résultat est forcément `false`
- Grâce au court-circuit, `b` n'est même pas évalué (optimisation)

## Question 5 - Donnée

**Prédiction : Expression avec plusieurs opérateurs**

Que vaut `canAccess` après l'exécution de ce code ?

```java
boolean isAdmin = false;
boolean hasPermission = true;
boolean isVerified = true;
boolean canAccess = isAdmin || (hasPermission && isVerified);
```

**A.** `true` **B.** `false` **C.** Erreur de compilation **D.** `null`

## Question 5 - Réponse

**Réponse correcte : A** `canAccess` vaut `true`

```java
boolean isAdmin = false;
boolean hasPermission = true;
boolean isVerified = true;
boolean canAccess = isAdmin || (hasPermission && isVerified); // true
```

**Évaluation étape par étape :**

1. `hasPermission && isVerified` → `true && true` = `true`
2. `isAdmin || true` → `false || true` = `true`

## Question 6 - Donnée

**Prédiction : Opérateur XOR**

Que vaut `result` après l'exécution de ce code ?

<div class="two-columns">
<div>

```java
boolean solarPower = true;
boolean gridPower = true;
boolean result = solarPower ^ gridPower;
```

</div>
<div>

- **A.** `true`
- **B.** `false`
- **C.** Erreur de compilation
- **D.** Dépend de la JVM utilisée

</div>
</div>

## Question 6 - Réponse

**Réponse correcte : B** `result` vaut `false`

```java
boolean solarPower = true;
boolean gridPower = true;
boolean result = solarPower ^ gridPower;
```

**Explications :**

- L'opérateur `^` (XOR) retourne `true` si les valeurs sont **différentes**

## Question 7 - Donnée

**Comparaison : Conditions redondantes**

Quelle version est préférable pour vérifier si un nombre est positif ?

- **A.** `if (number > 0 == true) { ... }`
- **B.** `if ((number > 0) == true) { ... }`
- **C.** `if (number > 0) { ... }`
- **D.** Les trois sont équivalentes et acceptables

## Question 7 - Réponse

**Réponse correcte : C** `if (number > 0) { ... }`

**Explications :**

- `number > 0` retourne déjà un `boolean`
- Comparer un booléen avec `== true` est redondant
- Code plus lisible et idiomatique
- Principe KISS (Keep It Simple and Stupid)

**À éviter :** comparaisons redondantes comme `== true` ou `== false`

## Question 8 - Donnée

**Comparaison : Négations multiples**

Quelle version est la plus lisible et maintenable ?

```java
// Version A
if (!(!isConnected || !hasData)) { ... }

// Version B
if (isConnected && hasData) { ... }
```

**A.** Version A **B.** Version B **C.** Équivalentes **D.** Aucune

## Question 8 - Réponse

**Réponse correcte : B**

```java
if (isConnected && hasData) { ... }
```

**Explications :**

- Les deux versions sont **logiquement équivalentes**
- Version B est plus simple et directe
- Éviter les négations multiples améliore la lisibilité
- Application des lois de De Morgan pour simplifier

## Question 9 - Donnée

**Modification : Simplification avec De Morgan**

Comment simplifier cette condition ?

```java
if (!(temperature < 15 || humidity > 80)) {
    startSystem();
}

- A if (temperature >= 15 || humidity <= 80)
- B if (temperature >= 15 && humidity <= 80)
- C if (!(temperature >= 15 && humidity <= 80))
- D if (temperature < 15 && humidity > 80)
```

## Question 9 - Réponse

**Réponse correcte : B**

```java
if (temperature >= 15 && humidity <= 80) {
...
```

**Application de la loi de De Morgan :**

1. `!(A || B)` = `!A && !B`
2. `!(temperature < 15)` → `temperature >= 15`
3. `!(humidity > 80)` → `humidity <= 80`

## Question 10 - Donnée

**Modification : Refactorisation d'une condition complexe**

Cette condition est difficile à lire. Quelle amélioration est prioritaire ?

```java
if (a && b || c && !d && e || !f && g && h && !i) { ... }
```

**A.** Ajouter des parenthèses pour clarifier la priorité

**B.** Extraire des sous-expressions dans des variables bien nommées

**C.** Convertir en if-else imbriqués

**D.** Utiliser un switch

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions sur le quiz ou le contenu ?

## Sources

- [Illustration principale][illustration-principale] par
  [Richard Jacobs](https://unsplash.com/@rj2747) sur
  [Unsplash](https://unsplash.com/photos/grayscale-photo-of-elephants-drinking-water-8oenpCXktqQ)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/02-algebre-de-boole/README.md
[licence]: https://creativecommons.org/licenses/by-sa/4.0/

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1464639351491-a172c2aa2911?q=80&w=2076&auto=format&fit=crop
