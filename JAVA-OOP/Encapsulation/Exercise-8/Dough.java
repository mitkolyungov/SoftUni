import java.util.HashMap;
import java.util.Map;

public class Dough {

    private Map<String, Double> flourTypeMap = new HashMap<> () {{
        put ("White", 1.5);
        put ("Wholegrain", 1.0);
    }};

    private Map<String, Double> bakingTechniqueMap = new HashMap<> () {{
        put ("Crispy", 0.9);
        put ("Chewy", 1.1);
        put ("Homemade", 1.0);
    }};

    private final int CALORIES_PER_GRAM_BASE = 2;
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType (flourType);
        setBakingTechnique (bakingTechnique);
        setWeight (weight);
    }

    private void setFlourType(String flourType) {
        if (flourTypeMap.containsKey (flourType)) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException ("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechniqueMap.containsKey (bakingTechnique)) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException ("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 0 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException ("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories() {
        return CALORIES_PER_GRAM_BASE * weight
                * flourTypeMap.get (flourType)
                * bakingTechniqueMap.get (bakingTechnique);
    }
}
