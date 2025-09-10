import java.util.*;

public class PalindromeChecker {
	
    // Function to take input from user
    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String input = sc.nextLine();
        return input;
    }

    // Function to check if string is palindrome
    public static boolean isPalindrome(String str) {
        // Remove non-alphanumeric and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Reverse string using StringBuilder (built-in)
        String reversed = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversed);
    }

    // Function to display the result
    public static void displayResult(String str, boolean isPalin) {
        if (isPalin) {
            System.out.println("\"" + str + "\" is a palindrome.");
        } else {
            System.out.println("\"" + str + "\" is not a palindrome.");
        }
    }
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        String input = getInput();
        boolean result = isPalindrome(input);
        displayResult(input, result);
    }
}
