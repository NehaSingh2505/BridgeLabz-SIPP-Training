package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

import java.io.*;

public class InputStreamReaderConsoleToFile {
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter writer = new FileWriter("output.txt")
        ) {
            System.out.println("Enter lines (type 'exit' to finish):");

            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line + System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

