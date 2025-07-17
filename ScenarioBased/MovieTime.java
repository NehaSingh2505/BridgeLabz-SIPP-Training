import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieTime {
    public static void main(String[] args) throws ParseException {
        List<String> showTime = new ArrayList<>(Arrays.asList(
            "10:00 AM", "12:00 PM", "03:00 PM", "06:00 PM", "09:00 PM"
        ));
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Movie Time!");
        System.out.print("Enter the timing of new movie (hh:mm AM/PM): ");
        String newMovieTime = sc.nextLine().toUpperCase();

        showTime.add(newMovieTime);

        SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
        int i = showTime.size() - 1;

        while (i > 0) {
            Date current = format.parse(showTime.get(i));
            Date previous = format.parse(showTime.get(i - 1));

            if (previous.after(current)) {
                String temp = showTime.get(i);
                showTime.set(i, showTime.get(i - 1));
                showTime.set(i - 1, temp);
                i--;
            } else {
                break;
            }
        }

        System.out.println("Updated Movie Show Times:");
        for (String time : showTime) {
            System.out.println(time);
        }

        sc.close();
    }
}
