# Exemple 02 - LinkedList

**Objectif pédagogique :** comprendre les différences entre `ArrayList` et
`LinkedList`.

**Concepts illustrés :**

- Création d'une `LinkedList`
- Polymorphisme d'implémentation (même interface `List`)
- Opérations spécifiques : ajout/suppression au début et à la fin

## Description

Cet exemple montre que `LinkedList` s'utilise de la même manière qu'`ArrayList`
car les deux implémentent l'interface `List`. Le code appelant est identique,
seule la création change. L'exemple illustre aussi les méthodes spécifiques de
`LinkedList` pour ajouter ou supprimer au début et à la fin.

## Code

Le fichier `LinkedListDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```
=== LinkedList : file de tâches ===
Tâches : [Arroser les tomates, Récolter les carottes, Planter du basilic]

Ajout en début de liste : Préparer le compost
Ajout en fin de liste : Ranger les outils
Tâches : [Préparer le compost, Arroser les tomates, Récolter les carottes, Planter du basilic, Ranger les outils]

Première tâche : Préparer le compost
Dernière tâche : Ranger les outils

Suppression de la première tâche...
Suppression de la dernière tâche...
Tâches restantes : [Arroser les tomates, Récolter les carottes, Planter du basilic]
```

## Points clés à retenir

- `LinkedList` et `ArrayList` implémentent la même interface `List`.
- Le code qui utilise `List` fonctionne avec les deux implémentations.
- `LinkedList` offre des méthodes supplémentaires : `addFirst()`, `addLast()`,
  `removeFirst()`, `removeLast()`.
- En cas de doute, préférez `ArrayList` pour la majorité des cas.

---

**Exemple suivant :** [03-hashset-unicite](../03-hashset-unicite/)
