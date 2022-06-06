import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        double[] nums = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToDouble (Double::parseDouble).toArray ();

        Map<Double, Integer> map = new TreeMap<> ();

        for (double num : nums) {
            map.putIfAbsent (num, 0);
            map.put (num, map.get (num) + 1);
        }

        for (Map.Entry<Double, Integer> entry : map.entrySet ()) {
            DecimalFormat df = new DecimalFormat ("0.#######");
            System.out.printf ("%s -> %d%n", df.format (entry.getKey ()), entry.getValue ());
        }
    }
}
