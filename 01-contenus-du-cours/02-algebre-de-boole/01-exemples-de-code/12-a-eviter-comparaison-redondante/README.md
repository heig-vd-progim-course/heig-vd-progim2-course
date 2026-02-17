# Exemple 12 - À éviter : Comparaison redondante

**Objectif pédagogique :** comprendre pourquoi comparer un booléen à `true` ou
`false` est redondant et nuit à la lisibilité.

**Concepts illustrés :**

- Redondance de `if (isReady == true)`
- Redondance de `return isReady == true;`
- Utilisation directe des booléens
- Amélioration de la lisibilité du code

## Description

Une erreur stylistique courante est de comparer explicitement une variable
booléenne à `true` ou `false`. Cette comparaison est redondante car la variable
est déjà un booléen.

**❌ Problème :**

```java
if (isReady == true) {      // Redondant
    return true;
}

boolean result = (isReady == true);  // Redondant
```

**✓ Solution :**

```java
if (isReady) {              // Clair et concis
    return true;
}

boolean result = isReady;   // Direct et lisible
```

Cette pratique rend le code plus verbeux sans apporter de valeur. De plus, elle
peut suggérer une incompréhension des booléens.

## Code

Le fichier `Example.java` démontre plusieurs cas de comparaisons redondantes
dans les conditions `if` et les instructions `return`, ainsi que leurs versions
simplifiées.

## Points clés à retenir

- Les variables booléennes sont déjà `true` ou `false`
- `if (isReady == true)` est équivalent à `if (isReady)`
- `if (isReady == false)` est équivalent à `if (!isReady)`
- `return isReady == true;` est équivalent à `return isReady;`
- La version simplifiée est plus lisible et idiomatique
- Évitez les doubles négations : `if (isReady != false)` est confus

## Suggestions de réflexion

Pour écrire du code plus clair :

1. Utilisez directement les variables booléennes dans les conditions
2. Utilisez `!` pour la négation au lieu de `== false`
3. Retournez directement les booléens au lieu de les comparer
4. Choisissez des noms de variables expressifs (`isReady`, `hasData`)

---

**Exemple suivant :**
[13-a-eviter-type-non-booleen](../13-a-eviter-type-non-booleen/README.md)
