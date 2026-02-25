# Exemple 02 - Classe avec méthodes

**Objectif pédagogique :** comprendre comment ajouter des méthodes à une classe
pour définir ses comportements.

**Concepts illustrés :**

- Déclaration de méthodes dans une classe
- Méthode `void` (sans valeur de retour)
- Accès aux attributs depuis une méthode
- Utilisation de `System.out.println()` dans les méthodes
- Plusieurs classes dans un même fichier
- Création d'un premier objet

## Description

Cet exemple ajoute des méthodes à la classe `Product`. Une méthode définit un
comportement que les objets de la classe peuvent effectuer.

La méthode `displayInfo()` affiche les informations du produit. Elle accède aux
attributs de la classe pour afficher leurs valeurs.

**Points importants** :

- Ce fichier contient **deux classes** (`Product` et `Main`)
- La classe `Main` crée un objet `Product` et appelle sa méthode
- Les attributs sont affectés directement (pas encore de constructeur)

## Code

Le fichier `Main.java` contient **deux classes** :

- La classe `Product` avec attributs et méthodes
- La classe `Main` qui crée un objet et appelle la méthode

**Note** : Le fichier s'appelle `Main.java` car c'est la classe `Main` qui est
publique. La classe `Product` n'est pas publique, elle est accessible uniquement
dans ce fichier.

## Sortie attendue

```text
Démonstration: deux classes dans un fichier

=== Informations du produit ===
Nom: Ordinateur portable
Prix: 899.9 CHF
Quantité en stock: 5
================================
```

## Points clés à retenir

- Une méthode définit un comportement de la classe
- Le mot-clé `void` indique qu'une méthode ne retourne pas de valeur
- Les méthodes peuvent accéder directement aux attributs de la classe
- Une méthode se déclare à l'intérieur de la classe
- Le nom de la méthode commence par une minuscule (convention camelCase)
- **On peut avoir plusieurs classes dans un fichier** (comme Product et Main)
- On crée un objet avec `new` et on appelle ses méthodes avec `.`

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Ajouter une autre méthode (par exemple : `displayPrice()` qui affiche
   seulement le prix)
2. Créer une méthode `displaySummary()` qui affiche un résumé en une ligne
3. Créer plusieurs objets `Product` avec des valeurs différentes
4. Ajouter une troisième classe dans le fichier (non publique)
5. Observer comment les méthodes accèdent aux attributs sans paramètres
   supplémentaires

---

**Exemple précédent :** [01-classe-simple](../01-classe-simple/)

**Exemple suivant :** [03-constructeur-simple](../03-constructeur-simple/)
