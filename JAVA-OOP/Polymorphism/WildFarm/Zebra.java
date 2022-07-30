public class Zebra extends Mammal {

    public Zebra(String animalType, String animalName, double animalWeight, String livingRegion) {
        super (animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println ("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            foodEaten += food.quantity;
        } else {
            System.out.printf ("%ss are not eating that type of food!%n",
                    this.getClass ().getSimpleName ());
        }
    }
}
