import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Person> people = new HashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equalsIgnoreCase ("end")) {
            String[] tokens = command.split ("\\s+");

            String personName = tokens[0];

            Person person = new Person (personName);
            people.putIfAbsent (personName,person);

            String info = tokens[1];
            if (info.equalsIgnoreCase ("company")) {

                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble (tokens[4]);

                people.get (personName).setCompany (new Company (companyName, department, salary));
            } else if (info.equalsIgnoreCase ("car")) {
                String carName = tokens[2];
                int speed = Integer.parseInt (tokens[3]);

                people.get (personName).setCar (new Car (carName, speed));
            } else if (info.equalsIgnoreCase ("pokemon")) {
                String pokemonName = tokens[2];
                String model = tokens[3];

                people.get (personName).getPokemons ().add (new Pokemon (pokemonName, model));
            } else if (info.equalsIgnoreCase ("parents")) {
                String name = tokens[2];
                String bDay = tokens[3];

                people.get (personName).getParents ().add (new Parents (name, bDay));
            } else if (info.equalsIgnoreCase ("children")) {
                String name = tokens[2];
                String bDay = tokens[3];

                people.get (personName).getChildren ().add (new Children (name, bDay));
            }


            command = scanner.nextLine ();
        }

        String person = scanner.nextLine ();

        System.out.println (people.get (person));
    }
}
