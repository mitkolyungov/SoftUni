import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        char[][] matrix = createMatrix (scanner);

        printMatrix (matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf ("%c%c%c ", row + 'a', row + col + 'a', row + 'a');
            }
            System.out.println ();
        }
    }

    private static char[][] createMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();

        int rows = dimensions[0];
        int cols = dimensions[1];

        return new char[rows][cols];
    }
}
