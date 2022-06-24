import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> inventory = Arrays.stream (scanner.nextLine ()
                        .split (", "))
                .collect (Collectors.toList ());

        String[] tokens = scanner.nextLine ().split (" - ");
        while (!tokens[0].equals ("Craft!")) {

            String command = tokens[0];
            String item = tokens[1];

            switch (command) {
                case "Collect":
                    if (!inventory.contains (item)) {
                        inventory.add (item);
                    }
                    break;
                case "Drop":
                    inventory.remove (item);
                    break;
                case "Combine Items":
                    String[] items = tokens[1].split (":");
                    String oldItem = items[0];
                    String newItem = items[1];

                    if (inventory.contains (oldItem)) {
                        int index = inventory.indexOf (oldItem);
                        inventory.add (index + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (inventory.contains (item)) {
                        inventory.remove (item);
                        inventory.add (item);
                    }
                    break;
            }

            tokens = scanner.nextLine ().split (" - ");
        }

        System.out.println (String.join (", ", inventory));
    }
}
