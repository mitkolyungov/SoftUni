package ShapesPackage;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    @Override
    void calculateArea() {
        area = Math.PI * Math.pow (radius, 2);
    }
}
