import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String command = scanner.nextLine ();
        double totalPrice = 0;

        while (!command.equals ("special") && !command.equals ("regular")) {
            double currentPrice = Double.parseDouble (command);

            if (currentPrice < 0) {
                System.out.println ("Invalid price!");
                command = scanner.nextLine ();
                continue;
            }

            totalPrice += currentPrice;

            command = scanner.nextLine ();
        }

        if (totalPrice == 0) {
            System.out.println ("Invalid order!");
            return;
        }

        System.out.println ("Congratulations you've just bought a new computer!");
        System.out.printf ("Price without taxes: %.2f$%n", totalPrice);
        System.out.printf ("Taxes: %.2f$%n", totalPrice * 0.2);
        System.out.println ("-----------");

        if (command.equals ("special")) {
            totalPrice *= 0.9;
        }

        System.out.printf ("Total price: %.2f$", totalPrice * 1.2);
    }
}
