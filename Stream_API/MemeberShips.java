import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.*;

class Member {
    String name;
    LocalDate expiry;
    Member(String n, LocalDate e) {
        name = n; expiry = e;
    }
    public String getName() { return name; }
    public LocalDate getExpiry() { return expiry; }
}

public class MemeberShips {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        List<Member> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            LocalDate date = LocalDate.parse(sc.nextLine());
            list.add(new Member(name, date));
        }
        LocalDate today = LocalDate.now();
        list.stream()
            .filter(m -> ChronoUnit.DAYS.between(today, m.getExpiry()) <= 30)
            .forEach(m -> System.out.println(m.getName() + " expires on " + m.getExpiry()));
        sc.close();
    }
}
