import java.util.*;

public class ShortestPath {
    static boolean[] visited;
    static int[] prevNodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<List<Integer>> graph = new ArrayList<> ();

        int nodes = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i <= nodes; i++) {
            graph.add (new ArrayList<> ());
        }

        int edges = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < edges; i++) {
            int[] paths = Arrays.stream (scanner.nextLine ().split (" "))
                    .mapToInt (Integer::parseInt)
                    .toArray ();

            graph.get (paths[0]).add (paths[1]);
        }

        int source = Integer.parseInt (scanner.nextLine ());
        int destination = Integer.parseInt (scanner.nextLine ());

        visited = new boolean[nodes + 1];
        prevNodes = new int[nodes + 1];

        Arrays.fill (prevNodes, -1);

        bfs (graph, source, destination);

        List<Integer> path = new ArrayList<> ();

        path.add (destination);

        int prevNode = prevNodes[destination];

        while (prevNode != -1) {
            path.add (prevNode);
            prevNode = prevNodes[prevNode];
        }


        System.out.printf ("Shortest path length is: %d%n", path.size () - 1);

        Collections.reverse (path);

        for (Integer integer : path) {
            System.out.print (integer + " ");
        }


    }

    private static void bfs(List<List<Integer>> graph, int source, int destination) {
        Deque<Integer> queue = new ArrayDeque<> ();

        queue.offer (source);
        visited[source] = true;

        while (!queue.isEmpty ()) {
            int node = queue.poll ();

            if (node == destination) {
                return;
            }

            for (Integer child : graph.get (node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    prevNodes[child] = node;
                    queue.offer (child);
                }
            }
        }
    }
}
