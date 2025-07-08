    public class Truck extends RentingSystem implements Rentable {
    public Truck(String vehicleNumber, String model, double baseRate) {
        super(vehicleNumber, model, baseRate);
    }
    @Override

    public double calculateRent(int days){
        return baseRate*days;
    }
    
}
