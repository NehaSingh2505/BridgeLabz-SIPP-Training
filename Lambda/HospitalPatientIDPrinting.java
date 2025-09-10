import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalPatientIDPrinting {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients : ");
        int n = sc.nextInt();

        List<String> patientIDs = new ArrayList<>();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Patient ID " + (i + 1) + " : ");
            String id = sc.nextLine();
            patientIDs.add(id);
        }

        System.out.println("\nPatient IDs for Admin Verification : ");
        patientIDs.forEach(System.out::println);
    }
}
