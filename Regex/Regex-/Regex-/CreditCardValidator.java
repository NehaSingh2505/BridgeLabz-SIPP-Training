import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter credit card number : ");
        String cardNumber = sc.nextLine();

        String visaRegex = "^4\\d{15}$";

        String masterRegex = "^5\\d{15}$";

        if (cardNumber.matches(visaRegex)) {
            System.out.println("\"" + cardNumber + "\" → Valid Visa Card");
        } 
        else if (cardNumber.matches(masterRegex)) {
            System.out.println("\"" + cardNumber + "\" → Valid MasterCard");
        } 
        else {
            System.out.println("\"" + cardNumber + "\" → Invalid Card Number");
        }
    }
}