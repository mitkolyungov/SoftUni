import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Set<String> uniqueNames = new LinkedHashSet<> ();

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine ();

            uniqueNames.add (name);
        }

        for (String uniqueName : uniqueNames) {
            System.out.println (uniqueName);
        }
    }

}
