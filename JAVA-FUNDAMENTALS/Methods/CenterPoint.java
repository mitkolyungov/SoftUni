import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int x1 = Integer.parseInt (scanner.nextLine ());
        int y1 = Integer.parseInt (scanner.nextLine ());
        int x2 = Integer.parseInt (scanner.nextLine ());
        int y2 = Integer.parseInt (scanner.nextLine ());

        closerPointToTheCenter (x1, y1, x2, y2);
    }

    private static void closerPointToTheCenter(int x1, int y1, int x2, int y2) {
        double first = Math.sqrt (Math.pow (x1, 2) + Math.pow (y1, 2));
        double second = Math.sqrt (Math.pow (x2, 2) + Math.pow (y2, 2));

        if (first > second) {
            System.out.printf ("(%d, %d)", x2, y2);
        } else {
            System.out.printf ("(%d, %d)", x1, y1);
        }
    }
}
