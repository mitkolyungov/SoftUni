import java.util.Scanner;

public class LoginMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String username = scanner.nextLine ();

        String password = reverseUsername (username);

        String command = scanner.nextLine ();

        int tries = 0;

        while (!command.equals (password)) {

            ++tries;

            if (tries == 4) {
                System.out.println ("User " + username + " blocked!");
                return;
            }
            System.out.println ("Incorrect password. Try again.");
            command = scanner.nextLine ();
        }
        System.out.println ("User " + username + " logged in.");
    }

    private static String reverseUsername(String username) {
        StringBuilder sb = new StringBuilder (username);
        sb.reverse ();
        return sb.toString ();
    }

}
