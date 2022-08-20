import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Map<String, Long>> data = new LinkedHashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("End")) {

            if (isInvalid (command)) {
                command = scanner.nextLine ();
                continue;
            }

            String[] tokens = command.split ("\\s+");

            int indexOf = command.indexOf ("@");

            String singer = command.substring (0, indexOf).trim ();

            String venue = command
                    .substring (indexOf + 1, firstNumber (indexOf, command)).trim ();

            int ticketPrice = Integer.parseInt (tokens[tokens.length - 2]);
            int ticketsCount = Integer.parseInt (tokens[tokens.length - 1]);

            long amountMoney = (long) ticketPrice * ticketsCount;

            data.putIfAbsent (venue, new LinkedHashMap<> ());

            data.get (venue).putIfAbsent (singer, 0L);
            data.get (venue)
                    .put (singer, data.get (venue).get (singer) + amountMoney);


            command = scanner.nextLine ();
        }

        for (var entry : data.entrySet ()) {
            System.out.println (entry.getKey ());

            entry.getValue ().entrySet ().stream ()
                    .sorted ((f, s) -> s.getValue ().compareTo (f.getValue ()))
                    .forEach (s -> {
                        System.out.printf ("#  %s -> %d%n", s.getKey (), s.getValue ());
                    });
        }
    }

    private static boolean isInvalid(String command) {
        String[] tokens = command.split ("@");
        String[] ticketInfo = tokens[1].split (" ");

        if (tokens[0].split ("\\s+").length > 3) {
            return true;
        }

        if (ticketInfo.length > 5) {
            return true;
        }

        if (!Character.isDigit (ticketInfo[ticketInfo.length - 1].charAt (0))) {
            return true;
        }

        if (!Character.isDigit (ticketInfo[ticketInfo.length - 2].charAt (0))) {
            return true;
        }

        return false;
    }

    private static int firstNumber(int indexOf, String command) {
        for (int i = indexOf; i < command.length (); i++) {
            if (Character.isDigit (command.charAt (i))) {
                return i;
            }
        }
        return -1;
    }
}
