import java.util.Scanner;

public class StringExplosion {
    static final Character explosion = '>';

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine ();

        StringBuilder stringBuilder = new StringBuilder ();

        for (int i = 0; i < input.length (); i++) {
            stringBuilder.append (input.charAt (i));
        }

        int power = -1;

        for (int i = 0; i < stringBuilder.length (); i++) {
            if (stringBuilder.charAt (i) != explosion) {
                continue;
            }
            power = stringBuilder.charAt (i + 1) - '0';
            for (int j = i + 1; j < j + power && j < stringBuilder.length (); j++) {
                if (stringBuilder.charAt (j) == explosion) {
                    power += stringBuilder.charAt (j + 1) - '0';
                    i += stringBuilder.charAt (j + 1) - '0';
                    continue;
                }
                stringBuilder.deleteCharAt (j);
                j--;
                power--;
            }
        }

        System.out.println (stringBuilder);
    }
}
