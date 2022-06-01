import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] array = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();


        int[] condensed = new int[array.length - 1];

        while (array.length > 1) {
            for (int i = 0; i < array.length - 1; i++) {
                condensed[i] = array[i] + array[i + 1];
            }
            array = condensed;

            condensed = new int[array.length - 1];
        }

        System.out.println (array[0]);
    }
}
