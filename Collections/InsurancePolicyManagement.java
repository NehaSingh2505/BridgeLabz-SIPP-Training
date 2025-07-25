import java.util.ArrayList;
import java.util.Scanner;

public class InsurancePolicyManagement {
    
    static class InsurancePolicy {
        String policyNumber;
        String policyholderName;
        String expiryDate;
        String coverageType;
        double premiumAmount;

        InsurancePolicy(String policyNumber, String policyholderName, String expiryDate,
                        String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        void display() {
            System.out.println("Policy Number    : " + policyNumber);
            System.out.println("Policyholder Name: " + policyholderName);
            System.out.println("Expiry Date      : " + expiryDate);
            System.out.println("Coverage Type    : " + coverageType);
            System.out.println("Premium Amount   : ₹" + premiumAmount);
            System.out.println("--------------------------------------");
        }
    }

    static ArrayList<InsurancePolicy> policyList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Insurance Policy Management System ===");
            System.out.println("1. Add New Policy");
            System.out.println("2. View All Policies");
            System.out.println("3. Search Policy by Number");
            System.out.println("4. Remove Policy");
            System.out.println("5. Update Policy");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> addPolicy();
                case 2 -> viewAllPolicies();
                case 3 -> searchPolicy();
                case 4 -> removePolicy();
                case 5 -> updatePolicy();
                case 0 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 0);
    }

    static void addPolicy() {
        System.out.print("Enter Policy Number: ");
        String number = scanner.nextLine();
        if (getPolicy(number) != null) {
            System.out.println("Policy already exists with this number!");
            return;
        }

        System.out.print("Enter Policyholder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Expiry Date (dd-mm-yyyy): ");
        String expiry = scanner.nextLine();
        System.out.print("Enter Coverage Type (Health/Auto/Home): ");
        String type = scanner.nextLine();
        System.out.print("Enter Premium Amount: ");
        double premium = scanner.nextDouble();

        InsurancePolicy policy = new InsurancePolicy(number, name, expiry, type, premium);
        policyList.add(policy);
        System.out.println("Policy added successfully!");
    }

    static void viewAllPolicies() {
        if (policyList.isEmpty()) {
            System.out.println("No policies found.");
            return;
        }
        for (InsurancePolicy policy : policyList) {
            policy.display();
        }
    }

    static void searchPolicy() {
        System.out.print("Enter Policy Number to search: ");
        String number = scanner.nextLine();
        InsurancePolicy policy = getPolicy(number);
        if (policy != null) {
            policy.display();
        } else {
            System.out.println("Policy not found.");
        }
    }

    static void removePolicy() {
        System.out.print("Enter Policy Number to remove: ");
        String number = scanner.nextLine();
        InsurancePolicy policy = getPolicy(number);
        if (policy != null) {
            policyList.remove(policy);
            System.out.println("Policy removed successfully.");
        } else {
            System.out.println("Policy not found.");
        }
    }

    static void updatePolicy() {
        System.out.print("Enter Policy Number to update: ");
        String number = scanner.nextLine();
        InsurancePolicy policy = getPolicy(number);
        if (policy == null) {
            System.out.println("Policy not found.");
            return;
        }

        System.out.print("Enter new Policyholder Name: ");
        policy.policyholderName = scanner.nextLine();
        System.out.print("Enter new Expiry Date: ");
        policy.expiryDate = scanner.nextLine();
        System.out.print("Enter new Coverage Type: ");
        policy.coverageType = scanner.nextLine();
        System.out.print("Enter new Premium Amount: ");
        policy.premiumAmount = scanner.nextDouble();

        System.out.println("Policy updated successfully.");
    }

    static InsurancePolicy getPolicy(String number) {
        for (InsurancePolicy policy : policyList) {
            if (policy.policyNumber.equalsIgnoreCase(number)) {
                return policy;
            }
        }
        return null;
    }
}
