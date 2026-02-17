# Exemple 03 - Opérateur XOR (OU exclusif)

**Objectif pédagogique :** comprendre et utiliser l'opérateur XOR pour les choix
exclusifs.

**Concepts illustrés :**

- Opérateur XOR (`^`) - ou exclusif
- Table de vérité
- Cas d'usage pratiques (choix mutuellement exclusifs)

## Description

L'opérateur XOR (`^`) retourne `true` si **une et une seule** des deux opérandes
est `true`. Si les deux sont identiques (toutes deux vraies ou toutes deux
fausses), il retourne `false`.

Cet opérateur est utile pour vérifier que deux conditions sont dans des états
opposés, ou pour modéliser des choix mutuellement exclusifs.

## Code

Le fichier `Example.java` montre plusieurs cas d'utilisation du XOR avec des
exemples pratiques.

## Sortie attendue

```
=== Opérateur XOR (^) ===

Exemple 1: Source d'énergie unique
usesSolarPower: true, usesGridPower: false
usesOnlyOneSource: true

Exemple 2: Deux sources activées
usesSolarPower: true, usesGridPower: true
usesOnlyOneSource: false

Exemple 3: Aucune source
usesSolarPower: false, usesGridPower: false
usesOnlyOneSource: false

Table de vérité XOR:
true  ^ true  = false
true  ^ false = true
false ^ true  = true
false ^ false = false

Comparaison XOR vs OR:
Avec XOR (^): Une seule option doit être vraie
true ^ false = true
false ^ true = true
true ^ true = false  ← Différent de OR

Avec OR (||): Au moins une option doit être vraie
true || false = true
false || true = true
true || true = true  ← Toujours vrai
```

## Points clés à retenir

- XOR retourne `true` si **exactement une** des deux conditions est vraie
- XOR est différent de OR : `true ^ true` donne `false`, `true || true` donne
  `true`
- Utile pour vérifier des choix mutuellement exclusifs
- Moins utilisé que AND et OR, mais important dans certains cas spécifiques

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Créer d'autres scénarios de choix exclusifs (modes de paiement, options de
   configuration).
2. Comparer le comportement de XOR avec OR dans différentes situations.
3. Utiliser XOR pour détecter des changements d'état.

---

**Exemple suivant :** [04-court-circuit](../04-court-circuit/README.md)
