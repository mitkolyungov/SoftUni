import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, String> parkingSlots = new LinkedHashMap<> ();

        int n = Integer.parseInt (scanner.nextLine ());


        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine ().split ("\\s+");

            String command = tokens[0];
            String name = tokens[1];

            if (command.equals ("register")) {
                String plateNumber = tokens[2];
                if (parkingSlots.containsKey (name)) {
                    System.out.printf ("ERROR: already registered with plate number %s%n"
                            , parkingSlots.get (name));
                } else {
                    parkingSlots.put (name, plateNumber);
                    System.out.printf ("%s registered %s successfully%n"
                            , name, plateNumber);
                }

            } else if (command.equals ("unregister")) {
                if (parkingSlots.containsKey (name)) {
                    parkingSlots.remove (name);
                    System.out.printf ("%s unregistered successfully%n", name);
                } else {
                    System.out.printf ("ERROR: user %s not found%n", name);
                }
            }
        }

        parkingSlots.forEach ((key, value) -> System.out.printf ("%s => %s%n", key, value));
    }
}
