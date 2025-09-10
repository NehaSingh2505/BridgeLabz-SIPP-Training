import java.util.Scanner;

interface UnitConverter {
    static double kmToMiles(double km) {
        return km * 0.621371; 
    }

    static double kgToLbs(double kg) {
        return kg * 2.20462; 
    }
}

public class UnitConversion {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose conversion type : ");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Kilograms to Pounds");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter distance in kilometers : ");
                double km = sc.nextDouble();
                double miles = UnitConverter.kmToMiles(km);
                System.out.println(km + " km = " + miles + " miles");
                break;

            case 2:
                System.out.print("Enter weight in kilograms : ");
                double kg = sc.nextDouble();
                double lbs = UnitConverter.kgToLbs(kg);
                System.out.println(kg + " kg = " + lbs + " lbs");
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
