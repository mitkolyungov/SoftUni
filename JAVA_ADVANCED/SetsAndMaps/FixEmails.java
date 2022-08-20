import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, String> map = new LinkedHashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("stop")) {
            String name = command;
            String email = scanner.nextLine ();

            String domain = email.substring (email.lastIndexOf (".") + 1);

            if (!domain.equals ("us")
                    && !domain.equals ("uk")
                    && !domain.equals ("com")) {

                map.putIfAbsent (name, email);
            }

            command = scanner.nextLine ();
        }

        for (var entry : map.entrySet ()) {
            System.out.println (entry.getKey () + " -> " + entry.getValue ());
        }
    }
}
