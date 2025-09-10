import java.util.*;
import java.util.stream.*;

class Doctor {
    String name, specialty;
    boolean weekend;
    Doctor(String n, String s, boolean w) {
        name = n; specialty = s; weekend = w;
    }
    public String getSpecialty() { return specialty; }
    public boolean isWeekend() { return weekend; }
    public String toString() {
        return name + " - " + specialty + " (Weekend: " + weekend + ")";
    }
}

public class Doctors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        List<Doctor> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String specialty = sc.nextLine();
            boolean weekend = sc.nextBoolean(); sc.nextLine();
            list.add(new Doctor(name, specialty, weekend));
        }
        list.stream()
            .filter(Doctor::isWeekend)
            .sorted(Comparator.comparing(Doctor::getSpecialty))
            .forEach(System.out::println);
        sc.close();
    }
}
