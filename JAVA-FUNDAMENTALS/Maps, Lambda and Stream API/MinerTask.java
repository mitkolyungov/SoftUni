import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Integer> resources = new LinkedHashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("stop")) {
            String resource = command;

            command = scanner.nextLine ();

            int quantities = Integer.parseInt (command);

            resources.putIfAbsent (resource, 0);
            resources.put (resource, resources.get (resource) + quantities);


            command = scanner.nextLine ();
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet ()) {
            System.out.printf ("%s -> %d%n"
                    , entry.getKey (), entry.getValue ());
        }
    }
}
