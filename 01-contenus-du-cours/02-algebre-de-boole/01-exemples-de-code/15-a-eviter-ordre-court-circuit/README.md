# Exemple 15 - À éviter : Ordre court-circuit incorrect

**Objectif pédagogique :** comprendre l'importance de l'ordre des conditions
avec les opérateurs court-circuit (`&&` et `||`).

**Concepts illustrés :**

- Risque de NullPointerException avec ordre incorrect
- Ordre optimal pour l'évaluation court-circuit
- Protection contre les erreurs d'exécution
- Performance et sécurité du code

## Description

Les opérateurs `&&` et `||` utilisent l'évaluation court-circuit : ils
s'arrêtent dès que le résultat est déterminé. L'ordre des conditions est donc
crucial pour éviter les erreurs et optimiser les performances.

**❌ Problème :**

```java
// DANGER : NullPointerException si text est null
if (text.length() > 0 && text != null) {
    // ...
}
```

**✓ Solution :**

```java
// Sûr : vérifie null AVANT d'utiliser l'objet
if (text != null && text.length() > 0) {
    // ...
}
```

## Code

Le fichier `Example.java` démontre différents cas où l'ordre incorrect des
conditions cause des erreurs ou réduit les performances.

## Points clés à retenir

- Avec `&&` : la condition la plus restrictive en premier évite des calculs
- Avec `&&` : vérifiez null AVANT d'appeler des méthodes sur l'objet
- Avec `||` : la condition la plus probable en premier améliore les performances
- L'ordre incorrect peut causer des NullPointerException
- L'ordre incorrect peut causer des divisions par zéro
- Pensez à la sécurité ET à la performance

## Suggestions de réflexion

Pour choisir le bon ordre :

1. Pour `&&` : placez les vérifications de sécurité (null, limites) en premier
2. Pour `&&` : placez les tests rapides avant les tests coûteux
3. Pour `||` : placez les conditions les plus probables en premier
4. Testez mentalement ce qui se passe si la première condition échoue

---

**Exemple suivant :**
[16-a-eviter-expression-complexe](../16-a-eviter-expression-complexe/README.md)
