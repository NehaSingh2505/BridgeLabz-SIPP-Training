public class MobileNumber {
    String brand;
    String model;
    double price;

    // Constructor
    public MobileNumber(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display mobile phone details
    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: ₹" + price);
    }

    public static void main(String[] args) {
    MobileNumber phone = new MobileNumber("Samsung", "Galaxy A55", 29999.99);
        phone.displayDetails();
    }
}
