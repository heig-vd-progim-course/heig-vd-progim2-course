# Exemple 02 - Opérateurs logiques de base (NOT, AND, OR)

**Objectif pédagogique :** comprendre et utiliser les trois opérateurs logiques
fondamentaux : NOT, AND et OR.

**Concepts illustrés :**

- Opérateur NOT (`!`) - négation
- Opérateur AND (`&&`) - conjonction
- Opérateur OR (`||`) - disjonction
- Tables de vérité

## Description

Cet exemple illustre les trois opérateurs logiques de base en algèbre de Boole.
Chaque opérateur est présenté avec sa table de vérité et des cas d'utilisation
pratiques.

- **NOT (`!`)** : inverse la valeur booléenne
- **AND (`&&`)** : retourne `true` seulement si les deux opérandes sont `true`
- **OR (`||`)** : retourne `true` si au moins un opérande est `true`

## Code

Le fichier `Example.java` démontre l'utilisation de chaque opérateur avec des
exemples concrets et des tables de vérité.

## Sortie attendue

```
=== Opérateur NOT (!) ===
isActive: true
isInactive: false

Table de vérité NOT:
!true  = false
!false = true

=== Opérateur AND (&&) ===
hasInternet: true, hasSubscription: true
canStream: true

hasInternet: true, hasSubscription: false
canStream: false

Table de vérité AND:
true  && true  = true
true  && false = false
false && true  = false
false && false = false

=== Opérateur OR (||) ===
isAdmin: false, isModerator: true
hasAccess: true

isAdmin: false, isModerator: false
hasAccess: false

Table de vérité OR:
true  || true  = true
true  || false = true
false || true  = true
false || false = false
```

## Points clés à retenir

- `!` inverse une valeur booléenne : `!true` devient `false`
- `&&` nécessite que **les deux** conditions soient vraies
- `||` nécessite qu'**au moins une** condition soit vraie
- Ces opérateurs sont la base de toute logique conditionnelle

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Modifier les valeurs booléennes et prédire les résultats avant d'exécuter.
2. Créer vos propres exemples avec des contextes réels (permissions, états,
   etc.).
3. Combiner plusieurs opérateurs dans une seule expression.

---

**Exemple suivant :** [03-operateur-xor](../03-operateur-xor/README.md)
