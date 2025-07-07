abstract class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    public double getFinalPrice() {
        return price - calculateDiscount();
    }

    public void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Original Price: ₹" + price);
        System.out.println("Discount: ₹" + calculateDiscount());
        System.out.println("Final Price: ₹" + getFinalPrice());
        System.out.println();
    }
}

class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price);
    }

    double calculateDiscount() {
        return price * 0.10;
    }
}

class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price);
    }

    double calculateDiscount() {
        return price * 0.20;
    }
}

class Grocery extends Product {
    public Grocery(String name, double price) {
        super(name, price);
    }

    double calculateDiscount() {
        return 0;
    }
}

public class OnlineBillingSystem{
    public static void main(String[] args) {
        Product p1 = new Electronics("Laptop", 50000);
        Product p2 = new Clothing("T-Shirt", 1200);
        Product p3 = new Grocery("Rice", 800);

        p1.displayDetails();
        p2.displayDetails();
        p3.displayDetails();
    }
}
