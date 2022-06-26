import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt)
                .collect (Collectors.toList ());

        String commands = scanner.nextLine ();

        while (!commands.equals ("Finish")) {
            String[] tokens = commands.split (" ");

            String command = tokens[0];
            int number = Integer.parseInt (tokens[1]);

            switch (command) {
                case "Add":
                    numbers.add (number);
                    break;
                case "Remove":
                    numbers.remove (Integer.valueOf (number));
                    break;
                case "Replace":
                    int replacement = Integer.parseInt (tokens[2]);
                    if (numbers.contains (number)) {
                        numbers.set (numbers.indexOf (number), replacement);
                    }
                    break;
                case "Collapse":
                    numbers.removeIf (integer -> integer < number);
                    break;
            }

            commands = scanner.nextLine ();
        }
        for (Integer number : numbers) {
            System.out.print (number + " ");
        }

    }
}
