import java.util.Arrays;
import java.util.Scanner;

public class MaxSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] integers = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();

        int counter = 0;
        int maxCount = 0;
        int endIndex = 0;
        boolean isChanged = false;

        for (int i = 1; i < integers.length; i++) {
            counter++;

            if (integers[i - 1] != integers[i]) {
                isChanged = true;
                counter = 0;
            }

            if (counter > maxCount) {
                endIndex = i;
                maxCount = counter;
            }
        }

        if (!isChanged) {
            for (int integer : integers) {
                System.out.print (integer + " ");
            }
        } else {
            for (int i = endIndex; i >= endIndex - maxCount; i--) {
                System.out.print (integers[i] + " ");
            }
        }
    }
}
