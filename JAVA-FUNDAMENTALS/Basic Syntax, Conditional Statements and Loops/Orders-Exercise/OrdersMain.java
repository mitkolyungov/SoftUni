import java.util.Scanner;

public class OrdersMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int numberOfOrders = Integer.parseInt (scanner.nextLine ());
        double totalSum = 0;

        for (int i = 0; i < numberOfOrders; i++) {
            double pricePerCapsule = Double.parseDouble (scanner.nextLine ());
            int days = Integer.parseInt (scanner.nextLine ());
            int capsulesCount = Integer.parseInt (scanner.nextLine ());
            double sum = days * capsulesCount * pricePerCapsule;
            totalSum += sum;
            System.out.printf ("The price for the coffee is: $%.2f\n", sum);
        }

        System.out.printf ("Total: $%.2f", totalSum);

    }
}
