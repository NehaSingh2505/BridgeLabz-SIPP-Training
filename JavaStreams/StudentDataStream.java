import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("students.dat"))) {
            dos.writeInt(101);
            dos.writeUTF("Neha");
            dos.writeDouble(8.5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("students.dat"))) {
            System.out.println("Roll: " + dis.readInt());
            System.out.println("Name: " + dis.readUTF());
            System.out.println("GPA: " + dis.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
