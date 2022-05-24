import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivisibleBy3Main {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        for (int i = 3; i < 100; i+=3) {
            System.out.println (i);
        }
    }
}
