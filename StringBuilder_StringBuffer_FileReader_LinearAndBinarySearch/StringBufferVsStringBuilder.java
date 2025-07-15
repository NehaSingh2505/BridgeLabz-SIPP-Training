package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

public class StringBufferVsStringBuilder {
    public static void main(String[] args) {
        int N = 1_000_000;
        long start, end;

        // StringBuffer
        StringBuffer sbf = new StringBuffer();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            sbf.append("hello");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) + " ns");

        // StringBuilder
        StringBuilder sb = new StringBuilder();
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            sb.append("hello");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) + " ns");
    }
}
