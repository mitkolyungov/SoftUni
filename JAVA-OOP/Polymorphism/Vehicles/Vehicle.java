import java.text.DecimalFormat;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    protected DecimalFormat df = new DecimalFormat ("##.##");

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String driving(double distance) {
        if (fuelQuantity >= distance * fuelConsumption) {
            fuelQuantity -= distance * fuelConsumption;
            return String.format ("%s travelled %s km",
                    this.getClass ().getSimpleName (), df.format (distance));
        }
        return String.format (this.getClass ().getSimpleName () + " needs refueling");
    }

    abstract void refueling(double liters);
}
