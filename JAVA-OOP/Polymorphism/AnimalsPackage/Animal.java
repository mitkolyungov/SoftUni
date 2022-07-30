package AnimalsPackage;

public abstract class Animal {
    protected String name;
    protected String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    abstract String explainSelf();

    @Override
    public String toString() {
        return String.format ("I am %s and my favourite food is %s%n",
                name, favouriteFood);
    }
}
