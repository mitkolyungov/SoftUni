import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] input = scanner.nextLine ().split ("[|]");

        int initialHealth = 100;
        int bitcoins = 0;
        int roomsCount = 0;

        Iterator<String> inputStream = Arrays.stream (input).iterator ();

        while (inputStream.hasNext ()) {
            roomsCount++;

            String[] commands = inputStream.next ().split ("\\s+");

            String command = commands[0];
            int number = Integer.parseInt (commands[1]);

            if (command.equals ("chest")) {
                System.out.printf ("You found %d bitcoins.%n", number);
                bitcoins += number;
            } else if (command.equals ("potion")) {
                initialHealth += number;

                int healed = number;

                if (initialHealth > 100) {
                    healed = number - (initialHealth - 100);
                    initialHealth = 100;
                }

                System.out.printf ("You healed for %d hp.%n", healed);
                System.out.printf ("Current health: %d hp.%n", initialHealth);
            } else {
                initialHealth -= number;

                if (initialHealth <= 0) {
                    System.out.printf ("You died! Killed by %s.%n", command);
                    System.out.printf ("Best room: %d%n", roomsCount);
                    return;
                } else {
                    System.out.printf ("You slayed %s.%n", command);
                }
            }
        }

        System.out.println ("You've made it!");
        System.out.printf ("Bitcoins: %d%n", bitcoins);
        System.out.printf ("Health: %d%n", initialHealth);
    }
}
