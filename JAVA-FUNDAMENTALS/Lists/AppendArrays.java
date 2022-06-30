
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> input = Arrays.stream (scanner.nextLine ().split ("\\|")).collect (Collectors.toList ());

        List<String> output = new ArrayList<> ();

        for (int i = input.size () - 1; i >= 0; i--) {

            String[] numbers = input.get (i).split ("\\s+");

            for (String number : numbers) {
                if (!number.equals ("")) {
                    output.add (number);

                }
            }
        }

        String print = output.toString ().trim ();
        System.out.println (print.replaceAll ("\\[|,|\\]", ""));
    }
}