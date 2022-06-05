import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegatives {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt).collect (Collectors.toList ());


        numbers = numbers.stream ().filter (n -> n >= 0).collect (Collectors.toList ());
        Collections.reverse (numbers);

        if (numbers.isEmpty ()) {
            System.out.println ("empty");
        } else {
            numbers.forEach (e -> System.out.printf ("%d ", e));
        }


    }
}
