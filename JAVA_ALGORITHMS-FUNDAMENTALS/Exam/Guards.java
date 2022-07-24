import java.util.*;

public class Guards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            graph[scanner.nextInt()][scanner.nextInt()] = 1;
        }

        int source = scanner.nextInt();

        boolean[] visited = new boolean[n + 1];

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        StringBuilder out = new StringBuilder();

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                out.append(i).append(" ");
            }
        }

        System.out.println(out.toString().trim());
    }
}