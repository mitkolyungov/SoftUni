import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        Map<String, Car> carInfo = new LinkedHashMap<> ();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine ().split ("\\s+");

            String model = tokens[0];
            int fuelAmount = Integer.parseInt (tokens[1]);
            double costKM = Double.parseDouble (tokens[2]);

            carInfo.putIfAbsent (model, new Car (model, fuelAmount, costKM));
        }

        String command = scanner.nextLine ();

        while (!command.equalsIgnoreCase ("end")) {
            String[] tokens = command.split ("\\s+");

            if (tokens[0].equalsIgnoreCase ("drive")) {
                String model = tokens[1];
                int distance = Integer.parseInt (tokens[2]);

                Car car = carInfo.get (model);
                car.beAbleToDrive (distance);
            }

            command = scanner.nextLine ();
        }

        for (Car value : carInfo.values ()) {
            System.out.println (value);
        }
    }
}
