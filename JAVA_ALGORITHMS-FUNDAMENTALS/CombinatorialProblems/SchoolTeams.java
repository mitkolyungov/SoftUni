import java.sql.Struct;
import java.util.*;
import java.util.stream.Collectors;

public class SchoolTeams {

    static Set<String> combinationsBoys = new HashSet<> ();
    static Set<String> combinationsGirls = new HashSet<> ();

    static String[] combGirls = new String[3];
    static String[] combBoys = new String[2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> girls = Arrays.stream (scanner.nextLine ().split (", "))
                .collect (Collectors.toList ());

        List<String> boys = Arrays.stream (scanner.nextLine ().split (", "))
                .collect (Collectors.toList ());

        combineGirls (0, 0, girls);
        combineBoys (0, 0, boys);

        for (String combinationsGirl : combinationsGirls) {
            for (String combinationsBoy : combinationsBoys) {
                System.out.print (combinationsGirl);
                System.out.print (", " + combinationsBoy);
                System.out.println ();
            }
        }
    }

    private static void combineBoys(int index, int start, List<String> boys) {
        if (index == combBoys.length) {
            combinationsBoys.add (asString (combBoys));
        } else {
            for (int i = start; i < boys.size (); i++) {
                combBoys[index] = boys.get (i);
                combineBoys (index + 1, i + 1, boys);
            }
        }
    }


    private static void combineGirls(int index, int start, List<String> girls) {
        if (index == combGirls.length) {
            combinationsGirls.add (asString (combGirls));
        } else {
            for (int i = start; i < girls.size (); i++) {
                combGirls[index] = girls.get (i);
                combineGirls (index + 1, i + 1, girls);
            }
        }
    }

    private static String asString(String[] stringArr) {
        return String.join (", ", stringArr);
    }
}
