import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String password = scanner.nextLine ();

        validPassword (password);
    }

    private static void validPassword(String password) {
        boolean length = validLength (password);
        boolean chars = validCharacters (password);
        boolean digits = validDigitsCount (password);


        if (length && chars && digits) {
            System.out.println ("Password is valid");
        }
    }

    private static boolean validDigitsCount(String password) {
        int count = 0;

        for (int i = 0; i < password.length (); i++) {
            if (Character.isDigit (password.charAt (i))) {
                count++;
            }
        }

        if (count < 2) {
            System.out.println ("Password must have at least 2 digits");
            return false;
        }

        return true;
    }


    private static boolean validCharacters(String password) {
        for (int i = 0; i < password.length (); i++) {
            if (!Character.isLetterOrDigit (password.charAt (i))) {
                System.out.println ("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    private static boolean validLength(String password) {
        if (password.length () < 6 || password.length () > 10) {
            System.out.println ("Password must be between 6 and 10 characters");
            return false;
        }
        return true;
    }
}
