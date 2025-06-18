import java.util.Scanner;

public class BMICalculator {

    
    public static double calculateBMI(double weight, double heightCm) {
        double heightMeters = heightCm / 100.0;
        return weight / (heightMeters * heightMeters);
    }

    
    public static String getBMIStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] data = new double[10][3];  
        String[] status = new String[10];

        System.out.println("Enter weight (kg) and height (cm) for 10 persons:");

        for (int i = 0; i < 10; i++) {
            System.out.printf("Person %d - Weight (kg): ", i + 1);
            data[i][0] = scanner.nextDouble();

            System.out.printf("Person %d - Height (cm): ", i + 1);
            data[i][1] = scanner.nextDouble();

           
            data[i][2] = calculateBMI(data[i][0], data[i][1]);

           
            status[i] = getBMIStatus(data[i][2]);
        }

        
        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight", "Height", "BMI", "Status");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n", data[i][0], data[i][1], data[i][2], status[i]);
        }

        scanner.close();
    }
}