import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<> ();

        String command = scanner.nextLine ();

        while (!command.equalsIgnoreCase ("tournament")) {
            String[] tokens = command.split ("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt (tokens[3]);

            trainers.putIfAbsent (trainerName, new Trainer (trainerName));

            Pokemon pokemon = new Pokemon (pokemonName, element, health);

            trainers.get (trainerName).getPokemons ().add (pokemon);

            command = scanner.nextLine ();
        }

        command = scanner.nextLine ();

        while (!command.equalsIgnoreCase ("end")) {
            String element = command;

            for (Trainer trainer : trainers.values ()) {
                if (trainer.getPokemons ().stream ().map (Pokemon::getElement)
                        .anyMatch (e -> e.equals (element))) {

                    trainer.addBadges ();
                } else {
                    for (Pokemon pokemon : trainer.getPokemons ()) {
                        pokemon.setHealth (pokemon.getHealth () - 10);

                    }

                    trainer.checkHealth();
                }

            }
            command = scanner.nextLine ();
        }

        trainers.entrySet ().stream ()
                .sorted ((f, s) -> s.getValue ().compareTo (f.getValue ()))
                .forEach ((k) -> {

                    System.out.printf ("%s %d %d%n",
                            k.getKey (), k.getValue ().getNumberOfBadges ()
                            , k.getValue ().getPokemons ().size ());
                });
    }
}
