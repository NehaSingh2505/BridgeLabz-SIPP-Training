class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    void displayDetails(int quantity) {
        System.out.println("Item Code  : " + itemCode);
        System.out.println("Item Name  : " + itemName);
        System.out.println("Unit Price : ₹" + price);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Total Cost : ₹" + calculateTotalCost(quantity));
    }

    public static void main(String[] args) {
        Item item = new Item(101, "Notebook", 75.0);
        item.displayDetails(4);
    }
}
