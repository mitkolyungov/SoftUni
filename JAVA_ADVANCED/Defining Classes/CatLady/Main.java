import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Cat> cats = new ArrayList<> ();

        String info = scanner.nextLine ();

        while (!info.equalsIgnoreCase ("end")) {
            String[] tokens = info.split ("\\s+");

            String type = tokens[0];
            String name = tokens[1];
            double specificChar = Double.parseDouble (tokens[2]);

            if (type.equalsIgnoreCase ("Siamese")) {
                cats.add (new Siamese (name, specificChar));
            } else if (type.equalsIgnoreCase ("Cymric")) {
                cats.add (new Cymric (name, specificChar));
            } else if (type.equalsIgnoreCase ("StreetExtraordinaire")) {
                cats.add (new StreetExtraordinaire (name, specificChar));
            }

            info = scanner.nextLine ();
        }

        String catName = scanner.nextLine ();

      cats.stream ()
                .filter (c -> c.getName ().equals (catName))
                .forEach (System.out::println);
    }
}
