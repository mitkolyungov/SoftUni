package ShapesPackage;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    void calculatePerimeter() {
        perimeter = 2 * height + 2 * width;
    }

    @Override
    void calculateArea() {
        area = height * width;
    }
}
