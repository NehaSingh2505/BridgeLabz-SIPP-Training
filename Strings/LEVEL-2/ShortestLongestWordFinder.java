import java.util.Scanner;

public class ShortestLongestWordFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] words = splitWords(input);
        String[][] wordLengthArray = createWordLengthArray(words);
        int[] result = findShortestAndLongest(wordLengthArray);
        System.out.println("\nWord\tLength");
        for (int i = 0; i < wordLengthArray.length; i++) {
            System.out.println(wordLengthArray[i][0] + "\t" + Integer.parseInt(wordLengthArray[i][1]));
        }
        System.out.println("\nShortest Word: " + wordLengthArray[result[0]][0]);
        System.out.println("Longest Word: " + wordLengthArray[result[1]][0]);
    }

    public static String[] splitWords(String str) {
        int len = getLength(str);
        String[] tempWords = new String[len];
        int wordIndex = 0;
        String current = "";

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                current += ch;
            } else {
                if (!current.equals("")) {
                    tempWords[wordIndex++] = current;
                    current = "";
                }
            }
        }
        if (!current.equals("")) {
            tempWords[wordIndex++] = current;
        }
        String[] words = new String[wordIndex];
        for (int i = 0; i < wordIndex; i++) {
            words[i] = tempWords[i];
        }

        return words;
    }

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static String[][] createWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestAndLongest(String[][] array) {
        int shortest = 0;
        int longest = 0;

        for (int i = 1; i < array.length; i++) {
            int len = Integer.parseInt(array[i][1]);
            if (len < Integer.parseInt(array[shortest][1])) shortest = i;
            if (len > Integer.parseInt(array[longest][1])) longest = i;
        }

        return new int[]{shortest, longest};
    }
}
