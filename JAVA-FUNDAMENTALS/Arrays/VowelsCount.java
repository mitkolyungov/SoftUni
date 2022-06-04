import java.util.*;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String string = scanner.nextLine ();

        System.out.println (vowelsCount (string.toLowerCase ()));

    }

    private static int vowelsCount(String string) {
        List<Character> vowels = Arrays.asList ('a', 'u', 'o', 'e', 'i');
        int count = 0;

        for (int i = 0; i < string.length (); i++) {
            if (vowels.contains (string.charAt (i))) {
                count++;
            }
        }

        return count;
    }
}
