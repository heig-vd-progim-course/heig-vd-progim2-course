/**
 * Programme principal démontrant la modification de l'état d'un objet.
 */
public class Main {
    public static void main(String[] args) {
        // Création d'un compte bancaire avec un solde initial
        BankAccount account = new BankAccount("Alice Martin", 1000.0);
        
        // Affichage de l'état initial
        account.displayInfo();
        System.out.println();
        
        // Modification de l'état : dépôt
        account.deposit(500.0);
        System.out.println();
        
        // Modification de l'état : retrait réussi
        account.withdraw(300.0);
        System.out.println();
        
        // Tentative de modification : retrait échoué (solde insuffisant)
        account.withdraw(2000.0);
        System.out.println();
        
        // Affichage de l'état final
        account.displayInfo();
    }
}
