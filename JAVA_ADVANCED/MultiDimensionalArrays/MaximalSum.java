import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    static int maxSum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        ;
        int[][] matrix = createMatrix (scanner);

        fillTheMatrix (scanner, matrix);

        int[][] subMatrixResult = new int[3][3];

        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col];
                //up
                sum += calculateIndex (matrix, row - 1, col);
                //down
                sum += calculateIndex (matrix, row + 1, col);
                //left
                sum += calculateIndex (matrix, row, col - 1);
                //right
                sum += calculateIndex (matrix, row, col + 1);
                //upLeft
                sum += calculateIndex (matrix, row - 1, col - 1);
                //upRight
                sum += calculateIndex (matrix, row - 1, col + 1);
                //downLeft
                sum += calculateIndex (matrix, row + 1, col - 1);
                //downRight
                sum += calculateIndex (matrix, row + 1, col + 1);

                if (sum > maxSum) {
                    maxSum = sum;
                    subMatrixResult = copyMatrix (matrix, row, col);
                }
            }
        }

        System.out.println ("Sum = " + maxSum);
        printMatrix (subMatrixResult);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print (matrix[row][col] + " ");
            }
            System.out.println ();

        }
    }

    private static int[][] copyMatrix(int[][] matrix, int row, int col) {
        int[][] subMatrix = new int[3][3];

        //copy the column
        int subMatrixRow = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            subMatrix[subMatrixRow++][1] = matrix[i][col];
        }

        //copy the row
        int subMatrixCol = 0;
        for (int i = col - 1; i <= col + 1; i++) {
            subMatrix[1][subMatrixCol++] = matrix[row][i];
        }

        //copy the primaryDiagonal
        subMatrixCol = 0;
        subMatrixRow = 0;
        for (int i = row - 1, j = col - 1; i <= row + 1; i++, j++) {
            subMatrix[subMatrixRow++][subMatrixCol++] = matrix[i][j];
        }

        //copy the secondaryDiagonal
        subMatrixCol = 0;
        subMatrixRow = subMatrix.length - 1;
        for (int i = row + 1, j = col - 1; i >= row - 1; i--, j++) {
            subMatrix[subMatrixRow--][subMatrixCol++] = matrix[i][j];
        }
        return subMatrix;
    }

    private static int calculateIndex(int[][] matrix, int row, int col) {
        if (isIndexValid (matrix, row, col)) {
            return matrix[row][col];
        } else {
            throw new IndexOutOfBoundsException ("Look at the indexes");
        }
    }

    private static boolean isIndexValid(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[][] createMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt).toArray ();

        int rows = dimensions[0];
        int cols = dimensions[1];

        return new int[rows][cols];
    }

    private static void fillTheMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                    .mapToInt (Integer::parseInt).toArray ();

            matrix[row] = arr;
        }
    }
}
