import java.util.Scanner;

public class DecryptingMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int key = Integer.parseInt (scanner.nextLine ());
        int lines = Integer.parseInt (scanner.nextLine ());

        StringBuilder stringBuilder = new StringBuilder ();

        for (int i = 0; i < lines; i++) {
            int charCode = scanner.nextLine ().charAt (0);
            stringBuilder.append ((char) (charCode+key));
        }


        System.out.println (stringBuilder);

    }
}
