import java.util.Arrays;
import java.util.Scanner;

public class CharArray {

    public static char[] stringToCharArray(String string) {
        char[] charArray = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            charArray[i] = string.charAt(i); 
        }
        return charArray;
    }

    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String mainString = sc.nextLine(); // allow full string with spaces

        char[] manualArray = stringToCharArray(mainString);

        char[] builtInArray = mainString.toCharArray();

        boolean isEqual = compareCharArrays(manualArray, builtInArray);

        System.out.println("\nManual char array     : " + Arrays.toString(manualArray));
        System.out.println("Built-in char array   : " + Arrays.toString(builtInArray));
        System.out.println("Are both arrays equal?: " + isEqual);

        sc.close();
    }
}
