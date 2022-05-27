import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());
        int[] command;
        ArrayDeque<Integer> stack = new ArrayDeque<> ();

        for (int i = 0; i < n; i++) {
            command = Arrays.stream (scanner.nextLine ().split (" "))
                    .mapToInt (Integer::parseInt).toArray ();
            if (command[0] == 1) {
                stack.push (command[1]);
            } else if (command[0] == 2) {
                stack.pop ();
            } else if (command[0] == 3) {
                printMaxElement (stack);
            }

        }

    }

    private static void printMaxElement(ArrayDeque<Integer> stack) {
        System.out.println (stack.stream ().max (Integer::compare).get ());
    }
}


