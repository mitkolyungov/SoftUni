import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        //Read input??
        Scanner scanner = new Scanner (System.in);

        String rotationInput = scanner.nextLine ();
        String input = scanner.nextLine ();

        List<String> wordList = new ArrayList<> ();
        int maxColumnLength = findMaxColumnLength (scanner, input, wordList);
        //create matrix
        int rows = wordList.size ();
        int cols = maxColumnLength;

        char[][] matrix = new char[rows][cols];
        //fill the matrix
        fillTheMatrix (wordList, rows, cols, matrix);

        //rotate and print
        String angleString = rotationInput.split ("[()]")[1];
        int angle = Integer.parseInt (angleString);
        int angleOfRotation = angle % 360;

        printMatrix (matrix, rows, cols, angleOfRotation);
    }

    private static int findMaxColumnLength(Scanner scanner, String input, List<String> wordList) {
        int maxColumnLength = Integer.MIN_VALUE;
        while (!input.equals ("END")) {
            int currentLength = input.length ();

            if (currentLength > maxColumnLength) {
                maxColumnLength = currentLength;
            }
            wordList.add (input);
            input = scanner.nextLine ();
        }
        return maxColumnLength;
    }

    private static void fillTheMatrix(List<String> wordList, int rows, int cols, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String currentWord = wordList.get (row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length ()) {
                    char currentChar = currentWord.charAt (col);
                    matrix[row][col] = currentChar;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix, int rows, int cols, int angleOfRotation) {
        switch (angleOfRotation) {
            case 0:
                //don't rotate at all
                rotate0 (matrix, rows, cols);
                break;
            case 90:
                //rotate to the right
                rotate90 (matrix, rows, cols);
                break;
            case 180:
                //rotate upside down
                rotate180 (matrix, rows, cols);
                break;
            case 270:
                //rotate left
                rotate270 (matrix, rows, cols);
                break;
        }
    }

    private static void rotate0(char[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print (matrix[row][col]);
            }
            System.out.println ();
        }
    }

    private static void rotate90(char[][] matrix, int rows, int cols) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {
                System.out.print (matrix[row][col]);
            }
            System.out.println ();
        }
    }

    private static void rotate180(char[][] matrix, int rows, int cols) {
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                System.out.print (matrix[row][col]);
            }
            System.out.println ();
        }
    }

    private static void rotate270(char[][] matrix, int rows, int cols) {
        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row++) {
                System.out.print (matrix[row][col]);
            }
            System.out.println ();
        }
    }
}