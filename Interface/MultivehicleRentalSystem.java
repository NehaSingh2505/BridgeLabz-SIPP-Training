import java.util.Scanner;

public class MultivehicleRentalSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        VehicleRental car = new Car();
        VehicleRental bike = new Bike();
        VehicleRental bus = new Bus();

        System.out.println("Choose a vehicle to rent : ");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Bus");

        int choice = sc.nextInt();
        VehicleRental vehicle = null;

        switch(choice) {
            case 1: vehicle = car; break;
            case 2: vehicle = bike; break;
            case 3: vehicle = bus; break;
            default: System.out.println("Invalid choice!"); return;
        }

        System.out.println("Enter action: 1 (Rent), 2 (Return)");
        int action = sc.nextInt();

        if(action == 1) {
            vehicle.rent();
        } else if(action == 2) {
            vehicle.returnVehicle();
        } else {
            System.out.println("Invalid action!");
        }
	}
}
