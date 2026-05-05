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
