public class QueenPuzzle {
    static char[][] board = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',}, {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',}, {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',}, {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',}, {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',}, {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',}, {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',}, {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},

    };

    static final int ROWS = 8;
    static final int COLS = 8;

    public static void main(String[] args) {

        findAllPossiblePlacements (0);
    }

    private static void findAllPossiblePlacements(int row) {
        if (row == 8) {
            print ();
        } else {
            for (int col = 0; col < COLS; col++) {
                if (beAbleToPlaceQueen (row, col)) {
                    putQueen (row, col);
                    findAllPossiblePlacements (row + 1);
                    removeQueen (row, col);
                }
            }
        }
    }

    private static void removeQueen(int row, int col) {
        board[row][col] = '-';
    }

    private static boolean beAbleToPlaceQueen(int row, int col) {
        for (int c = 0; c < COLS; c++) {
            if (board[row][c] == '*') {
                return false;
            }
        }

        for (int r = 0; r < ROWS; r++) {
            if (board[r][col] == '*') {
                return false;
            }
        }

        int r = row;
        int c = col;

        while (r >= 0 && c >= 0) {
            if (board[r--][c--] == '*') {
                return false;
            }
        }

        r = row;
        c = col;
        while (r < ROWS && c < COLS) {
            if (board[r++][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;
        while (r >= 0 && c < COLS) {
            if (board[r--][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;
        while (r < ROWS && c >= 0) {
            if (board[r++][c--] == '*') {
                return false;
            }
        }

        return true;
    }

    private static void putQueen(int r, int c) {
        board[r][c] = '*';
    }

    private static void print() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print (board[i][j] + " ");
            }
            System.out.println ();
        }
        System.out.println ();
    }

}
