import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] input = scanner.nextLine ().split (", ");

        int dimension = Integer.parseInt (input[0]);
        char pattern = input[1].charAt (0);

        int[][] matrix = new int[dimension][dimension];

        if (pattern == 'A') {
            fillTheMatrixA (matrix);
        } else if (pattern == 'B') {
            fillTheMatrixB (matrix);
        }

        printMatrix (matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] intArray : matrix) {
            for (int integer : intArray) {
                System.out.print (integer + " ");
            }
            System.out.println ();
        }
    }

    private static void fillTheMatrixA(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 1; col <= matrix[row].length; col++) {
                matrix[col - 1][row] = matrix.length * row + col;
            }
        }
    }

    private static void fillTheMatrixB(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if ((row + 1) % 2 == 0) {
                int indexRow = matrix.length;
                for (int col = 1; col <= matrix[row].length; col++) {
                    matrix[--indexRow][row] = matrix.length * row + col;
                }
            } else {
                for (int col = 1; col <= matrix[row].length; col++) {
                    matrix[col - 1][row] = matrix.length * row + col;
                }
            }
        }
    }
}
