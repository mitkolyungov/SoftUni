import java.util.Arrays;
import java.util.Scanner;

public class EqualArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        int[] array1 = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt).toArray ();

        int[] array2 = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt).toArray ();


        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                System.out.printf ("Arrays are not identical. " +
                        "Found difference at %d index.", i);
                return;
            }
        }

        System.out.println ("Arrays are identical. Sum: " + Arrays.stream (array1).sum ());
    }
}
