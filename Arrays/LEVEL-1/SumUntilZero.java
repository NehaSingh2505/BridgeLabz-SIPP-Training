import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];  
        double total = 0.0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number : ");
            double num = sc.nextDouble();

            if (num <= 0) {
                break;
            }

            if (index == 10) {
                System.out.println("Maximum of 10 values reached.");
                break;
            }

            numbers[index] = num;
            index++;
        }

        System.out.println("\nEntered numbers are:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];  
        }

        System.out.println("Total sum is :  " + total);

    }
}
