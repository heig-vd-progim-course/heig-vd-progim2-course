# Exemple 14 - À éviter : Négations multiples

**Objectif pédagogique :** comprendre pourquoi les négations multiples nuisent à
la lisibilité et comment les simplifier.

**Concepts illustrés :**

- Difficulté de lecture des négations multiples
- Application des lois de De Morgan pour simplifier
- Impact sur la compréhension du code
- Importance de la clarté dans les conditions

## Description

Les négations multiples rendent le code difficile à lire et augmentent le risque
d'erreurs logiques. Elles peuvent souvent être simplifiées en utilisant les lois
de De Morgan ou en reformulant la condition.

**❌ Problème :**

```java
if (!(!(isReady))) {                        // Triple négation !
    // ...
}

if (!(!hasError && !hasWarning)) {          // Difficile à comprendre
    // ...
}
```

**✓ Solution :**

```java
if (isReady) {                              // Simple et clair
    // ...
}

if (hasError || hasWarning) {               // De Morgan appliqué
    // ...
}
```

## Code

Le fichier `Example.java` démontre différents cas de négations multiples et
comment les simplifier pour améliorer la lisibilité.

## Points clés à retenir

- Chaque négation augmente la charge cognitive
- `!!variable` équivaut à `variable` (double négation = identité)
- Utilisez les lois de De Morgan pour simplifier les négations
- Préférez des noms de variables positifs (`isValid` plutôt que `isInvalid`)
- La clarté du code est prioritaire sur la "concision"
- Une condition complexe peut mériter une variable intermédiaire bien nommée

## Suggestions de réflexion

Pour éviter les négations multiples :

1. Appliquez les lois de De Morgan pour distribuer les négations
2. Utilisez des variables intermédiaires avec des noms clairs
3. Reformulez la logique pour éviter les négations
4. Préférez des conditions positives quand c'est possible

---

**Exemple suivant :**
[15-a-eviter-ordre-court-circuit](../15-a-eviter-ordre-court-circuit/README.md)
