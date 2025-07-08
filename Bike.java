    public class Bike extends RentingSystem implements Rentable {
    public Bike(String vehicleNumber, String model, double baseRate) {
        super(vehicleNumber, model, baseRate);
    }
    @Override

    public double calculateRent(int days){
        return baseRate*days;
    }
    
}

















