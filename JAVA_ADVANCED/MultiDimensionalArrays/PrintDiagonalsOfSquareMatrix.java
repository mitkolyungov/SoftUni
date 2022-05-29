import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int side = Integer.parseInt (scanner.nextLine ());
        int[][] matrix = new int[side][side];

        for (int i = 0; i < matrix.length; i++) {
            int[] arr = Arrays.stream (scanner.nextLine ().split (" "))
                    .mapToInt (Integer::parseInt).toArray ();
            matrix[i] = arr;
        }


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[col][col]+" ");
            }

            System.out.println ();

            for (int col = matrix.length-1; col >=0 ; col--) {
                System.out.print (matrix[col][row++]+" ");
            }
        }

    }
}

