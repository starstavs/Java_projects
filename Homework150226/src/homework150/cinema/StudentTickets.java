package homework150.cinema;

import java.time.LocalTime;


public class StudentTickets extends Movies {
    private final double DISCOUNTPERCENT = 5;
    private final String ALLOWEDDAY[] = new String[]{"Monday", "Thursday", "Wednesday", "Thursday", "Friday "};
    private final LocalTime startTime = LocalTime.of(8, 0);
    private final LocalTime endTime = LocalTime.of(17, 0);


    protected double getDiscountPercent(double price, LocalTime movieTime) {
        if (LocalTime.now().isAfter(startTime) && LocalTime.now().isBefore(endTime)) {
            return price - (price * DISCOUNTPERCENT / 100);
        } else {
            System.out.println("The selected time is not eligible for the student discount.");
            return price;
        }
    }


}
