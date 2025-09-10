import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataArithmetic {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a date (dd-MM-yyyy) : ");
		String str = sc.nextLine();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(str, format);
		
		LocalDate updateDate = date.plusDays(7).plusMonths(1).plusYears(2);
		System.out.println("After adding 7 days, 1 month, and 2 years : " + updateDate);
		
		LocalDate finalDate = updateDate.minusWeeks(3);
		System.out.println("After subtracting 3 weeks : " + finalDate);
	}

}
