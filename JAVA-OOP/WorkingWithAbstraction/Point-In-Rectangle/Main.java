import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] coordinates = readArray (scanner);

        Point pointA = new Point (coordinates[0], coordinates[1]);
        Point pointB = new Point (coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle (pointA, pointB);

        int lines = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < lines; i++) {
            int[] pointCoordinates = readArray (scanner);

            Point point = new Point (pointCoordinates[0], pointCoordinates[1]);

            System.out.println (rectangle.contains (point));
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt)
                .toArray ();
    }
}
