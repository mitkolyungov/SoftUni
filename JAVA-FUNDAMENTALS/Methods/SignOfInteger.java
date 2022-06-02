import java.util.Scanner;
public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        signOfInteger (Integer.parseInt (scanner.nextLine ()));
    }

    private static void signOfInteger(int integer) {
        if (integer > 0) {
            System.out.printf ("The number %d is positive.", integer);
        } else if (integer < 0) {
            System.out.printf ("The number %d is negative.", integer);
        } else {
            System.out.printf ("The number %d is zero.",integer);
        }
    }
}
