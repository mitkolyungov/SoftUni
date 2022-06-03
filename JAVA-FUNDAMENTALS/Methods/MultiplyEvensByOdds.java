import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int number = Integer.parseInt (scanner.nextLine ());

        System.out.println (getEvenSum (number) * getOddSum (number));
    }

    private static int getOddSum(int number) {
        int sum = 0;
        String num = String.valueOf (Math.abs (number));
        for (int i = 0; i < num.length (); i++) {
            if (num.charAt (i) % 2 == 1) {
                sum += num.charAt (i) - '0';
            }
        }
        return (sum);
    }

    private static int getEvenSum(int number) {
        int sum = 0;
        String num = String.valueOf (Math.abs (number));
        for (int i = 0; i < num.length (); i++) {
            if (num.charAt (i) % 2 == 0) {
                sum += num.charAt (i) - '0';
            }
        }
        return (sum);
    }
}
