import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ECommerceSorting {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        // User input for products
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Product " + (i + 1) + " : ");
            System.out.print("Name : ");
            String name = sc.nextLine();
            System.out.print("Price : ");
            double price = sc.nextDouble();
            System.out.print("Rating : ");
            double rating = sc.nextDouble();
            System.out.print("Discount (%) : ");
            double discount = sc.nextDouble();
            sc.nextLine(); 
            products.add(new Product(name, price, rating, discount));
        }

        System.out.println("\nSort by : 1. Price  2. Rating  3. Discount");
        int choice = sc.nextInt();

        Comparator<Product> comparator = null;

        switch (choice) {
            case 1:
                comparator = (p1, p2) -> Double.compare(p1.price, p2.price); 
                break;
            case 2:
                comparator = (p1, p2) -> Double.compare(p2.rating, p1.rating);
                break;
            case 3:
                comparator = (p1, p2) -> Double.compare(p2.discount, p1.discount); 
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        products.sort(comparator);

        System.out.println("\nSorted Products : ");
        products.forEach(System.out::println);
    }
}