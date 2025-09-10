import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotificationFiltering {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        List<Alert> alerts = Arrays.asList(
            new Alert("Patient A needs immediate surgery", "Critical"),
            new Alert("Patient B medicine reminder", "Normal"),
            new Alert("Patient C lab results ready", "Info"),
            new Alert("Patient D in critical condition", "Critical"),
            new Alert("Patient E appointment tomorrow", "Normal")
        );

        System.out.println("Filter alerts by type (Critical / Normal / Info): ");
        String choice = sc.nextLine().trim();

        Predicate<Alert> filterByType = alert -> alert.type.equalsIgnoreCase(choice);

        List<Alert> filteredAlerts = alerts.stream()
                                           .filter(filterByType)
                                           .collect(Collectors.toList());

        System.out.println("\nFiltered Alerts : ");
        if (filteredAlerts.isEmpty()) {
            System.out.println("No alerts of type : " + choice);
        } else {
            filteredAlerts.forEach(System.out::println);
        }
    }
}