# Exemple 08 - Condition complexe

**Objectif pédagogique :** maîtriser la structure `if-else if-else` pour gérer
plusieurs alternatives selon différentes conditions.

**Concepts illustrés :**

- Structure `if-else if-else`
- Cascade de conditions mutuellement exclusives
- Combinaison de plusieurs opérateurs booléens
- Utilisation de parenthèses pour la clarté

## Description

La structure `if-else if-else` permet de tester plusieurs conditions successives
et d'exécuter le bloc correspondant à la première condition vraie. C'est une
extension du `if-else` pour gérer plus de deux alternatives.

La syntaxe est :

```java
if (condition1) {
    // Code si condition1 est vraie
} else if (condition2) {
    // Code si condition1 est fausse et condition2 est vraie
} else if (condition3) {
    // Code si condition1 et condition2 sont fausses et condition3 est vraie
} else {
    // Code si toutes les conditions précédentes sont fausses
}
```

Seul le premier bloc dont la condition est vraie sera exécuté, puis le programme
continue après toute la structure.

## Code

Le fichier `Example.java` démontre différentes situations avec des conditions
complexes utilisant plusieurs opérateurs booléens et parenthèses.

## Sortie attendue

```
=== Structure if-else if-else ===

Test 1 : Classification de note
score: 92
Mention: Excellent

score: 75
Mention: Bien

score: 55
Mention: Passable

score: 42
Mention: Insuffisant

Test 2 : Calcul de tarif avec conditions complexes
age: 5, isStudent: false, hasCard: false
Catégorie: Enfant
Tarif: 0 CHF

age: 20, isStudent: true, hasCard: false
Catégorie: Étudiant
Tarif: 10 CHF

age: 70, isStudent: false, hasCard: false
Catégorie: Senior
Tarif: 8 CHF

age: 35, isStudent: false, hasCard: true
Catégorie: Membre avec carte
Tarif: 12 CHF

age: 30, isStudent: false, hasCard: false
Catégorie: Adulte
Tarif: 15 CHF

Test 3 : Validation de données avec expressions complexes
temperature: 22.0, humidity: 55, hasVentilation: true
Conditions de stockage: Optimales

temperature: 18.0, humidity: 65, hasVentilation: true
Conditions de stockage: Acceptables

temperature: 28.0, humidity: 80, hasVentilation: false
Conditions de stockage: Non conformes
```

## Points clés à retenir

- `if-else if-else` teste les conditions dans l'ordre, de haut en bas
- Seul le premier bloc dont la condition est vraie sera exécuté
- Les conditions suivantes ne sont pas testées une fois qu'une est vraie
- Le bloc `else` final est optionnel mais recommandé
- Utilisez des parenthèses pour clarifier les expressions complexes
- L'ordre des conditions est important pour la performance et la logique

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Modifier les valeurs pour voir les différentes branches s'exécuter.
2. Changer l'ordre des conditions et observer l'impact.
3. Ajouter ou retirer des parenthèses pour voir l'importance de la priorité.
4. Ajouter de nouvelles conditions intermédiaires.

---

**Exemple suivant :**
[11-a-eviter-affectation-condition](../11-a-eviter-affectation-condition/README.md)
