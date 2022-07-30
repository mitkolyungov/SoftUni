import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] carInfo = scanner.nextLine ().split (" ");

        double fuelQuantityCar = Double.parseDouble (carInfo[1]);
        double fuelConsumptionCar = Double.parseDouble (carInfo[2]);
        Vehicle car = new Car (fuelQuantityCar, fuelConsumptionCar);

        String[] truckInfo = scanner.nextLine ().split (" ");

        double fuelQuantityTruck = Double.parseDouble (truckInfo[1]);
        double fuelConsumptionTruck = Double.parseDouble (truckInfo[2]);
        Vehicle truck = new Truck (fuelQuantityTruck, fuelConsumptionTruck);


        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine ().split (" ");

            String command = input[0];
            String vehicle = input[1];

            if (command.equals ("Drive")) {
                double distance = Double.parseDouble (input[2]);

                if (vehicle.equals ("Car")) {
                    System.out.println (car.driving (distance));
                } else if (vehicle.equals ("Truck")) {
                    System.out.println (truck.driving (distance));
                }
            } else if (command.equals ("Refuel")) {
                double liters = Double.parseDouble (input[2]);

                if (vehicle.equals ("Car")) {
                    car.refueling (liters);
                } else if (vehicle.equals ("Truck")) {
                    truck.refueling (liters);
                }
            }
        }

        System.out.printf ("Car: %.2f%n",car.fuelQuantity);
        System.out.printf ("Truck: %.2f%n",truck.fuelQuantity);
    }
}
