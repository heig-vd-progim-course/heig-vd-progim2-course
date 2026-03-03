// Classe parent
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    // Méthode qui sera redéfinie
    public void makeSound() {
        System.out.println(name + " fait un bruit");
    }

    public void sleep() {
        System.out.println(name + " dort");
    }

    // Méthode qui utilise makeSound()
    public void introduce() {
        System.out.print(name + " se présente: ");
        makeSound();  // Appelle la version appropriée (polymorphisme)
    }
}

// Sous-classe : Dog
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    // Redéfinition de makeSound()
    @Override
    public void makeSound() {
        System.out.println(name + " aboie: Wouaf! Wouaf!");
    }

    // Méthode spécifique à Dog
    public void fetch() {
        System.out.println(name + " rapporte la balle");
    }
}

// Sous-classe : Cat
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    // Redéfinition de makeSound()
    @Override
    public void makeSound() {
        System.out.println(name + " miaule: Miaou!");
    }

    // Redéfinition de sleep() avec comportement personnalisé
    @Override
    public void sleep() {
        System.out.println(name + " dort en ronronnant... zzz");
    }
}

// Sous-classe : Bird
class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    // Redéfinition de makeSound()
    @Override
    public void makeSound() {
        System.out.println(name + " chante: Cui! Cui!");
    }

    // Redéfinition de introduce() avec appel à super
    @Override
    public void introduce() {
        System.out.print("🐦 ");
        super.introduce();  // Appelle la version du parent
    }
}

// Classe pour démontrer la surcharge (overload)
class Calculator {
    // Trois méthodes avec le même nom mais des signatures différentes
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Redéfinition (Override) ===\n");

        Dog dog = new Dog("Rex");
        Cat cat = new Cat("Whiskers");
        Bird bird = new Bird("Tweety");

        // Chaque animal fait son propre son
        dog.makeSound();   // Appelle Dog.makeSound()
        cat.makeSound();   // Appelle Cat.makeSound()
        bird.makeSound();  // Appelle Bird.makeSound()
        System.out.println();

        // sleep() : Dog utilise la version du parent, Cat sa propre version
        dog.sleep();       // Appelle Animal.sleep()
        cat.sleep();       // Appelle Cat.sleep() (redéfinie)
        System.out.println();

        // introduce() utilise le polymorphisme
        dog.introduce();   // Appelle Animal.introduce() qui appelle Dog.makeSound()
        cat.introduce();   // Appelle Animal.introduce() qui appelle Cat.makeSound()
        bird.introduce();  // Appelle Bird.introduce() qui appelle super.introduce()
        System.out.println();

        // Polymorphisme : traitement uniforme
        System.out.println("=== Polymorphisme ===\n");
        Animal[] animals = {dog, cat, bird};
        
        for (Animal animal : animals) {
            animal.makeSound();  // Java appelle la bonne version automatiquement
        }
        System.out.println();

        // Surcharge (Overload) - pour comparaison
        System.out.println("=== Surcharge (Overload) - pour comparaison ===\n");
        Calculator calc = new Calculator();
        
        System.out.println("add(5, 3) = " + calc.add(5, 3));              // int, int
        System.out.println("add(5.5, 3.2) = " + calc.add(5.5, 3.2));      // double, double
        System.out.println("add(1, 2, 3) = " + calc.add(1, 2, 3));        // int, int, int
    }
}
