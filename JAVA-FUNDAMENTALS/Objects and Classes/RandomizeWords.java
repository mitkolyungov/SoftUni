import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> list = Arrays.stream (scanner.nextLine ().split (" "))
                .collect (Collectors.toList ());

        Collections.shuffle (list);

        list.forEach (System.out::println);
    }
}
