import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, List<String>> courses = new LinkedHashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("end")) {
            String[] tokens = command.split (":");

            String courseName = tokens[0].trim ();
            String studentName = tokens[1].trim ();

            if (!courses.containsKey (courseName)) {
                courses.put (courseName, new ArrayList<> ());
            }

            courses.get (courseName).add (studentName);

            command = scanner.nextLine ();
        }

        for (Map.Entry<String, List<String>> entry : courses.entrySet ()) {
            System.out.printf ("%s: %d%n", entry.getKey (), entry.getValue ().size ());
            for (String student : entry.getValue ()) {
                System.out.printf ("-- %s%n", student);
            }
        }
    }
}
