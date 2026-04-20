# Exemple 12 - A éviter : instanceof avec des génériques

**Objectif pédagogique :** comprendre pourquoi `instanceof` ne fonctionne pas
avec des paramètres de type génériques à cause de l'effacement de type.

**Concepts illustrés :**

- Effacement de type (type erasure).
- Impossibilité d'utiliser `instanceof` avec un type paramétré.
- Impossibilité de créer un tableau de type générique.

## Description

Cet exemple montre les limitations des génériques Java dues à l'effacement de
type. À l'exécution, `List<String>` et `List<Integer>` deviennent simplement
`List`. Il est donc impossible de tester le type paramétré avec `instanceof`.

## Code

Le fichier `TypeErasureAntiPattern.java` contient un exemple commenté.

## Sortie attendue

```text
=== A éviter : instanceof avec génériques ===

--- Effacement de type ---
box1 est de type : Box
box2 est de type : Box
Même classe ? true

--- Limitations ---
On ne peut pas écrire : if (list instanceof List<String>)
On ne peut pas écrire : new T() ou new T[]
On peut seulement tester : if (list instanceof List<?>)
list est une List<?> : true
```
