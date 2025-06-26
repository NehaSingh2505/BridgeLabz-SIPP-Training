public class InventoryItem {
    int itemCode;
    String itemName;
    double price;

    // Constructor
    public InventoryItem(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    public void displayItemDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Unit: ₹" + price);
    }

    // Method to calculate total cost
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        InventoryItem item = new InventoryItem(501, "Notebook", 45.50);
        item.displayItemDetails();
        int quantity = 10;
        System.out.println("Total cost for " + quantity + " units: ₹" + item.calculateTotalCost(quantity));
    }
}
