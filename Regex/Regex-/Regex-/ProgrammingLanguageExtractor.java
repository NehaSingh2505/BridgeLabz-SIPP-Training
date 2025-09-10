import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgrammingLanguageExtractor {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text : ");
        String text = sc.nextLine();

        String regex = "\\b(Java|Python|JavaScript|C\\+\\+|C#|Go|Ruby|PHP|Swift|Kotlin)\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(matcher.group());
        }

        if (result.length() > 0) {
            System.out.println(result);
        } else {
            System.out.println("No programming languages found.");
        }
    }
}