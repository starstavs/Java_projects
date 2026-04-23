import java.util.Scanner;

public class VariablesOperatorStringsSCaner {


    public static void main(String[] args) {
        int mySelect;
        boolean execution = true;
        Scanner scanWork = new Scanner(System.in);
        PersonalInformation persInfo = new PersonalInformation();
        Calculator calc = new Calculator();

        System.out.println("Select an option");
        System.out.println("Write 1, if you want to meet.");
        System.out.println("Write 2, if you you need a calculator.");
        System.out.println("Write 3, if you need a temperature converter.");
        System.out.println("Write 4, if you want to need salary calculator.");
        System.out.println("Write 5, if you age in the future.");
        System.out.println("Write 6, if you want challenge.");
        System.out.println("Write 7, if you need mini profile generator.");
        System.out.println("Write 0, Exit");

        while (execution) {


            mySelect = scanWork.nextInt();
            switch (mySelect) {
                case 1: {
                    persInfo.getName();
                    persInfo.getYear();
                    persInfo.getCity();
                    persInfo.printName();
                    System.out.println("--------------------------");

                    break;
                }
                case 2: {
                    int num1 = calc.getNumber1();
                    int num2 = calc.getNumber2();
                    System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                    System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                    System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                    System.out.println(num1 + " / " + num2 + " = " + ((double)(num1 / num2)));
                    break;
                }
                case 3: {
                    System.out.println("Hallo3");
                    break;
                }
                case 4: {
                    System.out.println("Hallo4");
                    break;
                }
                case 5: {
                    System.out.println("Hallo5");
                    break;
                }
                case 6: {
                    System.out.println("Hallo6");
                    break;
                }
                case 7: {
                    System.out.println("Hallo7");
                    break;
                }
                case 0: {
                    System.out.println("Bye");
                    execution = false;
                    break;
                }
            }

        }
    }
}