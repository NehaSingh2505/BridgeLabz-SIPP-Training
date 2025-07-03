import java.util.*;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    protected String getMaskedInsuranceNumber() {
        return "****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }

    public abstract double calculateRentalCost(int days);

    public void displayBaseDetails() {
        System.out.println("Vehicle No.: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: ₹" + rentalRate);
    }
}

class Car extends Vehicle implements Insurable {
    private boolean luxury;

    public Car(String vehicleNumber, double rentalRate, boolean luxury, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
        this.luxury = luxury;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + (luxury ? 1000 : 0);
    }

    @Override
    public double calculateInsurance() {
        return luxury ? 3000 : 1500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: ₹" + calculateInsurance() + " | Policy No: " + getMaskedInsuranceNumber();
    }
}

class Bike extends Vehicle implements Insurable {
    private int engineCC;

    public Bike(String vehicleNumber, double rentalRate, int engineCC, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
        this.engineCC = engineCC;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return engineCC > 150 ? 800 : 500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: ₹" + calculateInsurance() + " | Policy No: " + getMaskedInsuranceNumber();
    }
}

class Truck extends Vehicle implements Insurable {
    private double loadCapacity;

    public Truck(String vehicleNumber, double rentalRate, double loadCapacity, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + (loadCapacity > 10 ? 2000 : 1000);
    }

    @Override
    public double calculateInsurance() {
        return 5000 + (loadCapacity * 100);
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: ₹" + calculateInsurance() + " | Policy No: " + getMaskedInsuranceNumber();
    }
}

public class VehicleRentalSystem {
    public static void printVehicleDetails(List<Vehicle> vehicles, int days) {
        for (Vehicle v : vehicles) {
            System.out.println("=====================================");
            v.displayBaseDetails();
            double rentalCost = v.calculateRentalCost(days);
            System.out.println("Rental Cost for " + days + " days: ₹" + rentalCost);
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println(ins.getInsuranceDetails());
            } else {
                System.out.println("No Insurance Info Available.");
            }
        }
    }

    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("CAR123", 1500, true, "INSU12345678"));
        fleet.add(new Bike("BIKE321", 500, 180, "IN4321"));
        fleet.add(new Truck("TRUCK789", 2500, 12, "I9876543"));
        printVehicleDetails(fleet, 5);
    }
}
