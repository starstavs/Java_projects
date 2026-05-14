public class FullTimeEmployee extends Employee {

    private static int employeeCount = 0;
    private double annualBonus;
    private int vacationDays;
    private final double annualPercent = 25;


    FullTimeEmployee(String name, double baseSalary, int vacationDays) {
        super(++employeeCount, name, baseSalary);
        this.annualBonus = getAnnualPercent();
        this.vacationDays = vacationDays;

    }

    public double getAnnualPercent() {
        return annualPercent;
    }


    public static int getEmployeeCount() {
        return employeeCount;
    }

    public int getVacationDays() {
        return vacationDays;
    }


    public double getAnnualBonus() {
        annualBonus = (getBaseSalary() * getAnnualPercent()) / 100;
        return annualBonus;
    }

    @Override
    public String toString() {
        return super.toString() + " annual bomus is " + getAnnualBonus() + " vacation days is " + getVacationDays();
    }


}
