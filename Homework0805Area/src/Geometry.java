import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Geometry {


    static double rectSquare;
    static Scanner sc = new Scanner(System.in);
    static boolean action = true;


    Geometry() {

    }

    public static void main(String[] args) {
        Geometry geometry = new Geometry();
        System.out.println("Select options");
        int option;
        do {
            System.out.println("1. Calculate the square area");
            System.out.println("2. Calculate the rectangle area");
            System.out.println("3. Calculate the circle area");
            System.out.println("4. Exit");

            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.println("Insert length side ");
                    double number = Double.parseDouble(sc.nextLine());
                    rectSquare = CalculateSquare(number);
                    System.out.println("Geometric Shapes is " + rectSquare);
                    break;
                }
                case 2 -> {
                    System.out.println("Insert length");
                    double number1 = Double.parseDouble(sc.nextLine());
                    System.out.println("Insert width");
                    double number2 = Double.parseDouble(sc.nextLine());
                    rectSquare = CalculateSquare(number1, number2);
                    System.out.println("Geometric Shapes is " + rectSquare);
                    break;
                }
                case 3 -> {
                    System.out.println("Insert radius ");
                    float number3 = Float.parseFloat(sc.nextLine());
                    rectSquare = CalculateSquare(number3);
                    System.out.println("Geometric Shapes is " + rectSquare);
                    break;
                }
                case 4 -> {
                    System.out.println("Exit");
                    action = false;
                    break;
                }
                default -> {
                    System.out.println("Invalid Parameters");
                    break;
                }
            }
        } while (action);
    }

    static double CalculateSquare(double rectLength) {

        return rectLength * rectLength;
    }

    static double CalculateSquare(double rectLength, double rectWidth) {

        return rectWidth * rectLength;
    }


    static double CalculateSquare(float radius) {
        final float pi = 3.14159f;
        return pi * radius * radius;
    }
}

