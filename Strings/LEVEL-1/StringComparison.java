import java.util.Scanner;

public class StringComparison {

    
    public static boolean compareStringsCharByChar(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string : ");
        String first = scanner.next();         

        System.out.print("Enter second string: ");
        String second = scanner.next();

        boolean charByCharResult = compareStringsCharByChar(first, second);
        boolean equalsResult    = first.equals(second);

        System.out.println("\nResult via charAt() : " + charByCharResult);
        System.out.println("Result via equals()  : " + equalsResult);

        if (charByCharResult == equalsResult) {
            System.out.println("Both methods returned the SAME result.");
        } else {
            System.out.println("Methods returned DIFFERENT results.");
        }

        scanner.close();
    }
}
