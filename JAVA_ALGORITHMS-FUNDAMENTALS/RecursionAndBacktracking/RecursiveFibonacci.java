import java.util.Scanner;

public class RecursiveFibonacci {
    static long[] storage;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int number = Integer.parseInt (scanner.nextLine ());

        storage = new long[number + 1];


        System.out.println (fibonacci (number));

    }

    private static long fibonacci(int number) {
        if (number <= 1) {
            return 1;
        }

        if (storage[number] != 0) {
            return storage[number];
        }

        return storage[number] = fibonacci (number - 1) + fibonacci (number - 2);
    }
}
