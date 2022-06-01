import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println (Arrays.stream (Arrays.stream (scanner.nextLine ().split ("\\s+"))
                        .mapToInt (Integer::parseInt).toArray ())
                .filter (e -> e % 2 == 0)
                .sum ());

    }
}
