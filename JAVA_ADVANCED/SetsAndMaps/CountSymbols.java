import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<Character, Integer> occurrences = new TreeMap<> ();

        String text = scanner.nextLine ();

        for (char c : text.toCharArray ()) {
            occurrences.putIfAbsent (c, 0);
            occurrences.put (c, occurrences.get (c) + 1);
        }

        for (var entry : occurrences.entrySet ()) {
            System.out.printf ("%c: %d time/s%n", entry.getKey (), entry.getValue ());
        }
    }
}
