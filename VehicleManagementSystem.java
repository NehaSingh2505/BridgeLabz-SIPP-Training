class Vehicle {
    String brand;
    String model;
    String fuelType;

    public Vehicle(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    double calculateServiceCost() {
        return 0;
    }

    void printServiceDetails() {
        System.out.println("Vehicle: " + brand + " " + model);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Service Cost: ₹" + calculateServiceCost());
        System.out.println();
    }
}

class Car extends Vehicle {
    public Car(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    double calculateServiceCost() {
        return 5000;
    }

    void printServiceDetails() {
        System.out.println("Car: " + brand + " " + model);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Car Service Cost: ₹" + calculateServiceCost());
        System.out.println();
    }
}

class Bike extends Vehicle {
    public Bike(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    double calculateServiceCost() {
        return 1500;
    }

    void printServiceDetails() {
        System.out.println("Bike: " + brand + " " + model);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Bike Service Cost: ₹" + calculateServiceCost());
        System.out.println();
    }
}

class Truck extends Vehicle {
    public Truck(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    double calculateServiceCost() {
        return 8000;
    }

    void printServiceDetails() {
        System.out.println("Truck: " + brand + " " + model);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Truck Service Cost: ₹" + calculateServiceCost());
        System.out.println();
    }
}

public class VehicleManagementSystem{
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("Toyota", "Camry", "Petrol");
        vehicles[1] = new Bike("Honda", "CBR", "Petrol");
        vehicles[2] = new Truck("Tata", "Xenon", "Diesel");

        for (Vehicle v : vehicles) {
            v.printServiceDetails();
        }
    }
}
