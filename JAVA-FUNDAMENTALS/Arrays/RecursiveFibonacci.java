import java.util.Scanner;

public class RecursiveFibonacci {
    static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());

        memory = new long[n + 1];
        memory[0] = 1;

        System.out.println (fibonacci (n - 1));
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        return memory[n] = fibonacci (n - 1) + fibonacci (n - 2);
    }
}
