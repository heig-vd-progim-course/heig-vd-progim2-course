# Exemple 03 - Constructeur simple

**Objectif pédagogique :** comprendre le rôle d'un constructeur et comment
l'utiliser pour initialiser les objets.

**Concepts illustrés :**

- Déclaration d'un constructeur
- Initialisation des attributs via le constructeur
- Utilisation du mot-clé `this` pour différencier attributs et paramètres
- Convention de nommage : constructeur = nom de la classe

## Description

Cet exemple ajoute un constructeur à la classe `Product`. Un constructeur est
une méthode spéciale qui est appelée automatiquement lors de la création d'un
objet avec le mot-clé `new`.

Le constructeur garantit que chaque objet `Product` est créé avec des valeurs
initiales valides pour ses attributs.

## Code

Les fichiers contiennent :

- `Product.java` : classe avec constructeur
- `Main.java` : programme principal qui crée un objet

## Sortie attendue

```text
=== Informations du produit ===
Nom: Clavier mécanique
Prix: 129.9 CHF
Quantité en stock: 15
================================
```

## Points clés à retenir

- Un constructeur a le même nom que la classe
- Un constructeur n'a pas de type de retour (même pas `void`)
- Le mot-clé `this` distingue les attributs des paramètres
- Le constructeur est appelé automatiquement avec `new`
- Il garantit que l'objet est créé dans un état valide

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Créer plusieurs objets avec des valeurs différentes
2. Modifier le constructeur pour ajouter des valeurs par défaut
3. Retirer `this.` et observer les erreurs de compilation
4. Créer un constructeur sans paramètres (constructeur par défaut)

---

**Exemple précédent :** [02-classe-avec-methodes](../02-classe-avec-methodes/)

**Exemple suivant :** [04-instanciation-objets](../04-instanciation-objets/)
