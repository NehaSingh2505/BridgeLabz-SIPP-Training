
public class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }

    public void displayItem() {
        System.out.println("Item: " + itemName + ", Price: ₹" + price + ", Quantity: " + quantity);
    }

    public static void main(String[] args) {
        CartItem item1 = new CartItem("Book", 200.0, 2);
        CartItem item2 = new CartItem("Pen", 20.0, 5);

        item1.displayItem();
        item2.displayItem();

        double total = item1.getTotalCost() + item2.getTotalCost();
        System.out.println("Total Cart Cost: ₹" + total);
    }
}
