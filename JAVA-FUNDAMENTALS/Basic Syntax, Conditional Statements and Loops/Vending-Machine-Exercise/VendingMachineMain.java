import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Double> acceptedCoins = List.of (0.1, 0.2, 0.5, 1.0, 2.0);

        Map<String, Double> products = new HashMap<> ();

        products.put ("Nuts", 2.0);
        products.put ("Water", 0.7);
        products.put ("Crisps", 1.5);
        products.put ("Soda", 0.8);
        products.put ("Coke", 1.0);

        String command = scanner.nextLine ();

        double insertedSum = 0;

        while (!command.equals ("Start")) {
            double insertedCoin = Double.parseDouble (command);
            if (acceptedCoins.contains (insertedCoin)) {
                insertedSum += insertedCoin;
            } else {
                System.out.printf ("Cannot accept %.2f\n", insertedCoin);
            }
            command = scanner.nextLine ();
        }

        double leftMoney = insertedSum;
        command = scanner.nextLine ();

        while (!command.equals ("End")) {
            String product = command;
            if (products.containsKey (product)) {
                double productPrice = products.get (product);
                if (productPrice <= leftMoney) {
                    System.out.println ("Purchased " + product);
                    leftMoney -= productPrice;
                } else {
                    System.out.println ("Sorry, not enough money");
                }
            } else {
                System.out.println ("Invalid product");
            }
            command = scanner.nextLine ();
        }

        System.out.printf ("Change: %.2f",leftMoney);
    }
}
