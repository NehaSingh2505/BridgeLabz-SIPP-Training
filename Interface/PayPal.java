interface PaymentProcessor {
    void processPayment(double amount);

    default void refund(double amount) {
        System.out.println("Refund of Rs." + amount + " not supported by this provider.");
    }
}

class PayPal implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Processed Rs." + amount + " via PayPal.");
    }
    public void refund(double amount) {
        System.out.println("Refunded Rs." + amount + " via PayPal.");
    }
}

class Stripe implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Processed Rs." + amount + " via Stripe.");
    }
}

class Razorpay implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Processed Rs." + amount + " via Razorpay.");
    }
    public void refund(double amount) {
        System.out.println("Refunded Rs." + amount + " via Razorpay.");
    }
}