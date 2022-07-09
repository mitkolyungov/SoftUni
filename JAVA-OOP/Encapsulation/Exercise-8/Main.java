import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] pizzaInfo = scanner.nextLine ().split (" ");

        String name = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt (pizzaInfo[2]);

        Pizza pizza;
        try {
            pizza = new Pizza (name, numberOfToppings);
        } catch (IllegalArgumentException ex) {
            System.out.println (ex.getMessage ());
            return;
        }

        String[] doughInfo = scanner.nextLine ().split (" ");

        String flourType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double doughWeight = Double.parseDouble (doughInfo[3]);

        try {
            Dough dough = new Dough (flourType, bakingTechnique, doughWeight);
            pizza.setDough (dough);
        } catch (IllegalArgumentException ex) {
            System.out.println (ex.getMessage ());
            return;
        }


        String command = scanner.nextLine ();

        while (!command.equalsIgnoreCase ("END")) {

            String[] toppingInfo = command.split (" ");

            String toppingName = toppingInfo[1];
            double toppingWeight = Double.parseDouble (toppingInfo[2]);

            try {
                Topping topping = new Topping (toppingName, toppingWeight);
                pizza.addTopping (topping);
            } catch (IllegalArgumentException ex) {
                System.out.println (ex.getMessage ());
                return;
            }

            command = scanner.nextLine ();
        }

        System.out.printf ("%s - %.2f"
                , pizza.getName (), pizza.getOverallCalories ());
    }
}
