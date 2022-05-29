import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IntersectionOfTwoMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int rows = Integer.parseInt (scanner.nextLine ());
        int cols = Integer.parseInt (scanner.nextLine ());

        char[][] matrixOne = new char[rows][cols];
        writeMatrix (scanner, matrixOne);

        char[][] matrixTwo = new char[rows][cols];
        writeMatrix (scanner,matrixTwo);

        for (int row = 0; row < matrixOne.length; row++) {
            for (int col = 0; col < matrixOne[row].length; col++) {
                if (matrixOne[row][col] == matrixTwo[row][col]) {
                    System.out.print(matrixOne[row][col]+" ");
                }else {
                    System.out.print("* ");
                }
            }
            System.out.println ();
        }
    }

    private static void writeMatrix(Scanner scanner, char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            char[] arr = scanner.nextLine ().replaceAll ("\\s+","").toCharArray ();
            matrix[i] = arr;
        }
    }
}


