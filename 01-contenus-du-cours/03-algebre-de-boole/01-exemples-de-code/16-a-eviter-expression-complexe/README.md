# Exemple 16 - À éviter : Expression complexe sans décomposition

**Objectif pédagogique :** comprendre pourquoi les expressions booléennes
complexes doivent être décomposées avec des variables intermédiaires bien
nommées.

**Concepts illustrés :**

- Impact négatif d'expressions trop complexes
- Importance des variables intermédiaires
- Amélioration de la lisibilité et maintenabilité
- Documentation implicite par les noms de variables

## Description

Une expression booléenne trop complexe est difficile à lire, comprendre,
déboguer et maintenir. La décomposition en variables intermédiaires avec des
noms explicites améliore grandement la qualité du code.

**❌ Problème :**

```java
if ((age >= 18 && age < 65 && hasLicense && !hasSuspension) ||
    (age >= 65 && hasLicense && hasMedicalCheck &&
     medicalCheckDate.isAfter(today.minusYears(1)))) {
    // Difficile à comprendre !
}
```

**✓ Solution :**

```java
boolean isAdult = age >= 18 && age < 65;
boolean isSenior = age >= 65;
boolean hasValidLicense = hasLicense && !hasSuspension;
boolean hasRecentMedical = hasMedicalCheck &&
                           medicalCheckDate.isAfter(today.minusYears(1));
boolean canDrive = (isAdult && hasValidLicense) ||
                   (isSenior && hasValidLicense && hasRecentMedical);

if (canDrive) {
    // Beaucoup plus clair !
}
```

## Code

Le fichier `Example.java` démontre différents cas d'expressions complexes et
comment les décomposer pour améliorer la lisibilité.

## Points clés à retenir

- Une expression complexe est difficile à lire d'un seul coup d'œil
- Les variables intermédiaires servent de documentation
- Chaque variable intermédiaire devrait avoir un nom significatif
- La décomposition facilite le débogage (on peut afficher chaque partie)
- La décomposition facilite les tests unitaires
- Un bon nom de variable vaut mieux qu'un commentaire

## Suggestions de réflexion

Pour décomposer une expression complexe :

1. Identifiez les sous-conditions logiques cohérentes
2. Créez des variables intermédiaires avec des noms descriptifs
3. Utilisez des verbes ou adjectifs clairs (`canAccess`, `isValid`)
4. Préférez plusieurs lignes claires à une ligne complexe
5. Testez que la décomposition ne change pas la logique

---

**Retour aux exemples de bonnes pratiques :**
[01-declaration-boolean](../01-declaration-boolean/README.md)
