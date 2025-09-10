
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingWords {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence : ");
        String sentence = sc.nextLine();

        String regex = "\\b(\\w+)\\b\\s+\\b\\1\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String word = matcher.group(1); 
            if (result.indexOf(word) == -1) { 
                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(word);
            }
        }

        if (result.length() > 0) {
            System.out.println(result);
        } else {
            System.out.println("No repeating words found.");
        }
    }
}
