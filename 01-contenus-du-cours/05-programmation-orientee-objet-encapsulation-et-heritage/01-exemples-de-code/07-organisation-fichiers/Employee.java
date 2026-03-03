public abstract class Employee {
    protected String name;
    protected String employeeId;
    protected double baseSalary;

    public Employee(String name, String employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Méthode abstraite : chaque type d'employé calcule son salaire différemment
    public abstract double calculateSalary();

    // Méthode concrète commune
    public void displayInfo() {
        System.out.println("Employé: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Salaire de base: " + baseSalary + " CHF");
        System.out.println("Salaire total: " + calculateSalary() + " CHF");
    }
}
