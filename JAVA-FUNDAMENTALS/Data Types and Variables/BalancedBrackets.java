import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int lines = Integer.parseInt (scanner.nextLine ());

        ArrayDeque<String> stack = new ArrayDeque<> ();

        for (int i = 0; i < lines; i++) {
            String string = scanner.nextLine ();

            if (string.equals ("(")){
                stack.push (string);
            } else if (string.equals (")")) {
                if (stack.size ()==0){
                    System.out.println ("UNBALANCED");
                    return;
                }else if (stack.peek ().equals ("(")){
                    stack.pop ();
                }
            }
        }

        if (stack.size ()==0){
            System.out.println ("BALANCED");
        }else {
            System.out.println ("UNBALANCED");
        }
    }
}
