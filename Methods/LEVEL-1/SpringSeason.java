import java.util.Scanner;
public class SpringSeason {
    public static boolean isSpringSeason(int month, int day) {
        if (month == 3 && day >= 20 || month == 4 || month == 5 || month == 6 && day < 21) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter Day (1-31): ");
        int day = sc.nextInt();
        
        boolean isSpring = SpringSeason.isSpringSeason(month, day);
        if (isSpring) {
            System.out.println("It is Spring Season.");
        } else {
            System.out.println("It is not Spring Season.");
        }
        
    }
}