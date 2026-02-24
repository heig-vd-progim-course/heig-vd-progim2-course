/**
 * Classe représentant un produit.
 * 
 * Cette classe montre la déclaration de base d'une classe avec des attributs.
 * Un attribut est une variable qui appartient à la classe et définit les
 * propriétés que chaque objet de cette classe aura.
 */
class Product {
    // Attributs de la classe
    // Chaque objet Product aura ces trois propriétés
    
    String name;        // Nom du produit
    double price;       // Prix du produit
    int stockQuantity;  // Quantité en stock
}

/**
 * Classe principale du programme.
 * 
 * NOTE IMPORTANTE: Ce fichier contient DEUX classes (Product et Main).
 * En Java, on peut avoir plusieurs classes dans un même fichier, mais une seule
 * peut être publique (public class) et son nom doit correspondre au nom du fichier.
 * 
 * Ici, Product n'est pas public, donc Main peut être la classe publique.
 */
public class Main {
    public static void main(String[] args) {
        // À ce stade, nous ne créons pas encore d'objets
        // Ce fichier montre simplement qu'on peut avoir plusieurs classes
        System.out.println("Ce fichier contient deux classes: Product et Main");
        System.out.println("La classe Product définit le modèle d'un produit.");
        System.out.println("Dans les prochains exemples, nous créerons des objets.");
    }
}
