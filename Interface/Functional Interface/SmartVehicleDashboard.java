import java.util.Scanner;

public class SmartVehicleDashboard {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        Vehicle normalCar = new Cars();
        Vehicle tesla = new ElectricCar();

        System.out.print("Enter Car speed : ");
        int carSpeed = sc.nextInt();
        normalCar.displaySpeed(carSpeed);

        System.out.print("Enter Electric Car speed : ");
        int eSpeed = sc.nextInt();
        tesla.displaySpeed(eSpeed);

        System.out.print("Enter Electric Car battery % : ");
        int battery = sc.nextInt();
        tesla.displayBattery(battery);
	}
}
