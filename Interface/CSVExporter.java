interface ReportExporter {
    void exportToCSV(String data);
    void exportToPDF(String data);
    default void exportToJSON(String data) {
        System.out.println("JSON export not supported by this exporter.");
    }
}

// Step 2: Implement different exporters
class CSVExporter implements ReportExporter {
    public void exportToCSV(String data) {
        System.out.println("Exported data to CSV : " + data);
    }
    public void exportToPDF(String data) {
        System.out.println("Exported data to PDF : " + data);
    }
}

class PDFExporter implements ReportExporter {
    public void exportToCSV(String data) {
        System.out.println("Exported data to CSV : " + data);
    }
    public void exportToPDF(String data) {
        System.out.println("Exported data to PDF : " + data);
    }
}

class AdvancedExporter implements ReportExporter {
    public void exportToCSV(String data) {
        System.out.println("Exported data to CSV : " + data);
    }
    public void exportToPDF(String data) {
        System.out.println("Exported data to PDF : " + data);
    }
    public void exportToJSON(String data) {
        System.out.println("Exported data to JSON : { \"report\" : \"" + data + "\" }");
    }
}