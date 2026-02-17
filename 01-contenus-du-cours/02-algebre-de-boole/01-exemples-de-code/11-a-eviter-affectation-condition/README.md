# Exemple 11 - À éviter : Affectation dans une condition

**Objectif pédagogique :** comprendre pourquoi l'affectation (`=`) dans une
condition est une erreur courante et dangereuse.

**Concepts illustrés :**

- Confusion entre affectation (`=`) et comparaison (`==`)
- Impact d'une affectation dans une condition
- Erreur de compilation en Java
- Bonne pratique : utiliser `==` pour les comparaisons

## Description

Une erreur fréquente en programmation est de confondre l'opérateur d'affectation
`=` avec l'opérateur de comparaison `==`. Cette erreur est particulièrement
problématique dans les structures conditionnelles.

**❌ Problème :**

```java
if (isReady = true) {  // ERREUR : affectation au lieu de comparaison
    // ...
}
```

**✓ Solution :**

```java
if (isReady == true) {  // Comparaison correcte (ou mieux : if (isReady))
    // ...
}
```

En Java, cette erreur produit généralement une erreur de compilation car le
résultat d'une affectation n'est pas directement utilisable comme condition
(sauf pour les booléens, où c'est syntaxiquement valide mais sémantiquement
incorrect).

## Code

Le fichier `Example.java` contient du code commenté illustrant cette erreur et
sa correction. Le code erroné est commenté pour éviter les erreurs de
compilation.

## Points clés à retenir

- `=` est l'opérateur d'affectation, `==` est l'opérateur de comparaison
- Une affectation modifie la variable, elle ne la teste pas
- En Java, `if (isReady = true)` compile mais affecte toujours `true`
- La condition devient toujours vraie, masquant les bugs
- Pour une variable booléenne, utilisez directement `if (isReady)`
- Si vous devez comparer explicitement, utilisez `==` : `if (isReady == false)`

## Suggestions de réflexion

Pour éviter cette erreur :

1. Utilisez directement les variables booléennes sans comparaison
2. Configurez votre IDE pour détecter ces erreurs
3. Relisez attentivement vos conditions
4. Comprenez la différence entre affectation et comparaison

---

**Exemple suivant :**
[12-a-eviter-comparaison-redondante](../12-a-eviter-comparaison-redondante/README.md)
