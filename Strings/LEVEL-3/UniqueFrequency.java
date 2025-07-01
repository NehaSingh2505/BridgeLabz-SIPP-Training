import java.util.Scanner;

public class UniqueFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        int length = getStringLength(input);
        char[] unique = findUniqueCharacters(input, length);
        int[] freq = getFrequencies(input, length);
        System.out.println("Char\tFreq");
        for (int i = 0; i < unique.length; i++) {
            System.out.println(unique[i] + "\t" + freq[unique[i]]);
        }
    }

    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    public static char[] findUniqueCharacters(String str, int len) {
        char[] temp = new char[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char current = str.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[index++] = current;
            }
        }
        char[] unique = new char[index];
        for (int i = 0; i < index; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }

    public static int[] getFrequencies(String str, int len) {
        int[] freq = new int[256];
        for (int i = 0; i < len; i++) {
            freq[str.charAt(i)]++;
        }
        return freq;
    }
}
