import java.util.Scanner;

public class StringIndexExample {
    static void generateException(String str) {
        System.out.println(str.charAt(str.length()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try {
            generateException(input);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
        }
    }
}