import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        String[] elements = in.nextLine ().substring (10).split (", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < universe.length; i++) {
            universe[i] = Integer.parseInt (elements[i]);
        }

        int numberOfSets = Integer.parseInt (in.nextLine ().substring (16));

        List<int[]> sets = new ArrayList<> ();

        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = in.nextLine ().split (", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < set.length; j++) {
                set[j] = Integer.parseInt (setElements[j]);
            }
            sets.add (set);
        }

        List<int[]> chosenSets = chooseSets (sets, universe);

        StringBuilder sb = new StringBuilder ();
        sb.append (String.format ("Sets to take (%d):%n", chosenSets.size ()));

        for (int[] chosenSet : chosenSets) {
            sb.append ("{ ");
            sb.append (Arrays.toString (chosenSet).replaceAll ("\\[|]", ""));
            sb.append (" }").append (System.lineSeparator ());
        }
        System.out.println (sb);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> selectedSets = new ArrayList<> ();

        Set<Integer> universeSet = new LinkedHashSet<> ();
        for (int k : universe) {
            universeSet.add (k);
        }

        while (!universeSet.isEmpty ()) {
            int bestMatchSetCount = 0;
            int[] bestMatchSet = new int[0];
            for (int[] currentSet : sets) {
                int countSetMatches = 0;
                for (int digit : currentSet) {
                    if (universeSet.contains (digit)) {
                        countSetMatches++;
                    }
                    if (countSetMatches > bestMatchSetCount) {
                        bestMatchSetCount = countSetMatches;
                        bestMatchSet = currentSet;
                    }
                }
            }

            selectedSets.add (bestMatchSet);
            sets.remove (bestMatchSet);
            for (int j : bestMatchSet) {
                universeSet.remove (j);
            }

        }
        return selectedSets;
    }

}