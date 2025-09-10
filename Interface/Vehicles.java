class Vehicles implements Cloneable {
    String model;
    String color;

    Vehicles(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // Overriding clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void display() {
        System.out.println("Vehicle Model : " + model + ", Color : " + color);
    }
}