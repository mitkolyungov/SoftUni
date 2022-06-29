import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSalesman {
    static class Car {
        String model;
        Engine engine;
        String weight;
        String color;

        public Car() {
            this.weight = "n/a";
            this.color = "n/a";
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format ("%s:%n" +
                            "  %s:%n" +
                            "    Power: %d%n" +
                            "    Displacement: %s%n" +
                            "    Efficiency: %s%n" +
                            "  Weight: %s%n" +
                            "  Color: %s"
                    , getModel (), getEngine ().getModel (), getEngine ().getPower ()
                    , getEngine ().getDisplacement (), getEngine ().getEfficiency ()
                    , getWeight (), getColor ());
        }
    }

    static class Engine {
        String model;
        int power;
        String displacement;
        String efficiency;

        public Engine() {
            this.displacement = "n/a";
            this.efficiency = "n/a";
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }

        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Engine> engineList = new ArrayList<> ();

        int n = Integer.parseInt (scanner.nextLine ());

        createEngines (scanner, engineList, n);

        List<Car> carList = new ArrayList<> ();

        int m = Integer.parseInt (scanner.nextLine ());

        createCars (scanner, engineList, carList, m);

        for (Car car : carList) {
            System.out.println (car);
        }
    }

    private static void createCars(Scanner scanner, List<Engine> engineList, List<Car> carList, int m) {
        for (int i = 0; i < m; i++) {
            String[] infoCar = scanner.nextLine ().split ("\\s+");

            Car car = new Car ();

            car.setModel (infoCar[0]);

            Engine engine = engineList.stream ().filter (s -> s.model.equals (infoCar[1]))
                    .findAny ().get ();

            car.setEngine (engine);
            setOptionalFieldsCar (infoCar, car);

            carList.add (car);
        }
    }

    private static void setOptionalFieldsCar(String[] infoCar, Car car) {
        if (infoCar.length == 3) {
            if (Character.isDigit (infoCar[2].charAt (0))) {
                car.setWeight (infoCar[2]);
            } else {
                car.setColor (infoCar[2]);
            }
        } else if (infoCar.length == 4) {
            car.setWeight (infoCar[2]);
            car.setColor (infoCar[3]);
        }
    }

    private static void createEngines(Scanner scanner, List<Engine> engineList, int n) {
        for (int i = 0; i < n; i++) {
            String[] infoEngine = scanner.nextLine ().split ("\\s+");

            Engine engine = new Engine ();

            engine.setModel (infoEngine[0]);
            engine.setPower (Integer.parseInt (infoEngine[1]));

            setOptionalFieldsEngine (infoEngine, engine);

            engineList.add (engine);
        }
    }

    private static void setOptionalFieldsEngine(String[] infoEngine, Engine engine) {
        if (infoEngine.length == 3) {
            if (Character.isLetter (infoEngine[2].charAt (0))) {
                engine.setEfficiency (infoEngine[2]);
            } else {
                engine.setDisplacement (infoEngine[2]);
            }
        } else if (infoEngine.length == 4) {
            engine.setDisplacement (infoEngine[2]);
            engine.setEfficiency (infoEngine[3]);
        }
    }
}
