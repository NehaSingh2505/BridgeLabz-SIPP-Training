import java.util.Scanner;

public class WhileMultiples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number less than 100: ");
        int number = sc.nextInt();
        int i = 1;

        while (i < 100) {
            if (i % number == 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
