import java.util.Scanner;

public class DataExporterFeature {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        ReportExporter csv = new CSVExporter();
        ReportExporter pdf = new PDFExporter();
        ReportExporter adv = new AdvancedExporter();

        System.out.println("Choose Exporter : ");
        System.out.println("1. CSV Exporter");
        System.out.println("2. PDF Exporter");
        System.out.println("3. Advanced Exporter (CSV, PDF, JSON)");

        int choice = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter report data : ");
        String data = sc.nextLine();

        ReportExporter exporter = null;
        switch (choice) {
            case 1: exporter = csv; break;
            case 2: exporter = pdf; break;
            case 3: exporter = adv; break;
            default: System.out.println("Invalid choice!"); return;
        }

        System.out.println("\nChoose Export Format : ");
        System.out.println("1. CSV");
        System.out.println("2. PDF");
        System.out.println("3. JSON");

        int formatChoice = sc.nextInt();

        switch (formatChoice) {
            case 1: exporter.exportToCSV(data); break;
            case 2: exporter.exportToPDF(data); break;
            case 3: exporter.exportToJSON(data); break;
            default: System.out.println("Invalid format!");
        }
	}
}
