import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String command = scanner.nextLine ();
        int first = Integer.parseInt (scanner.nextLine ());
        int second = Integer.parseInt (scanner.nextLine ());

        switch (command) {
            case "add":
                System.out.println (add (first, second));
                break;

            case "multiply":
                System.out.println (multiply (first, second));
                break;

            case "subtract":
                System.out.println (subtract (first, second));
                break;

            case "divide":
                System.out.println (divide (first, second));
                break;
        }
    }

    private static int divide(int first, int second) {
        return first / second;
    }

    private static int subtract(int first, int second) {
        return first - second;
    }

    private static int multiply(int first, int second) {
        return first * second;
    }

    private static int add(int first, int second) {
        return first + second;
    }
}
