class Bank {
    String name;

    Bank(String name) {
        this.name = name;
    }

    void openAccount(Customer c) {
        System.out.println(c.name + " opened an account in " + name);
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    void viewBalance() {
        System.out.println(name + " is viewing balance");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");
        Customer c1 = new Customer("Neha");

        bank.openAccount(c1);
        c1.viewBalance();
    }
}
