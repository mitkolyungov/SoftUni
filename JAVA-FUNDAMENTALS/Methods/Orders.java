import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String product = scanner.nextLine ();
        double quantity = Double.parseDouble (scanner.nextLine ());

        System.out.printf ("%.2f",calculatePrice (product, quantity));
    }

    private static double calculatePrice(String product, double quantity) {
        switch (product) {
            case "coffee":
                return quantity * 1.5;

            case "water":
                return quantity * 1;

            case "coke":
                return quantity * 1.4;

            case "snacks":
                return quantity * 2;
        }
        return -1;
    }
}
