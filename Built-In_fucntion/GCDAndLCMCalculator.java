import java.util.*;

public class GCDAndLCMCalculator {

    // Function to take input from user
    public static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int a = sc.nextInt();
        System.out.print("Enter second number : ");
        int b = sc.nextInt();
        sc.close();
        return new int[]{a, b};
    }

    // Function to calculate GCD using Euclidean Algorithm
    public static int calculateGCD(int a, int b) {
        return b == 0 ? a : calculateGCD(b, a % b);
    }

    // Function to calculate LCM using formula: (a * b) / GCD
    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }

    // Function to display results
    public static void displayResult(int a, int b, int gcd, int lcm) {
        System.out.println("GCD of " + a + " and " + b + " is : " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is : " + lcm);
    }

    // Main method
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        int[] numbers = getInput();
        int a = numbers[0];
        int b = numbers[1];

        if (a <= 0 || b <= 0) {
            System.out.println("Please enter positive integers only.");
            return;
        }

        int gcd = calculateGCD(a, b);
        int lcm = calculateLCM(a, b, gcd);

        displayResult(a, b, gcd, lcm);
    }
}
