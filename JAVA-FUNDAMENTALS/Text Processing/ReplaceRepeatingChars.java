import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine ();

        StringBuilder stringBuilder = new StringBuilder ();
        stringBuilder.append (input.charAt (0));

        for (int i = 0; i < input.length () - 1; i++) {
            if (input.charAt (i) != input.charAt (i + 1)) {
                stringBuilder.append (input.charAt (i + 1));
            }
        }

        System.out.println (stringBuilder);
    }
}
