import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        topNumbers (n);
    }

    private static void topNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            String number = String.valueOf (i);
            if (isSumDivisibleBy8 (number) && isOneOddDigit (number)) {
                System.out.println (number);
            }
        }
    }

    private static boolean isOneOddDigit(String number) {
        for (int i = 0; i < number.length (); i++) {
            if ((number.charAt (i) - '0') % 2 == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSumDivisibleBy8(String number) {
        int sum = 0;
        for (int i = 0; i < number.length (); i++) {
            sum += number.charAt (i) - '0';
        }

        return sum % 8 == 0;
    }
}
