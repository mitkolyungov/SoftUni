import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] strings = scanner.nextLine ().split (" ");

        System.out.println (sum (strings[0], strings[1]));
    }

    private static int sum(String string1, String string2) {
        int min = Math.min (string1.length (), string2.length ());
        int sum = 0;

        for (int i = 0; i < min; i++) {
            sum += string1.charAt (i) * string2.charAt (i);
        }

        if (string1.length () > string2.length ()) {
            for (int i = min; i < string1.length (); i++) {
                sum += string1.charAt (i);
            }
        } else if (string2.length () > string1.length ()) {
            for (int i = min; i < string2.length (); i++) {
                sum += string2.charAt (i);
            }
        }

        return sum;
    }
}
