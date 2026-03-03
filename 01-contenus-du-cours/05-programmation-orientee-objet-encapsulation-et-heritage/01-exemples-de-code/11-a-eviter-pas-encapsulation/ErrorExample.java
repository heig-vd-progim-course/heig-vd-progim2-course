// MAUVAISE PRATIQUE : attributs directement accessibles
class BankAccount {
    String accountNumber;    // Pas de protection !
    String ownerName;        // Pas de protection !
    double balance;          // Pas de protection !

    // Pas de constructeur avec validation
    // Pas de getters/setters avec validation
}

public class ErrorExample {
    public static void main(String[] args) {
        System.out.println("=== Démonstration des problèmes ===\n");

        BankAccount account = new BankAccount();

        // PROBLÈME 1 : Aucune validation
        account.accountNumber = "";           // Vide !
        account.ownerName = null;             // Null !
        account.balance = -1000.0;            // Négatif !

        System.out.println("Problème 1 - Aucune validation:");
        System.out.println("Compte: '" + account.accountNumber + "'");
        System.out.println("Propriétaire: " + account.ownerName);
        System.out.println("Solde: " + account.balance + " CHF");
        System.out.println("^ Toutes ces valeurs sont invalides mais acceptées !\n");

        // PROBLÈME 2 : Modifications incontrôlées
        account.balance = 1000.0;
        System.out.println("Problème 2 - Modifications incontrôlées:");
        System.out.println("Solde initial: " + account.balance + " CHF");

        // N'importe qui peut modifier le solde directement
        account.balance += 1000000.0;  // Ajout frauduleux !
        System.out.println("Après modification directe: " + account.balance + " CHF");
        System.out.println("^ Qui a fait ce changement ? Aucune trace !\n");

        // PROBLÈME 3 : Pas de contrôle des opérations
        System.out.println("Problème 3 - Pas de contrôle des opérations:");
        account.balance = 500.0;
        System.out.println("Solde: " + account.balance + " CHF");

        // Retrait qui dépasse le solde : pas d'erreur !
        account.balance -= 1000.0;
        System.out.println("Après retrait de 1000 CHF: " + account.balance + " CHF");
        System.out.println("^ Découvert non autorisé mais accepté !\n");

        // PROBLÈME 4 : Erreurs de logique faciles
        System.out.println("Problème 4 - Erreurs de logique faciles:");
        BankAccount account2 = new BankAccount();
        account2.balance = 1000.0;

        // Erreur de logique : division au lieu de soustraction
        // Le compilateur ne peut pas détecter ce genre d'erreur
        account2.balance = account2.balance / 2;  // Oups, erreur !
        System.out.println("Après erreur de logique: " + account2.balance + " CHF");
        System.out.println("^ Devrait être withdraw(500), pas division !\n");

        // PROBLÈME 5 : Impossible de changer l'implémentation
        System.out.println("Problème 5 - Couplage fort:");
        System.out.println("Si on veut changer 'balance' de double à BigDecimal,");
        System.out.println("il faut modifier TOUT le code qui accède directement !");
        System.out.println("Avec des getters/setters, seule la classe change.");
    }
}
