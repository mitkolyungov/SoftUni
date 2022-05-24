import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PassedMain {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        double grade = input.read () * 1.0;

        if (grade >= 3) {
            System.out.println ("Passed!");
        }

    }
}
