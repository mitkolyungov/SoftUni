import java.util.Scanner;

public class TribonacciSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        int[] result = new int[n + 3];

        result[0] = 1;
        result[1] = 1;
        result[2] = 2;

        tribonacci (n - 1, result);
        print (n, result);
    }

    private static void print(int n, int[] result) {
        for (int i = 0; i < n; i++) {
            System.out.print (result[i] + " ");
        }
    }

    private static void tribonacci(int n, int[] result) {
        if (n > 2) {
            for (int i = 3; i < result.length; i++) {
                result[i] = result[i - 1] + result[i - 2] + result[i - 3];
            }
        }
    }
}
