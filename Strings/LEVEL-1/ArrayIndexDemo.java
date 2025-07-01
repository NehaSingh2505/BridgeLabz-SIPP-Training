import java.util.Scanner;

public class ArrayIndexDemo {
    static void generateException(String[] names, int index) {
        System.out.println("Name: " + names[index]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Alice", "Bob", "Charlie"};
        int index = sc.nextInt();
        try {
            generateException(names, index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
        }
    }
}