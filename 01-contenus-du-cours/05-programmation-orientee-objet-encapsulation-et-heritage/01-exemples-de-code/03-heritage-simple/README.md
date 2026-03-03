# Héritage simple

## Objectif

Découvrir les bases de l'héritage : réutiliser le code d'une classe existante en
créant une classe enfant qui hérite de ses attributs et méthodes.

## Concept illustré

L'**héritage** permet de :

- Réutiliser le code d'une classe existante (classe parent)
- Créer une hiérarchie de classes (parent → enfant)
- Ajouter des fonctionnalités spécifiques dans les classes enfants
- Éviter la duplication de code

## Code complet

Créez un fichier `Main.java` avec le code suivant :

```java
// Classe parent (superclasse)
class BankAccount {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Dépôt de " + amount + " CHF effectué");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Retrait de " + amount + " CHF effectué");
        } else {
            System.out.println("Retrait impossible");
        }
    }

    public void displayInfo() {
        System.out.println("Compte: " + accountNumber);
        System.out.println("Propriétaire: " + ownerName);
        System.out.println("Solde: " + balance + " CHF");
    }
}

// Classe enfant (sous-classe) - Compte épargne
class SavingsAccount extends BankAccount {
    private double interestRate;  // Attribut spécifique au compte épargne

    public SavingsAccount(String accountNumber, String ownerName, double interestRate) {
        // Appel du constructeur de la classe parent
        super(accountNumber, ownerName);
        this.interestRate = interestRate;
    }

    // Méthode spécifique au compte épargne
    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Intérêts appliqués: " + interest + " CHF");
    }

    // Redéfinition de displayInfo pour ajouter le taux d'intérêt
    public void displayInfo() {
        super.displayInfo();  // Appelle la méthode du parent
        System.out.println("Taux d'intérêt: " + interestRate + "%");
    }
}

// Classe enfant (sous-classe) - Compte courant
class CheckingAccount extends BankAccount {
    private double overdraftLimit;  // Découvert autorisé

    public CheckingAccount(String accountNumber, String ownerName, double overdraftLimit) {
        super(accountNumber, ownerName);
        this.overdraftLimit = overdraftLimit;
    }

    // Redéfinition de withdraw pour permettre le découvert
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Retrait de " + amount + " CHF effectué");
        } else {
            System.out.println("Retrait impossible (limite de découvert dépassée)");
        }
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Découvert autorisé: " + overdraftLimit + " CHF");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Compte épargne ===");
        SavingsAccount savings = new SavingsAccount("CH-SA-001", "Alice Dupont", 2.5);
        savings.deposit(1000.0);    // Héritée de BankAccount
        savings.applyInterest();     // Spécifique à SavingsAccount
        savings.displayInfo();       // Redéfinie dans SavingsAccount
        System.out.println();

        System.out.println("=== Compte courant ===");
        CheckingAccount checking = new CheckingAccount("CH-CA-001", "Bob Martin", 500.0);
        checking.deposit(300.0);     // Héritée de BankAccount
        checking.withdraw(600.0);    // Redéfinie dans CheckingAccount (découvert)
        checking.displayInfo();      // Redéfinie dans CheckingAccount
    }
}
```

<details>
<summary>Description du code</summary>

Déclaration de la classe `BankAccount` avec trois attributs `protected` :
`accountNumber`, `ownerName`, `balance`. Le modificateur `protected` permet aux
classes enfants d'accéder à ces attributs.

Définition du constructeur de `BankAccount` qui initialise les trois attributs.

Déclaration des méthodes `deposit()` et `withdraw()` avec validation simple, et
`displayInfo()` pour afficher les informations.

Déclaration de la classe `SavingsAccount` avec le mot-clé `extends BankAccount`,
établissant une relation d'héritage. `SavingsAccount` hérite de tous les
attributs et méthodes de `BankAccount`.

Ajout d'un attribut privé `interestRate` spécifique au compte épargne.

Définition du constructeur de `SavingsAccount` qui appelle le constructeur du
parent avec `super(accountNumber, ownerName)` puis initialise `interestRate`.

Déclaration de la méthode `applyInterest()` spécifique à `SavingsAccount` qui
calcule et ajoute les intérêts au solde.

Redéfinition de `displayInfo()` : appel de `super.displayInfo()` pour afficher
les informations de base, puis ajout de l'affichage du taux d'intérêt.

Déclaration de la classe `CheckingAccount` qui hérite également de `BankAccount`
avec `extends`.

Ajout d'un attribut privé `overdraftLimit` pour le découvert autorisé.

Constructeur de `CheckingAccount` appelant `super()` puis initialisant
`overdraftLimit`.

Redéfinition de `withdraw()` pour permettre les retraits jusqu'à
`balance + overdraftLimit` au lieu de seulement `balance`.

Redéfinition de `displayInfo()` avec `super.displayInfo()` puis affichage du
découvert autorisé.

Dans `main`, création d'une instance de `SavingsAccount`, appel de méthodes
héritées (`deposit`) et spécifiques (`applyInterest`), puis affichage.

Création d'une instance de `CheckingAccount`, appel de `deposit` (hérité) et
`withdraw` (redéfini permettant le découvert), puis affichage.

</details>

## Exécution

Compilez et exécutez le programme :

```bash
javac Main.java
java Main
```

**Résultat attendu :**

```
=== Compte épargne ===
Dépôt de 1000.0 CHF effectué
Intérêts appliqués: 25.0 CHF
Compte: CH-SA-001
Propriétaire: Alice Dupont
Solde: 1025.0 CHF
Taux d'intérêt: 2.5%

=== Compte courant ===
Dépôt de 300.0 CHF effectué
Retrait de 600.0 CHF effectué
Compte: CH-CA-001
Propriétaire: Bob Martin
Solde: -300.0 CHF
Découvert autorisé: 500.0 CHF
```

## Points clés

- Le mot-clé `extends` établit une relation d'héritage (enfant `extends` parent)
- Une classe enfant hérite de tous les attributs et méthodes `public` et
  `protected` du parent
- `super()` dans le constructeur appelle le constructeur du parent
- `super.methode()` appelle une méthode du parent
- Les classes enfants peuvent ajouter leurs propres attributs et méthodes
- Les classes enfants peuvent redéfinir les méthodes du parent
- Le code commun n'existe qu'une seule fois dans le parent

## Avantages

- **Réutilisation** : pas besoin de réécrire `deposit()` dans chaque sous-classe
- **Maintenance** : une correction dans `BankAccount` s'applique à toutes les
  sous-classes
- **Organisation** : hiérarchie logique (BankAccount → SavingsAccount,
  CheckingAccount)
- **Extensibilité** : facile d'ajouter un nouveau type de compte

## Pour aller plus loin

Consultez l'exemple suivant ([04-heritage-abstract](../04-heritage-abstract/))
pour découvrir les classes abstraites, qui permettent de définir un "contrat"
que les classes enfants doivent respecter.
