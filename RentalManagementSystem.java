import java.util.*;

public class RentalManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the customer name: ");
        String customerName = sc.nextLine();
        System.out.println("What you want to rent? (Bike/Car/Truck): ");
        String vehicleType = sc.nextLine().toLowerCase();
        System.out.println("Enter the number of days you want to rent the vehicle: ");
        int days = sc.nextInt();

        Rentable bike = new Bike("B123", "Mountain Bike", 500);
        Rentable car = new Car("sedan", "sedan car", 1000);
        Rentable truck = new Truck("T789", "Pickup Truck", 2000);

        if (vehicleType.equals("bike")) {
            System.out.println("You have selected Bike for rent.");
            System.out.println("Bike Rent for " + days + " days: Rs. " + bike.calculateRent(days));
        } else if (vehicleType.equals("car")) {
            System.out.println("You have selected Car for rent.");
            System.out.println("Car Rent for " + days + " days: Rs. " + car.calculateRent(days));
        } else if (vehicleType.equals("truck")) {
            System.out.println("You have selected Truck for rent.");
            System.out.println("Truck Rent for " + days + " days: Rs. " + truck.calculateRent(days));
        } else {
            System.out.println("Invalid vehicle type selected.");
        }
    }
}