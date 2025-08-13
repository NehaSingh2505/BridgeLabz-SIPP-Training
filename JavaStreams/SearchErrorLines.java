import java.io.*;

public class SearchErrorLines {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("largefile.log"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
