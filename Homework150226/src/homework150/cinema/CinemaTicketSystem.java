package homework150.cinema;

import java.time.LocalTime;
import java.util.Scanner;

public class CinemaTicketSystem {
    public static Movies movies = new Movies();
    public static StudentTickets studentTickets = new StudentTickets();
    public static VipTickets vipTickets = new VipTickets();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Buyer[] buyer = new Buyer[50];
        int options, buyerCount = 0, movieIndex, movieTimeIndex;
        LocalTime moviTime;
        boolean action = true;

        while (action) {


            System.out.println("Welcome in cinema");

            buyer[buyerCount] = new Buyer();


            System.out.println("Would you like a VIP ticket? 1 - Yes, 2 - No");
            buyer[buyerCount].setVip((Integer.parseInt(scan.nextLine()) == 1) ? 1 : 0);

            System.out.println("You are student? 1 - Yes, 2 - No");
            buyer[buyerCount].setStudent((Integer.parseInt(scan.nextLine()) == 1) ? 1 : 0);


            System.out.println(("Select your desired movie."));
            movies.getMovies();
            options = Integer.parseInt(scan.nextLine());
            switch (options) {

                case 1 -> {
                    movieIndex = options - 1;
                    movieTimeIndex = movies.getMovies(movieIndex);

                    //  buyer[buyerCount].price = movies.getPrice(movieIndex);
                    buyer[buyerCount].setPrice(movies.getPrice(movieIndex));

                    if (buyer[buyerCount].getVip() == 1) {
                        buyer[buyerCount].setPrice(vipTickets.getMarkup(buyer[buyerCount].getPrice()));
                        buyer[buyerCount].setMovie(movies);
                        System.out.println("ssss" + buyer[buyerCount].getMovie());
                    }
                    if ((buyer[buyerCount].getStudent() == 1)) {
                        moviTime = movies.getMovieTime(movieIndex, movieTimeIndex);
                        buyer[buyerCount].setPrice(studentTickets.getDiscountPercent(buyer[buyerCount].getPrice(), moviTime));


                    }


                    System.out.println("sss");


                }
            }
            buyerCount++;
        }

    }
}
