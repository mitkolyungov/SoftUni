import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class TowerOfHanoi {

    static StringBuilder stringBuilder = new StringBuilder ();
    static Deque<Integer> source = new ArrayDeque<> ();
    static Deque<Integer> spare = new ArrayDeque<> ();
    static Deque<Integer> dest = new ArrayDeque<> ();
    static int steps = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        int disks = Integer.parseInt (reader.readLine ());

        for (int i = disks; i >= 1; i--) {
            source.push (i);
        }

        print ();

        solve (disks, source, dest, spare);

        System.out.println (stringBuilder.toString ());
        ;
    }

    private static void print() {
        stringBuilder.append (String.format ("Source: %s%nDestination: %s%nSpare: %s%n"
                        , getResultAsString (source), getResultAsString (dest), getResultAsString (spare)))
                .append (System.lineSeparator ());
    }

    private static String getResultAsString(Deque<Integer> deque) {
        return deque.stream ().sorted (Comparator.reverseOrder ())
                .map (String::valueOf)
                .collect (Collectors.joining (", "));
    }

    private static void solve(int disks, Deque<Integer> source, Deque<Integer> dest, Deque<Integer> spare) {
        if (disks == 1) {
            dest.push (source.pop ());
            stringBuilder.append ("Step #")
                    .append (steps++).append (": Moved disk")
                    .append (System.lineSeparator ());
            print ();
        } else {
            solve (disks - 1, source, spare, dest);
            solve (1, source, dest, spare);
            solve (disks - 1, spare, dest, source);
        }
    }

}
