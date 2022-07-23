import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TBC {

    public static char[][] graph;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader (new InputStreamReader (System.in));

        int rows = Integer.parseInt (reader.readLine ());
        int cols = Integer.parseInt (reader.readLine ());

        graph = new char[rows][cols];
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            char[] chars = reader.readLine ().toCharArray ();

            graph[i] = chars;
        }

        int counter = 0;

        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                if (graph[row][col] == 't' && !isOutOfBounds (row, col)
                        && !visited[row][col]) {

                    dfs (row, col);
                    counter++;
                }
            }
        }

        System.out.println (counter);
    }

    private static void dfs(int row, int col) {
        if (!isOutOfBounds (row, col) && graph[row][col] == 't'
                && !visited[row][col]) {

            visited[row][col] = true;

            //up
            dfs (row - 1, col);

            //down
            dfs (row + 1, col);

            //left
            dfs (row, col - 1);

            //right
            dfs (row, col + 1);

            //upLeft
            dfs (row - 1, col - 1);

            //upRight
            dfs (row - 1, col + 1);

            //downRight
            dfs (row + 1, col + 1);

            //downLeft
            dfs (row + 1, col - 1);
        }
    }

    private static boolean isOutOfBounds(int row, int col) {

        return row < 0 || row >= graph.length
                || col < 0 || col >= graph[row].length;
    }
}
