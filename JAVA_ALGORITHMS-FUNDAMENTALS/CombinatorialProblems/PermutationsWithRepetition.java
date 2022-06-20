import java.util.HashSet;
import java.util.Scanner;

public class PermutationsWithRepetition {
    static String[] elements;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        elements = scanner.nextLine ().split ("\\s+");


        permute (0);
    }

    private static void permute(int index) {
        if (index >= elements.length) {
            print (elements);
            return;
        }
        permute (index + 1);

        HashSet<String> swapped = new HashSet<> ();
        swapped.add (elements[index]);

        for (int i = index + 1; i < elements.length; i++) {
            if (!swapped.contains (elements[i])) {
                swap (index, i);
                permute (index + 1);
                swap (index, i);
                swapped.add (elements[i]);
            }
        }
    }

    private static void swap(int index, int i) {
        String temp = elements[index];
        elements[index] = elements[i];
        elements[i] = temp;
    }

    private static void print(String[] elements) {
        System.out.println (String.join (" ", elements));
    }
}
