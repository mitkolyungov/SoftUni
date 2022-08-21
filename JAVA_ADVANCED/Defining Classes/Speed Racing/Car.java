public class Car {
    private String model;
    private double fuelAmount;
    private double costPerKM;

    private int traveledDistance;

    public Car(String model, double fuelAmount, double costPerKM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.costPerKM = costPerKM;
        this.traveledDistance = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getCostPerKM() {
        return costPerKM;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setCostPerKM(double costPerKM) {
        this.costPerKM = costPerKM;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public void addDistance(int traveledDistance) {
        this.traveledDistance += traveledDistance;
    }

    public void beAbleToDrive(int distance) {
        if (getCostPerKM () * distance <= getFuelAmount ()) {

            setFuelAmount (getFuelAmount () - getCostPerKM () * distance);
            addDistance (distance);

        } else {
            System.out.println ("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format ("%s %.2f %d",
                getModel (), getFuelAmount (), getTraveledDistance ());
    }
}
