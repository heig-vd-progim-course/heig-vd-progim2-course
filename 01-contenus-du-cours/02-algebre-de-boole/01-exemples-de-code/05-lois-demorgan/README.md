# Exemple 05 - Lois de De Morgan

**Objectif pédagogique :** comprendre et appliquer les lois de De Morgan pour
simplifier des expressions booléennes.

**Concepts illustrés :**

- Première loi de De Morgan : `!(A && B) = !A || !B`
- Deuxième loi de De Morgan : `!(A || B) = !A && !B`
- Simplification d'expressions logiques
- Amélioration de la lisibilité du code

## Description

Les lois de De Morgan sont deux règles fondamentales permettant de transformer
la négation d'une expression complexe. Elles sont particulièrement utiles pour
simplifier le code et le rendre plus lisible.

**Première loi :** La négation d'une conjonction (AND) est équivalente à la
disjonction (OR) des négations.

**Deuxième loi :** La négation d'une disjonction (OR) est équivalente à la
conjonction (AND) des négations.

## Code

Le fichier `Example.java` démontre les deux lois avec des exemples concrets et
vérifi que les expressions équivalentes produisent les mêmes résultats.

## Sortie attendue

```
=== Première loi de De Morgan ===
!(A && B) est équivalent à (!A || !B)

Cas 1:
hasInternet: true, hasData: true
!(hasInternet && hasData) = false
!hasInternet || !hasData = false
Les deux expressions sont identiques: true

Cas 2:
hasInternet: true, hasData: false
!(hasInternet && hasData) = true
!hasInternet || !hasData = true
Les deux expressions sont identiques: true

=== Deuxième loi de De Morgan ===
!(A || B) est équivalent à (!A && !B)

Cas 3:
isClosed: false, isFullyBooked: false
!(isClosed || isFullyBooked) = true
!isClosed && !isFullyBooked = true
Les deux expressions sont identiques: true

Cas 4:
isClosed: true, isFullyBooked: false
!(isClosed || isFullyBooked) = false
!isClosed && !isFullyBooked = false
Les deux expressions sont identiques: true

=== Exemple pratique de simplification ===

Avant simplification:
!(hasError || hasWarning) = true

Après simplification avec De Morgan:
!hasError && !hasWarning = true

La version simplifiée est plus lisible:
"pas d'erreur ET pas d'avertissement"
```

## Points clés à retenir

- `!(A && B)` est équivalent à `!A || !B`
- `!(A || B)` est équivalent à `!A && !B`
- Les lois de De Morgan permettent de simplifier des expressions complexes
- La version simplifiée est souvent plus facile à lire et comprendre
- Ces lois sont utiles pour éviter les négations multiples

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Créer vos propres expressions avec négations et les simplifier.
2. Vérifier que les expressions équivalentes produisent toujours les mêmes
   résultats.
3. Comparer la lisibilité des versions avant/après simplification.

---

**Exemple suivant :** [06-condition-simple](../06-condition-simple/README.md)
