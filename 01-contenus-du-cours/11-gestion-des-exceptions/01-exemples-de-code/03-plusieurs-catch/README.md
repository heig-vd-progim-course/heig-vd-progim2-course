# Exemple 03 - Plusieurs blocs catch et leur ordre

**Objectif pédagogique :** comprendre comment enchaîner plusieurs blocs `catch`
et pourquoi l'ordre est important.

**Concepts illustrés :**

- Enchaînement de plusieurs blocs `catch`.
- Règle : les types les plus spécifiques doivent être placés en premier.
- Chaque `catch` ne capture que le type d'exception qui lui correspond.
- Placer `Exception` avant ses sous-types provoque une erreur de compilation.

## Description

Ce programme lit des valeurs de pH depuis un tableau. Il peut rencontrer deux
types d'erreurs différentes :

- Une valeur mal formatée (`"abc"`) lève une `NumberFormatException`.
- Un index hors limites (le tableau de labels est plus court que celui des
  valeurs) lève une `ArrayIndexOutOfBoundsException`.

Les deux blocs `catch` gèrent chaque cas séparément avec un message adapté.

## Code

Le fichier `PlusieursCatch.java` contient le programme complet.

## Sortie attendue

```
=== Lecture des valeurs de pH ===
Niveau normal : pH = 7.2
Format invalide pour l'entrée : For input string: "abc"
Index hors limites : Index 2 out of bounds for length 2
Index hors limites : Index 3 out of bounds for length 2
Lecture terminée.
```

## Points clés à retenir

- Placer les types les **plus spécifiques en premier** (p. ex.
  `NumberFormatException` avant `RuntimeException`).
- Le compilateur refuse un bloc `catch` dont le type est déjà capturé par un
  bloc précédent.
- Chaque `catch` traite un scénario d'erreur distinct, avec un message adapté.

---

**Exemple précédent :** [02-try-catch-base](../02-try-catch-base/)

**Exemple suivant :** [04-multi-catch-et-finally](../04-multi-catch-et-finally/)
