import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine ();

        StringBuilder stringBuilder = new StringBuilder ();

        for (int i = 0; i < input.length (); i++) {
            char character = (char) (input.charAt (i) + 3);
            stringBuilder.append (character);
        }

        System.out.println (stringBuilder);
    }
}
