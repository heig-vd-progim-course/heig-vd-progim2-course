/**
 * Classe représentant un compte bancaire.
 * 
 * Cette classe démontre comment les méthodes peuvent modifier l'état d'un objet.
 */
public class BankAccount {
    // Attributs (état de l'objet)
    String accountHolder;  // Titulaire du compte
    double balance;        // Solde du compte
    
    /**
     * Constructeur.
     */
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    /**
     * Dépose de l'argent sur le compte.
     * 
     * Cette méthode MODIFIE l'état de l'objet en augmentant le solde.
     * 
     * @param amount Le montant à déposer
     */
    void deposit(double amount) {
        if (amount > 0) {
            this.balance = this.balance + amount;  // Modification de l'état
            System.out.println("Dépôt de " + amount + " CHF effectué.");
            System.out.println("Nouveau solde: " + this.balance + " CHF");
        } else {
            System.out.println("Montant invalide pour un dépôt.");
        }
    }
    
    /**
     * Retire de l'argent du compte.
     * 
     * Cette méthode MODIFIE l'état de l'objet en diminuant le solde.
     * Elle effectue une validation pour éviter un solde négatif.
     * 
     * @param amount Le montant à retirer
     * @return true si le retrait a réussi, false sinon
     */
    boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance = this.balance - amount;  // Modification de l'état
            System.out.println("Retrait de " + amount + " CHF effectué.");
            System.out.println("Nouveau solde: " + this.balance + " CHF");
            return true;
        } else {
            System.out.println("Retrait de " + amount + " CHF impossible: solde insuffisant.");
            System.out.println("Solde actuel: " + this.balance + " CHF");
            return false;
        }
    }
    
    /**
     * Retourne le solde actuel.
     * 
     * Cette méthode CONSULTE l'état sans le modifier.
     * 
     * @return Le solde du compte
     */
    double getBalance() {
        return this.balance;
    }
    
    /**
     * Affiche les informations du compte.
     * 
     * Cette méthode CONSULTE l'état sans le modifier.
     */
    void displayInfo() {
        System.out.println("=== Compte bancaire ===");
        System.out.println("Titulaire: " + this.accountHolder);
        System.out.println("Solde: " + this.balance + " CHF");
        System.out.println("=====================");
    }
}
