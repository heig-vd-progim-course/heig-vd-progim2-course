# Exemple 06 - Condition simple

**Objectif pédagogique :** maîtriser la structure `if` simple pour exécuter du
code conditionnellement.

**Concepts illustrés :**

- Structure `if` simple
- Expression booléenne comme condition
- Bloc d'instructions conditionnel
- Comparaisons et expressions booléennes

## Description

La structure `if` permet d'exécuter un bloc de code uniquement si une condition
est vraie. C'est la structure de contrôle la plus fondamentale en programmation.

La syntaxe est :

```java
if (condition) {
    // Code exécuté si la condition est vraie
}
```

Si la condition est `false`, le bloc d'instructions est simplement ignoré et le
programme continue après l'accolade fermante.

## Code

Le fichier `Example.java` démontre différentes façons d'utiliser la structure
`if` avec des expressions booléennes simples et des comparaisons.

## Sortie attendue

```
=== Structure if simple ===

Test 1 : Vérification d'une variable booléenne
isConnected: true
La connexion est établie.

Test 2 : Utilisation d'une comparaison
score: 85
score: 40
Le score est suffisant.

Test 3 : Utilisation d'une expression booléenne complexe
age: 25, hasLicense: true
Vous pouvez conduire le véhicule.

Test 4 : Sans message si la condition est fausse
balance: 50.0, purchaseAmount: 75.0
Fin du programme (achat non effectué).
```

## Points clés à retenir

- La structure `if` exécute son bloc uniquement si la condition est vraie
- La condition doit être une expression booléenne
- Les accolades sont recommandées même pour une seule instruction
- Une condition peut être une variable booléenne ou une expression
- Si la condition est fausse, le code continue après le bloc `if`

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Modifier les valeurs des variables pour voir quand les conditions sont
   vraies.
2. Combiner plusieurs conditions avec `&&` et `||`.
3. Tester ce qui se passe si vous oubliez les accolades avec plusieurs
   instructions.

---

**Exemple suivant :** [07-condition-if-else](../07-condition-if-else/README.md)
