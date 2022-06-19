import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> wagons = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt)
                .collect (Collectors.toList ());

        int maxCapacity = Integer.parseInt (scanner.nextLine ());


        String command = scanner.nextLine ();

        while (!command.equals ("end")) {
            String[] tokens = command.split (" ");

            if (tokens[0].equals ("Add")) {
                wagons.add (Integer.parseInt (tokens[1]));
            } else {

                int people = Integer.parseInt (tokens[0]);

                for (int i = 0; i < wagons.size (); i++) {

                    if (wagons.get (i) + people <= maxCapacity) {
                        wagons.set (i, wagons.get (i) + people);
                        break;
                    }
                }
            }

            command = scanner.nextLine ();
        }

        for (Integer wagon : wagons) {
            System.out.print (wagon + " ");
        }
    }
}
