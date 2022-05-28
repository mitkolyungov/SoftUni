import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        StringBuilder stringBuilder = new StringBuilder ();

        for (int i = 0; i < 3; i++) {
            stringBuilder.append (scanner.nextLine ());
            stringBuilder.append (" ");
        }

        System.out.println (stringBuilder.reverse ());
    }
}
