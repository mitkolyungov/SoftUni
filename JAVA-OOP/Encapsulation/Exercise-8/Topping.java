import java.util.HashMap;
import java.util.Map;

public class Topping {

    private Map<String, Double> toppingMap = new HashMap<> () {{
        put ("Meat", 1.2);
        put ("Veggies", 0.8);
        put ("Cheese", 1.1);
        put ("Sauce", 0.9);
    }};
    private final int CALORIES_PER_GRAM_BASE = 2;
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType (toppingType);
        setWeight (weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingMap.containsKey (toppingType)) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException ("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 0 && weight <= 50) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException (toppingType + " weight should be in the range [1..50].");
        }
    }

    public double calculateCalories() {
        return CALORIES_PER_GRAM_BASE * weight * toppingMap.get (toppingType);
    }
}
