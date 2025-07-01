public class Circle {
    private double radius;

    //created constructor
    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void display() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();       
        Circle customCircle = new Circle(5.5);     

        defaultCircle.display();   
        customCircle.display();    
    }
}