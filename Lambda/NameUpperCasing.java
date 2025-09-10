import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NameUpperCasing {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees : ");
        int n = sc.nextInt();
        sc.nextLine();

        List<String> employeeNames = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Employee Name " + (i + 1) + " : ");
            employeeNames.add(sc.nextLine());
        }

        List<String> upperNames = employeeNames.stream()
                                               .map(String::toUpperCase)
                                               .collect(Collectors.toList());

        System.out.println("\nEmployee Names in Uppercase for HR Letter : ");
        upperNames.forEach(System.out::println);
    }
}
