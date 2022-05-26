import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        double britishPounds = Double.parseDouble (scanner.nextLine ());

        System.out.printf("%.3f",britishPounds*1.36);
    }
}
