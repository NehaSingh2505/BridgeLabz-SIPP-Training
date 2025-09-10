import java.util.Scanner;

public class SmartDeviceControl {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        SmartDevice light = new Light();
        SmartDevice ac = new AirConditioner();
        SmartDevice tv = new Television();

        System.out.println("Choose a device to control:");
        System.out.println("1. Light");
        System.out.println("2. Air Conditioner");
        System.out.println("3. Television");

        int choice = sc.nextInt();

        SmartDevice device = null;
        
        switch(choice) {
        	case 1: device = light; break;
        	case 2: device = ac; break;
        	case 3: device = tv; break;
        	default: System.out.println("Invalid choice!"); return;
        }

        System.out.println("Enter action: 1 (Turn ON), 2 (Turn OFF):");
        int action = sc.nextInt();

        if(action == 1) {
        	device.turnOn();
        } else if(action == 2) {
        	device.turnOff();
        } else {
        	System.out.println("Invalid action!");
        }
	}
}
