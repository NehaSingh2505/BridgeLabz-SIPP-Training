interface Payment {
    void pay(double amount);
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using UPI.");
    }
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card.");
    }
}

class WalletPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Wallet.");
    }
}