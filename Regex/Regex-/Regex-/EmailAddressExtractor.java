import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddressExtractor {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text : ");
        String text = sc.nextLine();
        
        String regex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        
        if (!found) {
            System.out.println("No email addresses found.");
        }
    }
}