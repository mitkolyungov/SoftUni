import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    static class Person {
        String name;
        String id;
        int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format ("%s with ID: %s is %d years old.", getName (), getId (), getAge ());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Person> personList = new ArrayList<> ();

        String command = scanner.nextLine ();

        while (!command.equals ("End")) {
            String[] tokens = command.split ("\\s+");

            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.parseInt (tokens[2]);

            personList.add (new Person (name, id, age));

            command = scanner.nextLine ();
        }

        personList.stream ().sorted (Comparator.comparingInt (Person::getAge)).forEach (System.out::println);
    }
}
