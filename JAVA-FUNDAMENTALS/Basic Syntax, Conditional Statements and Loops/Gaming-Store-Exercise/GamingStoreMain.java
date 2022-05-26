import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GamingStoreMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Double> info = new HashMap<> ();
        info.put ("OutFall 4", 39.99);
        info.put ("CS: OG", 15.99);
        info.put ("Zplinter Zell", 19.99);
        info.put ("Honored 2", 59.99);
        info.put ("RoverWatch", 29.99);
        info.put ("RoverWatch Origins Edition", 39.99);

        double totalBalance = Double.parseDouble (scanner.nextLine ());
        double currentBalance = totalBalance;
        String command = scanner.nextLine ();

        while (!command.equals ("Game Time")) {

            String game = command;

            if (info.containsKey (game)) {

                double gamePrice = info.get (game);

                if (gamePrice <= currentBalance) {
                    System.out.printf ("Bought %s\n", game);
                    currentBalance -= gamePrice;
                } else {
                    System.out.printf ("Too Expensive\n");
                    command = scanner.nextLine ();
                    continue;
                }
            } else {
                System.out.printf ("Not Found\n");
            }
            if (currentBalance == 0.0) {
                System.out.println ("Out of money!");
                return;
            }

            command = scanner.nextLine ();
        }

        System.out.printf ("Total spent: $%.2f. Remaining: $%.2f",
                totalBalance - currentBalance, currentBalance);

    }
}
