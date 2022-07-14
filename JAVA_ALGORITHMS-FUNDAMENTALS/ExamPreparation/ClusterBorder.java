import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ClusterBorder {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader (new InputStreamReader (System.in));


        int[] singleShipTime = Arrays.stream (reader.readLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt).toArray ();

        int[] pairShipTime = Arrays.stream (reader.readLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt).toArray ();

        int[] memory = new int[singleShipTime.length + 1];

        memory[1] = singleShipTime[0];

        for (int i = 2; i < memory.length; i++) {
            memory[i] = Math.min (memory[i - 1] + singleShipTime[i - 1],
                    memory[i - 2] + pairShipTime[i - 2]);
        }

        System.out.println ("Optimal Time: " + memory[memory.length - 1]);

        List<String> result = new ArrayList<> ();

        for (int i = memory.length - 1; i > 0; i--) {
            if (memory[i] - memory[i - 1] == singleShipTime[i - 1]) {
                result.add ("Single " + i);
            } else {
                result.add ("Pair of " + (i - 1) + " and " + i);
                i--;
            }
        }

        for (int i = result.size () - 1; i >= 0; i--) {
            System.out.println (result.get (i));
        }

    }
}
