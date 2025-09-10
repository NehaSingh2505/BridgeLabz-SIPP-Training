import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZone {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Choose a time zone to display current time : ");
        System.out.println("1. GMT (Greenwich Mean Time)");
        System.out.println("2. IST (Indian Standard Time)");
        System.out.println("3. PST (Pacific Standard Time)");
        System.out.print("Enter your choice (1/2/3) : ");
        
        int choice = sc.nextInt();
        
        String zone = "";
        
        switch (choice) {
        case 1 :
        	zone = "GMT";
        	break;
        case 2 :
        	zone = "Asia/Kolkata";
        	break;
        case 3 :
        	zone = "America/Los_Angeles";
        	break;
        default :
        	System.out.println("Invalid choice.");
        	return;
        }
        
        //Using built-in function to get current time
        ZonedDateTime currentTime = ZonedDateTime.now(java.time.ZoneId.of(zone));
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");
        
        System.out.println("Current Time in selected time zone : " + currentTime.format(format));
	}

}
