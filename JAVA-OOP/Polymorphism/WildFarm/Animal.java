import java.text.DecimalFormat;

public abstract class Animal {

    protected String animalType;
    protected String animalName;
    protected double animalWeight;
    protected int foodEaten;

    protected DecimalFormat df = new DecimalFormat ("#.##");

    public Animal(String animalType, String animalName, double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);

}
