class Circle {
    double radius;

    Circle() {
        this(1.0); 
    }

    Circle(double radius) {
        this.radius = radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
    }
}
