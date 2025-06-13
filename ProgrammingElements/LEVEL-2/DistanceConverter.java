import java.util.Scanner;

public class DistanceConverter {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the distance in feet: ");
            double distanceInFeet = scanner.nextDouble();

            double distanceInYards = distanceInFeet / 3.0;
            double distanceInMiles = distanceInYards / 1760.0;

            System.out.println("The distance in yards is =" + distanceInYards +
                               " while the distance in miles is =" + distanceInMiles);
        }
    }
}
