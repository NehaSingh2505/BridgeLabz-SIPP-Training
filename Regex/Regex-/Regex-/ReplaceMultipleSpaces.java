import java.util.Scanner;

public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text : ");
        String text = sc.nextLine();

        String result = text.replaceAll("\\s+", " ").trim();

        System.out.println(result);
    }
}