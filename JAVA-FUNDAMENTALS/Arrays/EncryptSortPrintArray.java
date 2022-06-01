import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt (scanner.nextLine ());
        }

        for (int i = 0; i < n; i++) {
            System.out.print (array[i] + " ");
        }
        System.out.println ();
        System.out.println (Arrays.stream (array).sum ());
    }
}
