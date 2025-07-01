import java.util.Scanner;

public class NestedLoopFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        int[] freq = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        System.out.println("Char\tFreq");
        for (int i = 0; i < freq.length; i++) {
            if (chars[i] != ' ' && chars[i] != '0')
                System.out.println(chars[i] + "\t" + freq[i]);
        }
    }
}
