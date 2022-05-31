import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[][] matrix = createMatrix (scanner);

        fillMatrix (scanner, matrix);

        String[] commands = scanner.nextLine ().split ("\\s+");

        String command = commands[0];

        while (!command.equalsIgnoreCase ("END")) {

            if (command.equals ("swap") && commands.length == 5
                    && isCoordinatesValid (matrix, commands[1], commands[2]
                    , commands[3], commands[4])) {

                int row1 = Integer.parseInt (commands[1]);
                int col1 = Integer.parseInt (commands[2]);
                int row2 = Integer.parseInt (commands[3]);
                int col2 = Integer.parseInt (commands[4]);

                swap (matrix, row1, col1, row2, col2);

                printMatrix (matrix);

            } else {
                System.out.println ("Invalid input!");
            }

            commands = scanner.nextLine ().split ("\\s+");
            command = commands[0];

        }


    }

    private static void swap(String[][] matrix, int row1, int col1, int row2, int col2) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] arr = scanner.nextLine ().split (" ");

            matrix[row] = arr;
        }
    }

    private static String[][] createMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print (matrix[row][col] + " ");
            }
            System.out.println ();
        }
    }

    private static boolean isCoordinatesValid(String[][] matrix, String row, String col, String rowTwo, String colTwo) {
        int row1 = Integer.parseInt (row);
        int col1 = Integer.parseInt (col);
        int row2 = Integer.parseInt (rowTwo);
        int col2 = Integer.parseInt (colTwo);
        return row1 >= 0 && row1 < matrix.length && col1 >= 0
                && col1 < matrix[row1].length && row2 >= 0
                && row2 < matrix.length && col2 >= 0
                && col2 < matrix[row2].length;
    }
}
