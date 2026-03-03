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
