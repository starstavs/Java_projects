import java.util.Scanner;

public class Calculator {
    Scanner scanNumber = new Scanner(System.in);
    int scanNumber1, scanNumber2;

    public int getNumber1() {
        System.out.println("Enter number 1.");
        scanNumber1 = scanNumber.nextInt();
        scanNumber.nextLine();
        return scanNumber1;
    }
    public int getNumber2() {
        System.out.println("Enter number 2.");
        scanNumber2 = scanNumber.nextInt();
        scanNumber.nextLine();
        return scanNumber2;
    }
}
