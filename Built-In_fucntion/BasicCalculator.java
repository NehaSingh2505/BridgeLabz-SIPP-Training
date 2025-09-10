import java.util.*;

public class BasicCalculator {

    // Function for addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Function for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Function for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Function for division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN; 
        }
        return a / b;
    }

    // Main method
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number : ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number : ");
        double num2 = sc.nextDouble();

        System.out.println("\nChoose operation :");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Enter choice (1-4) : ");
        int choice = sc.nextInt();

        double result = 0;
        boolean valid = true;

        switch (choice) {
            case 1:
                result = add(num1, num2);
                break;
            case 2:
                result = subtract(num1, num2);
                break;
            case 3:
                result = multiply(num1, num2);
                break;
            case 4:
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid choice.");
                valid = false;
        }

        if (valid && !Double.isNaN(result)) {
            System.out.println("Result : " + result);
        }
    }
}
