import java.util.Scanner;
import java.util.function.Predicate;

public class TemperatureAlertSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // Define threshold
        double threshold = 37.5;

        Predicate<Double> isHighTemp = temp -> temp > threshold;

        System.out.print("Enter current temperature : ");
        double temp = sc.nextDouble();

        if (isHighTemp.test(temp)) {
            System.out.println("Alert! High Temperature : " + temp + "°C");
        } else {
            System.out.println("Normal Temperature : " + temp + "°C");
        }
	}
}
