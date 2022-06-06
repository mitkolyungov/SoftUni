import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] words = scanner.nextLine ().split (" ");

        LinkedHashMap<String, Integer> counts = new LinkedHashMap<> ();

        for (String word : words) {
            String wordInLowerCase = word.toLowerCase ();
            counts.putIfAbsent (wordInLowerCase, 0);
            counts.put (wordInLowerCase, counts.get (wordInLowerCase) + 1);
        }

        ArrayList<String> odds = new ArrayList<> ();

        for (Map.Entry<String, Integer> entry : counts.entrySet ()) {
            if (entry.getValue () % 2 == 1) {
                odds.add (entry.getKey ());
            }
        }

        System.out.println (String.join (", ", odds));

    }
}
