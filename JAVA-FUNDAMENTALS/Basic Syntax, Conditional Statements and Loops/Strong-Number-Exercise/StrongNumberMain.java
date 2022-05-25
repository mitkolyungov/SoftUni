import java.util.Scanner;

public class StrongNumberMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String number = (scanner.nextLine ());

        int sum = 0;
        int factorialSum = 1;

        for (int i = 0; i < number.length (); i++) {

            factorialSum = getFactorialSum (number, factorialSum, i);
            sum += factorialSum;
            factorialSum = 1;
        }

        if (Integer.parseInt (number) == sum) {
            System.out.println ("yes");
        } else {
            System.out.println ("no");
        }

    }

    private static int getFactorialSum(String number, int factorialSum, int i) {
        for (int j = 1; j <= Integer.parseInt (String.valueOf (number.charAt (i))); j++) {
            factorialSum *= j;
        }
        return factorialSum;
    }
}
