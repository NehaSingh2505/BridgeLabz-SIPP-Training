import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private List<String> medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected void addToMedicalHistory(String record) {
        medicalHistory.add(record);
    }

    protected List<String> getMaskedMedicalHistory() {
        if (medicalHistory.isEmpty()) return List.of("No records available.");
        List<String> masked = new ArrayList<>();
        for (String record : medicalHistory) {
            masked.add("• " + record);
        }
        return masked;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> records;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
        addToMedicalHistory(record);
    }

    @Override
    public List<String> viewRecords() {
        return getMaskedMedicalHistory();
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
        addToMedicalHistory(record);
    }

    @Override
    public List<String> viewRecords() {
        return getMaskedMedicalHistory();
    }
}

public class HospitalManagementSystem {
    public static void processPatients(List<Patient> patients) {
        for (Patient p : patients) {
            System.out.println("====================================");
            p.getPatientDetails();
            System.out.println("Total Bill: ₹" + p.calculateBill());
            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) p;
                mr.addRecord("General checkup completed.");
                mr.addRecord("Prescribed medication.");
                System.out.println("Medical History:");
                for (String r : mr.viewRecords()) {
                    System.out.println(r);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new InPatient("P001", "yuvraj", 13, 4, 2000));
        patientList.add(new OutPatient("P002", "Rohan", 25, 800));
        processPatients(patientList);
    }
}
