package homework150.cinema;

public class VipTickets extends Movies {

   // private String snack[] = new String[]{"Coca-Cola", "Chips", "Popcorn"};
    private final int MARKUP = 10;


    public double getMarkup(double price){
        return price + (price * MARKUP / 100);
    }

    public void BookTicket() {

    }


}
