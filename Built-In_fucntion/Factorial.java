import java.util.*;

public class Factorial {

    // Function to get input from user
    public static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        sc.close();
        return num;
    }

    // Recursive function to calculate factorial
    public static long factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    // Function to display the result
    public static void displayResult(int n, long result) {
        System.out.println("Factorial of " + n + " is : " + result);
    }

    // Main method
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        int number = getInput();

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = factorial(number);
            displayResult(number, result);
        }
    }
}
