import java.util.Scanner;

public class NChooseKCount {

    static int n;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        n = Integer.parseInt (scanner.nextLine ());
        k = Integer.parseInt (scanner.nextLine ());


        System.out.println (possibleComp (n, k));
    }

    private static long possibleComp(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }

        return possibleComp (n - 1, k - 1) + possibleComp (n - 1, k);
    }
}
