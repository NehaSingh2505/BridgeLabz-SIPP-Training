package OOPS.Keyword;
public class BankAccount {
    static String bankName = "Punjab National Bank";
    static int totalAccounts = 0;

    private String accountHolderName;
    final String accountNumber;

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total accounts are: " + totalAccounts);
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Account Holder is : " + accountHolderName + ", Account Number is : " + accountNumber);
        }
    }
}
