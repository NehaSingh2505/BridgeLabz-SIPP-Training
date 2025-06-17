import java.util.Scanner;

public class WindChillCalculator {

    public static double calculateWindChill(double temperature, double windSpeed) {
        double windChill = 35.74 + 0.6215 * temperature
                + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the temperature in Fahrenheit:");
        double temperature = sc.nextDouble();

        System.out.println("Enter the wind speed in miles per hour:");
        double windSpeed = sc.nextDouble();

        if (temperature > 50 || windSpeed < 3) {
            System.out.println("Wind chill is only defined for temperatures <= 50°F and wind speeds >= 3 mph.");
        } else {
            double windChill = calculateWindChill(temperature, windSpeed);
            System.out.printf("The wind chill temperature is: %.2f°F\n", windChill);
        }
    }
}
