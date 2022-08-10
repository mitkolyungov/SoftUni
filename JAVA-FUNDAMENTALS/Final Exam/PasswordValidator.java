import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String password = scanner.nextLine ();

        StringBuilder sb = new StringBuilder (password);

        String command = scanner.nextLine ();

        while (!command.equals ("Complete")) {
            String[] tokens = command.split ("\\s+");

            String op = tokens[0];

            switch (op) {
                case "Make": {
                    String secondOp = tokens[1];
                    int index = Integer.parseInt (tokens[2]);

                    if (secondOp.equals ("Upper")) {
                        sb.replace (index, index + 1, String.valueOf ((char)(sb.charAt (index) - 32)));
                    } else if (secondOp.equals ("Lower")) {
                        sb.replace (index, index + 1, String.valueOf ((char)(sb.charAt (index) + 32)));
                    }

                    System.out.println (sb);

                    break;
                }
                case "Insert": {
                    int index = Integer.parseInt (tokens[1]);
                    String c = tokens[2];

                    sb.insert (index, c);

                    System.out.println (sb);
                    break;
                }
                case "Replace": {
                    String c = (tokens[1]);
                    int value = Integer.parseInt ((tokens[2]));

                    int total = c.charAt (0) + value;

                    char v = (char) total;

                    sb = new StringBuilder (sb.toString ().replace (c.charAt (0),v));

                    System.out.println (sb);
                    break;
                }
                case "Validation":
                    if (sb.length () < 8) {
                        System.out.println ("Password must be at least 8 characters long!");
                    }
                    if (!validLettersDigitsUnderscores (sb)) {
                        System.out.println ("Password must consist only of letters, digits and _!");
                    }
                    if (!upperLetter (sb)) {
                        System.out.println ("Password must consist at least one uppercase letter!");
                    }
                    if (!lowerLetter (sb)) {
                        System.out.println ("Password must consist at least one lowercase letter!");
                    }
                    if (!digits (sb)) {
                        System.out.println ("Password must consist at least one digit!");
                    }
            }

            command = scanner.nextLine ();
        }
    }

    private static boolean digits(StringBuilder sb) {
        for (int i = 0; i < sb.length (); i++) {
            if (Character.isDigit (sb.charAt (i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean lowerLetter(StringBuilder sb) {
        for (int i = 0; i < sb.length (); i++) {
            if (Character.isLowerCase (sb.charAt (i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean upperLetter(StringBuilder sb) {
        for (int i = 0; i < sb.length (); i++) {
            if (Character.isUpperCase (sb.charAt (i))) {
                return true;
            }
        }

        return false;
    }

    private static boolean validLettersDigitsUnderscores(StringBuilder sb) {
        for (int i = 0; i < sb.length (); i++) {
            char c = sb.charAt (i);

            if (!Character.isDigit (c)
                    && !Character.isAlphabetic (c)
                    && c != 95) {
                return false;
            }
        }
        return true;
    }
}
