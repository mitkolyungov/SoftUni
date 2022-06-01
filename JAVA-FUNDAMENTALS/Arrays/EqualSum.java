import java.util.Arrays;
import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] integers = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();

        if (integers.length == 1) {
            System.out.println (0);
            return;
        }

        for (int i = 0; i < integers.length; i++) {

            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += integers[j];
            }

            int rightSum = 0;
            for (int j = i + 1; j < integers.length; j++) {
                rightSum += integers[j];
            }

            if (leftSum == rightSum) {
                System.out.println (i);
                return;
            }
        }

        System.out.println ("no");
    }
}
