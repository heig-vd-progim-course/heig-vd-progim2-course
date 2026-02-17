# Exemple 13 - À éviter : Type non booléen dans une condition

**Objectif pédagogique :** comprendre pourquoi Java n'accepte que des booléens
dans les conditions et comment éviter cette erreur.

**Concepts illustrés :**

- Erreur de type dans les conditions
- Java vs langages avec conversion implicite
- Nécessité d'une expression booléenne explicite
- Comparaison correcte pour obtenir un booléen

## Description

Contrairement à certains langages (C, JavaScript, Python), Java est strict sur
les types dans les conditions : seules les expressions de type `boolean` sont
acceptées. Une valeur numérique (0, 1) ou une chaîne ne peut pas être utilisée
directement.

**❌ Problème :**

```java
int count = 0;
if (count) {              // ERREUR : count n'est pas un booléen
    // ...
}
```

**✓ Solution :**

```java
int count = 0;
if (count > 0) {          // Comparaison qui produit un booléen
    // ...
}
```

Cette rigueur de Java aide à éviter des bugs subtils et rend le code plus
explicite.

## Code

Le fichier `Example.java` contient du code commenté illustrant cette erreur avec
différents types de données (nombres, chaînes, objets).

## Points clés à retenir

- Java exige une expression de type `boolean` dans les conditions
- Un entier (même 0 ou 1) ne peut pas être utilisé directement
- Une référence `null` ne peut pas être utilisée directement
- Une chaîne vide ne peut pas être utilisée directement
- Utilisez des comparaisons explicites : `count > 0`, `text != null`, etc.
- Cette rigueur prévient les erreurs et rend le code plus lisible

## Suggestions de réflexion

Pour écrire des conditions correctes :

1. Comprenez que Java ne fait pas de conversion implicite vers boolean
2. Utilisez des opérateurs de comparaison pour créer des booléens
3. Pour tester null : `if (object != null)`
4. Pour tester vide : `if (!text.isEmpty())` (après avoir vérifié null)

---

**Exemple suivant :**
[14-a-eviter-negations-multiples](../14-a-eviter-negations-multiples/README.md)
