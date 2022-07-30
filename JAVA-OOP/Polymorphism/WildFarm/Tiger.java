public class Tiger extends Felime{

    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super (animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println ("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            foodEaten += food.quantity;
        }else {
            System.out.printf ("%ss are not eating that type of food!%n",
                    this.getClass ().getSimpleName ());
        }
    }
}
