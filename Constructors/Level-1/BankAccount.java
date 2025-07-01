class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String accNo, String holder, double balance) {
        super(accNo, holder, balance);
    }

    void display() {
        System.out.println("Account No: " + accountNumber + ", Holder: " + accountHolder + ", Balance: ₹" + getBalance());
    }
}
