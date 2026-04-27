/**
 * Classe représentant une jardinière qui cultive une parcelle.
 */
public class Gardener {
    private String name;
    private String email;
    private int yearsOfExperience;
    
    /**
     * Constructeur pour créer une jardinière.
     * 
     * @param name le nom
     * @param email l'adresse email
     * @param yearsOfExperience les années d'expérience
     */
    public Gardener(String name, String email, int yearsOfExperience) {
        setName(name);
        setEmail(email);
        setYearsOfExperience(yearsOfExperience);
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    // Setters avec validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Erreur : le nom ne peut pas être vide.");
            return;
        }
        this.name = name;
    }
    
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            System.out.println("Erreur : l'email doit être valide.");
            return;
        }
        this.email = email;
    }
    
    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            System.out.println("Erreur : l'expérience ne peut pas être négative.");
            return;
        }
        this.yearsOfExperience = yearsOfExperience;
    }
    
    /**
     * Affiche les informations de la jardinière.
     */
    public void displayInfo() {
        System.out.println("=== Informations de la jardinière ===");
        System.out.println("Nom: " + name);
        System.out.println("Email: " + email);
        System.out.println("Expérience: " + yearsOfExperience + " ans");
    }

    /**
     * Compare cette jardinière avec un autre objet pour l'égalité.
     * Deux jardinières sont égales si elles ont le même email.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Gardener other = (Gardener) obj;
        return email.equals(other.email);
    }

    /**
     * Retourne un code de hachage pour cette jardinière.
     * Le code de hachage est basé sur l'email.
     */
    @Override
    public int hashCode() {
        return email.hashCode();
    }
}

