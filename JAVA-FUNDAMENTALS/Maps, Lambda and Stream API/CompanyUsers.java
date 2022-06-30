import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, List<String>> companyUsers = new LinkedHashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("End")) {
            String[] tokens = command.split ("->");

            String companyName = tokens[0].trim ();
            String employeeID = tokens[1].trim ();

            if (!companyUsers.containsKey (companyName)) {
                companyUsers.put (companyName, new ArrayList<> ());
            }

            if (companyUsers.get (companyName).contains (employeeID)) {
                command = scanner.nextLine ();
                continue;
            }
            companyUsers.get (companyName).add (employeeID);


            command = scanner.nextLine ();
        }

        for (Map.Entry<String, List<String>> entry : companyUsers.entrySet ()) {
            System.out.printf ("%s%n", entry.getKey ());
            for (String employeeId : entry.getValue ()) {
                System.out.printf ("-- %s%n", employeeId);
            }
        }


    }
}
