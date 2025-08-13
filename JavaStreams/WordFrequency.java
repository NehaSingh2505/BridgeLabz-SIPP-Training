import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("textfile.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String w : words) {
                    if (!w.isEmpty()) {
                        wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
                    }
                }
            }

            wordCount.entrySet().stream()
                     .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                     .limit(5)
                     .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
