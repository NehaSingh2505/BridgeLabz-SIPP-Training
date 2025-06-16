import java.util.Scanner;

public class BMICalculator2DArray {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] data = new double[n][3]; 
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");

            System.out.print("Enter weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm): ");
            data[i][1] = sc.nextDouble();

            double heightInMeter = data[i][1] / 100;
            data[i][2] = data[i][0] / (heightInMeter * heightInMeter);

            double bmi = data[i][2];
            if (bmi <= 18.4) status[i] = "Underweight";
            else if (bmi <= 24.9) status[i] = "Normal";
            else if (bmi <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d: Height = %.1f cm, Weight = %.1f kg, BMI = %.2f, Status = %s\n",
                    i + 1, data[i][1], data[i][0], data[i][2], status[i]);
        }

        sc.close();
    }
}
