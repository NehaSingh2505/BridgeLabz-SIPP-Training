import java.util.Scanner;

public class CloningPrototypeObject {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Vehicle Model : ");
        String model = sc.nextLine();
        System.out.print("Enter Vehicle Color : ");
        String color = sc.nextLine();

        Vehicles prototype = new Vehicles(model, color);

        try {
            Vehicles clone1 = (Vehicles) prototype.clone();
            Vehicles clone2 = (Vehicles) prototype.clone();

            System.out.println("\nOriginal Vehicle : ");
            prototype.display();

            System.out.println("\nCloned Vehicles : ");
            clone1.display();
            clone2.display();

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported!");
        }
	}
}
