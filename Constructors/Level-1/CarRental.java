class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    static final double dailyRate = 1000.0;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    void display() {
        double total = rentalDays * dailyRate;
        System.out.println("Customer: " + customerName + ", Car: " + carModel + ", Total: Rs." + total);
    }
}
