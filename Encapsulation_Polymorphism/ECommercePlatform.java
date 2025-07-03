import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayBaseDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }
}

class Electronics extends Product implements Taxable {
    private double warrantyYears;

    public Electronics(int productId, String name, double price, double warrantyYears) {
        super(productId, name, price);
        this.warrantyYears = warrantyYears;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; 
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; 
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18% GST";
    }
}

class Clothing extends Product implements Taxable {
    private String size;

    public Clothing(int productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5% GST";
    }
}

class Groceries extends Product {
    private double weightKg;

    public Groceries(int productId, String name, double price, double weightKg) {
        super(productId, name, price);
        this.weightKg = weightKg;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}
 
public class ECommercePlatform {

    public static void printFinalPrice(List<Product> products) {
        for (Product product : products) {
            System.out.println("=================================");
            product.displayBaseDetails();
            double tax = 0.0;
            double discount = product.calculateDiscount();

            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
                System.out.println(((Taxable) product).getTaxDetails());
            } else {
                System.out.println("No tax applicable.");
            }

            double finalPrice = product.getPrice() + tax - discount;

            System.out.println("Discount: ₹" + discount);
            System.out.println("Tax: ₹" + tax);
            System.out.println("Final Price: ₹" + finalPrice);
        }
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        productList.add(new Electronics(101, "Smartphone", 25000, 2));
        productList.add(new Clothing(102, "T-Shirt", 1100, "M"));
        productList.add(new Groceries(103, "Wheat flour", 300, 5));

        printFinalPrice(productList);
    }
}
