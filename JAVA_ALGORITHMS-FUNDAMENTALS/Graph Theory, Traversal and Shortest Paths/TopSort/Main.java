import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public static List<String> topSort(Map<String, List<String>> graph) {
        List<String> sorted = new ArrayList<> ();

        Set<String> visited = new HashSet<> ();
        Set<String> detectCycles = new HashSet<> ();

        for (Map.Entry<String, List<String>> node : graph.entrySet ()) {
            dfs (node.getKey (), visited, graph, sorted, detectCycles);
        }

        Collections.reverse (sorted);
        return sorted;
    }

    private static void dfs(String key, Set<String> visited, Map<String, List<String>> graph, List<String> sorted, Set<String> detectCycles) {
        if (detectCycles.contains (key)) {
            throw new IllegalArgumentException ();
        }

        if (!visited.contains (key)) {
            visited.add (key);
            detectCycles.add (key);
            for (String child : graph.get (key)) {
                dfs (child, visited, graph, sorted, detectCycles);
            }
            detectCycles.remove (key);
            sorted.add (key);
        }
    }
}
