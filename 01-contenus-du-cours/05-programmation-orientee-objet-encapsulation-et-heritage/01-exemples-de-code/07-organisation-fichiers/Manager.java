public class Manager extends Employee {
    private int teamSize;
    private double bonus;

    public Manager(String name, String employeeId, double baseSalary, int teamSize) {
        super(name, employeeId, baseSalary);
        this.teamSize = teamSize;
        this.bonus = 0.0;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setBonus(double bonus) {
        if (bonus >= 0) {
            this.bonus = bonus;
            System.out.println("Bonus de " + bonus + " CHF attribué à " + name);
        }
    }

    @Override
    public double calculateSalary() {
        // Salaire de base + bonus + prime d'équipe (100 CHF par membre)
        return baseSalary + bonus + (teamSize * 100);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Taille de l'équipe: " + teamSize);
        System.out.println("Bonus: " + bonus + " CHF");
    }
}
