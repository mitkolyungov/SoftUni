import java.util.Arrays;
import java.util.Scanner;

public class MagicNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] integers = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();

        int sum = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < integers.length - 1; i++) {
            for (int j = i+1; j < integers.length ; j++) {
                if (integers[i] + integers[j] == sum) {
                    System.out.println (integers[i] + " " + integers[j]);
                }
            }
        }
    }
}
