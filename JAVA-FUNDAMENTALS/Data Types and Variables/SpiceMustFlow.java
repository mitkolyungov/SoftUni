import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int startingYield = Integer.parseInt (scanner.nextLine ());
        int totalYield = 0;
        int totalConsumed = 0;
        int countDays = 0;

        while (startingYield >= 100) {
            countDays++;
            totalYield += startingYield;

            int crewConsumes = 26;
            int yieldDrops = 10;
            totalConsumed += crewConsumes;
            startingYield -= yieldDrops;
        }
        // additional 26 after the mine has been exhausted
        totalConsumed += 26;

        if (totalYield < totalConsumed) {
            System.out.println (countDays);
            // 0 yield
            System.out.println (0);
            return;
        }
        System.out.println (countDays);
        System.out.println (totalYield - totalConsumed);
    }
}
