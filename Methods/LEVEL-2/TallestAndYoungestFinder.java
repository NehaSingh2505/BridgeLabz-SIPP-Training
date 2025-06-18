import java.util.Scanner;

public class TallestAndYoungestFinder {

    public static String findYoungest(String[] names, int[] ages) {
        int index = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[index]) {
                index = i;
            }
        }
        return names[index];
    }

    public static String findTallest(String[] names, double[] heights) {
        int index = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[index]) {
                index = i;
            }
        }
        return names[index];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = scanner.nextInt();

            System.out.print("Enter height of " + names[i] + " in cm: ");
            heights[i] = scanner.nextDouble();
        }

        System.out.println("Youngest: " + findYoungest(names, ages));
        System.out.println("Tallest: " + findTallest(names, heights));

        scanner.close();
    }
}