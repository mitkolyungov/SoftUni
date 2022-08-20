import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Map<String, Integer>> map = new TreeMap<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("end")) {
            String[] tokens = command.split ("\\s+");

            String ip = tokens[0].substring (tokens[0].indexOf ("=") + 1).trim ();
            String username = tokens[2].substring (tokens[2].lastIndexOf ("=") + 1).trim ();

            map.putIfAbsent (username, new LinkedHashMap<> ());
            map.get (username).putIfAbsent (ip, 0);
            map.get (username).put (ip, map.get (username).get (ip) + 1);

            command = scanner.nextLine ();
        }

        for (var mainEntry : map.entrySet ()) {
            System.out.println (mainEntry.getKey () + ":");

            int counter = 0;
            for (var subEntry : mainEntry.getValue ().entrySet ()) {
                counter++;

                if (counter < map.get (mainEntry.getKey ()).size ()) {
                    System.out.print (subEntry.getKey () + " => " + subEntry.getValue () + ", ");
                } else {
                    System.out.println (subEntry.getKey () + " => " + subEntry.getValue () + ".");
                }
            }
        }
    }
}
