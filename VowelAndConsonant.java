import java.util.Scanner;
public class VowelAndConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String vowel =" ";
        String consonant="";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                if ("aeiou".indexOf(ch) != -1) {
                    vowel += ch + " ";
                } else {
                    consonant += ch + " ";
                }
            }
        }
        System.out.println("Vowels are : " + vowel.trim());
        System.out.println("consonants: " + consonant.trim());
        sc.close();
    }
}



