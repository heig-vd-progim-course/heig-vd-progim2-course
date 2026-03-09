import java.util.HashSet;

/**
 * Exemple d'implémentation de equals() et hashCode()
 * 
 * Ce programme montre comment implémenter correctement ces deux méthodes
 * pour comparer des objets par leur contenu.
 */

class Bike {
    String brand;
    String model;
    
    Bike(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    /**
     * Redéfinition de equals() pour comparer le contenu
     * Deux vélos sont égaux s'ils ont la même marque et le même modèle
     */
    @Override
    public boolean equals(Object obj) {
        // 1. Vérifier si c'est le même objet (optimisation)
        if (this == obj) {
            return true;
        }
        
        // 2. Vérifier si l'objet est null
        if (obj == null) {
            return false;
        }
        
        // 3. Vérifier le type (avec getClass() ou instanceof)
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        // 4. Cast et comparaison des attributs
        Bike other = (Bike) obj;
        return brand.equals(other.brand) && model.equals(other.model);
    }
    
    /**
     * Redéfinition de hashCode() en cohérence avec equals()
     * Si deux objets sont égaux, ils doivent avoir le même hashCode
     */
    @Override
    public int hashCode() {
        // Formule courante : 31 * hash + attribut
        int result = brand.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }
    
    /**
     * Redéfinition de toString() pour un affichage lisible
     */
    @Override
    public String toString() {
        return "Bike{brand='" + brand + "', model='" + model + "'}";
    }
}

// Programme principal
class EqualsHashCodeDemo {
    public static void main(String[] args) {
        // Création d'objets
        Bike bike1 = new Bike("VanMoof", "S3");
        Bike bike2 = new Bike("VanMoof", "S3");  // Même contenu que bike1
        Bike bike3 = bike1;                       // Référence vers bike1
        Bike bike4 = new Bike("Stromer", "ST5"); // Contenu différent
        
        // Comparaison avec == (références)
        System.out.println("=== Comparaison avec == ===");
        System.out.println("bike1 == bike2 : " + (bike1 == bike2) + 
                          " (adresses différentes)");
        System.out.println("bike1 == bike3 : " + (bike1 == bike3) + 
                          " (même adresse)");
        
        // Comparaison avec equals() (contenu)
        System.out.println("\n=== Comparaison avec equals() ===");
        System.out.println("bike1.equals(bike2) : " + bike1.equals(bike2) + 
                          " (même contenu)");
        System.out.println("bike1.equals(bike3) : " + bike1.equals(bike3) + 
                          " (même objet)");
        System.out.println("bike1.equals(bike4) : " + bike1.equals(bike4) + 
                          " (contenu différent)");
        
        // Vérification du hashCode
        System.out.println("\n=== HashCode ===");
        System.out.println("bike1.hashCode() : " + bike1.hashCode());
        System.out.println("bike2.hashCode() : " + bike2.hashCode() + 
                          " (même valeur car equals = true)");
        System.out.println("bike4.hashCode() : " + bike4.hashCode() + 
                          " (valeur différente)");
        
        // Test avec HashSet
        System.out.println("\n=== Test avec HashSet ===");
        HashSet<Bike> uniqueBikes = new HashSet<>();
        
        System.out.println("Ajout de bike1 : " + uniqueBikes.add(bike1));
        System.out.println("Ajout de bike2 : " + uniqueBikes.add(bike2) + 
                          " (considéré comme doublon)");
        System.out.println("Ajout de bike4 : " + uniqueBikes.add(bike4));
        System.out.println("Taille du HashSet : " + uniqueBikes.size());
        
        // Affichage du contenu
        System.out.println("\nContenu du HashSet :");
        for (Bike bike : uniqueBikes) {
            System.out.println("  " + bike);
        }
    }
}
