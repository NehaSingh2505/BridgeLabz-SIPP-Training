import java.util.Scanner;

public class QuotientRemainderCalculator {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the first number: ");
            int number1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int number2 = scanner.nextInt();

            if (number2 == 0) {
                System.out.println("Division by zero is not allowed.");
            } else {
                int quotient = number1 / number2;
                int remainder = number1 % number2;

                System.out.println("The Quotient is =" + quotient +
                                   " and Remainder is =" + remainder +
                                   " of two numbers " + number1 + " and " + number2);
            }
        }
    }
}
