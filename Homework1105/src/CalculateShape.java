import java.util.Scanner;

public class CalculateShape {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double radius;
        double width;
        double height;
        System.out.println("Enter radius");
        radius = Double.parseDouble(scan.nextLine());
        Circle circle = new Circle(radius);
        System.out.println(circle);
        System.out.println("Enter rectangle width");
        width = Double.parseDouble(scan.nextLine());
        System.out.println("Enter rectangle height");
        height = Double.parseDouble(scan.nextLine());
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println(rectangle);

        System.out.println("Enter the base of the triangle");
        width = Double.parseDouble(scan.nextLine());
        System.out.println("Enter height of a triangle");
        height = Double.parseDouble(scan.nextLine());
        Triangle triangle = new Triangle(width,height);
        System.out.println(triangle);




    }
}
