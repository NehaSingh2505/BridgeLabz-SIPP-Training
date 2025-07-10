import java.util.Scanner;

public class CountingSortStudentAges {

    public static void countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int age : arr) count[age - min]++;

        for (int i = 1; i < range; i++) count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) arr[i] = output[i];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] ages = new int[n];

        System.out.println("Enter student ages (10 to 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
            if (ages[i] < 10 || ages[i] > 18) {
                System.out.println("Invalid age! Please enter between 10 and 18.");
                i--; 
            }
        }

        countingSort(ages, 10, 18);

        System.out.println("Sorted Student Ages:");
        for (int age : ages) System.out.print(age + " ");
    }
}
