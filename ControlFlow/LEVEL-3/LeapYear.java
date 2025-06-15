import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year : ");
        int year = sc.nextInt();

        if (year < 1582) {
            System.out.println("Enter year after 1581 : ");
        } else {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        System.out.println("Year " + year + " is a Leap Year.");
                    } else {
                        System.out.println("Year " + year + " is not a Leap Year.");
                    }
                } else {
                    System.out.println("Year " + year + " is a Leap Year.");
                }
            } else {
                System.out.println("Year " + year + " is not a Leap Year.");
            }

            
        }
    }
}
