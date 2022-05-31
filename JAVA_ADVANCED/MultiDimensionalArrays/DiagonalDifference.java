import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    static int primaryDiagonalSum = 0;
    static int secondaryDiagonalSum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int sizeOfMatrix = Integer.parseInt (scanner.nextLine ());

        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

        fillTheMatrix (scanner, matrix);

        calculateTheSums (matrix);

        printTheDifference ();

    }

    private static void printTheDifference() {
        System.out.println (Math.abs (primaryDiagonalSum - secondaryDiagonalSum));
    }

    private static void calculateTheSums(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            primaryDiagonalSum += matrix[row][row];

            secondaryDiagonalSum += matrix[matrix.length - row - 1][row];

        }
    }

    private static void fillTheMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                    .mapToInt (Integer::parseInt).toArray ();

            matrix[row] = arr;
        }
    }

}
