import java.util.Scanner;
import java.time.LocalDate;

public class PersonalInformation {
    String name;
    int age;
    String city;
    LocalDate today = LocalDate.now();
    int yearNow = today.getYear();
    Scanner scanObj = new Scanner(System.in);

    public void getName() {
        System.out.println("Enter please your name.");
        name = scanObj.nextLine();
    }

    public void getYear() {
        System.out.println("Enter please your year of birth.");
        age = yearNow - scanObj.nextInt();
        scanObj.nextLine();
    }

    public void getCity() {
        System.out.println("Enter you city, please");
        city = scanObj.nextLine();
    }

    public void printName() {
        System.out.println("Hallo " + name + "!");
        System.out.println("You are " + age + " yaers old.");
        System.out.println("You live in city " + city + ".");


    }

}
