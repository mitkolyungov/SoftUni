import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        CustomList<String> customList = new CustomList<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("END")) {
            String[] tokens = command.split ("\\s+");

            String op = tokens[0];

            switch (op) {
                case "Add": {
                    String value = tokens[1];
                    customList.add (value);
                    break;
                }
                case "Remove": {
                    int index = Integer.parseInt (tokens[1]);
                    customList.remove (index);
                    break;
                }
                case "Contains": {
                    String element = (tokens[1]);
                    System.out.println (customList.contains (element));
                    break;
                }
                case "Swap": {
                    int firstIndex = Integer.parseInt (tokens[1]);
                    int secondIndex = Integer.parseInt (tokens[2]);
                    customList.swap (firstIndex, secondIndex);
                    break;
                }
                case "Greater": {
                    String element = (tokens[1]);
                    System.out.println (customList.countGreaterThan (element));
                    break;
                }
                case "Max": {
                    System.out.println (customList.getMax ());
                    break;
                }
                case "Min": {
                    System.out.println (customList.getMin ());
                    break;
                }
                case "Print": {
                    System.out.println (customList);
                    break;
                }
                case "Sort":{
                    SorterClass.sort (customList);
                    break;
                }
                default:{
                    System.out.println ("Invalid command");
                }
            }

            command = scanner.nextLine ();
        }
    }
}
