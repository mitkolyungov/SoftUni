import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        BigDecimal bigDecimal = new BigDecimal (0);

        int numbers = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < numbers; i++) {
            BigDecimal number =  new BigDecimal (scanner.nextLine ());
            bigDecimal = bigDecimal.add (number);
        }

        System.out.println (bigDecimal);
    }
}
