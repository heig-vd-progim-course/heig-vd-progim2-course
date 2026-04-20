# Exemple 05 - Interface fonctionnelle Function

**Objectif pédagogique :** comprendre l'interface fonctionnelle `Function` et sa
méthode `apply` pour transformer des valeurs.

**Concepts illustrés :**

- Interface `Function<T, R>` et sa méthode `apply()`.
- Transformation d'une liste avec `Function`.
- Interface `Consumer<T>` et sa méthode `accept()`.

## Description

Cet exemple montre comment utiliser `Function<T, R>` pour transformer des
valeurs d'un type à un autre. Un `Function` prend un argument de type `T` et
retourne un résultat de type `R`.

## Code

Le fichier `FunctionDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```text
=== Function : transformation de valeurs ===
Noms : [Alice, Bob, Charlotte, Eve]

Longueurs des noms :
  Alice -> 5
  Bob -> 3
  Charlotte -> 9
  Eve -> 3

En majuscules :
  Alice -> ALICE
  Bob -> BOB
  Charlotte -> CHARLOTTE
  Eve -> EVE

Avec Consumer (affichage personnalisé) :
  >>> Alice <<<
  >>> Bob <<<
  >>> Charlotte <<<
  >>> Eve <<<
```
