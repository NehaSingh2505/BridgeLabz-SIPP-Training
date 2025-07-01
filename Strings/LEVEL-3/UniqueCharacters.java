import java.util.Scanner;

public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        char[] unique = findUniqueCharacters(input);
        System.out.println("Unique characters:");
        for (char c : unique) {
            if (c != '\0') System.out.print(c + " ");
        }
    }

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    public static char[] findUniqueCharacters(String str) {
        int len = getLength(str);
        char[] result = new char[len];
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
            if (isUnique) result[index++] = current;
        }
        return result;
    }
}
