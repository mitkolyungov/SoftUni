import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Birthable> birthableList = new ArrayList<> ();

        String input = scanner.nextLine ();

        while (!input.equals ("End")) {
            String[] tokens = input.split ("\\s+");

            Birthable birthable = tokens.length == 5
                    ? new Citizen (tokens[1], Integer.parseInt (tokens[2]),
                    tokens[3], tokens[4])
                    : tokens.length == 3 && !tokens[1].contains ("-")
                    ? new Pet (tokens[1], tokens[2])
                    : null;

            birthableList.add (birthable);

            input = scanner.nextLine ();
        }

        String birthYear = scanner.nextLine ();


        if (birthableList.stream ()
                .filter (Objects::nonNull)
                .map (Birthable::getBirthDate)
                .noneMatch (e -> e.endsWith (birthYear))) {

            System.out.println ("<no output>");

        } else {
            birthableList.stream ()
                    .filter (Objects::nonNull)
                    .map (Birthable::getBirthDate)
                    .filter (e -> e.endsWith (birthYear))
                    .forEach (System.out::println);
        }


    }
}
