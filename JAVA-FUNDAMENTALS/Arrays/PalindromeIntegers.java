import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String integer = scanner.nextLine ();

        while (!integer.equals ("END")) {

            System.out.println (isPalindrome (integer.trim ()));

            integer = scanner.nextLine ();
        }
    }

    private static boolean isPalindrome(String integer) {

        for (int i = 0; i < integer.length () / 2; i++) {
            if (integer.charAt (i) != integer.charAt (integer.length () - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
