import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonthPrinterMain {
    public static void main(String[] args) throws IOException {
        var input =
                new BufferedReader (new InputStreamReader (System.in));

        String[] months = new String[12];

        months[0] = ("January");
        months[1] = ("February");
        months[2] = ("March");
        months[3] = ("April");
        months[4] = ("May");
        months[5] = ("June");
        months[6] = ("Juli");
        months[7] = ("August");
        months[8] = ("September");
        months[9] = ("October");
        months[10] = ("November");
        months[11] = ("December");

        int month = Integer.parseInt (input.readLine ()) - 1;

        if (month>=0 && month<=11){
            System.out.println (months[month]);
        }else {
            System.out.println ("Error!");
        }
    }
}
