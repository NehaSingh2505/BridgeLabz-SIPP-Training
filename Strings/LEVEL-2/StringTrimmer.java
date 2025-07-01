import java.util.Scanner;

public class StringTrimmer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with leading/trailing spaces: ");
        String input = sc.nextLine();
        int[] trimIndexes = findTrimIndexes(input);
        String customTrimmed = customSubstring(input, trimIndexes[0], trimIndexes[1]);
        String builtinTrimmed = input.trim();
        boolean areEqual = compareStrings(customTrimmed, builtinTrimmed);
        System.out.println("\nCustom Trimmed String: [" + customTrimmed + "]");
        System.out.println("Built-in Trimmed String: [" + builtinTrimmed + "]");
        System.out.println("Both strings match: " + areEqual);
    }

    public static int[] findTrimIndexes(String str) {
        int len = getLength(str);
        int start = 0;
        int end = len - 1;
        while (start < len && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (getLength(str1) != getLength(str2)) return false;

        for (int i = 0; i < getLength(str1); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }

        return true;
    }

    
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }
}
