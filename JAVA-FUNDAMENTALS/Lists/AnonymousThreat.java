import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> strings = (Arrays.stream (scanner.nextLine ().split ("\\s+")))
                .collect (Collectors.toList ());

        String command = scanner.nextLine ();


        while (!command.equals ("3:1")) {
            String[] tokens = command.split ("\\s+");

            String operation = tokens[0];


            if (operation.equals ("merge")) {
                int startIndex = Integer.parseInt (tokens[1]);
                int endIndex = Integer.parseInt (tokens[2]);

                if (startIndex < 0) {
                    startIndex = 0;
                }

                if (endIndex > strings.size () - 1) {
                    endIndex = strings.size () - 1;
                }

                boolean validIndexes = endIndex >= startIndex;

                if (validIndexes) {
                    StringBuilder stringBuilder = new StringBuilder ();

                    for (int i = startIndex; i <= endIndex; i++) {
                        stringBuilder.append (strings.get (i));
                    }

                    for (int i = startIndex; i <= endIndex; i++) {
                        strings.remove (startIndex);
                    }

                    strings.add (startIndex, stringBuilder.toString ());
                }

            } else if (operation.equals ("divide")) {
                int index = Integer.parseInt (tokens[1]);
                int partitions = Integer.parseInt (tokens[2]);

                String element = strings.get (index);

                int parts = element.length () / partitions;

                strings.remove (element);

                for (int part = 0; part < partitions - 1; part++) {
                    strings.add (index++, element.substring (part * parts, parts + part * parts));
                }

                strings.add (index, element.substring (partitions * parts - parts));
            }
            command = scanner.nextLine ();
        }

        System.out.println (String.join (" ", strings));
    }
}
