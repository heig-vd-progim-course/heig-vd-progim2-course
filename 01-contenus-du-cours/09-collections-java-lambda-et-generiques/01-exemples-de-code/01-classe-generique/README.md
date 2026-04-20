# Exemple 07 - Classe générique

**Objectif pédagogique :** comprendre comment créer et utiliser une classe
générique avec un paramètre de type.

**Concepts illustrés :**

- Déclaration d'une classe générique `<T>`.
- Utilisation du paramètre de type dans les attributs et méthodes.
- Instanciation avec différents types concrets.
- Inférence de type avec l'opérateur diamant `<>`.

## Description

Cet exemple montre comment créer une classe `Box<T>` qui peut contenir une
valeur de n'importe quel type. Le paramètre `T` est remplacé par un type concret
lors de l'utilisation (`Box<String>`, `Box<Integer>`, etc.).

## Code

Le fichier `GenericClassDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```text
=== Classe générique ===
Boîte de String : Box[Tomate]
Valeur : Tomate

Boîte de Integer : Box[42]
Valeur : 42

Boîte de Double : Box[3.14]
Valeur : 3.14

=== Pair générique ===
Paire : (Nom, Alice)
Clé : Nom
Valeur : Alice

Paire : (Âge, 25)
Clé : Âge
Valeur : 25
```
