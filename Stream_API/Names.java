import java.util.*;
import java.util.stream.*;

public class Names {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        list.stream()
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
        sc.close();
    }
}
