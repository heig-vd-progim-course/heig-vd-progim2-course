/**
 * Classe représentant un produit avec des méthodes.
 * 
 * Cette classe montre comment ajouter des méthodes à une classe.
 * Les méthodes définissent les comportements que les objets peuvent effectuer.
 */
class Product {
    // Attributs de la classe
    String name;
    double price;
    int stockQuantity;
    
    /**
     * Méthode pour afficher les informations du produit.
     * 
     * Cette méthode ne prend pas de paramètres et ne retourne rien (void).
     * Elle accède directement aux attributs de la classe pour les afficher.
     */
    void displayInfo() {
        System.out.println("=== Informations du produit ===");
        System.out.println("Nom: " + name);
        System.out.println("Prix: " + price + " CHF");
        System.out.println("Quantité en stock: " + stockQuantity);
        System.out.println("================================");
    }
}

/**
 * Classe principale du programme.
 * 
 * NOTE IMPORTANTE: Ce fichier contient DEUX classes (Product et Main).
 * En Java, on peut avoir plusieurs classes dans un même fichier, mais une seule
 * peut être publique (public class) et son nom doit correspondre au nom du fichier.
 * 
 * Dans cet exemple, nous créons un objet Product et appelons sa méthode.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Démonstration: deux classes dans un fichier\n");
        
        // Création d'un objet Product
        Product laptop = new Product();
        
        // Affectation directe des attributs (pas encore de constructeur)
        laptop.name = "Ordinateur portable";
        laptop.price = 899.90;
        laptop.stockQuantity = 5;
        
        // Appel de la méthode displayInfo() sur l'objet
        laptop.displayInfo();
    }
}
