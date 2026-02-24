/**
 * Programme principal démontrant l'utilisation de méthodes avec retour.
 */
public class Main {
    public static void main(String[] args) {
        // Création d'un rectangle
        Rectangle rect = new Rectangle(5.0, 3.0);
        
        // Affichage de la description
        System.out.println(rect.getDescription());
        System.out.println();
        
        // Utilisation des valeurs retournées stockées dans des variables
        double area = rect.calculateArea();
        double perimeter = rect.calculatePerimeter();
        
        System.out.println("L'aire du rectangle est: " + area + " m²");
        System.out.println("Le périmètre du rectangle est: " + perimeter + " m");
        System.out.println();
        
        // Utilisation directe de la valeur retournée dans une condition
        if (rect.isLarge()) {
            System.out.println("Ce rectangle est considéré comme grand.");
        } else {
            System.out.println("Ce rectangle est considéré comme petit.");
        }
    }
}
