import java.util.*;

interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    private boolean isDiscounted;
    private double discountAmount;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.isDiscounted = false;
        this.discountAmount = 0;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    protected void setDiscountAmount(double discount) {
        this.discountAmount = discount;
        this.isDiscounted = true;
    }

    protected double getDiscountAmount() {
        return discountAmount;
    }

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: ₹" + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - getDiscountAmount();
    }

    @Override
    public void applyDiscount(double percentage) {
        double discount = (getPrice() * getQuantity()) * (percentage / 100);
        setDiscountAmount(discount);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Applied: ₹" + getDiscountAmount();
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private final double nonVegCharge = 30;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + nonVegCharge - getDiscountAmount();
    }

    @Override
    public void applyDiscount(double percentage) {
        double discount = ((getPrice() * getQuantity()) + nonVegCharge) * (percentage / 100);
        setDiscountAmount(discount);
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Applied: ₹" + getDiscountAmount();
    }
}

public class OnlineFoodDeliverySystem {
    public static void processOrder(List<FoodItem> orderList) {
        for (FoodItem item : orderList) {
            System.out.println("==================================");
            item.getItemDetails();
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                d.applyDiscount(10);
                System.out.println(d.getDiscountDetails());
            }
            System.out.println("Total Price: ₹" + item.calculateTotalPrice());
        }
    }

    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("tiramisu", 300, 1));
        processOrder(order);
    }
}
