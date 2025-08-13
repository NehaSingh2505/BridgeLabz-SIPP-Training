import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        File source = new File("largefile.dat");
        File dest = new File("copy.dat");

        try {
            // Unbuffered
            long start = System.nanoTime();
            try (FileInputStream fis = new FileInputStream(source);
                 FileOutputStream fos = new FileOutputStream(dest)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
            long unbufferedTime = System.nanoTime() - start;

            // Buffered
            start = System.nanoTime();
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy_buffered.dat"))) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
            }
            long bufferedTime = System.nanoTime() - start;

            System.out.println("Unbuffered Time: " + unbufferedTime / 1_000_000 + " ms");
            System.out.println("Buffered Time: " + bufferedTime / 1_000_000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
