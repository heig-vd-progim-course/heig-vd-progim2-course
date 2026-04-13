# À éviter 12 - Types bruts (raw types)

**À éviter :** utiliser des types bruts au lieu de types génériques paramétrés.

**Concepts concernés :**

- Types bruts (`ArrayList` au lieu de `ArrayList<String>`)
- Sûreté de typage
- `ClassCastException` à l'exécution

## Description

Cet exemple montre les problèmes causés par l'utilisation de collections sans
type paramétré. Sans générique, le compilateur ne peut pas vérifier les types et
des erreurs surviennent à l'exécution au lieu d'être détectées à la compilation.

> [!WARNING]
>
> Ce code est volontairement incorrect. Ne le copiez jamais dans vos projets.
> Utilisez toujours les types génériques (`List<String>`, `Set<Integer>`, etc.).

## Code

Le fichier `RawTypeDemo.java` contient l'exemple incorrect et la correction.

## Sortie attendue

```
=== ERREUR : utilisation de types bruts ===
Ajout de différents types dans la même liste...
Contenu : [Tomate, 42, true]

Tentative de parcours en tant que String...
Element : Tomate
ClassCastException attrapée !
Message : class java.lang.Integer cannot be cast to class java.lang.String

=== SOLUTION : utiliser les types génériques ===
Liste typée créée avec succès.
Contenu : [Tomate, Carotte, Basilic]
Chaque élément est garanti être un String.
```

## Points clés à retenir

- **Toujours** spécifier le type générique : `List<String>`, pas `List`.
- Les types bruts empêchent le compilateur de détecter les erreurs de type.
- Sans générique, les erreurs surviennent à l'exécution (`ClassCastException`)
  au lieu d'être détectées à la compilation.

---

**Voir aussi :** [01-arraylist-base](../01-arraylist-base/) pour la bonne
pratique avec les génériques.
