import java.util.Scanner;

public class SumOfNaturalNumber {

    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = sc.nextInt();

        int sum = calculateSum(number);
        System.out.println("Sum of first " + number + " natural numbers is: " + sum);
    }
}
