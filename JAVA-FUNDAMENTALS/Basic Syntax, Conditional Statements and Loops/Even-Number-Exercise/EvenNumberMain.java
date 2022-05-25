import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenNumberMain {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        int n = Integer.parseInt (input.readLine ());

        while (Math.abs (n%2) == 1) {
            System.out.println ("Please write an even number.");
            n = Integer.parseInt ((input.readLine ()));
        }
        System.out.printf ("The number is: %d", Math.abs (n));
    }
}
