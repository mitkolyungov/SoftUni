import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt).collect (Collectors.toList ());

        String commands = scanner.nextLine ();

        while (!commands.equals ("end")) {
            String[] tokens = commands.split (" ");
            String command = tokens[0];

            switch (command) {
                case "Add": {
                    int number = Integer.parseInt (tokens[1]);
                    numbers.add (number);
                    break;
                }
                case "Remove": {
                    int number = Integer.parseInt (tokens[1]);
                    numbers.remove (Integer.valueOf (number));
                    break;
                }
                case "RemoveAt": {
                    int index = Integer.parseInt (tokens[1]);
                    numbers.remove (index);
                    break;
                }
                case "Insert": {
                    int number = Integer.parseInt (tokens[1]);
                    int index = Integer.parseInt (tokens[2]);
                    numbers.add (index, number);
                    break;
                }
            }

            commands = scanner.nextLine ();
        }

        numbers.forEach (e -> {
            System.out.print (e + " ");
        });
    }
}
