import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        StringBuilder stringBuilder = new StringBuilder ();

        for (int i = 0; i < 3; i++) {
            stringBuilder.append (scanner.nextLine ());
        }

        System.out.println (stringBuilder);
    }
}
