import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        List<Person> persons = new ArrayList<> ();

        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine ().split (" ");

            String name = info[0];
            int age = Integer.parseInt (info[1]);

            persons.add (new Person (name, age));
        }

        persons.stream ().filter (p -> p.getAge () > 30)
                .forEach (p -> {
                    System.out.printf ("%s - %d%n"
                            , p.getName (), p.getAge ());
                });
    }
}
