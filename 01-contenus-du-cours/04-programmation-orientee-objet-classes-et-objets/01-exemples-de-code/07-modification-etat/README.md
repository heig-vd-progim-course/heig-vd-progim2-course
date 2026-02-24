# Exemple 07 - Modification de l'état d'un objet

**Objectif pédagogique :** comprendre comment les méthodes peuvent modifier
l'état (les attributs) d'un objet.

**Concepts illustrés :**

- Méthodes qui modifient les attributs
- Distinction entre méthodes qui lisent et méthodes qui modifient
- États d'un objet et transitions
- Validation lors de modifications

## Description

Cet exemple montre comment des méthodes peuvent modifier l'état d'un objet. Un
objet a un **état** défini par les valeurs de ses attributs. Les méthodes
peuvent consulter cet état (lecture) ou le modifier (écriture).

La classe `BankAccount` représente un compte bancaire avec des opérations de
dépôt et de retrait qui modifient le solde.

## Code

Les fichiers contiennent :

- `BankAccount.java` : classe avec méthodes qui modifient l'état
- `Main.java` : programme démontrant les modifications d'état

## Sortie attendue

```text
=== Compte bancaire ===
Titulaire: Alice Martin
Solde: 1000.0 CHF
=====================

Dépôt de 500.0 CHF effectué.
Nouveau solde: 1500.0 CHF

Retrait de 300.0 CHF effectué.
Nouveau solde: 1200.0 CHF

Retrait de 2000.0 CHF impossible: solde insuffisant.
Solde actuel: 1200.0 CHF

=== Compte bancaire ===
Titulaire: Alice Martin
Solde: 1200.0 CHF
=====================
```

## Points clés à retenir

- Les méthodes peuvent modifier les attributs de l'objet
- L'état d'un objet évolue au fil des appels de méthodes
- Les méthodes de modification peuvent inclure des validations
- Il est important de contrôler les modifications pour maintenir un état valide
- Une méthode peut retourner une valeur ET modifier l'état

## Suggestions d'expérimentation

Pour mieux comprendre cet exemple, essayez de :

1. Ajouter une méthode `addInterest(double rate)` qui ajoute des intérêts
2. Créer une méthode `transfer(BankAccount other, double amount)` pour des
   transferts
3. Suivre l'évolution du solde avec plusieurs opérations
4. Ajouter des frais de transaction lors de chaque opération

---

**Exemple précédent :** [06-methodes-retour](../06-methodes-retour/)

**Exemple suivant :** [08-exemple-complet](../08-exemple-complet/)
