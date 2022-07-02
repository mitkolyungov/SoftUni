import java.util.*;

public class DistanceBetweenVertices {
    static boolean[] visited;
    static int[] prevNodes;
    static Map<Integer, Integer> indexMapper = new HashMap<> ();

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int nodes = Integer.parseInt (scanner.nextLine ());

        int pairs = Integer.parseInt (scanner.nextLine ());

        List<List<Integer>> graph = new ArrayList<> ();

        for (int i = 0; i <= nodes; i++) {
            graph.add (new ArrayList<> ());
        }

        for (int i = 1; i <= nodes; i++) {

            String[] edges = (scanner.nextLine ().split (":"));

            indexMapper.put (Integer.valueOf (edges[0]), i);

            if (edges.length != 1) {
                int[] destinations = Arrays.stream (edges[1].split (" "))
                        .mapToInt (Integer::parseInt)
                        .toArray ();

                for (int destination : destinations) {
                    graph.get (i).add (destination);
                }
            }
        }

        visited = new boolean[nodes + 1];


        for (int i = 0; i < pairs; i++) {
            int[] relations = Arrays.stream (scanner.nextLine ().split ("-"))
                    .mapToInt (Integer::parseInt)
                    .toArray ();

            int source = relations[0];
            int destination = relations[1];

            prevNodes = new int[nodes + 1];
            Arrays.fill (prevNodes, -1);

            bfs (graph, indexMapper.get (source), indexMapper.get (destination));

            int steps = 0;
            int prevNode = prevNodes[indexMapper.get (destination)];


            while (prevNode != -1) {
                steps++;
                prevNode = prevNodes[prevNode];
            }

            if (steps == 0) {
                steps = -1;
            }
            System.out.printf ("{%d, %d} -> %d%n", source, destination, steps);

            Arrays.fill (visited, false);
        }
    }

    private static void bfs(List<List<Integer>> graph, int source, int destination) {
        Deque<Integer> queue = new ArrayDeque<> ();

        queue.add (source);
        visited[source] = true;

        while (!queue.isEmpty ()) {
            int node = queue.poll ();

            if (node == destination) {
                return;
            }

            for (int i = 0; i < graph.get (node).size (); i++) {
                int child = indexMapper.get (graph.get (node).get (i));
                if (!visited[child]) {
                    visited[child] = true;
                    prevNodes[child] = node;
                    queue.offer (child);
                }
            }
        }
    }
}
