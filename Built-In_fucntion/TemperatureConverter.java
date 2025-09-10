import java.util.*;

public class TemperatureConverter {

    // Function to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    // Function to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    // Function to display menu and take input
    public static void startConversion() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose conversion type :");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter choice (1 or 2) : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter temperature in Fahrenheit : ");
                double f = sc.nextDouble();
                double c = fahrenheitToCelsius(f);
                System.out.printf("%.2f°F = %.2f°C\n", f, c);
                break;

            case 2:
                System.out.print("Enter temperature in Celsius : ");
                double cTemp = sc.nextDouble();
                double fTemp = celsiusToFahrenheit(cTemp);
                System.out.printf("%.2f°C = %.2f°F\n", cTemp, fTemp);
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        startConversion();
    }
}
