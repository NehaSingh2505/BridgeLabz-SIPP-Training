import java.util.Scanner;

public class PaymentGatewayIntegration {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        PaymentProcessor paypal = new PayPal();
        PaymentProcessor stripe = new Stripe();
        PaymentProcessor razorpay = new Razorpay();

        System.out.println("Choose Payment Provider : ");
        System.out.println("1. PayPal");
        System.out.println("2. Stripe");
        System.out.println("3. Razorpay");

        int choice = sc.nextInt();
        PaymentProcessor processor = null;

        switch (choice) {
            case 1: processor = paypal; break;
            case 2: processor = stripe; break;
            case 3: processor = razorpay; break;
            default: System.out.println("Invalid choice!"); return;
        }

        System.out.print("Enter amount to pay: Rs.");
        double amount = sc.nextDouble();
        processor.processPayment(amount);

        System.out.print("Do you want a refund? (yes/no): ");
        String refundChoice = sc.next();
        if (refundChoice.equalsIgnoreCase("yes")) {
            processor.refund(amount);
        }
	}
}
