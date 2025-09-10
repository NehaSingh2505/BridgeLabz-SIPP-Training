import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InvoiceObjectCreation {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions : ");
        int n = sc.nextInt();
        sc.nextLine();

        List<String> transactionIds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Transaction ID " + (i + 1) + " : ");
            transactionIds.add(sc.nextLine());
        }

        List<Invoice> invoices = transactionIds.stream()
                                                .map(Invoice::new)
                                                .collect(Collectors.toList());

        System.out.println("\nGenerated Invoices : ");
        invoices.forEach(System.out::println);
    }
}