import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        String URL = "";

        ArrayDeque<String> stack = new ArrayDeque<> ();
        ArrayDeque<String> queue = new ArrayDeque<> ();


        String command = scanner.nextLine ();

        while (!command.equals ("Home")){

            if (command.equals ("back")){
                if (stack.size ()<=1){
                    System.out.println ("no previous URLs");
                }else {
                    queue.addFirst (stack.pop ());
                    System.out.println (stack.peek ());
                }
            }else if (command.equals ("forward")){
                if (queue.size ()<1){
                    System.out.println ("no next URLs");
                }else {
                    stack.push (queue.peek ());
                    System.out.println (queue.poll());
                }
            }
            else if (!command.equals ("")){
                URL = command;
                stack.push (URL);
                queue.clear ();
                System.out.println (stack.peek ());
            }

            command = scanner.nextLine ();;
        }

    }
}
