package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderCountWord {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static void main(String[] args) {
    	String filePath = "src/DSA/LinearAndBinarySearch/FindRotationPoint.java";
        String word = "FindRotationPoint";
        System.out.println("Occurrences of '" + word + "': " + countWordOccurrences(filePath, word));
    }
}
