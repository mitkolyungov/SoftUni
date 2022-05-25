import java.io.*;

public class PassedOrFailedMain {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        double grade = Double.parseDouble (input.readLine ());
        if (grade >= 3) {
            System.out.println ("Passed!");
        }else {
            System.out.println ("Failed!");
        }
    }
}

