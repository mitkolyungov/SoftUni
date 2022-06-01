import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> array = Arrays.stream (scanner.nextLine ().split (" "))
                .map (String::valueOf)
                .collect (Collectors.toList ());

        int rotation = Integer.parseInt (scanner.nextLine ());

        Collections.rotate (array, array.size () - rotation);

        array.forEach (s -> {
            System.out.print (s + " ");
        });


    }
}
