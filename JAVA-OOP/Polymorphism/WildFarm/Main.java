import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Animal> animalList = new ArrayList<> ();

        String command = scanner.nextLine ();

        while (!command.equalsIgnoreCase ("End")) {
            
            Animal animal;
            Food food;

            String[] animalTokens = command.split ("\\s+");

            String animalType = animalTokens[0];
            String animalName = animalTokens[1];
            double animalWeight = Double.parseDouble (animalTokens[2]);
            String animalLivingRegion = animalTokens[3];

            switch (animalType) {
                case "Cat":
                    String catBreed = animalTokens[4];
                    animal = new Cat (animalType, animalName, animalWeight, animalLivingRegion, catBreed);
                    break;
                case "Mouse":
                    animal = new Mouse (animalType, animalName, animalWeight, animalLivingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra (animalType, animalName, animalWeight, animalLivingRegion);
                    break;
                default:
                    animal = new Tiger (animalType, animalName, animalWeight, animalLivingRegion);
                    break;
            }

            command = scanner.nextLine ();

            String[] foodTokens = command.split ("\\s+");

            String foodType = foodTokens[0];
            int foodQuantity = Integer.parseInt (foodTokens[1]);

            if (foodType.equals ("Vegetable")) {
                food = new Vegetable (foodQuantity);
            } else {
                food = new Meat (foodQuantity);
            }

            animal.makeSound ();
            animal.eat (food);

            animalList.add (animal);


            command = scanner.nextLine ();
        }

        for (Animal currentAnimal : animalList) {
            System.out.println (currentAnimal);
        }

    }
}
