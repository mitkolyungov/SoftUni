import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Buyer> info = new HashMap<> ();

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine ().split ("\\s+");

            String name = tokens[0];

            Buyer buyer = tokens.length == 4
                    ? new Citizen (name, Integer.parseInt (tokens[1]), tokens[2], tokens[3])
                    : new Rebel (name, Integer.parseInt (tokens[1]), tokens[2]);

            info.putIfAbsent (name, buyer);
        }

        String command = scanner.nextLine ();

        while (!command.equals ("End")) {

            if (info.containsKey (command)) {
                info.get (command).buyFood ();
            }

            command = scanner.nextLine ();
        }

        System.out.println (info.values ()
                .stream ().mapToInt (Buyer::getFood).sum ());


    }
}
