// Classe principale GardenManagementSystem
//
// Cette classe contient la méthode main() qui permet de tester les classes
// Plant, Plot et Gardener.
//
// Elle illustre :
// - La création d'objets avec le mot-clé new
// - L'appel de méthodes sur des objets
// - L'accès direct aux attributs publics (pour cette première version)

public class GardenManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Système de gestion de jardin communautaire ===");
        System.out.println();

        // Création de plantes
        Plant tomato = new Plant("Tomate cerise", "Solanum lycopersicum", 
                                 "2025-04-15", 45.5);
        Plant carrot = new Plant("Carotte", "Daucus carota", 
                                 "2025-03-20", 12.0);
        Plant basil = new Plant("Basilic", "Ocimum basilicum", 
                                "2025-05-01", 25.3);

        // Création de parcelles
        Plot plot1 = new Plot(1, 10.5, "Zone Nord");
        Plot plot2 = new Plot(2, 15.0, "Zone Sud");

        // Création de jardiniers
        Gardener alice = new Gardener("Alice Dupont", "alice.dupont@example.com", 3);
        Gardener bob = new Gardener("Bob Martin", "bob.martin@example.com", 5);

        // Affichage des informations
        System.out.println("--- Plantes du jardin ---");
        tomato.displayInfo();
        carrot.displayInfo();
        basil.displayInfo();

        System.out.println("--- Parcelles du jardin ---");
        plot1.displayInfo();
        plot2.displayInfo();

        System.out.println("--- Jardiniers du jardin ---");
        alice.displayInfo();
        bob.displayInfo();

        // Modification directe des attributs (possible car ils sont publics)
        System.out.println("--- Mise à jour de la taille de la tomate ---");
        tomato.size = 52.7;
        tomato.displayInfo();

        // Test de la méthode harvest()
        System.out.println("--- Récolte des plantes ---");
        tomato.harvest();
        carrot.harvest();
        
        // Affichage des informations après récolte
        System.out.println();
        System.out.println("--- État des plantes après récolte ---");
        tomato.displayInfo();
        carrot.displayInfo();
        
        // Tentative de récolte d'une plante déjà récoltée
        System.out.println("--- Tentative de récolte de la tomate à nouveau ---");
        tomato.harvest();
    }
}
