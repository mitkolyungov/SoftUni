package AnimalsPackage;

public class Dog extends Animal{
    public Dog(String name, String favouriteFood) {
        super (name, favouriteFood);
    }

    @Override
    String explainSelf() {
        return super.toString () + "DJAAF";
    }
}
