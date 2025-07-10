import java.util.Scanner;

public class ProductPriceSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }

        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of product prices: ");
        int n = sc.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter the prices:");
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();

        quickSort(prices, 0, n - 1);

        System.out.println("Sorted Prices:");
        for (int price : prices) System.out.print(price + " ");
    }
}
