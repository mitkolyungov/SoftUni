import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String number = scanner.nextLine ();
        String multiplayer =  (scanner.nextLine ());

        BigInteger bigInteger = new BigInteger (number);

        System.out.println (bigInteger.multiply (BigInteger.valueOf (Long.parseLong (multiplayer))));
    }
}
