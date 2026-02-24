/**
 * Classe représentant un rectangle.
 * 
 * Cette classe démontre l'utilisation de méthodes avec valeurs de retour.
 */
public class Rectangle {
    // Attributs
    double width;   // Largeur
    double height;  // Hauteur
    
    /**
     * Constructeur.
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    /**
     * Calcule et retourne l'aire du rectangle.
     * 
     * @return L'aire du rectangle (largeur * hauteur)
     */
    double calculateArea() {
        // La méthode retourne une valeur de type double
        return width * height;
    }
    
    /**
     * Calcule et retourne le périmètre du rectangle.
     * 
     * @return Le périmètre du rectangle (2 * largeur + 2 * hauteur)
     */
    double calculatePerimeter() {
        return 2 * width + 2 * height;
    }
    
    /**
     * Vérifie si le rectangle est considéré comme "grand".
     * 
     * Un rectangle est grand si son aire est supérieure à 10.
     * 
     * @return true si l'aire > 10, false sinon
     */
    boolean isLarge() {
        // On peut utiliser une autre méthode dans le calcul
        double area = calculateArea();
        return area > 10;
    }
    
    /**
     * Retourne une description textuelle du rectangle.
     * 
     * @return Une chaîne décrivant le rectangle
     */
    String getDescription() {
        return "Rectangle: " + width + " x " + height;
    }
}
