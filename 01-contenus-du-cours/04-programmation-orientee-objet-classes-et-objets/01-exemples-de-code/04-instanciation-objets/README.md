# Exemple 04 - Instanciation de plusieurs objets

**Objectif pédagogique :** comprendre comment créer et manipuler plusieurs
objets d'une même classe.

**Concepts illustrés :**

- Création de plusieurs instances d'une classe
- Le mot-clé `new` pour l'instanciation
- Indépendance des objets (chaque objet a ses propres valeurs)
- Accès aux méthodes et attributs avec l'opérateur point (`.`)

## Description

Cet exemple montre comment créer plusieurs objets à partir d'une même classe.
Chaque objet est une instance indépendante avec ses propres valeurs d'attributs.

Le programme crée trois objets `Product` différents et affiche leurs
informations. Cela illustre qu'une classe est un modèle réutilisable pour créer
autant d'objets que nécessaire.

## Code

Les fichiers contiennent :

- `Product.java` : classe Product (identique à l'exemple 03)
- `Main.java` : programme créant trois objets différents

## Sortie attendue

```text
=== Informations du produit ===
Nom: Clavier mécanique
Prix: 129.9 CHF
Quantité en stock: 15
================================

=== Informations du produit ===
Nom: Souris sans fil
Prix: 45.5 CHF
Quantité en stock: 28
================================

=== Informations du produit ===
Nom: Écran 27 pouces
Prix: 349.0 CHF
Quantité en stock: 8
================================
```

## Points clés à retenir

- Une classe peut créer un nombre illimité d'objets
- Chaque objet est indépendant et a ses propres valeurs
- Le mot-clé `new` alloue de la mémoire pour chaque nouvel objet
- L'opérateur point (`.`) permet d'accéder aux méthodes d'un objet
- Les variables contiennent des références vers les objets

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Créer 5 ou 10 objets différents
2. Stocker les objets dans un tableau : `Product[] products = new Product[3];`
3. Modifier les attributs d'un objet et observer que les autres ne changent pas
4. Afficher seulement certains objets selon une condition

---

**Exemple précédent :**
[03-constructeur-simple](../03-constructeur-simple/README.md)

**Exemple suivant :** [05-mot-cle-this](../05-mot-cle-this/README.md)
