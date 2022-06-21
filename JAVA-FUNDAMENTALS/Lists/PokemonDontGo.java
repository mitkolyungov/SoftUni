import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> distances = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .map (Integer::parseInt).collect (Collectors.toList ());

        int sum = 0;
        int removedElementValue = 0;

        while (!distances.isEmpty ()) {
            int index = Integer.parseInt (scanner.nextLine ());

            if (index < 0) {

                removedElementValue = distances.remove (0);

                distances.add (0, distances.get (distances.size () - 1));

            } else if (index > distances.size () - 1) {

                removedElementValue = distances.remove (distances.size () - 1);

                distances.add (distances.get (0));

            } else {
                removedElementValue = distances.remove (index);
            }

            sum += removedElementValue;

            for (int i = 0; i < distances.size (); i++) {

                if (distances.get (i) > removedElementValue) {

                    distances.set (i, distances.get (i) - removedElementValue);

                } else if (distances.get (i) <= removedElementValue) {

                    distances.set (i, distances.get (i) + removedElementValue);

                }
            }
        }

        System.out.println (sum);
    }
}
