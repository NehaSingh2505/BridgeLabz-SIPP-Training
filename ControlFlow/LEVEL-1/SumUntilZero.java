import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double userInput;

        System.out.print("Enter a number: ");
        userInput = sc.nextDouble();

        while (userInput != 0) {
            total += userInput;
            System.out.print("Enter a number : ");
            userInput = sc.nextDouble();
        }

        System.out.println("Total sum is : " + total);
        sc.close();
    }
}