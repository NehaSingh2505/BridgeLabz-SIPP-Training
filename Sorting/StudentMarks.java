//bubble sort implementation to sort student marks in ascending order

import java.util.Scanner;

public class StudentMarks{
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Students: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the marks of students :");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        bubbleSort(arr);

        System.out.println("Sorted marks array :");
        for (int x : arr)
            System.out.print(x + " ");

        sc.close();
    }
}
