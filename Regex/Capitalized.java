
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Capitalized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence : ");
        String sentence = sc.nextLine();

        String regex = "\\b[A-Z][a-z]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);

        boolean firstWordSkipped = false;
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String word = matcher.group();

            if (!firstWordSkipped && sentence.startsWith(word)) {
                firstWordSkipped = true;
                continue;
            }

            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(word);
        }

        if (result.length() > 0) {
            System.out.println(result);
        } else {
            System.out.println("No capitalized words found.");
        }
    }
}
