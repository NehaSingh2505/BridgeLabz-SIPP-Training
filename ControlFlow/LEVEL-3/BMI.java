import java.util.Scanner;

public class BMI{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();

        System.out.print("Enter height in cm: ");
        double heightCm = sc.nextDouble();

        double heightMeter = heightCm / 100;
        double bmi = weight / (heightMeter * heightMeter);

        System.out.printf("Your BMI is: %.2f\n", bmi);

        if (bmi <= 18.4)
            System.out.println("Status: Underweight");
        else if (bmi <= 24.9)
            System.out.println("Status: Normal");
        else if (bmi <= 39.9)
            System.out.println("Status: Overweight");
        else
            System.out.println("Status: Obese");

        sc.close();
    }
}
