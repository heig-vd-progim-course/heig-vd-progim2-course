# Encapsulation avec validation

## Objectif

Comprendre l'importance de la validation dans les setters pour garantir
l'intégrité des données et éviter les états invalides.

## Concept illustré

L'**encapsulation avec validation** permet de :

- Contrôler les valeurs affectées aux attributs
- Rejeter les valeurs invalides
- Garantir que l'objet reste toujours dans un état cohérent
- Centraliser les règles métier dans la classe

## Code complet

Créez un fichier `Main.java` avec le code suivant :

```java
class BankAccount {
    private String accountNumber;
    private double balance;
    private String ownerName;

    // Constructeur avec validation
    public BankAccount(String accountNumber, String ownerName) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Le numéro de compte ne peut pas être vide");
        }
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du propriétaire ne peut pas être vide");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter avec validation
    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            System.out.println("Erreur: le nom du propriétaire ne peut pas être vide");
            return;
        }
        this.ownerName = ownerName;
    }

    // Méthodes métier avec validation
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Erreur: le montant du dépôt doit être positif");
            return;
        }
        balance += amount;
        System.out.println("Dépôt de " + amount + " CHF effectué");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Erreur: le montant du retrait doit être positif");
            return;
        }
        if (amount > balance) {
            System.out.println("Erreur: solde insuffisant (solde: " + balance + " CHF)");
            return;
        }
        balance -= amount;
        System.out.println("Retrait de " + amount + " CHF effectué");
    }

    public void displayInfo() {
        System.out.println("Compte: " + accountNumber);
        System.out.println("Propriétaire: " + ownerName);
        System.out.println("Solde: " + balance + " CHF");
    }
}

public class Main {
    public static void main(String[] args) {
        // Créer un compte valide
        BankAccount account = new BankAccount("CH-1234567890", "Alice Dupont");
        account.displayInfo();
        System.out.println();

        // Opérations valides
        account.deposit(1000.0);
        account.withdraw(300.0);
        System.out.println();
        account.displayInfo();
        System.out.println();

        // Tentatives avec des valeurs invalides
        System.out.println("=== Tests avec valeurs invalides ===");
        account.deposit(-100.0);      // Montant négatif
        account.deposit(0.0);          // Montant zéro
        account.withdraw(2000.0);      // Solde insuffisant
        account.setOwnerName("");      // Nom vide
        System.out.println();

        // Le compte reste dans un état cohérent
        System.out.println("État final du compte:");
        account.displayInfo();
    }
}
```

<details>
<summary>Description du code</summary>

Déclaration de la classe `BankAccount` avec trois attributs privés :
`accountNumber`, `balance` et `ownerName`.

Définition d'un constructeur qui accepte `accountNumber` et `ownerName`. Le
constructeur valide ces paramètres avec des structures conditionnelles `if` et
lance une exception `IllegalArgumentException` si les valeurs sont `null` ou
vides (vérification avec `trim().isEmpty()`).

Déclaration des getters publics pour `accountNumber`, `ownerName` et `balance`
qui retournent les valeurs des attributs privés.

Déclaration du setter `setOwnerName(String ownerName)` avec validation : une
structure conditionnelle `if` vérifie si le paramètre est `null` ou vide. Si la
validation échoue, affichage d'un message d'erreur avec `System.out.println()`
et retour anticipé avec `return`. Sinon, affectation de la valeur à l'attribut.

Déclaration de la méthode `deposit(double amount)` avec validation : structure
conditionnelle vérifiant que `amount` est positif (comparaison `amount <= 0`).
Si invalide, affichage d'erreur et `return`. Sinon, opération
`balance += amount` et message de confirmation.

Déclaration de la méthode `withdraw(double amount)` avec deux validations :
première structure conditionnelle pour vérifier que `amount > 0`, deuxième pour
vérifier que `amount <= balance`. Si une validation échoue, message d'erreur et
`return`. Sinon, opération `balance -= amount` et message de confirmation.

Déclaration de la méthode `displayInfo()` qui affiche les trois attributs avec
`System.out.println()`.

Dans la méthode `main`, création d'une instance de `BankAccount` avec des
valeurs valides, puis appel de `displayInfo()`.

Appels de méthodes avec des paramètres valides : `deposit(1000.0)` puis
`withdraw(300.0)`, suivis de l'affichage de l'état.

Série de tests avec valeurs invalides : `deposit(-100.0)`, `deposit(0.0)`,
`withdraw(2000.0)`, `setOwnerName("")`. Chaque appel déclenche un message
d'erreur mais l'objet reste cohérent.

Affichage final de l'état du compte pour vérifier qu'il n'a pas été corrompu par
les tentatives invalides.

</details>

## Exécution

Compilez et exécutez le programme :

```bash
javac Main.java
java Main
```

**Résultat attendu :**

```
Compte: CH-1234567890
Propriétaire: Alice Dupont
Solde: 0.0 CHF

Dépôt de 1000.0 CHF effectué
Retrait de 300.0 CHF effectué

Compte: CH-1234567890
Propriétaire: Alice Dupont
Solde: 700.0 CHF

=== Tests avec valeurs invalides ===
Erreur: le montant du dépôt doit être positif
Erreur: le montant du dépôt doit être positif
Erreur: solde insuffisant (solde: 700.0 CHF)
Erreur: le nom du propriétaire ne peut pas être vide

État final du compte:
Compte: CH-1234567890
Propriétaire: Alice Dupont
Solde: 700.0 CHF
```

## Points clés

- La validation dans le constructeur garantit que l'objet est créé dans un état
  valide
- Les setters et méthodes métier valident leurs paramètres avant modification
- Les valeurs invalides sont rejetées avec des messages d'erreur clairs
- L'objet reste toujours dans un état cohérent, même après des tentatives
  invalides
- La validation centralise les règles métier dans la classe

## Avantages

- **Intégrité des données** : impossible de créer des états incohérents
- **Maintenance** : règles de validation centralisées en un seul endroit
- **Débogage** : les erreurs sont détectées immédiatement
- **Fiabilité** : le reste du code peut faire confiance aux objets validés

## Pour aller plus loin

Maintenant que vous maîtrisez l'encapsulation, découvrez l'héritage dans
l'exemple suivant ([03-heritage-simple](../03-heritage-simple/)) pour réutiliser
ce code dans différents types de comptes.
