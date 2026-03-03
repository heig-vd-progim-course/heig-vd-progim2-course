// Classe abstraite : ne peut pas être instanciée directement
abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    // Méthode abstraite : doit être implémentée par les sous-classes
    public abstract double calculateArea();

    // Méthode abstraite pour le périmètre
    public abstract double calculatePerimeter();

    // Méthode concrète : code commun à toutes les formes
    public void displayInfo() {
        System.out.println("Forme: " + getClass().getSimpleName());
        System.out.println("Couleur: " + color);
        System.out.println("Aire: " + calculateArea() + " cm²");
        System.out.println("Périmètre: " + calculatePerimeter() + " cm");
    }

    // Méthode concrète avec logique commune
    public void paint(String newColor) {
        System.out.println("Changement de couleur: " + color + " → " + newColor);
        this.color = newColor;
    }
}

// Classe concrète : Rectangle
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    // Implémentation obligatoire de calculateArea()
    @Override
    public double calculateArea() {
        return width * height;
    }

    // Implémentation obligatoire de calculatePerimeter()
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

// Classe concrète : Circle
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Classe concrète : Triangle
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        // Formule de Héron
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

public class Main {
    public static void main(String[] args) {
        // Impossible de créer une instance de Shape :
        // Shape shape = new Shape("rouge");  // ERREUR: Shape est abstraite

        // Créer des formes concrètes
        Rectangle rect = new Rectangle("bleu", 5.0, 3.0);
        Circle circle = new Circle("rouge", 4.0);
        Triangle triangle = new Triangle("vert", 3.0, 4.0, 5.0);

        // Afficher les informations
        System.out.println("=== Rectangle ===");
        rect.displayInfo();
        System.out.println();

        System.out.println("=== Cercle ===");
        circle.displayInfo();
        System.out.println();

        System.out.println("=== Triangle ===");
        triangle.displayInfo();
        System.out.println();

        // Utiliser une méthode concrète héritée
        System.out.println("=== Changement de couleur ===");
        rect.paint("jaune");
        rect.displayInfo();
        System.out.println();

        // Polymorphisme : traitement uniforme
        System.out.println("=== Catalogue de formes ===");
        Shape[] shapes = {rect, circle, triangle};
        
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        System.out.println("Aire totale: " + totalArea + " cm²");
    }
}
