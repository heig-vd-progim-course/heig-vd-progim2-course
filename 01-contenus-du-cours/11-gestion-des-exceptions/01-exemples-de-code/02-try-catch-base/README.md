# Exemple 02 - Bloc try-catch de base

**Objectif pédagogique :** comprendre la structure `try-catch` et son effet sur
le flux d'exécution.

**Concepts illustrés :**

- Structure `try { ... } catch (ExceptionType e) { ... }`.
- Le bloc `catch` n'est exécuté que si l'exception correspondante est levée.
- Le programme continue après le bloc `try-catch`.
- Accès au message de l'exception via `e.getMessage()`.

## Description

Ce programme reprend le programme de l'exemple 01, mais entoure l'appel à
`Double.parseDouble()` d'un bloc `try-catch`. Quand la valeur `"abc"` est
rencontrée, l'exception est capturée et un message d'erreur métier est affiché.
La boucle continue avec la valeur suivante.

## Code

Le fichier `TryCatchBase.java` contient le programme complet.

## Sortie attendue

```
=== Lecture des valeurs de pH ===
pH lu : 7.2
Fin de traitement de : 7.2
Valeur invalide : 'abc' - For input string: "abc"
Fin de traitement de : abc
pH lu : 13.5
Fin de traitement de : 13.5
Lecture terminée.
```

## Points clés à retenir

- Le code dans `try` s'arrête à la ligne qui lève l'exception.
- Le bloc `catch` prend le relais uniquement en cas d'erreur.
- Le code après le bloc `try-catch` (ici, `System.out.println(...)`) s'exécute
  dans tous les cas.
- `getMessage()` retourne le message court de l'exception.
- `e.printStackTrace()` afficherait la trace complète (utile en développement).

---

**Exemple précédent :** [01-programme-fragile](../01-programme-fragile/)

**Exemple suivant :** [03-plusieurs-catch](../03-plusieurs-catch/)
