import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] integers = Arrays.stream (scanner.nextLine ().split (" ")).mapToInt (Integer::parseInt).toArray ();

        ArrayDeque<Integer> stack = new ArrayDeque<> ();

        for (int integer : integers) {
            stack.push (integer);
        }

        while (stack.iterator ().hasNext ()) {
            System.out.print (stack.pop () + " ");
        }


    }
}
