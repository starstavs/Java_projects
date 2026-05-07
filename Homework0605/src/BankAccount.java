import java.util.Scanner;


public class BankAccount {
    static Scanner scan = new Scanner(System.in);
    static boolean actions = true;
    static SavingsAccount[] saver = new SavingsAccount[2];


    public static void main(String[] args) {
        int selectedUser = 0;
        for (int i = 0; i < saver.length; i++) {
            saver[i] = new SavingsAccount();
        }
        do {
            while (true) {
                System.out.println("Select user");
                System.out.println("1. User 1");
                System.out.println("2. User 2");
                int selOption = Integer.parseInt(scan.nextLine());
                switch (selOption) {
                    case 1 -> {
                        selectedUser = 0;
                        break;
                    }
                    case 2 -> {
                        selectedUser = 1;
                        break;
                    }
                    default -> {
                        System.out.println("Invalid parameter");
                        continue;
                    }

                }
                break;
            }


            int option;
            System.out.println("User interface menu");
            System.out.println("---------------------");
            System.out.println("Please, select the action.");
            System.out.println("1. Open a deposit.");
            System.out.println("2. Check balance.");
            System.out.println("3. Calculate the monthly interest.");
            System.out.println("4. Modify interest rate.");
            System.out.println("5. Exit.");
            option = Integer.parseInt(scan.nextLine());

            switch (option) {
                case 1 -> {

                    System.out.println("Insert name for User " + (int)(selectedUser + 1));
                    saver[selectedUser].userName = scan.nextLine();
                    System.out.println("Insert age for User " + (int)(selectedUser + 1));
                    saver[selectedUser].userAge = Integer.parseInt(scan.nextLine());
                    System.out.println("Insert balance for User " + (int)(selectedUser + 1));
                    saver[selectedUser].savingsBalance = Double.parseDouble(scan.nextLine());

                    System.out.println("User registered");
                    break;

                }


                case 2 -> {
                    System.out.println(saver[selectedUser].toString());
                    break;

                }
                case 3 -> {
                    saver[selectedUser].monthlyInterest = saver[selectedUser].calculateMonthlyInterest(saver[selectedUser].savingsBalance);
                    saver[selectedUser].savingsBalance += (double) Math.round(((saver[selectedUser].monthlyInterest * 12)) * 100) /100;
                    System.out.println("User " + saver[selectedUser].userName + " have monthly interest " + saver[selectedUser].monthlyInterest + "$");
                    System.out.println("New balance is " + saver[selectedUser].savingsBalance + "$");
                    break;
                }
                case 4 -> {

                    System.out.println("Your annual interest rate is " + saver[selectedUser].annualInterestRate);
                    System.out.println("Insert new annual interest rate");
                    double newInterestRate = Double.parseDouble(scan.nextLine());
                    saver[selectedUser].modifyInterestRate(newInterestRate);
                    System.out.println("New annual interest rate is " + saver[selectedUser].annualInterestRate);
                    break;
                }
                case 5 -> {
                    System.out.println("Session closed");
                    actions = false;
                    break;
                }
                default -> System.out.println("Invalid parameter");
            }
        } while (actions);
        scan.close();
    }
}
