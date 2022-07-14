import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MonkeyBusiness {
    public static int n;
    public static int[] expression;
    static StringBuilder stringBuilder = new StringBuilder ();
    public static int[] numbers;

    public static int counter = 0;

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader (new InputStreamReader (System.in));

        n = Integer.parseInt (reader.readLine ());

        expression = new int[n];
        numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        combine (0);

        System.out.print (stringBuilder.toString ());

        System.out.println ("Total Solutions: " + counter);
    }

    private static void combine(int index) {
        if (index >= expression.length) {
            print (expression);
        } else {
            expression[index] = numbers[index];
            combine (index + 1);
            expression[index] = -numbers[index];
            combine (index + 1);
        }
    }

    private static void print(int[] expression) {
        int sum = Arrays.stream (expression).sum ();

        if (sum == 0) {
            counter++;
            for (int number : expression) {
                String numberAsString = number > 0 ? "+" + number : String.valueOf (number);
                stringBuilder.append (numberAsString).append (" ");
            }
            stringBuilder.append (System.lineSeparator ());
        }
    }
}
