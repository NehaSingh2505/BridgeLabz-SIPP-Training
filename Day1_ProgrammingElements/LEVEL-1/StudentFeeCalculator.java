import java.util.Scanner;

public class StudentFeeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total fee amount: ");
        double fee = sc.nextDouble();

        System.out.print("Enter the discount percentage: ");
        double discountPercent = sc.nextDouble();

        if (fee < 0 || discountPercent < 0 || discountPercent > 100) {
            System.out.println("Invalid input. Fee and discount percentage must be non-negative, and discount cannot exceed 100%.");
        } else {
            double discount = (discountPercent / 100) * fee;
            double finalFee = fee - discount;

            System.out.println("The discount amount is INR " + discount +
                               " and final discounted fee is INR " + finalFee);
        }

        sc.close();
    }
}
