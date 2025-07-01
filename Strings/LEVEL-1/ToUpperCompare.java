import java.util.Scanner;

public class ToUpperCompare {
    public static String toUpperManual(String text) {
        String upper = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                upper += (char)(ch - 32);
            } else {
                upper += ch;
            }
        }
        return upper;
    }

    public static boolean compare(String a, String b) {
        return a.equals(b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String manual = toUpperManual(text);
        String builtIn = text.toUpperCase();

        System.out.println("Manual: " + manual);
        System.out.println("Built-in: " + builtIn);
        System.out.println("Are equal: " + compare(manual, builtIn));
    }
}
