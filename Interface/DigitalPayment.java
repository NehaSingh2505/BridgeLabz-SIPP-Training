import java.util.Scanner;

public class DigitalPayment {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        Payment upi = new UPIPayment();
        Payment card = new CreditCardPayment();
        Payment wallet = new WalletPayment();

        System.out.println("Choose a payment method : ");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Wallet");

        int choice = sc.nextInt();
        Payment payment = null;

        switch(choice) {
            case 1: payment = upi; break;
            case 2: payment = card; break;
            case 3: payment = wallet; break;
            default: System.out.println("Invalid choice!"); return;
        }

        System.out.print("Enter amount to pay: Rs.");
        double amount = sc.nextDouble();

        payment.pay(amount);
	}
}
