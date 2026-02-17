# Exemple 04 - Court-circuit des opérateurs logiques

**Objectif pédagogique :** comprendre le comportement court-circuit des
opérateurs `&&` et `||` et son importance.

**Concepts illustrés :**

- Évaluation court-circuit avec AND (`&&`)
- Évaluation court-circuit avec OR (`||`)
- Ordre des conditions pour éviter les erreurs
- Optimisation des performances

## Description

Les opérateurs `&&` et `||` utilisent l'**évaluation court-circuit** : la
deuxième expression n'est évaluée que si nécessaire.

- **Avec `&&`** : si la première expression est `false`, la deuxième n'est pas
  évaluée (le résultat sera forcément `false`)
- **Avec `||`** : si la première expression est `true`, la deuxième n'est pas
  évaluée (le résultat sera forcément `true`)

Ce comportement permet d'**éviter les erreurs** (comme `NullPointerException`)
et d'**optimiser les performances**.

## Code

Le fichier `Example.java` démontre le court-circuit avec des exemples pratiques
et des compteurs pour visualiser les évaluations.

## Sortie attendue

```
=== Court-circuit avec AND (&&) ===

Test 1: Première condition false
Évaluation de la condition 1: false
Résultat: false
Condition 2 évaluée ? NON (grâce au court-circuit)

Test 2: Première condition true
Évaluation de la condition 1: true
Évaluation de la condition 2: true
Résultat: true
Condition 2 évaluée ? OUI

=== Court-circuit avec OR (||) ===

Test 3: Première condition true
Évaluation de la condition 1: true
Résultat: true
Condition 2 évaluée ? NON (grâce au court-circuit)

Test 4: Première condition false
Évaluation de la condition 1: false
Évaluation de la condition 2: false
Résultat: false
Condition 2 évaluée ? OUI

=== Application pratique: Éviter NullPointerException ===

Test avec null:
text est null, vérification sautée
Est valide ? false

Test avec texte vide:
text n'est pas null, vérification de la longueur
text est vide
Est valide ? false

Test avec texte valide:
text n'est pas null, vérification de la longueur
text est valide
Est valide ? true
```

## Points clés à retenir

- `&&` : si le premier est `false`, le second n'est pas évalué
- `||` : si le premier est `true`, le second n'est pas évalué
- **L'ordre des conditions est crucial** pour éviter les erreurs
- Toujours placer les vérifications de sécurité en premier (ex: vérifier
  `!= null`)
- Le court-circuit améliore aussi les performances

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Inverser l'ordre des conditions dans l'exemple `null` et observer l'erreur.
2. Créer vos propres exemples avec des vérifications de sécurité.
3. Comparer avec les opérateurs bit-à-bit `&` et `|` qui n'ont pas de
   court-circuit.

---

**Exemple suivant :** [05-lois-demorgan](../05-lois-demorgan/README.md)
