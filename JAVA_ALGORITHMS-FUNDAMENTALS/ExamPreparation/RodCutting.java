import java.util.Arrays;
import java.util.Scanner;

public class RodCutting {

    static int[] bestPrice;
    static int[] bestCombo;
    static int[] price;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        price = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt)
                .toArray ();

        int length = Integer.parseInt (scanner.nextLine ());

        bestCombo = new int[length + 1];
        bestPrice = new int[length + 1];

        System.out.println (cutRod (length));

        reconstructSolution (length);
    }

    private static int cutRod(int n) {
        if (bestPrice[n] > 0) return bestPrice[n];

        if (n == 0) return 0;

        int currentBest = bestPrice[n];

        for (int i = 1; i <= n; i++) {
            currentBest = Math.max (currentBest, price[i] + cutRod (n - i));
            if (currentBest > bestPrice[n]) {
                bestPrice[n] = currentBest;
                bestCombo[n] = i;
            }
        }

        return bestPrice[n];
    }

    private static void reconstructSolution(int n) {
        while (n - bestCombo[n] != 0) {
            System.out.print (bestCombo[n] + " ");
            n = n - bestCombo[n];
        }
        System.out.println (bestCombo[n]);
    }


}
