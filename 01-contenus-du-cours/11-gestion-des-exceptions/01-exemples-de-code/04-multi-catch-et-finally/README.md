# Exemple 04 - Multi-catch et finally

**Objectif pédagogique :** comprendre la syntaxe multi-catch et le rôle du bloc
`finally`.

**Concepts illustrés :**

- Syntaxe multi-catch avec `|` pour regrouper plusieurs types.
- Le bloc `finally` s'exécute dans tous les cas (succès ou erreur).
- Cas d'usage du `finally` : compteur, nettoyage, journalisation.
- La variable `e` dans un multi-catch est implicitement `final`.

## Description

Ce programme reprend le scénario de l'exemple 03, mais regroupe les deux
exceptions dans un seul `catch` avec `|`. Un bloc `finally` incrémente un
compteur à chaque tentative de lecture, qu'elle ait réussi ou échoué.

Le multi-catch est approprié ici car le traitement des deux erreurs est
**identique** : afficher un message générique. Si les traitements devaient
différer, deux blocs `catch` séparés seraient préférables.

## Code

Le fichier `MultiCatchEtFinally.java` contient le programme complet.

## Sortie attendue

```
=== Lecture des valeurs de pH ===
Niveau normal : pH = 7.2
Tentatives de lecture : 1
Erreur de lecture : For input string: "abc"
Tentatives de lecture : 2
Erreur de lecture : Index 2 out of bounds for length 2
Tentatives de lecture : 3
Erreur de lecture : Index 3 out of bounds for length 2
Tentatives de lecture : 4
Total des tentatives : 4
```

## Points clés à retenir

- `catch (TypeA | TypeB e)` : traite les deux types de façon identique.
- `finally` est utile pour le nettoyage de ressources, la journalisation ou le
  décompte.
- Le bloc `finally` s'exécute même si une exception est levée et non capturée
  (remonte la pile d'appels après `finally`).
- Utiliser le multi-catch uniquement si le traitement est vraiment identique.

---

**Exemple précédent :** [03-plusieurs-catch](../03-plusieurs-catch/)

**Exemple suivant :** [05-throw-et-throws](../05-throw-et-throws/)
