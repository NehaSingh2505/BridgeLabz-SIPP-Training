import java.util.Scanner;

public class DivisionCalculator {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;

        return new int[] { quotient, remainder };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number:");
        int number = sc.nextInt();

        System.out.println("Enter the divisor:");
        int divisor = sc.nextInt();

        if (divisor == 0) {
            System.out.println("Divisor cannot be zero!");
        } else {
            int[] result = findRemainderAndQuotient(number, divisor);
            System.out.println("Quotient: " + result[0]);
            System.out.println("Remainder: " + result[1]);
        }
    }
}
