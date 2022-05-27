import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        String[] input = scanner.nextLine ().split (" ");

        ArrayDeque<Integer> stack = new ArrayDeque<> ();

        for (int i = 0; i < input.length; i++) {
            if (Character.isDigit (input[i].charAt (0))) {
                int number = Integer.parseInt (input[i]);
                stack.push (number);
            } else {
                int leftNumber = stack.peek ();
                String op = input[i];

                int rightNumber = Integer.parseInt (input[++i]);
                stack.push (rightNumber);

                if (op.equals ("+")) {
                    stack.push (leftNumber + rightNumber);
                } else if (op.equals ("-")) {
                    stack.push (leftNumber - rightNumber);
                }
            }
        }

        System.out.println (stack.peek ());
    }
}
