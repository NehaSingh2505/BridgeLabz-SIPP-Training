
import java.util.Scanner;
public class SumOfNaturalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number greater than 0.");
            sc.close();
            return;
        }

        int sumWhileLoop = 0;
        int i = 1;
        while (i <= n) {
            sumWhileLoop += i;
            i++;
        }

        int sumFormula = n * (n + 1) / 2;

        System.out.println("the sum using while loop: " + sumWhileLoop);
        System.out.println("the sum using formula: " + sumFormula);

        if (sumWhileLoop == sumFormula) {
            System.out.println("Both results are correct and equal.");
        } else {
            System.out.println("There is an inequality between the two results.");
        }

        sc.close();
    }
}