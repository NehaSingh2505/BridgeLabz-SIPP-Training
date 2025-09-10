import java.util.*;

class StockPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stock prices: ");
        int n = sc.nextInt();

        List<Double> prices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter stock price: ");
            prices.add(sc.nextDouble());
        }

        System.out.println("\nStock Prices:");
        prices.forEach(p -> System.out.println("Price: " + p));
    }
}
