import java.util.ArrayList;
import java.util.List;

// Abstract Base Class
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();
}

// Electronics Subclass
class Electronics extends WarehouseItem {
    private int warrantyInMonths;

    public Electronics(String name, int warrantyInMonths) {
        super(name);
        this.warrantyInMonths = warrantyInMonths;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics: " + getName() + ", Warranty: " + warrantyInMonths + " months");
    }
}

// Groceries Subclass
class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, String expiryDate) {
        super(name);
        this.expiryDate = expiryDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Grocery: " + getName() + ", Expires on: " + expiryDate);
    }
}

// Furniture Subclass
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture: " + getName() + ", Material: " + material);
    }
}

// Generic Storage Class
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// Utility Class for Wildcard Method
class WarehouseUtil {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}

// Main Class
public class SmartWareHouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 24));
        electronicsStorage.addItem(new Electronics("Smartphone", 12));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Milk", "2025-08-01"));
        groceriesStorage.addItem(new Groceries("Bread", "2025-07-24"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("Table", "Metal"));

        System.out.println("=== Electronics ===");
        WarehouseUtil.displayAllItems(electronicsStorage.getItems());

        System.out.println("\n=== Groceries ===");
        WarehouseUtil.displayAllItems(groceriesStorage.getItems());

        System.out.println("\n=== Furniture ===");
    }
}