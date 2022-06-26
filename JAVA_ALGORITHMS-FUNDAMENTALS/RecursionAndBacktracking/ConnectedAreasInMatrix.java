import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectedAreasInMatrix {

    static char[][] matrix;
    static List<int[]> areas;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System.in));

        int rows = Integer.parseInt (bufferedReader.readLine ());
        int cols = Integer.parseInt (bufferedReader.readLine ());

        matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = bufferedReader.readLine ().toCharArray ();
        }

        areas = new ArrayList<> ();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '-') {
                    areas.add (new int[]{row, col, 0});
                    ;
                    solve (row, col);
                }
            }
        }

        System.out.printf ("Total areas found: %d%n", areas.size ());

        AtomicInteger atomicInteger = new AtomicInteger (1);

        areas.stream ().sorted ((f, s) -> Integer.compare (s[2], f[2]))
                .forEach (s -> {
                    System.out.printf ("Area #%d at (%d, %d), size: %d%n",
                            atomicInteger.getAndIncrement (), s[0], s[1], s[2]);
                });
    }

    private static void solve(int row, int col) {
        if (isOutOfBounds (row, col) || matrix[row][col] == '*' || matrix[row][col] == 'V') {
            return;
        }
        matrix[row][col] = 'V';

        areas.get (areas.size () - 1)[2]++;

        solve (row - 1, col);
        solve (row + 1, col);
        solve (row, col - 1);
        solve (row, col + 1);
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
