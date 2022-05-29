import java.util.Arrays;
import java.util.Scanner;

public class MacimumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] dimension = Arrays.stream (scanner.nextLine ().split (", "))
                .mapToInt (Integer::parseInt).toArray ();

        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            int[] arr = Arrays.stream (scanner.nextLine ().split (", "))
                    .mapToInt (Integer::parseInt).toArray ();
            matrix[i] = arr;
        }

        int sum = 0;
        int maxSum = 0;
        int[][] submatrix = new int[2][2];

        for (int row = 0; row < matrix.length-1; row++) {
            for (int col = 0; col < matrix[row].length-1; col++) {
                sum = matrix[row][col]+matrix[row+1][col]
                +matrix[row][col+1]+matrix[row+1][col+1];

                if (sum>maxSum){
                    submatrix[0][0] = matrix[row][col];
                    submatrix[0][1] = matrix[row][col+1];
                    submatrix[1][0] = matrix[row+1][col];
                    submatrix[1][1] = matrix[row+1][col+1];
                    maxSum = sum;
                }
            }
        }

        for (int i = 0; i < submatrix.length ; i++) {
            for (int j = 0; j < submatrix[i].length; j++) {
                System.out.print(submatrix[i][j]+" ");
            }
            System.out.println ();
        }

        System.out.println (maxSum);


    }
}

