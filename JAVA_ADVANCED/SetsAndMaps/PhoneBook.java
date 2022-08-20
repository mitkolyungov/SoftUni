import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, String> phonebook = new HashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("search")) {
            String[] tokens = command.split ("-");

            if (tokens.length == 2) {
                String name = tokens[0];
                String phoneNumber = tokens[1];

                phonebook.put (name, phoneNumber);
            }
            command = scanner.nextLine ();
        }

        command = scanner.nextLine ();

        while (!command.equals ("stop")) {
            String name = command;

            if (phonebook.containsKey (name)) {
                System.out.println (name + " -> " + phonebook.get (name));
            } else {
                System.out.println ("Contact " + name + " does not exist.");
            }

            command = scanner.nextLine ();
        }
    }
}
