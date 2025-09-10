interface SmartDevice {
    void turnOn();
    void turnOff();
}

class Light implements SmartDevice {
    public void turnOn() {
        System.out.println("Light is ON");
    }
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class AirConditioner implements SmartDevice {
    public void turnOn() {
        System.out.println("Air Conditioner is ON");
    }
    public void turnOff() {
        System.out.println("Air Conditioner is OFF");
    }
}

class Television implements SmartDevice {
    public void turnOn() {
        System.out.println("Television is ON");
    }
    public void turnOff() {
        System.out.println("Television is OFF");
    }
}