import java.util.Scanner;

public class BackgroundJobExecution {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        Runnable emailJob = () -> {
            System.out.println("Sending email...");
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            System.out.println("Email sent successfully!");
        };

        Runnable backupJob = () -> {
            System.out.println("Performing data backup...");
            try { Thread.sleep(3000); } catch (InterruptedException e) {}
            System.out.println("Backup completed!");
        };

        Runnable reportJob = () -> {
            System.out.println("Generating report...");
            try { Thread.sleep(2500); } catch (InterruptedException e) {}
            System.out.println("Report generated!");
        };

        System.out.println("Choose a job to execute : ");
        System.out.println("1. Send Email");
        System.out.println("2. Data Backup");
        System.out.println("3. Generate Report");
        int choice = sc.nextInt();

        Runnable job = null;
        switch (choice) {
            case 1: job = emailJob; break;
            case 2: job = backupJob; break;
            case 3: job = reportJob; break;
            default: System.out.println("Invalid choice!"); return;
        }

        Thread thread = new Thread(job);
        thread.start();

        System.out.println("Job started in background. You can continue other work...");
    }
}
