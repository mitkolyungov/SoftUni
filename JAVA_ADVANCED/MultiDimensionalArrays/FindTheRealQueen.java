import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        char[][] matrix = new char[8][8];

        for (int i = 0; i < matrix.length; i++) {
            char[] arr = scanner.nextLine ().replaceAll ("\\s+", "")
                    .toCharArray ();

            matrix[i] = arr;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'q') {
                    if (checkTheQueen (matrix, row, col)){
                        System.out.println (row+" "+col);
                    }
                }
            }
        }
    }

    private static boolean checkTheQueen(char[][] matrix, int row, int col) {
        int savedCol = col;
        // to the left
        for (int i = col - 1; i >= 0; i--) {
            if (matrix[row][i] == 'q') {
                return false;
            }
        }

        //to the right
        for (int i = col + 1; i < matrix.length; i++) {
            if (matrix[row][i] == 'q') {
                return false;
            }
        }
        // to the top
        for (int i = row - 1; i >= 0; i--) {
            if (matrix[i][col] == 'q') {
                return false;
            }
        }

        //to the bottom
        for (int i = row + 1; i < matrix.length; i++) {
            if (matrix[i][col] == 'q') {
                return false;
            }
        }

        // to the top right
        col = savedCol+1;
        for (int i = row - 1; i >= 0 && col< matrix.length; i--, col++) {
            if (matrix[i][col] == 'q') {
                return false;
            }
        }

        col = savedCol-1;
        // to the top left
        for (int i = row - 1; i >= 0 && col >= 0; i--, col--) {
            if (matrix[i][col] == 'q') {
                return false;
            }
        }

        col = savedCol+1;
        //to the bottom right
        for (int i = row + 1; i < matrix.length && col < matrix.length; i++, col++) {
            if (matrix[i][col] == 'q') {
                return false;
            }
        }

        col = savedCol-1;
        // to the bottom left
        for (int i = row+1;i< matrix.length && col>=0; i++,col--) {
            if (matrix[i][col] == 'q') {
                return false;
            }
        }
        return true;
    }

}
