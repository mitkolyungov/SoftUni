import java.util.*;

public class Climbing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int rows = Integer.parseInt (scanner.nextLine ());
        int cols = Integer.parseInt (scanner.nextLine ());

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                    .mapToInt (Integer::parseInt)
                    .toArray ();
        }

        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = matrix[rows - 1][cols - 1];

        for (int i = cols - 2; i >= 0; i--) {
            dp[rows - 1][i] = matrix[rows - 1][i] + dp[rows - 1][i + 1];
        }

        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = matrix[i][cols - 1] + dp[i + 1][cols - 1];
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                dp[i][j] = matrix[i][j] + Math.max (dp[i + 1][j], dp[i][j + 1]);
            }
        }

        System.out.println (dp[0][0]);

        List<Integer> path = new ArrayList<> ();

        int row = 0;
        int col = 0;

        path.add (matrix[row][col]);

        while (row < rows - 1 || col < cols - 1) {
            int bottom = 0;
            int right = 0;

            if (row < rows - 1) {
                bottom = dp[row + 1][col];
            }

            if (col < cols - 1) {
                right = dp[row][col + 1];
            }

            if (bottom > right) {
                row++;
            } else {
                col++;
            }

            path.add (matrix[row][col]);
        }

        Collections.reverse (path);

        for (Integer integer : path) {
            System.out.print (integer + " ");
        }
    }
}
