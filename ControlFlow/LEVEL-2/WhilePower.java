import java.util.Scanner;

public class WhilePower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base number: ");
        int baseNumber = sc.nextInt();
        System.out.print("Enter the power: ");
        int powerNumber = sc.nextInt();
        int result = 1, count = 0;

        while (count < powerNumber) {
            result *= baseNumber;
            count++;
        }

        System.out.println("Result: " + result);
    }
}
