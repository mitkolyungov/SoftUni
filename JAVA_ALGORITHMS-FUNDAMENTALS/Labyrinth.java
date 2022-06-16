import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Labyrinth {
    public static List<Character> path = new ArrayList<> ();
    static char[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int row = Integer.parseInt (scanner.nextLine ());
        int col = Integer.parseInt (scanner.nextLine ());

        matrix = new char[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine ().toCharArray ();
        }

        char target = 'e';

        findAllPath (0, 0, ' ');
    }

    private static void findAllPath(int row, int col, char direction) {
        if (!isInBound (row, col)) {
            return;
        }

        path.add (direction);

        if (isExit (row, col)) {
            printPath ();
        } else if (!isVisited (row, col) && isFree (row, col)) {
            mark (row, col);

            findAllPath (row, col + 1, 'R');
            findAllPath (row + 1, col, 'D');
            findAllPath (row, col - 1, 'L');
            findAllPath (row - 1, col, 'U');

            unmark (row, col);
        }

        path.remove (path.size () - 1);

    }

    private static boolean isFree(int row, int col) {
        return matrix[row][col] == '-';
    }

    private static boolean isVisited(int row, int col) {
        return matrix[row][col] == 'V';
    }

    private static void unmark(int row, int col) {
        matrix[row][col] = '-';
    }

    private static void mark(int row, int col) {
        matrix[row][col] = 'V';
    }

    private static boolean isExit(int row, int col) {
        return matrix[row][col] == 'e';
    }

    private static void printPath() {
        for (Character character : path) {

            if (character == ' ') {
                continue;
            }

            System.out.print (character);
        }
        System.out.println ();
    }

    private static boolean isInBound(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
