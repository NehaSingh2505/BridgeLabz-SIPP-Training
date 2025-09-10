import java.util.Scanner;

public class CensorBadWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence : ");
        String sentence = sc.nextLine();

        String[] badWords = {"damn", "stupid"};

        for (String badWord : badWords) {
            sentence = sentence.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }

        System.out.println(sentence);
    }
}