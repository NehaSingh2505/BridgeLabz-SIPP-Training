// Write a program to find the sum of n natural numbers using while loop compare the result with the formulae n*(n+1)/2 and show the result from both computations was correct. 
// Hint => 
// Take the user input number and check whether it's a Natural number
// If it's a natural number Compute using formulae as well as compute using while loop
// Compare the two results and print the result

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