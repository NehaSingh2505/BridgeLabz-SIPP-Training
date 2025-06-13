import java.util.Scanner;

public class HeightConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      System.out.println("Enter your height in centimeters: ");

        double heightCm = scanner.nextDouble();

        double totalInches = heightCm / 2.54;
        int feet = (int) (totalInches / 12);
        int inches = (int) (totalInches % 12);

        System.out.println("Your Height in cm is " + heightCm +
                           " while in feet is " + feet +
                           " and inches is " + inches);

        scanner.close();
    }
}

