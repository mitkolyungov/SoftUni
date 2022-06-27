import java.util.*;
import java.util.stream.Collectors;

public class WordCruncher {
    static String target;
    static List<String> words;
    static Map<Integer, List<String>> table;
    static Map<String, Integer> occurancies = new HashMap<> ();
    static List<String> combined;

    static Set<String> result = new TreeSet<> ();

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        words = Arrays.stream (scanner.nextLine ().split (", ")).collect (Collectors.toList ());

        target = scanner.nextLine ();

        words.removeIf (string -> !target.contains (string));

        combined = new ArrayList<> ();

        table = new HashMap<> ();

        for (String substr : words) {
            occurancies.putIfAbsent (substr, 0);
            occurancies.put (substr, occurancies.get (substr) + 1);
            int index = target.indexOf (substr);
            while (index != -1) {
                table.putIfAbsent (index, new ArrayList<> ());
                table.get (index).add (substr);
                index = target.indexOf (substr, index + 1);
            }
        }

        permute (0);

        for (String line : result) {
            System.out.println (line);
        }

    }

    private static void permute(int index) {
        if (index == target.length ()) {
            print ();
        } else if (table.containsKey (index)) {
            List<String> strings = table.get (index);
            for (String string : strings) {
                if (occurancies.get (string) > 0) {
                    occurancies.put (string, occurancies.get (string) - 1);
                    combined.add (string);
                    permute (index + string.length ());
                    combined.remove (combined.size () - 1);
                    occurancies.put (string, occurancies.get (string) + 1);
                }
            }
        }
    }

    private static void print() {
        String actual = String.join ("", combined);
        if (actual.equals (target)) {
            result.add (String.join (" ", combined));
        }
    }
}
