import java.util.*;
import java.util.stream.*;

class Claim {
    String type;
    double amount;
    Claim(String t, double a) {
        type = t; amount = a;
    }
    public String getType() { return type; }
    public double getAmount() { return amount; }
}

public class Claims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        List<Claim> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.nextLine();
            double amt = sc.nextDouble(); sc.nextLine();
            list.add(new Claim(type, amt));
        }
        list.stream()
            .collect(Collectors.groupingBy(Claim::getType,
                     Collectors.averagingDouble(Claim::getAmount)))
            .forEach((t, avg) -> System.out.println(t + " -> " + avg));
        sc.close();
    }
}
