package homework150.cinema;

import java.time.LocalTime;
import java.util.Scanner;

public class Movies {

    private final Object[][] movies = new Object[3][];
    Scanner scan = new Scanner(System.in);

    Movies() {
        movies[0] = new Object[]{"1 The Forbidden Kingdom", 10.0, LocalTime.of(10, 0), LocalTime.of(14, 0), LocalTime.of(18, 0)};
        movies[1] = new Object[]{"2 Project Hail Mary", 12.0, LocalTime.of(8, 0), LocalTime.of(17, 0)};
        movies[2] = new Object[]{"3 The Astronaut", 14.0, LocalTime.of(15, 0), LocalTime.of(22, 0)};
    }

    protected int getMovies(int numberMovie) {

        for (int j = 2; j < movies[numberMovie].length; j++) {
            System.out.println((j - 1) + " - " + movies[numberMovie][j]);
        }
        System.out.println("Select time");
        int option = Integer.parseInt(scan.nextLine());
        if (option <= movies[numberMovie].length) return option;
        else return 0;
    }

    protected void getMovies() {
        for (int i = 0; i < movies.length; i++) {
            System.out.println(" \n" + movies[i][0] + " - " + movies[i][1] + "Euro \n");
            for (int j = 2; j < movies[i].length; j++) {
                System.out.print(movies[i][j] + " ");
            }
        }

    }

    protected LocalTime getMovieTime(int numberMovie, int numberTime) {
        return (LocalTime) movies[numberMovie][numberTime];
    }

    protected double getPrice(int numberMovie) {
        return (double) movies[numberMovie][1];
    }

    @Override
    public String toString() {
        return "Movie" + movies[0][0];
    }

}




