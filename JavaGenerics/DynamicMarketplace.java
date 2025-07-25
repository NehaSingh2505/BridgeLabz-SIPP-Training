import java.util.*;

interface Category {
    String getCategoryName();
}

enum BookCategory implements Category {
    FICTION, NON_FICTION, EDUCATIONAL;

    public String getCategoryName() {
        return name();
    }
}

enum ClothingCategory implements Category {
    MENS, WOMENS, KIDS;

    public String getCategoryName() {
        return name();
    }
}

enum GadgetCategory implements Category {
    MOBILE, LAPTOP, ACCESSORY;

    public String getCategoryName() {
        return name();
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }

    public String getDetails() {
        return name + " - ₹" + price + " [" + category.getCategoryName() + "]";
    }

    public T getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

class ProductUtil {
    public static <T extends Category> void applyDiscount(Product<T> product, double percent) {
        System.out.println("Applying " + percent + "% discount to: " + product.getDetails());
        product.applyDiscount(percent);
    }
}

public class DynamicMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book1 = new Product<>("Java Basics", 499.0, BookCategory.EDUCATIONAL);
        Product<ClothingCategory> shirt = new Product<>("Men's Shirt", 999.0, ClothingCategory.MENS);
        Product<GadgetCategory> mobile = new Product<>("Smartphone", 15999.0, GadgetCategory.MOBILE);

        List<Product<? extends Category>> catalog = new ArrayList<>();
        catalog.add(book1);
        catalog.add(shirt);
        catalog.add(mobile);

        System.out.println("=== Product Catalog ===");
        for (Product<? extends Category> product : catalog) {
            System.out.println(product.getDetails());
        }

        
        System.out.println("\n=== Applying Discounts ===");
        ProductUtil.applyDiscount(book1, 10);
        ProductUtil.applyDiscount(shirt, 20);
        ProductUtil.applyDiscount(mobile, 5);

        System.out.println("\n=== Updated Catalog ===");
        for (Product<? extends Category> product : catalog) {
            System.out.println(product.getDetails());
        }
    }
}
