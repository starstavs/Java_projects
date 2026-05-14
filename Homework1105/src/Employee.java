public class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return getEmployeeId() + ". Name " + getName() + ", base salary " + getBaseSalary();
    }
}
