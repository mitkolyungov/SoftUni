import java.util.Scanner;

public class MessagesMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        StringBuilder stringBuilder = new StringBuilder ();

        for (int i = 0; i < n; i++) {
            String code = scanner.nextLine ();
            int numberLength = code.length ();
            int mainDigit = Character.getNumericValue (code.charAt (0));

            if (mainDigit == 0) {
                stringBuilder.append (" ");
                continue;
            }

            int offset = (mainDigit - 2) * 3;
            if (mainDigit == 8 || mainDigit == 9) {
                offset = offset + 1;
            }

            char letter = (char) (offset + numberLength - 1 + 97);
            stringBuilder.append (letter);
        }
        System.out.println (stringBuilder.toString ());
    }
}
