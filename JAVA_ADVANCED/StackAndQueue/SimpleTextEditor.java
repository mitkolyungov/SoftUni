import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        ArrayDeque<String> stack = new ArrayDeque<> ();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine ().split ("\\s+");
            int command = Integer.parseInt (commands[0]);
            if (command == 1) {
                if (stack.peek () != null) {
                    stack.push (stack.peek ().concat (commands[1]));
                } else {
                    stack.push (commands[1]);
                }
            } else if (command == 2) {
                int removedElements = Integer.parseInt (commands[1]);
                stack.push (stack.peek ().substring (0,
                        stack.peek ().length () - removedElements));
            } else if (command == 3) {
                int index = Integer.parseInt (commands[1]);
                System.out.println (stack.peek ().charAt (index - 1));
            } else if (command == 4) {
                stack.pop ();
            }
        }
    }
}
