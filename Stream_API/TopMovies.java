import java.util.*;
import java.util.stream.*;

class Movie {
    String title;
    int year;
    double rating;
    Movie(String t, int y, double r) {
        title = t; year = y; rating = r;
    }
    public String toString() {
        return title + " (" + year + ") - " + rating;
    }
    public int getYear() { return year; }
    public double getRating() { return rating; }
}

public class TopMovies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        List<Movie> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String title = sc.nextLine();
            int year = sc.nextInt();
            double rating = sc.nextDouble(); sc.nextLine();
            list.add(new Movie(title, year, rating));
        }
        list.stream()
            .sorted(Comparator.comparing(Movie::getRating).reversed()
            .thenComparing(Movie::getYear).reversed())
            .limit(5)
            .forEach(System.out::println);
        sc.close();
    }
}
