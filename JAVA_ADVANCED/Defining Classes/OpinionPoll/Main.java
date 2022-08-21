import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        List<Person> personList = new ArrayList<> ();

        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine ().split ("\\s+");

            String name = info[0];
            int age = Integer.parseInt (info[1]);

            personList.add (new Person (name, age));
        }

        personList.stream ()
                .filter (p -> p.getAge () > 30)
                .sorted (Comparator.comparing (Person::getName))
                .forEach (s -> {
                    System.out.println (s.getName () + " - " + s.getAge ());
                });
    }
}
