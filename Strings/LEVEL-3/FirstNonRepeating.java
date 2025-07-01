import java.util.Scanner;

public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        char result = getFirstNonRepeating(str);
        System.out.println("First non-repeating character: " + result);
    }

    public static char getFirstNonRepeating(String str) {
        int[] freq = new int[256];
        int len = 0;
        try {
            while (true) {
                char c = str.charAt(len);
                freq[c]++;
                len++;
            }
        } catch (Exception e) {}

        for (int i = 0; i < len; i++) {
            if (freq[str.charAt(i)] == 1) return str.charAt(i);
        }
        return '\0';
    }
}
