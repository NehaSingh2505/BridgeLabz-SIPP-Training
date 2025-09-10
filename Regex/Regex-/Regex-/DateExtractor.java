import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text : ");
        String text = sc.nextLine();
        
        String regex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";
        
        Pattern pattern = Pattern.compile(regex);
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
            System.out.println("No dates found.");
        }
    }
}