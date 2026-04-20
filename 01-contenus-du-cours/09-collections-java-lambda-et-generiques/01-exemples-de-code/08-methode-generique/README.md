# Exemple 08 - Méthode générique

**Objectif pédagogique :** comprendre comment déclarer une méthode générique
indépendante de la classe.

**Concepts illustrés :**

- Déclaration d'une méthode générique avec `<T>` avant le type de retour.
- Inférence de type lors de l'appel.
- Méthode générique dans une classe non générique.

## Description

Cet exemple montre comment créer des méthodes génériques. Le paramètre de type
est déclaré au niveau de la méthode (pas de la classe), ce qui permet de
l'utiliser dans des classes ordinaires ou des méthodes statiques.

## Code

Le fichier `GenericMethodDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```text
=== Méthode générique ===
Premier élément (String) : Tomate
Premier élément (Integer) : 10
Premier élément (Double) : 3.14

=== Affichage générique ===
Tableau de String :
  - Alice
  - Bob
  - Charlotte

Tableau de Integer :
  - 1
  - 2
  - 3
```
