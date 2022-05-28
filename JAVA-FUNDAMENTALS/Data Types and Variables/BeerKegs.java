import java.util.Scanner;

public class BeerKegs {
    static final double PI = Math.PI;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        double maxVolume = 0;
        String finalName = "";
        for (int i = 0; i < n; i++) {
            String kegName = "";
            double volume = 0;
            kegName = scanner.nextLine ();
            double radius = Double.parseDouble (scanner.nextLine ());
            double height = Double.parseDouble (scanner.nextLine ());

            volume = PI * radius * radius * height;
            if (volume > maxVolume) {
                maxVolume = volume;
                finalName = kegName;
            }
        }

        System.out.println (finalName);
    }
}
