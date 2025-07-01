import java.util.Scanner;

public class CustomSplitCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] builtIn = input.split(" ");
        String[] custom = customSplit(input);

        System.out.println("\nCustom Split:");
        for (String word : custom) {
            System.out.println(word);
        }

        System.out.println("\nComparison with built-in split(): " + compareArrays(builtIn, custom));
    }

    public static String[] customSplit(String str) {
        int len = getLength(str);

        // Step 1: Count number of words
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (str.charAt(i) == ' ') {
                inWord = false;
            }
        }

        // Step 2: Split manually
        String[] words = new String[wordCount];
        int index = 0;
        String currentWord = "";

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                currentWord += ch;
            } else {
                if (!currentWord.equals("")) {
                    words[index++] = currentWord;
                    currentWord = "";
                }
            }
        }

        // Last word if not added
        if (!currentWord.equals("")) {
            words[index] = currentWord;
        }

        return words;
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

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }
}
