import java.util.*;

public class MoveDownRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int rows = Integer.parseInt (scanner.nextLine ());
        int cols = Integer.parseInt (scanner.nextLine ());

        int[][] table = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            table[i] = Arrays.stream (scanner.nextLine ().split (" "))
                    .mapToInt (Integer::parseInt)
                    .toArray ();
        }

        int[][] dp = new int[rows][cols];
        dp[0][0] = table[0][0];

        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + table[0][col];
        }

        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + table[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int j = 1; j < cols; j++) {
                dp[row][j] = Math.max (dp[row - 1][j], dp[row][j - 1])
                        + table[row][j];
            }
        }

        List<String> path = new ArrayList<> ();

        path.add (outputFormat (rows - 1, cols - 1));

        int row = rows - 1;
        int col = cols - 1;

        while (row > 0 || col > 0) {

            int top = 0;
            int left = 0;

            if (row > 0) {
                top = dp[row - 1][col];
            }

            if (col > 0) {
                left = dp[row][col - 1];
            }

            if (top > left) {
                row--;
            } else {
                col--;
            }

            path.add (outputFormat (row, col));
        }

        Collections.reverse (path);

        System.out.println (String.join (" ", path));
    }

    private static String outputFormat(int row, int col) {
        return "[" + row + ", " + col + "]";
    }
}
