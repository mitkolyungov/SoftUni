import java.util.Scanner;

public class SpecialNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt ();

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int number = i;
            for (int j = 1; j <= String.valueOf (i).length (); j++) {
                sum += number % 10;
                number = number / 10;

            }

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf ("%d -> True\n", i);
            } else {
                System.out.printf ("%d -> False\n", i);
            }

        }
    }

}
