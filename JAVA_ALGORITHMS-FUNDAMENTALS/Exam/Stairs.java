import java.util.Scanner;

public class Stairs {
    static long[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int steps = scanner.nextInt ();

        numbers = new long[steps + 2];
        numbers[0] = 1;
        numbers[1] = 1;

        numberOfWays (steps);

        System.out.println (numbers[steps]);
    }

    private static long numberOfWays(int steps) {
        if (steps <= 1) {
            return 1;
        }

        if (numbers[steps] != 0) {
            return numbers[steps];
        }

        return numbers[steps] = numberOfWays (steps - 1) + numberOfWays (steps - 2);
    }
}
