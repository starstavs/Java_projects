import java.util.Scanner;

public class EmployeeManagement {


    public static void main(String[] args) {
        boolean action = true;
        int option;
        String name;
        double baseSalary;
        int vacationDay;
        int workedHour;
        double hourleRate;
        int department;
        int fullTimeCount = 0, partTimeCount = 0;

        Scanner scan = new Scanner(System.in);
        FullTimeEmployee[] fullTimeEmployee = new FullTimeEmployee[50];
        PartTimeEmployee[] partTimeEmployee = new PartTimeEmployee[50];

        do {
            System.out.println("Manage employee.");
            System.out.println("--------------------");
            System.out.println("1 Full time employee");
            System.out.println("2 Part time employee");
            System.out.println("3 Exit");
            option = Integer.parseInt(scan.nextLine());
            switch (option) {
                case 1 -> {
                    System.out.println("Select action");
                    System.out.println("1 Add new employee");
                    System.out.println("2 List of Employees");

                    option = Integer.parseInt(scan.nextLine());
                    switch (option) {
                        case 1 -> {
                            System.out.println("Enter name");
                            name = scan.nextLine();
                            System.out.println("Enter base salary");
                            baseSalary = Double.parseDouble(scan.nextLine());
                            System.out.println("Enter vacation days");
                            vacationDay = Integer.parseInt(scan.nextLine());
                            fullTimeEmployee[fullTimeCount] = new FullTimeEmployee(name, baseSalary, vacationDay);
                            fullTimeCount++;
                        }
                        case 2 -> {
                            for (int i = 0; i < fullTimeCount; i++) {
                                System.out.println(fullTimeEmployee[i]);
                            }

                        }

                        default -> System.out.println("Invalid parameter");

                    }
                }
                case 2 -> {
                    System.out.println("Select action");
                    System.out.println("1 Add new employee");
                    System.out.println("2 List of Employees");
                    option = Integer.parseInt(scan.nextLine());
                    switch (option) {
                        case 1 -> {
                            System.out.println("Enter name");
                            name = scan.nextLine();
                            System.out.println("Enter worked hour");
                            workedHour = Integer.parseInt(scan.nextLine());
                            System.out.println("Enter department");
                            department = Integer.parseInt(scan.nextLine());
                            partTimeEmployee[partTimeCount] = new PartTimeEmployee(name, workedHour, department);
                            partTimeCount++;
                        }
                        case 2 -> {
                            for (int i = 0; i < partTimeCount; i++) {
                                System.out.println(partTimeEmployee[i]);
                            }
                        }

                        default -> System.out.println("Invalid parameter");
                    }
                }
                case 3 -> {
                    action = false;
                    System.out.println("Goodbye");
                }
                default -> {
                    System.out.println("Invalid parameter");
                    continue;
                }
            }

        } while (action);

        scan.close();
    }


}
