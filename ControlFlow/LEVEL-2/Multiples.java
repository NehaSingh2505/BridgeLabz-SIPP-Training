import java.util.Scanner;

public class Multiples{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number less than 100 =>  ");
        int number = sc.nextInt();

        for (int i = 1; i < 100; i++) {
            if (i % number == 0) {
                System.out.println(i);
            }
        }
        
    }
}