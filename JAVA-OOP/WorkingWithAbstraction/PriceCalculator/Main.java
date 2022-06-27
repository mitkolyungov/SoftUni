import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] info = scanner.nextLine ().split (" ");

        double pricePerDay = Double.parseDouble (info[0]);
        int days = Integer.parseInt (info[1]);
        Season season = Season.valueOf (info[2]);
        DiscountType discountType = DiscountType.valueOf (info[3]);

        PriceCalculator priceCalculator = new PriceCalculator (pricePerDay,days,season,discountType);

        System.out.printf ("%.2f",priceCalculator.getCalculatedPrice ());
    }
}
