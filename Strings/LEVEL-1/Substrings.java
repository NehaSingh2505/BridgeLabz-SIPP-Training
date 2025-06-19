import java.util.Scanner;

public class Substrings {

    public static String manualSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i); 
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String original = sc.next();

        System.out.print("Enter the start : ");
        int start = sc.nextInt();

        System.out.print("Enter the end : ");
        int end = sc.nextInt();

        String builtInSub = original.substring(start, end);

        String manualSub = manualSubstring(original, start, end);

        boolean areEqual = compareStrings(builtInSub, manualSub);

        System.out.println("\nManual Substring     : " + manualSub);
        System.out.println("Built-in Substring   : " + builtInSub);
        System.out.println("Both the striings are equals ? => : " + areEqual);

        sc.close();
    }
}
