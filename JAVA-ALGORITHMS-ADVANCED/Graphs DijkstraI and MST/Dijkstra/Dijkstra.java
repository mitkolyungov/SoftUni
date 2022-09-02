package main.java;

import java.util.*;

public class Dijkstra {

    public static List<Integer> dijkstraAlgorithm(int[][] graph, int sourceNode, int destinationNode) {

        int[] distances = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        int[] prev = new int[graph.length];

        Arrays.fill (distances, Integer.MAX_VALUE);
        Arrays.fill (prev, -1);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<> (Comparator.comparingInt (node -> distances[node]));

        priorityQueue.offer (sourceNode);

        while (!priorityQueue.isEmpty ()) {
            int parent = priorityQueue.poll ();
            visited[parent] = true;
            int[] children = graph[parent];

            for (int index = 0; index < children.length; index++) {

                if (children[index] != 0 && !visited[index]) {
                    priorityQueue.offer (index);

                    int newDistance = distances[parent] + graph[parent][index];

                    if (newDistance < distances[index]) {
                        distances[index] = newDistance;
                        prev[index] = parent;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<> ();

        path.add (destinationNode);
        int n = prev[destinationNode];

        while (n != -1) {
            path.add (n);
            n = prev[n];
        }

        Collections.reverse (path);
        return path.size () == 1 ? null : path;

    }
}
