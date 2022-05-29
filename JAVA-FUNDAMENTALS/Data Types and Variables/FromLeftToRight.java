import java.util.Arrays;
import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int lines = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < lines; i++) {
            long[] numbers = Arrays.stream (scanner.nextLine ().split (" "))
                    .mapToLong (Long::parseLong).toArray ();

            if (numbers[0]>numbers[1]){
                System.out.println (sumOfDigits(numbers[0]));
            } else if (numbers[0]<numbers[1]) {
                System.out.println (sumOfDigits (numbers[1]));
            }else {
                System.out.println (sumOfDigits (numbers[1]));
            }
        }
    }

    private static long sumOfDigits(long number) {
        String string = String.valueOf (Math.abs (number));
        long sum = 0;
        for (int i = 0; i < string.length (); i++) {
            sum+=string.charAt (i)-'0';
        }
        return Math.abs (sum);
    }
}
