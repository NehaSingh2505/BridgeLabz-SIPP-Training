package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderReadLines {
    public static void main(String[] args) {
    	String filePath = "src/DSA/LinearAndBinarySearch/FindRotationPoint.java";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
