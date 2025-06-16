import java.util.Scanner;
public class MultiplicationTableSixToNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 6 to 9 : ");
        int number = sc.nextInt();

        if (number < 6 || number > 9) {
            System.out.println("Please enter a number between 6 and 9.");
            return;
        }

        int[] multiplicationResult = new int[10];

        for (int i = 0; i < 10; i++) {
            multiplicationResult[i] = number * (i + 1);
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationResult[i]);
        }
    }
}
