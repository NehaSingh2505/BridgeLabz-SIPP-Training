interface Vehicle {
    void displaySpeed(int speed);
    default void displayBattery(int battery) {
        System.out.println("Battery : " + battery + "%");
    }
}

class Cars implements Vehicle {
    @Override
    public void displaySpeed(int speed) {
        System.out.println("Car speed : " + speed + " km/h");
    }
}

class ElectricCar implements Vehicle {
    @Override
    public void displaySpeed(int speed) {
        System.out.println("Electric Car speed : " + speed + " km/h");
    }
}