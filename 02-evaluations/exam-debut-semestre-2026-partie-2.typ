#import "@preview/codelst:2.0.2": sourcecode
#import "@local/heig-vd-evaluations-and-exams-template:0.1.0": conf, question_types
#set text(font: "Atkinson Hyperlegible")

#let parts = (
  ("Question 1", 12),
  ("Question 2", 16),
  ("Question 3", 18),
)

#let additional_information = [

  Vous avez le droit à une page A4 recto-verso de résumé avec vos propres notes.

  Vous pouvez répondre aux questions en français ou en anglais.

  Toute tentative de triche sera sanctionnée par la note de 1.

  _Examen préparé avec l'aide d'Hadrien Louis, GitHub Copilot et Claude (Anthropic)._
]

#show: doc => conf(
  evaluation_title: "Programmation Ingénierie des Médias 2 (ProgIM2)",
  evaluation_subtitle: [ProgIM2 - VGX - Partie 2#if "room" in sys.inputs [ (Salle #sys.inputs.room)]],
  evaluation_date: "01.04.2026",
  duration: "90 minutes (10h10 à 11h40). Vous avez eu 5 minutes de lecture avant le début (10h05 à 10h10).",
  parts,
  additional_information,
  doc,
)

#let show_official_answer = if "show_official_answer" in sys.inputs {
  sys.inputs.show_official_answer == "true"
} else {
  false
}

#pagebreak()

#align(center)[Page laissée vide]

#pagebreak()

// ============================================================================
// QUESTION 1 : Classes abstraites et Interfaces
// ============================================================================

