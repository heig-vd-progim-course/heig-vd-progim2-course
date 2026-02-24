# Exemple 01 - Classe simple avec attributs

**Objectif pédagogique :** comprendre comment déclarer une classe avec des
attributs en Java.

**Concepts illustrés :**

- Déclaration d'une classe avec le mot-clé `class`
- Attributs (variables d'instance)
- Types de données (String, int, double)
- Plusieurs classes dans un même fichier

## Description

Cet exemple montre comment déclarer une classe simple avec des attributs. Une
classe est un modèle qui définit les propriétés (attributs) que les objets de
cette classe auront.

La classe `Product` représente un produit avec un nom, un prix et une quantité
en stock.

**Point important** : ce fichier contient **deux classes** (`Product` et `Main`)
dans un seul fichier. En Java, c'est possible, mais une seule classe peut être
`public` et doit porter le nom du fichier. Ici, `Main` est publique et `Product`
n'est pas publique.

À ce stade, nous ne créons pas encore d'objets, nous montrons seulement la
structure d'une classe.

## Code

Le fichier `Main.java` contient **deux classes** :

- La classe `Product` avec trois attributs
- La classe `Main` avec la méthode principale

**Note** : Le fichier s'appelle `Main.java` car c'est la classe `Main` qui est
publique. En Java, le nom du fichier doit correspondre au nom de la classe
publique.

## Sortie attendue

```text
Ce fichier contient deux classes: Product et Main
La classe Product définit le modèle d'un produit.
Dans les prochains exemples, nous créerons des objets.
```

## Points clés à retenir

- Une classe se déclare avec le mot-clé `class`
- Les attributs sont des variables déclarées dans la classe
- Chaque attribut a un type (String, int, double, etc.)
- Une classe est un modèle, pas encore un objet concret
- Le nom de la classe commence par une majuscule (convention PascalCase)
- **On peut avoir plusieurs classes dans un même fichier**
- Seule la classe `public` doit porter le nom du fichier

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Ajouter d'autres attributs (par exemple : `String category`,
   `boolean isAvailable`)
2. Créer une autre classe similaire dans le même fichier (par exemple : `Book`
   avec titre, auteur, pages)
3. Essayer de rendre `Product` publique et observer l'erreur (un seul
   `public class` par fichier)
4. Observer comment Java organise les attributs dans la classe

---

**Exemple suivant :** [02-classe-avec-methodes](../02-classe-avec-methodes/)
