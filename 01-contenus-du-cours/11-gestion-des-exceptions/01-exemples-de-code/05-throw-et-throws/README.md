# Exemple 05 - throw et throws

**Objectif pédagogique :** comprendre comment lancer une exception avec `throw`
et déclarer des exceptions propagées avec `throws`.

**Concepts illustrés :**

- Lancer une exception avec `throw new ExceptionType(message)`.
- Déclarer une exception vérifiée dans la signature avec `throws`.
- L'exécution s'arrête immédiatement après `throw`.
- Différence entre `throw` (lancement) et `throws` (déclaration).

## Description

La classe `WaterSensor` illustre deux usages distincts :

- Le **constructeur** utilise `throw` pour rejeter une valeur de pH invalide. Si
  le pH est hors de la plage [0.0 ; 14.0], une `IllegalArgumentException` est
  lancée. C'est une exception non vérifiée : l'appelant n'est pas obligé de la
  capturer.

- La méthode `readFromString()` déclare `throws Exception` dans sa signature.
  Cela oblige le compilateur à vérifier que l'appelant gère ou propage
  l'exception. C'est une exception vérifiée.

## Code

Le fichier `ThrowEtThrows.java` contient les deux classes.

## Sortie attendue

```
=== Test du throw dans le constructeur ===
Capteur créé : PH-01 (pH = 7.2)
Erreur : Valeur de pH invalide : 15.0 (attendu entre 0.0 et 14.0)

=== Test du throws dans readFromString ===
Lecture OK : pH = 8.5
Erreur : Valeur de pH hors plage : 15.0 pour le capteur PH-01
```

## Points clés à retenir

- `throw` est un mot-clé utilisé dans le corps d'une méthode pour lancer une
  instance d'exception.
- `throws` est déclaré dans la signature de la méthode pour indiquer qu'une
  exception vérifiée peut être propagée.
- L'exécution s'arrête immédiatement après `throw` : les lignes suivantes dans
  le bloc `try` ne sont pas exécutées.
- Une exception non vérifiée (`RuntimeException`) n'a pas besoin d'être déclarée
  avec `throws`.

---

**Exemple précédent :**
[04-multi-catch-et-finally](../04-multi-catch-et-finally/)

**Exemple suivant :**
[06-exception-personnalisee](../06-exception-personnalisee/)
