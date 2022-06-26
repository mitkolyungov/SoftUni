import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NestedLoopsToRecursion {
    static int limit;

    static int[] elements;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System.in));

        limit = Integer.parseInt (bufferedReader.readLine ());

        elements = new int[limit];
        solve (0);
    }

    private static void solve(int number) {
        if (number == elements.length) {
            print (elements);
        } else {
            for (int i = 1; i <= limit; i++) {
                elements[number] = i;
                solve (number + 1);
            }
        }
    }

    private static void print(int[] elements) {
        for (int element : elements) {
            System.out.print (element + " ");
        }
        System.out.println ();
    }
}
