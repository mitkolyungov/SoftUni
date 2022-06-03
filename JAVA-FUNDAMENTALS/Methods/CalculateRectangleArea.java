import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        double width = Double.parseDouble (scanner.nextLine ());
        double height = Double.parseDouble (scanner.nextLine ());

        System.out.printf ("%.0f",calculateArea(width,height));
    }

    private static double calculateArea(double a, double b) {
        return a*b;
    }
}
