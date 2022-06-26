import java.util.Scanner;

public class TheBiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int biscuitsProducedPerDay = Integer.parseInt (scanner.nextLine ());
        int workersCount = Integer.parseInt (scanner.nextLine ());
        int biscuitsAnotherFactoryProduced = Integer.parseInt (scanner.nextLine ());

        int usualProduction = biscuitsProducedPerDay * workersCount * 20;
        double unusualProduction = Math.floor (biscuitsProducedPerDay * workersCount * 0.75) * 10;

        int totalProduction = usualProduction + (int) unusualProduction;

        System.out.printf ("You have produced %d biscuits for the past month.%n", totalProduction);


        if (totalProduction > biscuitsAnotherFactoryProduced) {
            double percentMore = (totalProduction - biscuitsAnotherFactoryProduced) * 1.0 / biscuitsAnotherFactoryProduced * 100.0;
            System.out.printf ("You produce %.2f percent more biscuits.%n", percentMore);
        } else {
            double difference = biscuitsAnotherFactoryProduced - totalProduction;
            double percentLess = difference / biscuitsAnotherFactoryProduced * 100.0;
            System.out.printf ("You produce %.2f percent less biscuits.%n", percentLess);
            ;
        }
    }
}
