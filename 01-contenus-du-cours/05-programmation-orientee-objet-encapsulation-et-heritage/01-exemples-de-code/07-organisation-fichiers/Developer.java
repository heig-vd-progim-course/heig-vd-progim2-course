public class Developer extends Employee {
    private String programmingLanguage;
    private int projectsCompleted;

    public Developer(String name, String employeeId, double baseSalary,
                     String programmingLanguage) {
        super(name, employeeId, baseSalary);
        this.programmingLanguage = programmingLanguage;
        this.projectsCompleted = 0;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void completeProject() {
        projectsCompleted++;
        System.out.println(name + " a terminé un projet (" +
                         programmingLanguage + "). Total: " + projectsCompleted);
    }

    @Override
    public double calculateSalary() {
        // Bonus de 500 CHF par projet complété
        return baseSalary + (projectsCompleted * 500);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Langage: " + programmingLanguage);
        System.out.println("Projets complétés: " + projectsCompleted);
    }
}
