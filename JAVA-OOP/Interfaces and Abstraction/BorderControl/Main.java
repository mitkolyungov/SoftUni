import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Identifiable> society = new ArrayList<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("End")) {
            String[] tokens = command.split ("\\s+");

            Identifiable identifiable = tokens.length == 2
                    ? new Robot (tokens[1], tokens[0])
                    : new Citizen (tokens[0], Integer.parseInt (tokens[1]), tokens[2]);

            society.add (identifiable);
            
            command = scanner.nextLine ();
        }

        String fakeId = scanner.nextLine ();

        society.stream ().filter (e -> e.getId ().endsWith (fakeId))
                .forEach (s -> System.out.println (s.getId ()));
    }
}
