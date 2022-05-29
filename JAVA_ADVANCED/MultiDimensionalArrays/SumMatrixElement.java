import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] dimension = Arrays.stream(scanner.nextLine ().split (", "))
                .mapToInt (Integer::parseInt).toArray ();

        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            int[] arr = Arrays.stream(scanner.nextLine ().split (", "))
                    .mapToInt (Integer::parseInt).toArray ();
            matrix[i] = arr;
        }

        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum+=matrix[row][col];
            }
        }

        System.out.println (rows);
        System.out.println (cols);
        System.out.println (sum);


    }
}
