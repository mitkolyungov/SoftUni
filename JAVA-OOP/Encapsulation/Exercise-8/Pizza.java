import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        setName (name);
        setToppings (numberOfToppings);
        this.toppings = new ArrayList<> ();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (!name.trim ().isEmpty () && name.length () <= 15) {
            this.name = name;
        } else {
            throw new IllegalArgumentException ("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings >= 0 && numberOfToppings <= 10) {
            this.numberOfToppings = numberOfToppings;
        } else {
            throw new IllegalArgumentException ("Number of toppings should be in range [0..10].");
        }
    }

    public void addTopping(Topping topping) {
        setToppings (toppings.size () + 1);
        this.toppings.add (topping);
    }

    public double getOverallCalories() {
        double totalCalories = 0;

        for (Topping topping : this.toppings) {
            totalCalories += topping.calculateCalories ();
        }

        totalCalories += this.dough.calculateCalories ();

        return totalCalories;
    }
}
