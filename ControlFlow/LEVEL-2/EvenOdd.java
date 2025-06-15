import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        if (number < 1) {
            System.out.println("Enter a natural number: ");
            return;
        }

        for (int i = 1; i <= number; i++) {
            System.out.println(i + " is : " + (i % 2 == 0 ? "Even" : "Odd"));
        }
        sc.close();
    }
}
