import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ParkingCharges {
    final static double minimalFee = 2.0;
    final static int minimalParkTime = 180;
    final static double additionalFee = 0.5;
    final static int maxChargeTime = 1440;
    static Scanner scan = new Scanner(System.in);
    static boolean action = true;
    static Car[] car = new Car[50];
    public static int countCar = 0;
    static String newCar;
    static double totalFeePerDay;

    ParkingCharges() {

    }


    public static void main(String[] args) {


        int options;


        do {

            System.out.println("Select options");
            System.out.println("1. Car arrived at the parking");
            System.out.println("2. Car status");
            System.out.println("3. Auto left the parking");
            System.out.println("4. Exit");
            options = Integer.parseInt(scan.nextLine());
            switch (options) {
                case 1 -> {
                    System.out.println("Car arrived");
                    newCar = carArrived(countCar);
                    System.out.println("The car with number " + newCar + " saved.");
                    break;
                }
                case 2 -> {

                    getListOfCar(countCar);


                    break;
                }
                case 3 -> {
                    calculateCharges(countCar);
                    break;
                }
                case 4 -> {
                    System.out.println("Goodbye");
                    action = false;
                    break;
                }
                default -> {
                    System.out.println("Invalid parameter");

                }
            }


        } while (action);
        scan.close();

    }

    public static String carArrived(int countCar) {
        System.out.println("Insert vehicle number");
        String vehicleNumber = scan.nextLine();
        car[countCar] = new Car();
        car[countCar].vehicleNumber = vehicleNumber;
        System.out.println("Insert arrived date(YYYY-MM-DD)");
        car[countCar].arrivalDate = LocalDate.parse(scan.nextLine());
        System.out.println("Insert arrived time(HH:MM)");
        car[countCar].arrivalTime = LocalTime.parse(scan.nextLine());
        ParkingCharges.countCar++;
        return vehicleNumber;
    }

    public static void getListOfCar(int countCar) {
        if (countCar == 0) return;
        for (int i = 0; i < countCar; i++) {
            System.out.println(car[i].toString());
        }
    }

    public static void calculateCharges(int countCar) {
        if (countCar == 0) return;
        totalFeePerDay = 0;
        for (int i = 0; i < countCar; i++) {
            Duration timeDuration = getChargeTime(i);
            long minutes = timeDuration.toMinutes();
            if (minutes <= minimalParkTime) {
                car[i].fee = minimalFee;
            } else if (minutes > maxChargeTime) {
                car[i].fee = 10.0;
                System.out.println("The vehicle with license plate "+ car[i].vehicleNumber +" has exceeded the maximum parking time.");
            } else {
                if (((int) minutes - minimalParkTime) % 60 == 0) {
                    car[i].fee = minimalFee + (((int) minutes - minimalParkTime) / 60) * additionalFee;
                } else {
                    car[i].fee = minimalFee + ((((int) minutes - minimalParkTime) / 60) + 1) * additionalFee;
                }
            }
            totalFeePerDay += car[i].fee;
            System.out.println("Vehicle " + car[i].vehicleNumber + ", duration " + timeDuration.toHours() + " Hour, " + timeDuration.toMinutesPart() + " Minutes. Total fee " + car[i].fee);
        }
        System.out.println("-------------------------------------------");
        System.out.println("Total income was" + totalFeePerDay);
    }

    public static Duration getChargeTime(int i) {
        LocalDateTime combTime = LocalDateTime.of(car[i].arrivalDate, car[i].arrivalTime);
        return Duration.between(combTime, LocalDateTime.now());
    }
}