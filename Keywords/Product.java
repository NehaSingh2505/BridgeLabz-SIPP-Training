class Product {
    static double discount = 5.0; 

    final String productID;
    String productName;
    double price;
    int quantity;

    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void display() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID + ", Name: " + productName + ", Price: Rs." + price + ", Quantity: " + quantity);
        }
    }
}

