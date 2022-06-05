import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());

        BigInteger bigInteger = new BigInteger ("1");

        for (int i = 2; i <= n; i++) {
            bigInteger = bigInteger.multiply (BigInteger.valueOf
                    (Integer.parseInt (String.valueOf (i))));
        }

        System.out.println (bigInteger);
    }
}
