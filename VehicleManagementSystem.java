import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    String brand;
    String model;
    String fuelType;

    public Vehicle(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    abstract double calculateServiceCost();
    abstract void printServiceDetails();
}

class Car extends Vehicle {
    int engineCapacity;

    public Car(String brand, String model, String fuelType, int engineCapacity) {
        super(brand, model, fuelType);
        this.engineCapacity = engineCapacity;
    }

    @Override
    double calculateServiceCost() {
        return engineCapacity * 1000;
    }

    @Override
    void printServiceDetails() {
        System.out.println("Car Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
        System.out.println("Service Cost: Rs." + calculateServiceCost());
    }
}

class Bike extends Vehicle {
    boolean isSportsBike;

    public Bike(String brand, String model, String fuelType, boolean isSportsBike) {
        super(brand, model, fuelType);
        this.isSportsBike = isSportsBike;
    }

    @Override
    double calculateServiceCost() {
        return isSportsBike ? 500 : 300;
    }

    @Override
    void printServiceDetails() {
        System.out.println("Bike Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Is Sports Bike: " + (isSportsBike ? "Yes" : "No"));
        System.out.println("Service Cost: Rs." + calculateServiceCost());
    }
}

// class Truck extends Vehicle {
//     double loadCapacity;

//     public Truck(String brand, String model, String fuelType, double loadCapacity) {
//         super(brand, model, fuelType);
//         this.loadCapacity = loadCapacity;
//     }

//     @Override
//     double calculateServiceCost() {
//         return loadCapacity * 1000;
//     }

//     @Override
//     void printServiceDetails() {
//         System.out.println("Truck Brand: " + brand);
//         System.out.println("Model: " + model);
//         System.out.println("Fuel Type: " + fuelType);
//         System.out.println("Load Capacity: " + loadCapacity + " tons");
//         System.out.println("Service Cost: Rs." + calculateServiceCost());
//     }
// }
class Truck extends Vehicle{
    
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Toyota", "Camry", "Petrol", 2000));
        vehicles.add(new Bike("Yamaha", "R15", "Petrol", true));
        vehicles.add(new Truck("Tata", "LPT 1613", "Diesel", 5.5));

        System.out.println("Garage Vehicle Service Details");
        for (Vehicle v : vehicles) {
            v.printServiceDetails();
            System.out.println();
        }
    }
}