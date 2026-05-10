import java.time.*;


public class Car {
    String vehicleNumber;
    LocalTime arrivalTime;
    LocalDate arrivalDate;
    Double fee;




    public Car() {

    }

    @Override
    public String toString() {
        return "Vehicle " + vehicleNumber + ", arrival " + arrivalDate + ", am " + arrivalTime;
    }

    ;

}
