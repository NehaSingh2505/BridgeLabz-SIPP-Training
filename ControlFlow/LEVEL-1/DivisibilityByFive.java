
import java.util.Scanner;

public class DivisibilityByFive {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            if (number % 5 == 0) {
                System.out.println("Is the number " + number + " divisible by 5 :Yes");
            } else {
                System.out.println("Is the number " + number + " divisible by 5 : No");
            }
        }
    }
}