import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] info = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt)
                .toArray ();

        int[] integers = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt)
                .toArray ();

        int pullElements = info[1];
        int isPresent = info[2];

        ArrayDeque<Integer> queue = new ArrayDeque<> ();

        for (int integer : integers) {
            queue.offer (integer);
        }

        for (int i = 0; i < pullElements; i++) {
            queue.poll ();
        }

        System.out.println (printResult (queue, isPresent));

    }

    private static String printResult(ArrayDeque<Integer> queue, int isPresent) {
        if (queue.isEmpty ()) {
            return String.valueOf (0);
        } else if (queue.contains (isPresent)) {
            return "true";
        } else {
            return String.valueOf (queue.stream ().min (Integer::compare).get ());
        }
    }
}
