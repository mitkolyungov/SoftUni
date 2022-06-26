import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<String> books = Arrays.stream (scanner.nextLine ().split ("&")).collect (Collectors.toList ());

        String commands = scanner.nextLine ();

        while (!commands.equals ("Done")) {
            String[] tokens = commands.split (" [|] ");

            String command = tokens[0];
            String book = tokens[1];

            switch (command) {
                case "Add Book":
                    if (!books.contains (book)) {
                        books.add (0, book);
                    }
                    break;
                case "Take Book":
                    books.remove (book);
                    break;
                case "Swap Books":
                    String book2 = tokens[2];
                    if (books.contains (book2) && books.contains (book)) {
                        Collections.swap (books, books.indexOf (book), books.indexOf (book2));
                    }
                    break;
                case "Insert Book":
                    if (!books.contains (book)) {
                        books.add (book);
                    }
                    break;
                case "Check Book":
                    int index = Integer.parseInt (book);

                    if (index >= 0 && index < books.size ()) {
                        System.out.println (books.get (index));
                    }
                    break;
            }

            commands = scanner.nextLine ();
        }

        System.out.println (String.join (", ", books));
    }
}
