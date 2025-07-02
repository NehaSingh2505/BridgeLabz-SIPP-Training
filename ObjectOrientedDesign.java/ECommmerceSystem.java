import java.util.*;

class Product {
    String name;

    Product(String name) {
        this.name = name;
    }
}

class Order {
    int id;
    ArrayList<Product> products;

    Order(int id) {
        this.id = id;
        products = new ArrayList<>();
    }

    void addProduct(Product p) {
        products.add(p);
    }

    void showOrder() {
        System.out.println("Order ID: " + id);
        for (Product p : products) {
            System.out.println("Product: " + p.name);
        }
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    void placeOrder(Order o) {
        System.out.println(name + " placed an order.");
        o.showOrder();
    }
}

public class ECommmerceSystem{
    public static void main(String[] args) {
        Product p1 = new Product("Shoes");
        Product p2 = new Product("T-shirt");

        Order o1 = new Order(101);
        o1.addProduct(p1);
        o1.addProduct(p2);

        Customer c1 = new Customer("Neha");
        c1.placeOrder(o1);
    }
}
