import java.util.Scanner;

public class IllegalArgumentExample {
    static void generateException(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age");
        } else {
            System.out.println("Valid age: " + age);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        try {
            generateException(age);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
        }
    }
}