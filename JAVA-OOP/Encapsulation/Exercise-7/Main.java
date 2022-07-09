import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] input = scanner.nextLine ().split (";");

        Map<String, Person> peopleByName = new HashMap<> ();
        Map<String, Product> productByName = new HashMap<> ();

        for (String s : input) {
            String[] people = s.split ("=");
            String name = people[0];
            double money = Double.parseDouble (people[1]);

            try {
                Person person = new Person (name, money);
                peopleByName.putIfAbsent (name, person);
            } catch (IllegalArgumentException ex) {
                System.out.println (ex.getMessage ());
            }
        }

        input = scanner.nextLine ().split (";");

        for (String s : input) {
            String[] products = s.split ("=");
            String name = products[0];
            double cost = Double.parseDouble (products[1]);

            try {
                Product product = new Product (name, cost);
                productByName.putIfAbsent (name, product);
            } catch (IllegalArgumentException ex) {
                System.out.println (ex.getMessage ());
            }
        }

        String line;

        while (!"END".equals (line = scanner.nextLine ())) {
            String[] tokens = line.split ("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            if (!peopleByName.containsKey (personName)) {
                continue;
            }

            try {
                peopleByName.get (personName).buyProduct (productByName.get (productName));
                System.out.printf ("%s bought %s%n", personName, productName);

            } catch (IllegalArgumentException iae) {
                System.out.println (iae.getMessage ());
            }
        }

        for (Person value : peopleByName.values ()) {
            System.out.println (value.toString ());
        }
    }
}