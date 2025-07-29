import java.util.*;

public class ShoppingCartSystem {

    static HashMap<String, Double> productPrices = new HashMap<>();
    static LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public static void main(String[] args) {
        initializeProductPrices();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Shopping Cart Menu ===");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart (Insertion Order)");
            System.out.println("4. View Cart Sorted by Price");
            System.out.println("5. Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> displayProducts();
                case 2 -> addToCart(sc);
                case 3 -> viewCartInOrder();
                case 4 -> viewCartSortedByPrice();
                case 5 -> checkout();
                case 0 -> System.out.println("Exiting. Thank you for shopping!");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }

    static void initializeProductPrices() {
        productPrices.put("Apple", 30.0);
        productPrices.put("Banana", 10.0);
        productPrices.put("Milk", 45.0);
        productPrices.put("Bread", 25.0);
        productPrices.put("Chocolate", 60.0);
        productPrices.put("Eggs", 6.0);
    }

    static void displayProducts() {
        System.out.println("\nAvailable Products:");
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            System.out.println("- " + entry.getKey() + ": ₹" + entry.getValue());
        }
    }

    static void addToCart(Scanner sc) {
        System.out.print("Enter product name to add: ");
        String product = sc.nextLine();
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        cart.put(product, cart.getOrDefault(product, 0) + quantity);
        System.out.println("Added " + quantity + " x " + product + " to cart.");
    }

    static void viewCartInOrder() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n🛒 Cart (in order of addition):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            double price = productPrices.get(product);
            System.out.printf("- %s: %d x ₹%.2f = ₹%.2f%n", product, qty, price, qty * price);
        }
    }

    static void viewCartSortedByPrice() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

        for (String product : cart.keySet()) {
            double price = productPrices.get(product);
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(product);
        }

        System.out.println("\n🛒 Cart (sorted by unit price):");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            double unitPrice = entry.getKey();
            for (String product : entry.getValue()) {
                int qty = cart.get(product);
                System.out.printf("- %s: %d x ₹%.2f = ₹%.2f%n", product, qty, unitPrice, qty * unitPrice);
            }
        }
    }

    static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Nothing to checkout.");
            return;
        }

        double total = 0;
        System.out.println("\n🧾 Checkout Summary:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            double price = productPrices.get(product);
            double subtotal = qty * price;
            System.out.printf("- %s: %d x ₹%.2f = ₹%.2f%n", product, qty, price, subtotal);
            total += subtotal;
        }
        System.out.printf("Total Amount: ₹%.2f%n", total);
        cart.clear();
        System.out.println("Cart cleared. Thank you for your purchase!");
    }
}
