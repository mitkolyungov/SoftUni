import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String string = scanner.nextLine ();
        int count = Integer.parseInt (scanner.nextLine ());

        System.out.println (repeatString (string, count));
    }

    private static String repeatString(String string, int count) {
        return String.valueOf (string).repeat (Math.max (0, count));
    }
}
