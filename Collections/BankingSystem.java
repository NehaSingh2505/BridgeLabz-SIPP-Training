import java.util.*;

public class BankingSystem {

    static class WithdrawalRequest {
        String accountNumber;
        double amount;

        WithdrawalRequest(String accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    static HashMap<String, Double> accounts = new HashMap<>();
    static Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Banking System Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Request Withdrawal");
            System.out.println("4. Process Withdrawal Queue");
            System.out.println("5. View All Accounts");
            System.out.println("6. View Accounts Sorted by Balance");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createAccount(sc);
                case 2 -> deposit(sc);
                case 3 -> requestWithdrawal(sc);
                case 4 -> processWithdrawals();
                case 5 -> viewAccounts();
                case 6 -> viewSortedAccounts();
                case 0 -> System.out.println("Exiting system.");
                default -> System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 0);

        sc.close();
    }

    static void createAccount(Scanner sc) {
        System.out.print("Enter new Account Number: ");
        String accNo = sc.nextLine();
        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
            return;
        }
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        accounts.put(accNo, balance);
        System.out.println("Account created successfully.");
    }

    static void deposit(Scanner sc) {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        if (!accounts.containsKey(accNo)) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        accounts.put(accNo, accounts.get(accNo) + amount);
        System.out.println("Deposit successful.");
    }

    static void requestWithdrawal(Scanner sc) {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        if (!accounts.containsKey(accNo)) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        withdrawalQueue.add(new WithdrawalRequest(accNo, amount));
        System.out.println("Withdrawal request added to queue.");
    }

    static void processWithdrawals() {
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No withdrawal requests in queue.");
            return;
        }
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            if (!accounts.containsKey(req.accountNumber)) {
                System.out.println("Account " + req.accountNumber + " does not exist. Skipping.");
                continue;
            }
            double balance = accounts.get(req.accountNumber);
            if (balance >= req.amount) {
                accounts.put(req.accountNumber, balance - req.amount);
                System.out.println("Processed withdrawal of ₹" + req.amount + " from Account " + req.accountNumber);
            } else {
                System.out.println("Insufficient balance in Account " + req.accountNumber + ". Request skipped.");
            }
        }
    }

    static void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
            return;
        }
        System.out.println("Account Number -> Balance");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println(entry.getKey() + " -> ₹" + entry.getValue());
        }
    }

    static void viewSortedAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to sort.");
            return;
        }

        TreeMap<Double, List<String>> balanceMap = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            double balance = entry.getValue();
            balanceMap.putIfAbsent(balance, new ArrayList<>());
            balanceMap.get(balance).add(entry.getKey());
        }

        System.out.println("Accounts sorted by balance (low to high):");
        for (Map.Entry<Double, List<String>> entry : balanceMap.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println(acc + " -> ₹" + entry.getKey());
            }
        }
    }
}
