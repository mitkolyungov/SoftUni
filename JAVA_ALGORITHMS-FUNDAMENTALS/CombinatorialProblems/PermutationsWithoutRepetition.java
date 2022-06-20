import java.util.Scanner;

public class PermutationsWithoutRepetition {

    static String[] set;
    static String[] permutes;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        set = scanner.nextLine ().split ("\\s+");

        permutes = new String[set.length];

        used = new boolean[set.length];

        permute (0);
    }

    private static void permute(int index) {
        if (index == set.length) {
            print (permutes);
            return;
        }

        for (int i = 0; i < set.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutes[index] = set[i];
                permute (index + 1);
                used[i] = false;
            }
        }
    }

    private static void print(String[] permutes) {
        System.out.println (String.join (", ", permutes));
    }
}
