import java.util.Scanner;

public class CalendarDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        printCalendar(month, year);
    }

    static void printCalendar(int month, int year) {
        String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        int[] daysInMonth = {
            0, 31, isLeapYear(year) ? 29 : 28, 31, 30, 31,
            30, 31, 31, 30, 31, 30, 31
        };
        int startDay = getStartDay(month, year);
        int numDays = daysInMonth[month];
        System.out.printf("\n  %s %d\n", months[month], year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%3d ", day);
            if (((day + startDay) % 7 == 0) || (day == numDays)) {
                System.out.println();
            }
        }
    }

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    static int getStartDay(int month, int year) {
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + 31 * m0 / 12) % 7;
        return d0;
    }
}
