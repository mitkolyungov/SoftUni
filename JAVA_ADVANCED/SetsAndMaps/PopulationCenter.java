import java.util.*;

public class PopulationCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Map<String, Long>> data = new LinkedHashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("report")) {
            String[] tokens = command.split ("\\|");

            String cityName = tokens[0].trim ();
            String countryName = tokens[1].trim ();
            long population = Long.parseLong (tokens[2].trim ());

            data.putIfAbsent (countryName, new LinkedHashMap<> ());
            data.get (countryName).putIfAbsent (cityName, population);

            command = scanner.nextLine ();
        }

        for (var entry : data.entrySet ()) {
            System.out.println (entry.getKey () + " (total population: " + entry.getValue () + ")");


            entry.getValue ().entrySet ().stream ()
                    .sorted ((f, d) -> d.getValue ().compareTo (f.getValue ()))
                    .forEach (s -> System.out.println ("=>" + s.getKey () + ": " + s.getValue ()));
        }
    }
}
