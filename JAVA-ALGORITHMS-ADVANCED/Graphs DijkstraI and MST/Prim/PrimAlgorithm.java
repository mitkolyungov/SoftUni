import java.util.*;

public class PrimAlgorithm {

    public static Set<Integer> visited = new HashSet<> ();
    public static Map<Integer, List<Edge>> edgesByNode = new HashMap<> ();

    public static List<Edge> primImplementation(int numberOfVertices, List<Edge> edges) {
        List<Edge> forest = new ArrayList<> ();

        for (Edge edge : edges) {
            edgesByNode.putIfAbsent (edge.getStartNode (), new ArrayList<> ());
            edgesByNode.get (edge.getStartNode ()).add (edge);
            edgesByNode.putIfAbsent (edge.getEndNode (), new ArrayList<> ());
            edgesByNode.get (edge.getEndNode ()).add (edge);
        }

        for (int node : edgesByNode.keySet ()) {
            if (!visited.contains (node)) {
                prim (node, forest);
            }
        }

        forest.sort (Comparator.comparingInt (Edge::getWeight));

        return forest;
    }

    private static void prim(int start, List<Edge> forest) {

        visited.add (start);

        PriorityQueue<Edge> edges = new PriorityQueue<> ();

        edges.addAll (edgesByNode.get (start));

        while (!edges.isEmpty ()) {
            Edge minEdge = edges.poll ();

            int sourceNode = minEdge.getStartNode ();
            int destNode = minEdge.getEndNode ();

            int nonTreeNode = -1;

            if (visited.contains (sourceNode) && !visited.contains (destNode)) {
                nonTreeNode = destNode;
            }

            if (visited.contains (destNode) && !visited.contains (sourceNode)) {
                nonTreeNode = sourceNode;
            }

            if (nonTreeNode != -1) {
                forest.add (minEdge);
                visited.add (nonTreeNode);
                edges.addAll (edgesByNode.get (nonTreeNode));
            }
        }
    }
}
