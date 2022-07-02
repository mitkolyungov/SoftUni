import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<List<Integer>> graph = new ArrayList<> ();

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String nextLine = scanner.nextLine ();
            if (nextLine.trim ().equals ("")) {
                graph.add (new ArrayList<> ());
                continue;
            }

            graph.add (Arrays.stream (nextLine.split ("\\s+")).map (Integer::parseInt).collect (Collectors.toList ()));
        }

        List<Deque<Integer>> connectedComponents = getConnectedComponents (graph);

        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.print ("Connected component: ");
            for (Integer integer : connectedComponent) {
                System.out.print (integer + " ");
            }
            System.out.println ();
        }
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size ()];
        List<Deque<Integer>> components = new ArrayList<> ();

        for (int start = 0; start < graph.size (); start++) {
            if (!visited[start]) {
                components.add (new ArrayDeque<> ());
                dfs (start, components, graph, visited);
            }
        }

        return components;
    }

    private static void dfs(int node, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;
            for (int child : graph.get (node)) {
                dfs (child, components, graph, visited);
            }
            components.get (components.size () - 1).offer (node);
        }
    }
}
