# Exemple 06 - Méthodes avec valeurs de retour

**Objectif pédagogique :** comprendre comment créer et utiliser des méthodes qui
retournent des valeurs.

**Concepts illustrés :**

- Méthodes avec type de retour (autres que `void`)
- Utilisation du mot-clé `return`
- Calculs et traitements dans les méthodes
- Utilisation de la valeur retournée

## Description

Cet exemple montre comment créer des méthodes qui retournent des valeurs. Une
méthode peut effectuer des calculs ou des traitements et retourner le résultat à
la personne appelante.

La classe `Rectangle` contient des méthodes qui calculent l'aire et le périmètre
du rectangle et retournent ces valeurs.

## Code

Les fichiers contiennent :

- `Rectangle.java` : classe avec méthodes retournant des valeurs
- `Main.java` : programme utilisant les valeurs retournées

## Sortie attendue

```text
Rectangle: 5.0 x 3.0

L'aire du rectangle est: 15.0 m²
Le périmètre du rectangle est: 16.0 m

Ce rectangle est considéré comme grand.
```

## Points clés à retenir

- Une méthode peut retourner une valeur avec `return`
- Le type de retour est spécifié avant le nom de la méthode
- La valeur retournée peut être stockée dans une variable
- La valeur retournée peut être utilisée directement dans une expression
- Une méthode `void` ne retourne rien

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Créer une méthode `isSquare()` qui retourne `true` si c'est un carré
2. Ajouter une méthode `getDiagonal()` qui calcule la diagonale
3. Créer plusieurs rectangles et comparer leurs aires
4. Utiliser les valeurs retournées dans des conditions `if`

---

**Exemple précédent :** [05-mot-cle-this](../05-mot-cle-this/)

**Exemple suivant :** [07-modification-etat](../07-modification-etat/)
