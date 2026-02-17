# Exemple 07 - Condition if-else

**Objectif pédagogique :** maîtriser la structure `if-else` pour gérer deux
alternatives selon une condition.

**Concepts illustrés :**

- Structure `if-else`
- Choix entre deux alternatives exclusives
- Bloc d'instructions pour chaque branche
- Applications pratiques du branchement

## Description

La structure `if-else` permet de choisir entre deux chemins d'exécution selon
qu'une condition est vraie ou fausse. Contrairement au `if` simple, elle
garantit qu'un des deux blocs sera toujours exécuté.

La syntaxe est :

```java
if (condition) {
    // Code exécuté si la condition est vraie
} else {
    // Code exécuté si la condition est fausse
}
```

Cette structure est particulièrement utile quand on doit effectuer une action
différente selon le résultat d'un test.

## Code

Le fichier `Example.java` démontre différentes situations où `if-else` est
approprié pour gérer deux alternatives exclusives.

## Sortie attendue

```
=== Structure if-else ===

Test 1 : Nombre pair ou impair
number: 42
Le nombre est pair.

number: 17
Le nombre est impair.

Test 2 : Température et message approprié
temperature: 22.5
La température est confortable.

temperature: 15.0
La température est fraîche.

Test 3 : Accès autorisé ou refusé
age: 25, hasTicket: true
Accès autorisé.

age: 16, hasTicket: true
Accès refusé.

Test 4 : Calcul avec conditions
batteryLevel: 75
Mode normal activé.
Luminosité: 100%

batteryLevel: 15
Mode économie d'énergie activé.
Luminosité: 30%
```

## Points clés à retenir

- `if-else` garantit qu'exactement un des deux blocs sera exécuté
- Utilisez `if-else` quand vous avez deux alternatives exclusives
- Le bloc `else` gère tous les cas où la condition est fausse
- Chaque bloc peut contenir plusieurs instructions
- La structure rend le code plus clair qu'avec des `if` multiples

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Modifier les valeurs pour voir les deux branches s'exécuter.
2. Ajouter plusieurs instructions dans chaque bloc `if` et `else`.
3. Comparer avec deux `if` séparés pour comprendre la différence.

---

**Exemple suivant :**
[08-condition-complexe](../08-condition-complexe/README.md)
