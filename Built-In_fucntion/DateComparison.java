import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateComparison {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the first date (dd-MM-yyyy) : ");
		String date1 = sc.nextLine();
		
		System.out.print("Enter the second date (dd-MM-yyyy) : ");
		String date2 = sc.nextLine();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyy");
		LocalDate firstDate = LocalDate.parse(date1, format);
		LocalDate secondDate = LocalDate.parse(date2, format);
		
		if(firstDate.isBefore(secondDate)) {
			System.out.println("The first date is before the second date.");
		} else if(firstDate.isAfter(secondDate)) {              
			System.out.println("The first date is after the second date.");
		} else if(firstDate.isEqual(secondDate)) {
			System.out.println("Both dates are same.");
		} else {
			System.out.println("Unexpected comparison result.");	
		}
	}

}
