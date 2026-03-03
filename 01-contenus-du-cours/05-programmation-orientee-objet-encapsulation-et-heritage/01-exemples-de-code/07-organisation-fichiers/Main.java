public class Main {
    public static void main(String[] args) {
        System.out.println("=== Système de gestion des employés ===\n");

        // Créer des développeurs
        Developer dev1 = new Developer("Alice Dupont", "DEV001", 80000, "Java");
        Developer dev2 = new Developer("Bob Martin", "DEV002", 75000, "Python");

        // Créer un manager
        Manager manager = new Manager("Carol Smith", "MGR001", 90000, 5);

        // Simuler du travail
        System.out.println("=== Activités ===");
        dev1.completeProject();
        dev1.completeProject();
        dev2.completeProject();
        manager.setBonus(5000);
        System.out.println();

        // Afficher les informations
        System.out.println("=== Développeur 1 ===");
        dev1.displayInfo();
        System.out.println();

        System.out.println("=== Développeur 2 ===");
        dev2.displayInfo();
        System.out.println();

        System.out.println("=== Manager ===");
        manager.displayInfo();
        System.out.println();

        // Traitement polymorphe
        System.out.println("=== Masse salariale totale ===");
        Employee[] employees = {dev1, dev2, manager};
        
        double totalSalary = 0;
        for (Employee emp : employees) {
            totalSalary += emp.calculateSalary();
        }
        System.out.println("Total: " + totalSalary + " CHF");
    }
}
