public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super (animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println ("Meowwww");
    }

    @Override
    public void eat(Food food) {
        foodEaten += food.quantity;
    }

    @Override
    public String toString() {
        return String.format ("%s[%s, %s, %s, %s, %d]",
                animalType, animalName, breed, df.format (animalWeight),
                livingRegion, foodEaten);
    }
}
