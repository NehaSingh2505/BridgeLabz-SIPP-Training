package AlgorithmsRuntimeAnalysisBigONotation;
import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 100_000, 1_000_000};
        for (int size : sizes) {
            System.out.println("Dataset size: " + size);
            int[] bubble = new Random().ints(size, 0, size).toArray();
            int[] merge = Arrays.copyOf(bubble, bubble.length);
            int[] quick = Arrays.copyOf(bubble, bubble.length);

            if (size <= 10_000) { // Avoid long run-time for Bubble Sort
                long start = System.nanoTime();
                bubbleSort(bubble);
                long end = System.nanoTime();
                System.out.println("Bubble Sort: " + (end - start) / 1_000_000 + " ms");
            } else {
                System.out.println("Bubble Sort: Skipped (size too large)");
            }

            long start = System.nanoTime();
            Arrays.sort(merge);
            long end = System.nanoTime();
            System.out.println("Merge Sort: " + (end - start) / 1_000_000 + " ms");

            start = System.nanoTime();
            Arrays.sort(quick);
            end = System.nanoTime();
            System.out.println("Quick Sort: " + (end - start) / 1_000_000 + " ms");
            System.out.println("----------");
        }
    }
}
