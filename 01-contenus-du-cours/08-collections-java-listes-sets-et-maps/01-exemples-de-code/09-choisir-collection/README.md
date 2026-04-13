# Exemple 09 - Choisir la bonne collection

**Objectif pédagogique :** illustrer le choix de la bonne collection selon le
besoin dans un contexte réaliste.

**Concepts illustrés :**

- Utilisation combinée de `ArrayList`, `HashSet` et `HashMap`
- Choix de collection selon le contexte
- Programmation vers l'interface

## Description

Cet exemple complet montre un jardin communautaire utilisant simultanément une
`ArrayList` pour les tâches du jour (ordonnées), un `HashSet` pour les espèces
disponibles (unicité) et une `HashMap` pour les attributions de parcelles
(association clé-valeur). Chaque collection est choisie en fonction du besoin
spécifique.

## Code

Le fichier `CollectionChoiceDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```
=== Jardin communautaire : choix des collections ===

--- Tâches du jour (ArrayList : ordre important) ---
1. Arroser les tomates
2. Récolter les carottes
3. Planter du basilic
4. Préparer le compost

--- Espèces disponibles (HashSet : unicité) ---
Espèces : [Tomate, Carotte, Menthe, Basilic] (ordre variable)
Nombre d'espèces uniques : 4
La Tomate est disponible : true

--- Attributions (HashMap : association clé-valeur) ---
Alice -> Parcelle A1
Bob -> Parcelle B2
Clara -> Parcelle A3

=== Résumé ===
4 tâches à réaliser
4 espèces disponibles
3 parcelles attribuées
```

## Points clés à retenir

- `ArrayList` pour les éléments ordonnés (tâches à faire dans l'ordre).
- `HashSet` pour les éléments uniques (catalogue d'espèces sans doublons).
- `HashMap` pour les associations clé-valeur (jardinière et sa parcelle).
- Chaque collection répond à un besoin différent. Il n'y a pas de collection
  universelle.

---

**Contre-exemples :**
[11-a-eviter-modification-pendant-iteration](../11-a-eviter-modification-pendant-iteration/)
