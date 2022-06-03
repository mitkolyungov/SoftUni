import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        double numFirst = Double.parseDouble (scanner.nextLine ());
        char op = scanner.nextLine ().charAt (0);
        double numSecond = Double.parseDouble (scanner.nextLine ());

        switch (op) {
            case '*':
                System.out.println (new DecimalFormat ("0.##")
                        .format (multiplication (numFirst, numSecond)));
                break;

            case '/':
                System.out.println (new DecimalFormat ("0.##")
                        .format (division (numFirst, numSecond)));
                break;

            case '+':
                System.out.println (new DecimalFormat ("0.##")
                        .format (addition (numFirst, numSecond)));
                break;

            case '-':
                System.out.println (new DecimalFormat ("0.##")
                        .format (subtraction (numFirst, numSecond)));
                break;
        }
    }

    private static double subtraction(double numFirst, double numSecond) {
        return numFirst - numSecond;
    }

    private static double addition(double numFirst, double numSecond) {
        return numFirst + numSecond;
    }

    private static double division(double numFirst, double numSecond) {
        return numFirst / numSecond;
    }

    private static double multiplication(double numFirst, double numSecond) {
        return numFirst * numSecond;
    }
}
