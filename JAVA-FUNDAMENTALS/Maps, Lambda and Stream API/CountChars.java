import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String text = scanner.nextLine ();

        Map<Character, Integer> occurrences = new HashMap<> ();

        for (char c : text.toCharArray ()) {
            if (c == ' ') {
                continue;
            }

            occurrences.putIfAbsent (c, 0);
            occurrences.put (c, occurrences.get (c) + 1);
        }

        for (Map.Entry<Character, Integer> entrySet : occurrences.entrySet ()) {
            System.out.printf ("%s -> %d%n"
                    , entrySet.getKey (), entrySet.getValue ());
        }
    }
}
