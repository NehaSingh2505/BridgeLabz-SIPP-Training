package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

public class StringBuilderReverse {
    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.println("Reversed string: " + reverse(input));
    }
}
