package AlgorithmsRuntimeAnalysisBigONotation;
import java.util.Arrays;
import java.util.Random;

public class SearchEfficiency {
    public static int linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return 1;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return 1;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 100_000, 1_000_000, 10_000_000};
        int target = -1;

        for (int size : sizes) {
            int[] dataset = new Random().ints(size, 0, size + 1000).toArray();
            System.out.println("Dataset size: " + size);

            long start = System.nanoTime();
            linearSearch(dataset, target);
            long end = System.nanoTime();
            System.out.println("Linear Search: " + (end - start) / 1_000_000 + " ms");

            start = System.nanoTime();
            binarySearch(dataset, target);
            end = System.nanoTime();
            System.out.println("Binary Search: " + (end - start) / 1_000_000 + " ms");
            System.out.println("----------");
        }
    }
}
