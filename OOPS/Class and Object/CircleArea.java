public class CircleArea {
    private double radius;

    public CircleArea(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void display() {
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
}

class MainCircleArea {
    public static void main(String[] args) {
        CircleArea c = new CircleArea(5.0);
        c.display();
    }
}