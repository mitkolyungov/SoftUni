import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> integerList = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt)
                .collect (Collectors.toList ());

        String commands = scanner.nextLine ();

        while (!commands.equals ("End")) {

            String[] tokens = commands.split ("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add": {
                    int number = Integer.parseInt (tokens[1]);

                    integerList.add (number);

                    break;
                }
                case "Remove": {
                    int index = Integer.parseInt (tokens[1]);

                    if (isValid (integerList, index)) {
                        integerList.remove (index);
                    } else {
                        System.out.print ("Invalid index\n");
                    }
                    break;
                }
                case "Insert": {
                    int number = Integer.parseInt (tokens[1]);
                    int index = Integer.parseInt (tokens[2]);

                    if (isValid (integerList, index)) {
                        integerList.add (index, number);
                    } else {
                        System.out.print ("Invalid index\n");
                    }
                    break;
                }
                case "Shift":
                    String direction = tokens[1];
                    int count = Integer.parseInt (tokens[2]);

                    if (direction.equals ("right")) {
                        Collections.rotate (integerList, count);
                    } else if (direction.equals ("left")) {
                        Collections.rotate (integerList, integerList.size () - count);
                    }
                    break;
            }

            commands = scanner.nextLine ();
        }

        for (Integer integer : integerList) {
            System.out.print (integer + " ");
        }
    }

    private static boolean isValid(List<Integer> integerList, int index) {
        return index >= 0 && index < integerList.size ();
    }
}
