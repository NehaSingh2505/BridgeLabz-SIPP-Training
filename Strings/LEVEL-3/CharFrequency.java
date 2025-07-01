import java.util.Scanner;

public class CharFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] result = getFrequency(input);
        System.out.println("Char\tFreq");
        for (int i = 0; i < result.length; i++) {
            if (result[i][0] != null)
                System.out.println(result[i][0] + "\t" + result[i][1]);
        }
    }

    public static String[][] getFrequency(String str) {
        int[] freq = new int[256];
        int len = 0;
        try {
            while (true) {
                char c = str.charAt(len);
                freq[c]++;
                len++;
            }
        } catch (Exception e) {}

        String[][] res = new String[256][2];
        boolean[] visited = new boolean[256];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (!visited[c]) {
                res[index][0] = String.valueOf(c);
                res[index][1] = String.valueOf(freq[c]);
                visited[c] = true;
                index++;
            }
        }
        return res;
    }
}
