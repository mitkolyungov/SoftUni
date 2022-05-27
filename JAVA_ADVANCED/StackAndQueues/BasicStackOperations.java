import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        int[] input = Arrays.stream (scanner.nextLine ().split (" ")).mapToInt (Integer::parseInt).toArray ();
        int[] integers = Arrays.stream (scanner.nextLine ().split (" ")).mapToInt (Integer::parseInt).toArray ();

        ArrayDeque<Integer> stack = new ArrayDeque<> ();

        int getNumberOfElementToPop = input[1];

        int isPresent = input[2];

        for (int integer : integers) {
            stack.push (integer);
        }

        for (int i = 0; i < getNumberOfElementToPop; i++) {
            stack.pop ();
        }

        System.out.println (getResult (stack, isPresent));
    }

    private static String getResult(ArrayDeque<Integer> stack, int isPresent) {
        if (stack.isEmpty ()) {
            return "0";
        }

        if (stack.contains (isPresent)) {
            return "true";
        }
        return String.valueOf (stack.stream ().min (Integer::compare).get ());
    }
}

