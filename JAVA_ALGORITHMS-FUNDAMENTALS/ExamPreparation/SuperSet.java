import java.util.Arrays;
import java.util.Scanner;

public class SuperSet {
    static int[] elements;
    static int[] combination;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        elements = Arrays.stream (scanner.nextLine ().split (", "))
                .mapToInt (Integer::parseInt)
                .toArray ();

        for (int i = 1; i <= elements.length ; i++) {
            combination = new int[i];
            solve(0,1);
        }
    }

    private static void solve(int index, int start) {
        if (index == combination.length) {
            print ();
        } else {
            for (int i = start; i <= elements.length; i++) {
                combination[index] = elements[i-1];
                solve (index + 1, i + 1);
            }
        }
    }

    private static void print() {
        for (int element : combination) {
            System.out.print (element + " ");
        }
        System.out.println ();
    }
}