#question_types.question_statement(
  title: "POO Avancée : Classes abstraites et interfaces",
  statement: [
    Le code suivant contient plusieurs erreurs. Analysez-le et répondez aux questions.
    
    #sourcecode[```java
    interface Playable {
        void play();
        String getTitle();
    }
    
    abstract class Media {
        private String title;
        public int duration;
        
        public Media(String title) {
            title = title;
        }
        
        public String getTitle() {
            return title;
        }
        
        public abstract void display();
    }
    
    class Video extends Media implements Playable {
        private String resolution;
        
        public Video(String title, String resolution) {
            this.title = title;
            this.resolution = resolution;
        }
        
        public void display() {
            System.out.println("Vidéo: " + title + " (" + resolution + ")");
        }
        
        public void play() {
            System.out.println("Lecture de la vidéo");
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            Video v = new Video("Tutoriel Java", "1080p");
            v.display();
            v.play();
            v.duration = 3600;
            System.out.println("Durée: " + v.duration + "s");
        }
    }
    ```]
    
    Identifiez 4 erreurs dans ce code. Pour chaque erreur :
    - La classe/interface et l'endroit concerné (1 point)
    - Pourquoi c'est une erreur (2 points)
  ],
  points: 12,
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Identification des erreurs (12 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *Erreur 1 (3 points) :* Media, `public int duration;`
    
    Problème : L'attribut devrait être privé (principe d'encapsulation). Même dans une classe abstraite, les attributs doivent être privés.
    
    *Erreur 2 (3 points) :* Media, constructeur `title = title;`
    
    Problème : Pas de `this.`, le paramètre s'assigne à lui-même. L'attribut reste null.
    
    *Erreur 3 (3 points) :* Video, constructeur `this.title = title;`
    
    Problème : Video étend Media mais n'appelle pas `super(title)`. De plus, `title` est privé dans Media (inaccessible directement).
    
    *Erreur 4 (3 points) :* Video, méthode display() `"Vidéo: " + title`
    
    Problème : `title` est privé dans Media, inaccessible dans la classe fille. Il faut utiliser `getTitle()`.
    
    *(Note : aussi acceptable = Video ne redéfinit pas getTitle() de l'interface Playable, mais getTitle() est héritée de Media donc pas d'erreur)*
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 2 : Polymorphisme et héritage
// ============================================================================

#question_types.question_statement(
  title: "POO Avancée : Polymorphisme avec formes géométriques",
  statement: [
    Analysez le code suivant (sans erreurs) et répondez aux questions.
    
    #sourcecode[```java
    interface Drawable {
        void draw();
    }
    
    abstract class Shape {
        protected String color;
        
        public Shape(String color) {
            this.color = color;
        }
        
        public abstract double getArea();
        
        public void describe() {
            System.out.println("Forme de couleur " + color);
        }
    }
    
    class Circle extends Shape implements Drawable {
        private double radius;
        
        public Circle(String color, double radius) {
            super(color);
            this.radius = radius;
        }
        
        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
        
        @Override
        public void draw() {
            System.out.println("Dessin d'un cercle " + color);
        }
        
        @Override
        public void describe() {
            System.out.println("Cercle " + color + " de rayon " + radius);
        }
    }
    
    class Rectangle extends Shape implements Drawable {
        private double width;
        private double height;
        
        public Rectangle(String color, double width, double height) {
            super(color);
            this.width = width;
            this.height = height;
        }
        
        @Override
        public double getArea() {
            return width * height;
        }
        
        @Override
        public void draw() {
            System.out.println("Dessin d'un rectangle " + color);
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            Shape s1 = new Circle("rouge", 5.0);
            Shape s2 = new Rectangle("bleu", 4.0, 3.0);
            
            s1.describe();
            s2.describe();
            
            Drawable d1 = new Circle("vert", 3.0);
            d1.draw();
            
            System.out.println("Aire: " + s1.getArea());
        }
    }
    ```]
    
    *Partie A (12 points)* : Que sera affiché dans la console lors de l'exécution de ce programme ? Écrivez exactement ce qui sera affiché, ligne par ligne.
  ],
  points: 12,
)


#question_types.answer_bloc_with_icon(
  height_cm: 10cm,
  icon_text: "Partie A : Sortie console (12 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    ```
    Cercle rouge de rayon 5.0
    Forme de couleur bleu
    Dessin d'un cercle vert
    Aire: 78.53981633974483
    ```
    
    Explications :
    - Ligne 1 : `s1.describe()` appelle la version redéfinie dans `Circle`
    - Ligne 2 : `s2.describe()` appelle la version de `Shape` (pas redéfinie dans `Rectangle`)
    - Ligne 3 : `d1.draw()` appelle la méthode de `Circle`
    - Ligne 4 : `s1.getArea()` calcule π × 5² ≈ 78.54
    
    (3 points par ligne correcte)
  ],
)

#pagebreak()

#question_types.multiple_choice_question(
  title: "Partie B",
  statement: "Vrai ou Faux :",
  points: 4,
  header: ("Énoncé", "Réponse"),
  answers: (
    ("La variable `s2` peut appeler la méthode `draw()`.", "FAUX - `s2` est de type `Shape`, et `Shape` n'implémente pas `Drawable`. Même si `Rectangle` implémente `Drawable`, on ne peut pas appeler `draw()` via une référence `Shape`. Il faudrait faire un cast : `((Drawable)s2).draw()`."),
    ("La méthode `describe()` appelée sur `s1` exécute la version de `Circle` (et non celle de `Shape`).", "VRAI - Grâce au polymorphisme, même si `s1` est de type `Shape`, la méthode appelée est celle de l'objet réel (`Circle`). `Circle` redéfinit `describe()` avec `@Override`, donc c'est cette version qui s'exécute."),
  ),
  show_official_answer: show_official_answer,
  answer_below: true,
)

#pagebreak()

#align(center)[Page laissée vide]

#pagebreak()

// ============================================================================
// QUESTION 3 : POO Avancée - Comparaison de code et concepts
// ============================================================================

#question_types.question_statement(
  title: "POO Avancée : Comparaison de code et concepts",
  statement: [
    *Partie A (10 points)* : Comparez les deux approches suivantes pour afficher des informations sur des animaux.
    
    *Code A :*
    #sourcecode[```java
    class Animal {
        protected String name;
        
        public Animal(String name) {
            this.name = name;
        }
    }
    
    class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
        
        public void bark() {
            System.out.println(name + " aboie");
        }
    }
    
    class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
        
        public void meow() {
            System.out.println(name + " miaule");
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            Animal[] animals = {new Dog("Rex"), new Cat("Mimi")};
            
            for (Animal a : animals) {
                if (a instanceof Dog) {
                    ((Dog) a).bark();
                } else if (a instanceof Cat) {
                    ((Cat) a).meow();
                }
            }
        }
    }
    ```]

    #colbreak()
    
    *Code B :*
    #sourcecode[```java
    abstract class Animal {
        protected String name;
        
        public Animal(String name) {
            this.name = name;
        }
        
        public abstract void makeSound();
    }
    
    class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
        
        @Override
        public void makeSound() {
            System.out.println(name + " aboie");
        }
    }
    
    class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
        
        @Override
        public void makeSound() {
            System.out.println(name + " miaule");
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            Animal[] animals = {new Dog("Rex"), new Cat("Mimi")};
            
            for (Animal a : animals) {
                a.makeSound();
            }
        }
    }
    ```]
    
    *Partie A (10 points)* : Questions de réflexion
    
    1. Quelle est la différence principale entre les deux approches ? (3 points)
    2. Quelle approche est meilleure selon les principes de la POO ? Justifiez. (4 points)
    3. Que se passerait-il dans le Code A si on ajoutait une classe `Bird` ? Et dans le Code B ? (3 points)
  ],
  points: 10,
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Partie A : Comparaison de code (10 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    1. *Différence principale (3 points) :*
    
    Code A utilise `instanceof` et casting pour vérifier le type réel de l'objet et appeler la méthode spécifique.
    
    Code B utilise le polymorphisme avec une méthode abstraite `makeSound()` redéfinie dans chaque sous-classe.
    
    2. *Meilleure approche (4 points) :*
    
    Le Code B est meilleur car il respecte le principe du polymorphisme. Avantages :
    - Pas besoin de `instanceof` ni de casting
    - Plus extensible : ajouter un nouveau type d'animal ne nécessite pas de modifier la boucle
    - Code plus maintenable et lisible
    - Respecte le principe Ouvert/Fermé (open/closed principle)
    
    3. *Ajout d'une classe Bird (3 points) :*
    
    Code A : Il faudrait ajouter un nouveau `else if (a instanceof Bird)` dans la boucle, ce qui nécessite de modifier le code existant.
    
    Code B : Il suffit de créer la classe `Bird` avec sa méthode `makeSound()`, aucune modification de la boucle n'est nécessaire.
  ],
)

#pagebreak()

#question_types.multiple_choice_question(
  title: "Partie B",
  statement: "Vrai ou Faux :",
  points: 8,
  header: ("Énoncé", "Réponse"),
  answers: (
    ("Une classe abstraite peut contenir des méthodes concrètes (non abstraites), mais une interface ne peut contenir que des méthodes abstraites.", "VRAI - Une classe abstraite peut avoir des méthodes concrètes et des méthodes abstraites. Une interface, avant Java 8, ne pouvait contenir que des méthodes abstraites. Depuis Java 8, les interfaces peuvent aussi contenir des méthodes par défaut (concrètes), mais elles ne peuvent pas avoir d'état (attributs non statiques). Une erreur a été commise à la correction, tout le monde à 2 points bonus"),
    ("L'opérateur `instanceof` permet de vérifier si un objet est une instance d'une classe ou d'une de ses sous-classes.", "VRAI - `instanceof` vérifie si l'objet est une instance de la classe spécifiée ou de n'importe quelle sous-classe. Par exemple, si `Dog extends Animal`, alors `dog instanceof Animal` retourne `true`."),
    ("Dans le Code B, si on écrit `Animal a = new Dog(\"Rex\")`, l'appel `a.makeSound()` exécutera la méthode `makeSound()` de la classe `Dog`.", "VRAI - C'est le principe du polymorphisme. Même si la variable `a` est de type `Animal`, Java appelle toujours la méthode de l'objet réel (ici `Dog`), pas celle du type de la variable."),
    ("Le casting `(Dog) animal` est toujours sûr si `animal instanceof Dog` retourne `true`.", "VRAI - Si `instanceof` retourne `true`, cela garantit que le casting est sûr et ne provoquera pas de `ClassCastException`. C'est pour cela qu'on vérifie toujours avec `instanceof` avant de caster."),
  ),
  show_official_answer: show_official_answer,
  answer_below: true,
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Vous pouvez utiliser cet espace pour des notes ou des brouillons, ou compléter vos réponses aux questions précédentes.",
)
