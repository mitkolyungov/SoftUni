import java.util.Scanner;

public class CombinationsWithRep {
    static String[] elements;
    static String[] kSlots;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        elements = scanner.nextLine ().split (" ");

        kSlots = new String[Integer.parseInt (scanner.nextLine ())];

        combine (0, 0);
    }

    private static void combine(int index, int start) {
        if (index >= kSlots.length) {
            print (kSlots);
            return;
        }

        for (int i = start; i < elements.length; i++) {
            kSlots[index] = elements[i];
            combine (index + 1, i);
        }
    }

    private static void print(String[] kSlots) {
        System.out.println (String.join (" ", kSlots));
    }
}
