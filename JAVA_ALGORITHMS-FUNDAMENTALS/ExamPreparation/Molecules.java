import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Molecules {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader (new InputStreamReader (System.in));

        int nodes = Integer.parseInt (reader.readLine ());
        int edges = Integer.parseInt (reader.readLine ());

        int[][] graph = new int[nodes + 1][nodes + 1];

        for (int i = 0; i < edges; i++) {
            int[] numbers = Arrays.stream (reader.readLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();

            graph[numbers[0]][numbers[1]] = 1;
        }

        int startNode = Integer.parseInt (reader.readLine ());

        boolean[] visited = new boolean[nodes + 1];

        Deque<Integer> queue = new ArrayDeque<> ();

        queue.offer (startNode);
        visited[startNode] = true;

        while (!queue.isEmpty ()) {
            int node = queue.poll ();

            int[] arr = graph[node];

            for (int i = 0; i < arr.length; i++) {
                if (!visited[i] && arr[i] != 0) {
                    visited[i] = true;
                    queue.offer (i);
                }
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.print (i + " ");
            }
        }
    }
}
