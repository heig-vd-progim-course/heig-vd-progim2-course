# Exemple 08 - Exemple complet

**Objectif pédagogique :** intégrer tous les concepts vus dans les exemples
précédents dans une application complète.

**Concepts illustrés :**

- Classe avec attributs, constructeur, et méthodes
- Méthodes avec et sans valeur de retour
- Modification de l'état d'un objet
- Utilisation du mot-clé `this`
- Création et manipulation de plusieurs objets
- Interactions entre objets

## Description

Cet exemple complet intègre tous les concepts de programmation orientée objet
vus précédemment. Il représente un système de gestion de bibliothèque avec des
livres que l'on peut emprunter et retourner.

La classe `Book` combine :

- Des attributs pour stocker les informations
- Un constructeur pour initialiser les objets
- Des méthodes de consultation (getters)
- Des méthodes de modification d'état (borrow, returnBook)
- Des validations
- Utilisation de `this`

## Code

Les fichiers contiennent :

- `Book.java` : classe complète avec tous les concepts
- `Main.java` : programme démontrant une utilisation réaliste

## Sortie attendue

```text
=== Bibliothèque ===

--- Livre 1 ---
Titre: Le Petit Prince
Auteur: Antoine de Saint-Exupéry
Pages: 96
Disponible: Oui

--- Livre 2 ---
Titre: 1984
Auteur: George Orwell
Pages: 328
Disponible: Oui

--- Livre 3 ---
Titre: Le Seigneur des Anneaux
Auteur: J.R.R. Tolkien
Pages: 1178
Disponible: Oui

=== Emprunt de livres ===

Le livre "Le Petit Prince" a été emprunté avec succès.

Le livre "1984" a été emprunté avec succès.

Impossible d'emprunter "Le Petit Prince": le livre n'est pas disponible.

=== État actuel ===

--- Livre 1 ---
Titre: Le Petit Prince
Auteur: Antoine de Saint-Exupéry
Pages: 96
Disponible: Non

--- Livre 2 ---
Titre: 1984
Auteur: George Orwell
Pages: 328
Disponible: Non

--- Livre 3 ---
Titre: Le Seigneur des Anneaux
Auteur: J.R.R. Tolkien
Pages: 1178
Disponible: Oui

=== Retour de livres ===

Le livre "Le Petit Prince" a été retourné avec succès.

=== État final ===

--- Livre 1 ---
Titre: Le Petit Prince
Auteur: Antoine de Saint-Exupéry
Pages: 96
Disponible: Oui

Nombre total de pages: 1602
```

## Points clés à retenir

- Une classe bien conçue combine attributs, constructeur et méthodes
- Les méthodes peuvent consulter ou modifier l'état
- Les validations garantissent la cohérence de l'état
- Le mot-clé `this` améliore la clarté du code
- Les objets peuvent interagir entre eux
- Un bon design facilite la maintenance et l'évolution

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Ajouter un attribut `borrower` (String) pour savoir qui a emprunté le livre
2. Créer une méthode `extendLoan()` pour prolonger un emprunt
3. Implémenter un système de notation (rating) pour les livres
4. Ajouter une classe `Library` qui gère une collection de livres
5. Créer une classe `Member` pour représenter les personnes qui empruntent

---

**Exemple précédent :** [07-modification-etat](../07-modification-etat/)

**Suite du cours :** [Exercices](../../02-exercices/) •
[Mini-projet](../../03-mini-projet/)
