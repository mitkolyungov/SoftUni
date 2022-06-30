import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String command = scanner.nextLine ();

        Map<String, List<String>> forceBook = new LinkedHashMap<> ();

        while (!command.equals ("Lumpawaroo")) {
            String[] tokens;
            if (command.contains ("|")) {
                tokens = command.split ("[|]");

                String forceSide = tokens[0].trim ();
                String forceUser = tokens[1].trim ();

                if (isSideValid (forceBook, forceSide)
                        && nonExistentUser (forceBook, forceUser)) {

                    createSide (forceBook, forceSide);
                    addUser (forceBook, forceUser, forceSide);

                } else if (nonExistentUser (forceBook, forceUser)) {

                    addUser (forceBook, forceUser, forceSide);
                }
            } else if (command.contains ("->")) {
                tokens = command.split ("->");

                String forceUser = tokens[0].trim ();
                String forceSide = tokens[1].trim ();

                if (!nonExistentUser (forceBook, forceUser)) {
                    removeUser (forceBook, forceUser);

                    if (isSideValid (forceBook, forceSide)) {
                        createSide (forceBook, forceSide);
                    }
                    addUser (forceBook, forceUser, forceSide);

                } else if (nonExistentUser (forceBook, forceUser)) {

                    if (isSideValid (forceBook, forceSide)) {
                        createSide (forceBook, forceSide);
                    }
                    addUser (forceBook, forceUser, forceSide);

                } else if (isSideValid (forceBook, forceSide)
                        && nonExistentUser (forceBook, forceUser)) {

                    createSide (forceBook, forceSide);
                    addUser (forceBook, forceUser, forceSide);
                }

                System.out.printf ("%s joins the %s side!%n"
                        , forceUser, forceSide);
            }
            command = scanner.nextLine ();
        }
        printOutput (forceBook);
    }

    private static void removeUser(Map<String, List<String>> forceBook, String forceUser) {
        forceBook.forEach ((key, value) -> value.removeIf (s -> s.equals (forceUser)));
    }

    private static void createSide(Map<String, List<String>> forceBook, String forceSide) {
        forceBook.put (forceSide, new ArrayList<> ());
    }

    private static void addUser(Map<String, List<String>> forceBook, String forceUser, String forceSide) {
        forceBook.get (forceSide).add (forceUser);
    }

    private static boolean nonExistentUser(Map<String, List<String>> forceBook, String forceUser) {
        return forceBook.values ().stream ().noneMatch (v -> v.contains (forceUser));
    }

    private static boolean isSideValid(Map<String, List<String>> forceBook, String forceSide) {
        return !forceBook.containsKey (forceSide);
    }

    private static void printOutput(Map<String, List<String>> forceBook) {
        forceBook.entrySet ()
                .stream ().filter (e -> e.getValue ().size () > 0)
                .forEach (entry -> {
                    System.out.printf ("Side: %s, Members: %d%n"
                            , entry.getKey (), entry.getValue ().size ());

                    for (String person : entry.getValue ()) {
                        System.out.printf ("! %s%n", person);
                    }

                });
    }
}
