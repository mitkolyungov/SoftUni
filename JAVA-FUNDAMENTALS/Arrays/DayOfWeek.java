import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> dayOfWeeks = new ArrayList<> ();

        int day = Integer.parseInt (scanner.nextLine ()) - 1;

        dayOfWeeks.add ("Monday");
        dayOfWeeks.add ("Tuesday");
        dayOfWeeks.add ("Wednesday");
        dayOfWeeks.add ("Thursday");
        dayOfWeeks.add ("Friday");
        dayOfWeeks.add ("Saturday");
        dayOfWeeks.add ("Sunday");

        if (day >= 0 && day <= 6) {
            System.out.println (dayOfWeeks.get (day));
        } else {
            System.out.println ("Invalid day!");
        }

    }
}
