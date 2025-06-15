import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;

        while (true) {
            System.out.print("Enter a number : ");
            double number = scanner.nextDouble();

            if (number <= 0) {
                break; 
            }

            total += number; 
        }

        System.out.println("Total sum: " + total);
        scanner.close();
    }
}
