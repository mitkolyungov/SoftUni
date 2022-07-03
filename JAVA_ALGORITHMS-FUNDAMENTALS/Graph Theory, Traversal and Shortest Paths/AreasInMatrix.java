import java.util.*;
import java.util.stream.Collectors;

public class AreasInMatrix {
    static char[][] graph;
    static boolean[][] visited;

    static Map<Character, Integer> storage = new TreeMap<> ();

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        graph = new char[n][];
        visited = new boolean[n][];

        fillGraph (scanner);

        findAreas ();

        printFoundedAreas ();

    }

    private static void printFoundedAreas() {
        System.out.printf ("Areas: %d%n", storage.values ().stream ().mapToInt (e -> e).sum ());

        for (Map.Entry<Character, Integer> entry : storage.entrySet ()) {
            System.out.printf ("Letter '%c' -> %d%n", entry.getKey (), entry.getValue ());
        }
    }

    private static void findAreas() {
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                if (!visited[row][col]) {
                    bfs (row, col, graph[row][col]);
                    storage.putIfAbsent (graph[row][col], 0);
                    storage.put (graph[row][col], storage.get (graph[row][col]) + 1);
                }
            }
        }
    }

    private static void fillGraph(Scanner scanner) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = scanner.nextLine ().toCharArray ();
            visited[i] = new boolean[graph[i].length];
        }
    }

    private static void bfs(int row, int col, char symbol) {
        if (!isInBounds (row, col) || graph[row][col] != symbol
                || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        //up
        bfs (row - 1, col, symbol);
        //down
        bfs (row + 1, col, symbol);
        //right
        bfs (row, col + 1, symbol);
        //left
        bfs (row, col - 1, symbol);

    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < graph.length && col >= 0 && col < graph[row].length;
    }
}
