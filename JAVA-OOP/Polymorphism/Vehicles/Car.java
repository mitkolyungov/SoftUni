import java.text.DecimalFormat;

public class Car extends Vehicle {

    private static double INCREASED_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super (fuelQuantity, fuelConsumption + INCREASED_FUEL_CONSUMPTION);
    }

    @Override
    void refueling(double liters) {
        fuelQuantity += liters;
    }

}
