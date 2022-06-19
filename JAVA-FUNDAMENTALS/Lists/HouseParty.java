import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> guest = new ArrayList<> ();

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            List<String> tokens = Arrays.stream (scanner.nextLine ()
                            .split (" "))
                    .collect (Collectors.toList ());

            String name = tokens.get (0);

            if (tokens.contains ("not")) {

                if (guest.contains (name)) {
                    guest.remove (name);
                } else {
                    System.out.printf ("%s is not in the list!\n", name);
                }

            } else {

                if (guest.contains (name)) {
                    System.out.printf ("%s is already in the list!\n", name);
                } else {
                    guest.add (name);
                }
            }
        }

        for (String name : guest) {
            System.out.println (name);
        }
    }
}
