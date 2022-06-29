import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RawData {
    static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        Tire[] tire;

        public Car(String model, Engine engine, Cargo cargo, Tire[] tire) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tire = tire;
        }

        public String getModel() {
            return model;
        }

        public Engine getEngine() {
            return engine;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public Tire[] getTire() {
            return tire;
        }

    }

    static class Engine {
        int engineSpeed;
        int enginePower;

        public Engine(int engineSpeed, int enginePower) {
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
        }

        public int getEngineSpeed() {
            return engineSpeed;
        }

        public int getEnginePower() {
            return enginePower;
        }
    }

    static class Cargo {
        int cargoWeight;
        String cargoType;

        public Cargo(int cargoWeight, String cargoType) {
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
        }

        public String getCargoType() {
            return cargoType;
        }
    }

    static class Tire {
        double tirePressure;
        int tireAge;

        public Tire(double tirePressure, int tireAge) {
            this.tirePressure = tirePressure;
            this.tireAge = tireAge;
        }

        public double getTirePressure() {
            return tirePressure;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        List<Car> carList = new ArrayList<> ();

        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine ().split ("\\s+");

            String model = info[0];

            carList.add (new Car (model, createEngine (info)
                    , createCargo (info), createTires (info)));
        }

        String line = scanner.nextLine ();

        if (line.equals ("fragile")) {
            carList.stream ().filter (c -> c.getCargo ().getCargoType ().equals (line))
                    .filter (s -> Arrays.stream (s.getTire ()).anyMatch (t -> t.getTirePressure () < 1))
                    .forEach (s-> System.out.println (s.model));

        } else if (line.equals ("flamable")) {
            carList.stream ().filter (c -> c.getCargo ().getCargoType ().equals (line))
                    .filter (e -> e.getEngine ().getEnginePower () > 250)
                    .forEach (s-> System.out.println (s.model));
        }
    }

    private static Tire[] createTires(String[] info) {
        Tire[] tires = new Tire[4];
        int count = 0;
        for (int j = 5; j < info.length; j++) {
            double pressure = Double.parseDouble (info[j++]);
            int age = Integer.parseInt (info[j]);

            tires[count++] = new Tire (pressure, age);
        }

        return tires;
    }

    private static Cargo createCargo(String[] info) {
        int weight = Integer.parseInt (info[3]);
        String type = info[4];

        return new Cargo (weight, type);
    }

    private static Engine createEngine(String[] info) {
        int speed = Integer.parseInt (info[1]);
        int power = Integer.parseInt (info[2]);

        return new Engine (speed, power);
    }
}
