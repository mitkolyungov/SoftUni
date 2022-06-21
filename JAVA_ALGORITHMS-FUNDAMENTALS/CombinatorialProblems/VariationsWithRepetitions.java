import java.util.Scanner;

public class VariationsWithRepetitions {

    static String[] elements;
    static String[] kSlots;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        elements = scanner.nextLine ().split ("\\s+");

        kSlots = new String[Integer.parseInt (scanner.nextLine ())];

        variations (0);
    }

    private static void variations(int index) {
        if (index >= kSlots.length) {
            print ();
            return;
        }

        for (String element : elements) {
            kSlots[index] = element;
            variations (index + 1);
        }
    }

    private static void print() {
        System.out.println (String.join (" ", kSlots));
    }
}
