import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

interface DateUtils {
    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class DateFormatUtility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter year (YYYY) : ");
        int year = sc.nextInt();

        System.out.print("Enter month (MM) : ");
        int month = sc.nextInt();

        System.out.print("Enter day (DD) : ");
        int day = sc.nextInt();

        LocalDate date = LocalDate.of(year, month, day);

        System.out.println("\nChoose Date Format : ");
        System.out.println("1. dd/MM/yyyy");
        System.out.println("2. MM-dd-yyyy");
        System.out.println("3. yyyy-MM-dd");

        int choice = sc.nextInt();
        String formattedDate = "";

        switch (choice) {
            case 1:
                formattedDate = DateUtils.formatDate(date, "dd/MM/yyyy");
                break;
            case 2:
                formattedDate = DateUtils.formatDate(date, "MM-dd-yyyy");
                break;
            case 3:
                formattedDate = DateUtils.formatDate(date, "yyyy-MM-dd");
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        System.out.println("Formatted Date : " + formattedDate);
    }
}
