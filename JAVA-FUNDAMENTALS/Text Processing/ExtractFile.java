import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String path = scanner.nextLine ();

        System.out.printf ("File name: %s%n", path.substring (path.lastIndexOf ('\\') + 1, path.lastIndexOf ('.')));
        System.out.printf ("File extension: %s", path.substring (path.lastIndexOf ('.') + 1));
    }
}
