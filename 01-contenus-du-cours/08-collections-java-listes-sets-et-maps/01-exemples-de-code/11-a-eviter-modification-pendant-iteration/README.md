# À éviter 11 - Modification pendant l'itération

**À éviter :** modifier une collection avec `collection.remove()` pendant une
boucle `for-each`.

**Concepts concernés :**

- `ConcurrentModificationException`
- Boucle `for-each` et modification concurrente
- Solution correcte avec `Iterator.remove()`

## Description

Cet exemple montre l'erreur classique qui consiste à supprimer un élément d'une
collection pendant une boucle `for-each`. Java détecte la modification
concurrente et lève une `ConcurrentModificationException`. Le fichier montre
aussi la solution correcte avec un itérateur.

> [!WARNING]
>
> Ce code est volontairement incorrect. Ne le copiez jamais dans vos projets.
> Consultez l'[exemple 08](../08-iterateur-suppression/) pour la bonne approche.

## Code

Le fichier `ConcurrentModificationDemo.java` contient l'exemple incorrect et la
correction.

## Sortie attendue

```
=== ERREUR : modification pendant for-each ===
Plantes avant : [Tomate, Carotte, Thym, Basilic, Tournesol]
Tentative de suppression pendant for-each...
ConcurrentModificationException attrapée !
Message : null

=== SOLUTION : utiliser Iterator.remove() ===
Plantes avant : [Tomate, Carotte, Thym, Basilic, Tournesol]
Suppression avec itérateur...
Plantes après : [Carotte, Basilic]
```

## Points clés à retenir

- **Ne jamais** appeler `list.remove()` dans une boucle `for-each`.
- Utiliser `Iterator it = list.iterator()` et `it.remove()` à la place.
- Cette erreur est fréquente chez les débutants : mémorisez la règle !

---

**Voir aussi :** [08-iterateur-suppression](../08-iterateur-suppression/) pour
la bonne pratique.
