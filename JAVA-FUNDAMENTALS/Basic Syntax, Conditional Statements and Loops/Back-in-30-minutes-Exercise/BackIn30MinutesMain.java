import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackIn30MinutesMain {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        int hour = Integer.parseInt (input.readLine ());
        int minutes = Integer.parseInt (input.readLine ());

        int totalMinutes = hour * 60 + minutes + 30;
        hour = totalMinutes/60;
        minutes = totalMinutes%60;
        if (totalMinutes / 60 == 24) {
            hour = 0;
        }

        if (minutes < 10) {
            System.out.printf ("%d:0%d", hour, minutes);
        } else {
            System.out.printf ("%d:%d", hour, minutes);
        }
    }
}
