import java.util.*;

class Doctor {
    String name;

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient p) {
        System.out.println(name + " is consulting " + p.name);
    }
}

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

class Hospital {
    String name;

    Hospital(String name) {
        this.name = name;
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Hospital h = new Hospital("City Hospital");

        Doctor d1 = new Doctor("Dr. Mehta");
        Doctor d2 = new Doctor("Dr. Arora");

        Patient p1 = new Patient("Suman");
        Patient p2 = new Patient("Rakesh");

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
    }
}
