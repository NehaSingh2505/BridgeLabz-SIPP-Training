import java.util.Scanner;

public class NumberAnalyzer {

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int a, int b) {
        if (a > b) return 1;
        else if (a == b) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        for (int num : numbers) {
            if (isPositive(num)) {
                System.out.print("Number " + num + " is positive and ");
                System.out.println(isEven(num) ? "even." : "odd.");
            } else {
                System.out.println("Number " + num + " is negative.");
            }
        }

        int result = compare(numbers[0], numbers[4]);
        System.out.print("Comparison of first and last number: ");
        if (result == 1) {
            System.out.println("First number is greater.");
        } else if (result == 0) {
            System.out.println("Both are equal.");
        } else {
            System.out.println("First number is smaller.");
        }

        scanner.close();
    }
}