import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationsWithRep {
    static int[] elements;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));

        n = Integer.parseInt (reader.readLine ());
        int k = Integer.parseInt (reader.readLine ());

        elements = new int[k];

        solve (0, 1);
    }

    private static void solve(int index, int start) {
        if (index == elements.length) {
            print (elements);
            return;
        }

        for (int i = start; i <= n; i++) {
            elements[index] = i;
            solve (index + 1, i);
        }
    }

    private static void print(int[] elements) {
        for (int element : elements) {
            System.out.print (element + " ");
        }
        System.out.println ();
    }
}
