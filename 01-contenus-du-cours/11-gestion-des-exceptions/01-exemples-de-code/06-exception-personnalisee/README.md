# Exemple 06 - Exception personnalisée et système robuste

**Objectif pédagogique :** créer une exception personnalisée et l'intégrer dans
un programme complet combinant tous les concepts du chapitre.

**Concepts illustrés :**

- Création d'une exception vérifiée (`InvalidPhException extends Exception`).
- Deux constructeurs : avec message, et avec cause (chaînage d'exceptions).
- Déclaration `throws` dans les signatures de méthode.
- Chaînage d'exceptions pour préserver la cause originale.
- Accès à la cause avec `getCause()`.

## Description

Ce programme réunit tous les concepts du chapitre dans un système complet de
surveillance de la qualité de l'eau.

La classe `InvalidPhException` est une exception vérifiée spécifique au domaine.
Elle porte un message précis en cas de valeur de pH invalide, et peut encapsuler
une cause originale (par exemple une `NumberFormatException` quand la valeur
d'entrée n'est pas un nombre valide).

La classe `WaterSensor` déclare `throws InvalidPhException` dans ses méthodes,
forçant le code appelant à gérer les erreurs de manière explicite.

## Code

Le fichier `ExceptionPersonnalisee.java` contient les trois classes :
`InvalidPhException`, `WaterSensor` et `ExceptionPersonnalisee` (main).

## Sortie attendue

```
=== Système de surveillance de l'eau ===

--- Création du capteur ---
Capteur PH-01 initialisé.

--- Lecture des mesures ---
Lecture OK : pH = 7.2
ALERTE pH : Valeur de pH hors plage pour le capteur PH-01 : 15.0 (attendu entre 0.0 et 14.0)
ALERTE pH : Valeur de pH hors plage pour le capteur PH-01 : NaN (attendu entre 0.0 et 14.0)
  Cause : For input string: "abc"
Lecture OK : pH = 8.1

Surveillance terminée.
```

## Points clés à retenir

- Hériter d'`Exception` (pas de `RuntimeException`) rend l'exception vérifiée :
  le compilateur oblige l'appelant à la gérer.
- Le chaînage d'exceptions avec `super(message, cause)` préserve la trace de
  l'erreur originale.
- `e.getCause()` permet d'accéder à l'exception qui a causé celle-ci.
- Les exceptions personnalisées rendent le code `catch` plus expressif :
  `catch (InvalidPhException e)` est plus lisible que `catch (Exception e)`.

---

**Exemple précédent :** [05-throw-et-throws](../05-throw-et-throws/)
