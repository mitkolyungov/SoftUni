import java.util.*;
import java.util.stream.Collectors;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            int integer = Integer.parseInt (scanner.nextLine ());
            array[i] = integer;
        }

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print (array[i] + " ");
        }

    }
}

