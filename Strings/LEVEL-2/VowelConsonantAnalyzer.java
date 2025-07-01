import java.util.Scanner;

public class VowelConsonantAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        int[] counts = countVowelsAndConsonants(input);
        String[][] charTypes = getCharTypeArray(input);
        displayCharTypeArray(charTypes);
        System.out.println("\nTotal Vowels: " + counts[0]);
        System.out.println("Total Consonants: " + counts[1]);
    }

    public static int[] countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;

        for (int i = 0; i < getLength(str); i++) {
            char ch = str.charAt(i);
            String type = getCharType(ch);
            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }

        return new int[]{vowels, consonants};
    }

    public static String getCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32); 
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    public static String[][] getCharTypeArray(String str) {
        int len = getLength(str);
        String[][] result = new String[len][2];

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getCharType(ch);
        }

        return result;
    }

    public static void displayCharTypeArray(String[][] array) {
        System.out.println("\nCharacter\tType");
        for (int i = 0; i < array.length; i++) {
            System.out.println("   " + array[i][0] + "\t\t" + array[i][1]);
        }
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
