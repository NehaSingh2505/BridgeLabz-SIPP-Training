package AlgorithmsRuntimeAnalysisBigONotation;
import java.util.*;

public class SearchStructureComparison {
    public static void main(String[] args) {
        int[] sizes = {1_000, 100_000, 1_000_000};
        int target = -1;

        for (int size : sizes) {
            System.out.println("Dataset size: " + size);

            // Array
            int[] arr = new Random().ints(size, 0, size + 1000).toArray();
            long start = System.nanoTime();
            boolean found = false;
            for (int num : arr) {
                if (num == target) {
                    found = true;
                    break;
                }
            }
            long end = System.nanoTime();
            System.out.println("Array Search: " + (end - start) / 1_000_000 + " ms");

            // HashSet
            HashSet<Integer> hashSet = new HashSet<>();
            for (int num : arr) hashSet.add(num);
            start = System.nanoTime();
            hashSet.contains(target);
            end = System.nanoTime();
            System.out.println("HashSet Search: " + (end - start) / 1_000_000 + " ms");

            // TreeSet
            TreeSet<Integer> treeSet = new TreeSet<>(Arrays.stream(arr).boxed().toList());
            start = System.nanoTime();
            treeSet.contains(target);
            end = System.nanoTime();
            System.out.println("TreeSet Search: " + (end - start) / 1_000_000 + " ms");

            System.out.println("----------");
        }
    }
}
