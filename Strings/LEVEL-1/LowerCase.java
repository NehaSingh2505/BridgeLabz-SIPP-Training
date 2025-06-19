import java.util.Scanner;

public class LowerCase {

    public static String convertToLowercase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32); 
            }

            result += ch; 
        }

        return result;
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full text: ");
        String input = sc.nextLine();

        String customLower = convertToLowercase(input);

        String builtInLower = input.toLowerCase();

        boolean isEqual = compareStrings(customLower, builtInLower);

        System.out.println("\nlowercase : " + customLower);
        System.out.println("Built-in lowercase: " + builtInLower);
        System.out.println("Are both equal?  : " + isEqual);

        sc.close();
    }
}
