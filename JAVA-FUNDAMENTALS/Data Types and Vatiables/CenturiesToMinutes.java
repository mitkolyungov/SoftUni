import java.math.BigInteger;
import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Integer n = scanner.nextInt ();

        int centuries = n;
        int years = centuries*100;
        double days = years*365.2422;
        double hours = days*24;
        double minutes = (hours*60);
        System.out.printf ("%d centuries = %d years = %.0f days " +
                "= %.0f hours = %.0f minutes",centuries,years,days,hours,minutes);
    }
}



