public class Mouse extends Mammal {


    public Mouse(String animalType, String animalName, double animalWeight, String livingRegion) {
        super (animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println ("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            foodEaten += food.quantity;
        }else {
            System.out.printf ("Mice are not eating that type of food!%n");
        }
    }
}
