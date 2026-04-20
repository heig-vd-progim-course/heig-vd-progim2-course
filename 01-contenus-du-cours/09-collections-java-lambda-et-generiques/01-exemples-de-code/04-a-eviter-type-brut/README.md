# Exemple 11 - A éviter : type brut (raw type)

**Objectif pédagogique :** comprendre pourquoi utiliser un type brut (sans
paramètre de type) est dangereux.

**Concepts illustrés :**

- Type brut (`List` au lieu de `List<String>`).
- Perte de la vérification de type à la compilation.
- `ClassCastException` à l'exécution.

## Description

Cet exemple montre les risques d'utiliser un type brut. Sans le paramètre de
type, Java ne peut pas vérifier les types à la compilation. Le programme compile
sans erreur mais peut échouer à l'exécution.

## Code

Le fichier `RawTypeAntiPattern.java` contient un exemple commenté.

## Sortie attendue

```text
=== A éviter : type brut ===

--- Mauvaise pratique : type brut ---
Exception : class java.lang.Integer cannot be cast to class java.lang.String

--- Bonne pratique : type paramétré ---
Le compilateur empêche l'ajout d'un Integer dans List<String>.
Liste sûre : [Tomate, Basilic]
```
