import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortNumbersMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> numbers = new ArrayList<> ();

        for (int i = 0; i < 3; i++) {
            numbers.add (Integer.parseInt (scanner.nextLine ()));
        }

        numbers.sort (Comparator.reverseOrder ());

        for (Integer number : numbers) {
            System.out.println (number);
        }

    }
}
