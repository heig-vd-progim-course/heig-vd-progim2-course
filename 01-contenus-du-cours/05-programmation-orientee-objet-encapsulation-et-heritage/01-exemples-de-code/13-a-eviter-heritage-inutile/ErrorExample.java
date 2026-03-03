// MAUVAISE PRATIQUE 1 : Héritage pour réutiliser du code (violation "est-un")
class ArrayList {
    private int size;
    private int capacity;

    public ArrayList() {
        size = 0;
        capacity = 10;
    }

    public int getSize() { return size; }
    public void add() { size++; }
    public void clear() { size = 0; }
}

// ERREUR : Un Stack n'EST PAS un ArrayList !
// On hérite juste pour réutiliser le code
class Stack extends ArrayList {
    public void push() {
        add();  // Réutilise add() mais sémantiquement incorrect
    }

    public void pop() {
        // Logique incorrecte
    }
}

// MAUVAISE PRATIQUE 2 : Hiérarchie non logique
class Rectangle {
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }

    public double getArea() {
        return width * height;
    }
}

// ERREUR : Un carré n'EST PAS vraiment un rectangle en POO
// (Problème du carré-rectangle classique)
class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    // Doit maintenir width == height
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);  // Casse le principe de substitution de Liskov
    }

    @Override
    public void setHeight(double height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}

// MAUVAISE PRATIQUE 3 : Composition serait mieux
class Engine {
    public void start() {
        System.out.println("Moteur démarré");
    }

    public void stop() {
        System.out.println("Moteur arrêté");
    }
}

// ERREUR : Une voiture n'EST PAS un moteur !
// Elle A un moteur (composition, pas héritage)
class Car extends Engine {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    public void drive() {
        start();  // Hérite de Engine
        System.out.println(brand + " roule");
    }
}

public class ErrorExample {
    public static void main(String[] args) {
        System.out.println("=== Démonstration des problèmes ===\n");

        // PROBLÈME 1 : Stack hérite de ArrayList
        System.out.println("Problème 1 - Héritage pour réutiliser du code:");
        Stack stack = new Stack();
        stack.push();
        stack.push();
        
        // On peut appeler des méthodes d'ArrayList qui n'ont pas de sens pour un Stack !
        stack.clear();  // Un Stack devrait avoir pop(), pas clear() !
        System.out.println("Taille du stack: " + stack.getSize());
        System.out.println("^ On peut accéder à des méthodes qui violent l'abstraction Stack !\n");

        // PROBLÈME 2 : Square hérite de Rectangle (problème classique)
        System.out.println("Problème 2 - Violation du principe de substitution:");
        Rectangle rect = new Rectangle(5, 3);
        System.out.println("Rectangle (5x3) - Aire: " + rect.getArea());

        Square square = new Square(4);
        System.out.println("Carré (4x4) - Aire: " + square.getArea());

        // Le problème apparaît ici :
        Rectangle rectRef = square;  // Un carré est traité comme un rectangle
        rectRef.setWidth(5);         // On change seulement la largeur...
        rectRef.setHeight(3);        // Puis la hauteur...
        
        // Comportement inattendu : les deux changent ensemble !
        System.out.println("Après setWidth(5) et setHeight(3):");
        System.out.println("Largeur: " + square.width + ", Hauteur: " + square.height);
        System.out.println("^ Le carré ne maintient pas width == height comme prévu !\n");

        // PROBLÈME 3 : Car hérite de Engine
        System.out.println("Problème 3 - Composition serait mieux:");
        Car car = new Car("Tesla");
        car.drive();

        // On peut traiter une Car comme un Engine !
        Engine engine = car;
        engine.start();
        System.out.println("^ Une voiture n'est pas un moteur, elle EN A un !\n");

        // CONCLUSION
        System.out.println("=== Conclusion ===");
        System.out.println("L'héritage doit respecter la relation 'est-un' (is-a):");
        System.out.println("✓ Un Dog EST un Animal → héritage approprié");
        System.out.println("✓ Un Developer EST un Employee → héritage approprié");
        System.out.println("Un Stack N'EST PAS un ArrayList → composition");
        System.out.println("Une Car N'EST PAS un Engine → composition");
        System.out.println("Un Square pose problème avec Rectangle → modèles séparés");
    }
}
