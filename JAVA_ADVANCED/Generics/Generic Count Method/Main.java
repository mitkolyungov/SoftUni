import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        Box<Double> box = new Box ();

        for (int i = 0; i < n; i++) {
            Double element = Double.valueOf ((scanner.nextLine ()));
            box.add (element);
        }

        Double elementToCompare = Double.valueOf (scanner.nextLine ());
        System.out.println (box.getCountOfGreaterElementsThan (elementToCompare));
    }
}
