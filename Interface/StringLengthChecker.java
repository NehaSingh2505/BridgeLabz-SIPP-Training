import java.util.Scanner;
import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        Function<String, Integer> getLength = msg -> msg.length();

        // Define character limit
        int limit = 20;

        System.out.print("Enter your message : ");
        String message = sc.nextLine();

        int length = getLength.apply(message);

        System.out.println("Message length : " + length);

        if (length > limit) {
            System.out.println("Message exceeds the " + limit + " character limit!");
        } else {
            System.out.println("Message is within the limit.");
        }
    }
}
