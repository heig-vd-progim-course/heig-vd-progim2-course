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
    @Override
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
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Retrait de " + amount + " CHF effectué");
        } else {
            System.out.println("Retrait impossible (limite de découvert dépassée)");
        }
    }

    @Override
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
