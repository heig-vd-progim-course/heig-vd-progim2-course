/**
 * Programme principal démontrant une utilisation complète de la POO.
 * 
 * Ce programme simule un système de gestion de bibliothèque simple.
 */
public class Main {
    public static void main(String[] args) {
        // Création de plusieurs livres
        Book book1 = new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 96);
        Book book2 = new Book("1984", "George Orwell", 328);
        Book book3 = new Book("Le Seigneur des Anneaux", "J.R.R. Tolkien", 1178);
        
        // Affichage initial de la bibliothèque
        System.out.println("=== Bibliothèque ===");
        System.out.println();
        
        System.out.println("--- Livre 1 ---");
        book1.displayInfo();
        System.out.println();
        
        System.out.println("--- Livre 2 ---");
        book2.displayInfo();
        System.out.println();
        
        System.out.println("--- Livre 3 ---");
        book3.displayInfo();
        System.out.println();
        
        // Emprunts de livres
        System.out.println("=== Emprunt de livres ===");
        System.out.println();
        
        book1.borrow();  // Devrait réussir
        System.out.println();
        
        book2.borrow();  // Devrait réussir
        System.out.println();
        
        book1.borrow();  // Devrait échouer (déjà emprunté)
        System.out.println();
        
        // État après les emprunts
        System.out.println("=== État actuel ===");
        System.out.println();
        
        System.out.println("--- Livre 1 ---");
        book1.displayInfo();
        System.out.println();
        
        System.out.println("--- Livre 2 ---");
        book2.displayInfo();
        System.out.println();
        
        System.out.println("--- Livre 3 ---");
        book3.displayInfo();
        System.out.println();
        
        // Retour d'un livre
        System.out.println("=== Retour de livres ===");
        System.out.println();
        
        book1.returnBook();  // Devrait réussir
        System.out.println();
        
        // État final
        System.out.println("=== État final ===");
        System.out.println();
        
        System.out.println("--- Livre 1 ---");
        book1.displayInfo();
        System.out.println();
        
        // Utilisation des valeurs retournées par les méthodes
        int totalPages = book1.getPages() + book2.getPages() + book3.getPages();
        System.out.println("Nombre total de pages: " + totalPages);
    }
}
