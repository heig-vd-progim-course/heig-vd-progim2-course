class BankAccount {
    // Attributs privés : accessibles uniquement depuis la classe
    private String accountNumber;
    private double balance;

    // Constructeur
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Getter pour accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter pour balance
    public double getBalance() {
        return balance;
    }

    // Setter pour balance (permet de modifier le solde)
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Méthodes métier
    public void deposit(double amount) {
        balance += amount;
    }

    public void displayInfo() {
        System.out.println("Compte: " + accountNumber);
        System.out.println("Solde: " + balance + " CHF");
    }
}

public class Main {
    public static void main(String[] args) {
        // Créer un compte bancaire
        BankAccount account = new BankAccount("CH-1234567890");

        // Accéder aux attributs via les getters
        System.out.println("Numéro de compte: " + account.getAccountNumber());
        System.out.println("Solde initial: " + account.getBalance() + " CHF");

        // Modifier le solde via un setter
        account.setBalance(1000.0);
        System.out.println("\nAprès setBalance(1000.0):");
        account.displayInfo();

        // Utiliser une méthode métier
        account.deposit(500.0);
        System.out.println("\nAprès deposit(500.0):");
        account.displayInfo();

        // L'accès direct est impossible (décommentez pour voir l'erreur)
        // account.balance = 10000.0;  // ERREUR : balance est private
    }
}
