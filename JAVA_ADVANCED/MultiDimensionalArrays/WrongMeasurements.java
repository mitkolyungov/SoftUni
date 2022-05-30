import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int rows = Integer.parseInt (scanner.nextLine ());

        int[][] matrix = new int[rows][];
        int[][] fixedMatrix = new int[rows][];

        for (int i = 0; i < matrix.length; i++) {
            int[] arr = Arrays.stream (scanner.nextLine ().split (" "))
                    .mapToInt (Integer::parseInt).toArray ();

            matrix[i] = arr;
            fixedMatrix[i] = arr.clone ();
        }

        String[] wrongPosition = scanner.nextLine ().split (" ");

        int wrongRow = Integer.parseInt (wrongPosition[0]);
        int wrongCol = Integer.parseInt (wrongPosition[1]);

        int wrongNumber = matrix[wrongRow][wrongCol];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                int sum = 0;
                if (matrix[row][col] == wrongNumber) {
                    if (isIndexValid (matrix, row - 1, col) && matrix[row - 1][col] != wrongNumber) {
                        sum += matrix[row-1][col];
                    }
                    if (isIndexValid (matrix, row + 1, col) && matrix[row + 1][col] != wrongNumber) {
                        sum += matrix[row+1][col];
                    }
                    if (isIndexValid (matrix, row, col - 1) && matrix[row][col - 1] != wrongNumber) {
                        sum += matrix[row][col-1];
                    }
                    if (isIndexValid (matrix, row, col + 1) && matrix[row][col + 1] != wrongNumber) {
                        sum += matrix[row][col+1];
                    }
                    fixedMatrix[row][col] = sum;
                }
            }
        }

        printMatrix(fixedMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println ();
        }
    }

    private static boolean isIndexValid(int[][] matrix, int row, int col) {
        return row < matrix.length && row >= 0 && col >= 0 && col < matrix[row].length;
    }
}
