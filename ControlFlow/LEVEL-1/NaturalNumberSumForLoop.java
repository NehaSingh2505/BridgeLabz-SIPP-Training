
import java.util.Scanner;

public class NaturalNumberSumForLoop {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a natural number: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Enter a natural number greater than 0.");
                return;
            }

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }

            int formulaSum = n * (n + 1) / 2;

            System.out.println("Sum using for loop: " + sum);
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Are both results equal : " + (sum == formulaSum ? "Yes" : "No"));
        }
    }
}
