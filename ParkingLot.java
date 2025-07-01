import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        int maxSlots = 6;
        int parkedCars = 0;
        Scanner input = new Scanner(System.in);

        while (parkedCars < maxSlots) {
            System.out.print("want to park a car? (yes/no): ");
            String choice = input.nextLine();

            if (choice.equals("yes")) {
                parkedCars++;
                System.out.println("Car parked. Total parked: " + parkedCars);
            } else if (choice.equals("no")) {
                System.out.println("Exiting Parking System");
                break;
            } else {
                System.out.println("Invalid input. Type 'yes' or 'no'.");
            }
        }

        if (parkedCars == maxSlots) {
            System.out.println("Parking Full");
        }

    }
}
