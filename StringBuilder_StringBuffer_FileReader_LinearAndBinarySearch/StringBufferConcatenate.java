package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

public class StringBufferConcatenate {
    public static String concatenateStrings(String[] arr) {
        StringBuffer sb = new StringBuffer();

        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = { "Hello", " ", "World", "!" };
        System.out.println("Concatenated string: " + concatenateStrings(words));
    }
}
