public class PartTimeEmployee extends Employee {
    private static int workedHour;
    private static final double hourlyRate = 15.0;
    private static int employeeCount = 0;
    private int departmentNumber;
    private static double salary;

    PartTimeEmployee(String name, int workedHour, int departmentNumber) {
        super(++employeeCount, name, SalaryCalculate(workedHour));
        this.workedHour = workedHour;
        this.departmentNumber = departmentNumber;

    }
    public static double SalaryCalculate(double workedHour){
       salary = workedHour  * hourlyRate;
       return salary;
    }

    public int getWorkedHour() {
        return workedHour;
    }


    public int getDepartmentNumber() {
        return departmentNumber;
    }



    @Override
    public String toString() {
        return super.toString() + " for "+ getWorkedHour() + " hour worked in department " + getDepartmentNumber() + ".";
    }
}
