import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int messageCapacity = Integer.parseInt (scanner.nextLine ());

        Map<String, Integer> info = new LinkedHashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("Statistics")) {
            String[] tokens = command.split ("=");

            String op = tokens[0];

            switch (op) {
                case "Add": {

                    String username = tokens[1];

                    if (info.containsKey (username)) {
                        command = scanner.nextLine ();
                        continue;
                    }

                    int sentMessages = Integer.parseInt (tokens[2]);
                    int receivedMessages = Integer.parseInt (tokens[3]);

                    int totalMessages = sentMessages + receivedMessages;

                    info.put (username, totalMessages);

                    break;
                }
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];

                    if (info.containsKey (sender) && info.containsKey (receiver)) {
                        info.put (sender, info.get (sender) + 1);
                        info.put (receiver, info.get (receiver) + 1);

                        if (info.get (sender) >= messageCapacity) {
                            info.remove (sender);
                            print (sender);
                        }

                        if (info.get (receiver) >= messageCapacity) {
                            info.remove (receiver);
                            print (receiver);
                        }
                    }

                    break;
                case "Empty": {
                    String username = tokens[1];

                    if (username.equals ("All")) {
                        info.clear ();
                    } else {
                        info.remove (username);
                    }
                    break;
                }
            }

            command = scanner.nextLine ();
        }

        System.out.println ("Users count: " + info.keySet ().size ());

        info.forEach ((key, value) -> System.out.println (key + " - " + value));
    }

    private static void print(String name) {
        System.out.println (name + " reached the capacity!");
    }
}
