import java.util.*;

public class EncryptSortAndPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());
        List<Character> vowels = Arrays.asList ('a', 'e', 'u', 'o', 'i', 'A', 'E', 'U', 'O', 'I');
        int[] numberSequence = new int[n];

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine ();

            int sum = 0;
            for (int j = 0; j < word.length (); j++) {

                char letter = word.charAt (j);
                if (vowels.contains (letter)) {
                    sum += letter * word.length ();
                } else {
                    sum += letter / word.length ();
                }
            }

            numberSequence[i] = sum;
        }


        Arrays.sort (numberSequence);

        for (int i : numberSequence) {
            System.out.println (i);
        }
    }
}
