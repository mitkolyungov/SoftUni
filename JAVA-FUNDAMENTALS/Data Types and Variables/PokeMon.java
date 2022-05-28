import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int pokemonPower = Integer.parseInt (scanner.nextLine ());
        int distance = scanner.nextInt ();
        int exhaustionFactory = scanner.nextInt ();

        int originalValueOfN = pokemonPower;
        int targets = 0;

        while (pokemonPower >= distance) {

            if (pokemonPower == originalValueOfN / 2) {
                if (exhaustionFactory > 0) {
                    pokemonPower /= exhaustionFactory;
                    if (pokemonPower < distance) {
                        break;
                    }
                }
            }
            pokemonPower -= distance;
            targets++;
        }
        System.out.println (pokemonPower);
        System.out.println (targets);

    }
}
