    public class Car extends RentingSystem implements Rentable {
    public Car(String vehicleNumber, String model, double baseRate) {
        super(vehicleNumber, model, baseRate);
    }
    @Override

    public double calculateRent(int days){
        return baseRate*days;
    }
    
}

















