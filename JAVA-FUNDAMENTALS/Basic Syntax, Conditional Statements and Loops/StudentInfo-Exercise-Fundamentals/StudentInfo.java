import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentInfo {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        String[] info = new String[3];
        for (int i = 0; i < 3; i++) {
            String studentInfo = input.readLine ();
            info[i] = studentInfo;
        }


        System.out.printf ("Name: %s, Age: %d, Grade: %.2f", info[0], Integer.parseInt (info[1]), Double.parseDouble (info[2]));
    }
}
