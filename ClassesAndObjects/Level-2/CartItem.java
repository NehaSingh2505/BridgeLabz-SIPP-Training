import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalCost() {
        return price * quantity;
    }
}

class ShoppingCart {
    ArrayList<CartItem> items = new ArrayList<>();

    void addItem(CartItem item) {
        items.add(item);
        System.out.println(item.itemName + " added to cart.");
    }

    void removeItem(String itemName) {
        boolean removed = items.removeIf(item -> item.itemName.equalsIgnoreCase(itemName));
        if (removed)
            System.out.println(itemName + " removed from cart.");
        else
            System.out.println(itemName + " not found in cart.");
    }

    void displayTotalCost() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalCost();
        }
        System.out.println("Total Cart Cost: ₹" + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem("Pen", 10.0, 3));
        cart.addItem(new CartItem("Notebook", 40.0, 2));
        cart.removeItem("Pen");
        cart.displayTotalCost();
    }
}
