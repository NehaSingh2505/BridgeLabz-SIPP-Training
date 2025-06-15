import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base number =");
        int base = sc.nextInt();
        System.out.print("Enter the power = ");
        int power = sc.nextInt();
        int result = 1;

        for (int i = 1; i <= power; i++) {
            result *= base;
        }

        System.out.println("Result: " + result);
    }
}

