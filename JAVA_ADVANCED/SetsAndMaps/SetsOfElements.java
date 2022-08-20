import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] lengths = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt)
                .toArray ();

        int firstSetLength = lengths[0];
        int secondSetLength = lengths[1];

        Set<String> firstSet = new LinkedHashSet<> ();
        Set<String> secondSet = new LinkedHashSet<> ();

        fillSet (scanner, firstSetLength, firstSet);

        fillSet (scanner, secondSetLength, secondSet);

        firstSet.retainAll (secondSet);

        System.out.println (String.join (" ", firstSet));
    }

    private static void fillSet(Scanner scanner, int firstSetLength, Set<String> firstSet) {
        for (int i = 0; i < firstSetLength; i++) {
            String n =  (scanner.nextLine ());

            firstSet.add (n);
        }
    }
}
