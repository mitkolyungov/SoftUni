import java.util.*;

public class CyclesInGraph {

    static Map<Character, List<Character>> graph = new HashMap<> ();

    static boolean acyclic = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String command = scanner.nextLine ();

        Character source = null;

        while (!command.equalsIgnoreCase ("End")) {
            String[] edges = command.split ("-");

            if (source == null) {
                source = edges[0].charAt (0);
            }

            graph.putIfAbsent (edges[0].charAt (0), new ArrayList<> ());
            graph.get (source).add (edges[1].charAt (0));

            command = scanner.nextLine ();
        }

        Set<Character> visited = new HashSet<> ();
        Set<Character> detectCycles = new HashSet<> ();

        try {
            dfs (source, visited, detectCycles);
            System.out.println ("Acyclic: Yes");
        } catch (IllegalStateException ex) {
            System.out.println (ex.getMessage ());
        }
    }


    private static void dfs(Character key, Set<Character> visited, Set<Character> detectCycles) {
        if (detectCycles.contains (key)) {
            throw new IllegalStateException ("Acyclic: No");
        }
        if (visited.contains (key)) {
            return;
        }

        visited.add (key);
        detectCycles.add (key);

        if (graph.get (key) == null) {
            return;
        }
        for (Character child : graph.get (key)) {
            dfs (child, visited, detectCycles);
        }
        detectCycles.remove (key);
    }
}
