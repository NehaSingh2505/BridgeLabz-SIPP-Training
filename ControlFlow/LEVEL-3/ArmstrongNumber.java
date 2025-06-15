 import java.util.Scanner;

public class ArmstrongNumber {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
         int number = sc.nextInt();

         int originalNumber = number;
        int sum = 0;

        while (originalNumber != 0) {
            int digit = originalNumber % 10;       
            sum += digit * digit * digit;          
        }

        if (sum == number) {
            System.out.println(number + " is an Armstrong Number.");
        } else {
            System.out.println(number + " is Not an Armstrong Number.");
        }

    }
}
