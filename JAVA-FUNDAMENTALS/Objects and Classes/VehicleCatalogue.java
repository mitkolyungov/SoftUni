import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleCatalogue {
    static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        public Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        @Override
        public String toString() {
            return String.format ("Type: %s%n" +
                            "Model: %s%n" +
                            "Color: %s%n" +
                            "Horsepower: %d",
                    getType ().toUpperCase ().charAt (0) + getType ().substring (1)
                    , getModel (), getColor (), getHorsePower ());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String lines = scanner.nextLine ();

        List<Vehicle> vehicles = new ArrayList<> ();

        while (!lines.equals ("End")) {
            String[] tokens = lines.split ("\\s+");

            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int hp = Integer.parseInt (tokens[3]);

            vehicles.add (new Vehicle (type, model, color, hp));

            lines = scanner.nextLine ();
        }

        String command = scanner.nextLine ();

        while (!command.equals ("Close the Catalogue")) {
            String model = command;

            printModelInfo (vehicles, model);

            command = scanner.nextLine ();
        }

        getAverageHorsepower ("Car", vehicles);
        getAverageHorsepower ("Truck", vehicles);
    }

    private static void printModelInfo(List<Vehicle> vehicles, String model) {
        vehicles.stream ().filter (v -> v.getModel ().equals (model))
                .forEach (System.out::println);
    }

    private static PrintStream getAverageHorsepower(String type, List<Vehicle> vehicles) {
        return System.out.printf ("%ss have average horsepower of: %.2f.%n",
                type, vehicles.stream ().filter (v -> v.getType ()
                                .equalsIgnoreCase (type))
                        .collect (Collectors.averagingInt (v -> v.horsePower)));
    }
}
