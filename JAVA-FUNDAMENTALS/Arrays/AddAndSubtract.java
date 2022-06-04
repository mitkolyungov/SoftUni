import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int first = Integer.parseInt (scanner.nextLine ());
        int second = Integer.parseInt (scanner.nextLine ());
        int third = Integer.parseInt (scanner.nextLine ());

        System.out.println (subtraction (addition (first, second), third));
    }

    private static int subtraction(int a, int b) {
        return a - b;
    }

    private static int addition(int a, int b) {
        return a + b;
    }
}
