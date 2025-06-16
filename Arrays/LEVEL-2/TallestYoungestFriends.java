import java.util.Scanner;

public class TallestYoungestFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age of Amar: ");
        int ageAmar = sc.nextInt();
        System.out.print("Enter height of Amar (in cm): ");
        double heightAmar = sc.nextDouble();

        System.out.print("Enter age of Akbar: ");
        int ageAkbar = sc.nextInt();
        System.out.print("Enter height of Akbar (in cm): ");
        double heightAkbar = sc.nextDouble();

        System.out.print("Enter age of Anthony: ");
        int ageAnthony = sc.nextInt();
        System.out.print("Enter height of Anthony (in cm): ");
        double heightAnthony = sc.nextDouble();

        String youngest = "Amar";
        int minAge = ageAmar;

        if (ageAkbar < minAge) {
            youngest = "Akbar";
            minAge = ageAkbar;
        }
        if (ageAnthony < minAge) {
            youngest = "Anthony";
            minAge = ageAnthony;
        }

        String tallest = "Amar";
        double maxHeight = heightAmar;

        if (heightAkbar > maxHeight) {
            tallest = "Akbar";
            maxHeight = heightAkbar;
        }
        if (heightAnthony > maxHeight) {
            tallest = "Anthony";
            maxHeight = heightAnthony;
        }

        System.out.println("\nYoungest friend is : " + youngest);
        System.out.println("Tallest friend is : " + tallest);

    }
}
