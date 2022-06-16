import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int num1 = Integer.parseInt (scanner.nextLine ());
        int num2 = Integer.parseInt (scanner.nextLine ());
        int num3 = Integer.parseInt (scanner.nextLine ());

        System.out.println (findTheSign (num1, num2, num3));
    }

    private static String findTheSign(int num1, int num2, int num3) {
        int count = 0;

        if (num1 == 0 || num2 == 0 || num3 == 0) {
            return "zero";
        }

        if (num1 < 0) {
            count++;
        }

        if (num2 < 0) {
            count++;
        }

        if (num3 < 0) {
            count++;
        }

        return isNegative (count);
    }

    private static String isNegative(int count) {
        if (count % 2 == 0) {
            return "positive";
        }

        return "negative";
    }
}
