package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

import java.io.*;

public class InputStreamReaderBinaryToChar {
    public static void main(String[] args) {
    	String filePath = "src/DSA/LinearAndBinarySearch/FindRotationPoint.java";

        try (
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader = new BufferedReader(isr)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
