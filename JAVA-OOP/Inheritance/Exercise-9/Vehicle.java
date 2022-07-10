package vehicle;

public class Vehicle {
    private final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    protected double fuelConsumption;
    protected double fuel;
    protected int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = getDEFAULT_FUEL_CONSUMPTION ();
    }

    public double getDEFAULT_FUEL_CONSUMPTION() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    protected void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
        if (getFuel () >= getFuelConsumption () * kilometers) {
            setFuel (getFuel () - getFuelConsumption () * kilometers);
        }
    }
}
