// Write a program to find the distance in yards and miles for the distance provided by the user in feet
// Hint => 1 mile = 1760 yards and 1 yard is 3 feet
// I/P => distanceInFeet
// O/P => The distance in yards is ___ while the distance in miles is ___

import java.util.Scanner;
public class MilesYards {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the distance in feet: ");
            double distanceInFeet = scanner.nextDouble();

            double distanceInYards = distanceInFeet / 3.0;
            double distanceInMiles = distanceInYards / 1760.0;

            System.out.println("The distance in yards is :" + distanceInYards +
                               " while the distance in miles is :" + distanceInMiles);
        }
    }
}