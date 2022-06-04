import java.text.DecimalFormat;
import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        double first = Double.parseDouble (scanner.nextLine ());
        double second = Double.parseDouble (scanner.nextLine ());

        factorialDivision (first, second);
    }

    private static void factorialDivision(double first, double second) {
        System.out.printf ("%.2f", factorial (Math.abs (first)) / factorial (Math.abs (second)));
    }

    private static double factorial(double number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial (number - 1);
    }
}
