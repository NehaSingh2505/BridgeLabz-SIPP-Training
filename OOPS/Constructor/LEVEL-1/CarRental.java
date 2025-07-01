public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private final double RATE_PER_DAY = 1500.0;

    public CarRental() {
        this("Customer", "Sedan", 1);
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * RATE_PER_DAY;
    }

    public void display() {
        System.out.println("Customer: " + customerName + ", Car Model: " + carModel +
                           ", Days: " + rentalDays + ", Total Cost: ₹" + calculateTotalCost());
    }
}
