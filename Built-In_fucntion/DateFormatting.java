import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateFormatting {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		LocalDate currentDate = LocalDate.now();
		
		System.out.println("Choose a date format : ");
		System.out.println("1. dd/MM/yyyy");
		System.out.println("2. yyyy-MM-dd");
		System.out.println("3. EEE, MMM dd, yyyy");
		System.out.print("Enter your choice (1/2/3) : ");
		
		int choice = sc.nextInt();
		
		DateTimeFormatter format;
		if(choice == 1) {
			format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		} else if (choice == 2) {
			format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		} else if (choice == 3) {
			format = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
		} else {
			System.out.println("Invalid choice.");
			return;
		}
		
		System.out.println("Formatted Current Date : " + currentDate.format(format));
	}

}
