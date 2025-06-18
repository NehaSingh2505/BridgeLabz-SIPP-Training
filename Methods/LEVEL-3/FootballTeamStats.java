import java.util.Random;

public class FootballTeamStats {
    public static int[] generateHeights(int size) {
        Random rand = new Random();
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = 150 + rand.nextInt(101); // 150–250
        }
        return heights;
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int h : arr) sum += h;
        return sum;
    }

    public static double findMean(int[] arr) {
        return (double) findSum(arr) / arr.length;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int h : arr) if (h < min) min = h;
        return min;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int h : arr) if (h > max) max = h;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights(11);
        System.out.println("Player Heights:");
        for (int h : heights) System.out.print(h + " ");
        System.out.println("\nMean Height: " + findMean(heights));
        System.out.println("Shortest Height: " + findMin(heights));
        System.out.println("Tallest Height: " + findMax(heights));
    }
}