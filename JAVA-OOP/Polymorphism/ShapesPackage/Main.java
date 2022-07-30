package ShapesPackage;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle (2, 5);

        rectangle.calculateArea ();
        rectangle.calculatePerimeter ();

        System.out.println (rectangle.area);
        System.out.println (rectangle.perimeter);

        Shape circle = new Circle (4);

        circle.calculatePerimeter ();
        circle.calculateArea ();

        System.out.println (circle.perimeter);
        System.out.println (circle.area);
    }
}
