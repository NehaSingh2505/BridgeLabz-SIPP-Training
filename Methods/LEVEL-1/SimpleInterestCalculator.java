import java.util.Scanner;

public class SimpleInterestCalculator {
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal Amount: ");
        double principal = sc.nextDouble();
        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();
        System.out.print("Enter Time Period (in years): ");
        double time = sc.nextDouble();
        double interest = SimpleInterestCalculator.calculateSimpleInterest(principal, rate, time);
        System.out.printf(
            "Simple Interest is: %.2f, for Principal %.2f, Rate of Interest :  %.2f, and Time %.2f years.%n",
            interest, principal, rate, time
        );
        sc.close();
    }
}