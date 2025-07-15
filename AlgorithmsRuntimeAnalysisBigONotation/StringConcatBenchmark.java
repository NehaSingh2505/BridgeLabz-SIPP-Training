package AlgorithmsRuntimeAnalysisBigONotation;
public class StringConcatBenchmark {
    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 100_000, 1_000_000};
        String word = "hello";

        for (int N : sizes) {
            System.out.println("Operations count: " + N);

            long start = System.nanoTime();
            String s = "";
            for (int i = 0; i < N; i++) {
                s += word;
            }
            long end = System.nanoTime();
            System.out.println("String (Immutable): " + (end - start) / 1_000_000 + " ms");

            start = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(word);
            }
            end = System.nanoTime();
            System.out.println("StringBuilder: " + (end - start) / 1_000_000 + " ms");

            start = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < N; i++) {
                sbf.append(word);
            }
            end = System.nanoTime();
            System.out.println("StringBuffer: " + (end - start) / 1_000_000 + " ms");
            System.out.println("----------");
        }
    }
}
