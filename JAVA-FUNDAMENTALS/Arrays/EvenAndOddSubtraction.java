import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] array = Arrays.stream(scanner.nextLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt).toArray ();

        int evenSum = Arrays.stream (array)
                .filter (e->e%2==0).sum ();

        int oddSum = Arrays.stream (array)
                .filter (e->e%2==1).sum ();


        System.out.println (evenSum-oddSum);
    }
}
