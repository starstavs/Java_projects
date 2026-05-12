public class FullTimeEmployee extends Employee{
    private double annualBonus;
    private int vacationDays;

    FullTimeEmployee(){

    }
    public int getVacationDays(String name) {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public double getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(double annualBonus) {
        this.annualBonus = annualBonus;
    }
}
