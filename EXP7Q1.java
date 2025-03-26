
abstract class Shape {
    abstract void calculateArea();
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    void calculateArea() {
        double area = length * width;
        System.out.println("Rectangle Area: " + area);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Circle Area: " + area);
    }
}

public class EXP7Q1 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 10);
        rect.calculateArea();

        Circle circle = new Circle(7);
        circle.calculateArea();
    }
}
