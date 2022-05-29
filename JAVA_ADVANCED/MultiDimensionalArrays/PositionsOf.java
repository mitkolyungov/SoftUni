import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] rowsAndCows = Arrays.stream(scanner.nextLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt).toArray ();

        int[][] matrix = new int[rowsAndCows[0]][rowsAndCows[1]];

        for (int i = 0; i < matrix.length; i++) {
            int[] arr = Arrays.stream(scanner.nextLine ().split ("\\s+"))
                    .mapToInt (Integer::parseInt).toArray ();

            matrix[i] = arr;
        }

        int searchingNumber = Integer.parseInt (scanner.nextLine ());
        boolean isFound = false;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cows = 0; cows < matrix[rows].length; cows++) {
                if (matrix[rows][cows]==searchingNumber){
                    System.out.println (rows+" "+cows);
                    isFound = true;
                }
            }
        }

        if (!isFound){
            System.out.println ("not found");
        }
    }
}
