import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private static double INCREASED_FUEL_CONSUMPTION = 1.6;
    private static double REFUELED_PERCENTAGES = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super (fuelQuantity, fuelConsumption + INCREASED_FUEL_CONSUMPTION);
    }

    @Override
    void refueling(double liters) {
        fuelQuantity += liters * REFUELED_PERCENTAGES;
    }
}
