import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> integerList = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt)
                .collect (Collectors.toList ());

        String commands = scanner.nextLine ();

        while (!commands.equals ("end")) {
            String[] tokens = commands.split (" ");

            String command = tokens[0];
            int element = Integer.parseInt (tokens[1]);

            if (command.equals ("Delete")) {
                integerList.removeIf (integer -> integer == (element));

            } else if (command.equals ("Insert")) {
                int index = Integer.parseInt (tokens[2]);

                integerList.add (index, element);
            }

            commands = scanner.nextLine ();
        }

        integerList.forEach (e -> {
            System.out.print (e + " ");
        });
    }
}
