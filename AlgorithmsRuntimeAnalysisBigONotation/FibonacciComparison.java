package AlgorithmsRuntimeAnalysisBigONotation;
public class FibonacciComparison {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testCases = {10, 30, 50};

        for (int n : testCases) {
            System.out.println("Fibonacci(" + n + ")");

            long start = System.nanoTime();
            if (n <= 30) {
                int rec = fibonacciRecursive(n);
                long end = System.nanoTime();
                System.out.println("Recursive result: " + rec);
                System.out.println("Recursive time: " + (end - start) / 1_000_000 + " ms");
            } else {
                System.out.println("Recursive skipped (too slow)");
            }

            start = System.nanoTime();
            int iter = fibonacciIterative(n);
            long end = System.nanoTime();
            System.out.println("Iterative result: " + iter);
            System.out.println("Iterative time: " + (end - start) / 1_000_000 + " ms");
            System.out.println("----------");
        }
    }
}
