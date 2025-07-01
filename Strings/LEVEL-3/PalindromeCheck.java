import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.println("Logic 1: " + isPalindrome1(text));
        System.out.println("Logic 2: " + isPalindrome2(text, 0, text.length() - 1));
        System.out.println("Logic 3: " + isPalindrome3(text));
    }

    public static boolean isPalindrome1(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    public static boolean isPalindrome2(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome2(str, start + 1, end - 1);
    }

    public static boolean isPalindrome3(String str) {
        char[] original = str.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = str.charAt(original.length - i - 1);
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }
}