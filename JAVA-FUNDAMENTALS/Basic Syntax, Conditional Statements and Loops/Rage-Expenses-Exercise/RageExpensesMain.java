import java.util.Scanner;

public class RageExpensesMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int lostGameCount = Integer.parseInt (scanner.nextLine ());
        double headsetPrice = Double.parseDouble (scanner.nextLine ());
        double mousePrice = Double.parseDouble (scanner.nextLine ());
        double keyboardPrice = Double.parseDouble (scanner.nextLine ());
        double displayPrice = Double.parseDouble (scanner.nextLine ());

        int brokenHeadSets = lostGameCount/2;
        int brokenMouses = lostGameCount/3;
        int brokenKeyboards = lostGameCount/6;
        int brokenDisplay = lostGameCount/12;

        double sum = brokenDisplay*displayPrice
                +brokenHeadSets*headsetPrice
                +brokenKeyboards*keyboardPrice
                +brokenMouses*mousePrice;

        System.out.printf ("Rage expenses: %.2f lv.",sum);
    }
}
