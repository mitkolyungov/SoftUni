public abstract class Mammal extends Animal{
    protected String livingRegion;

    public Mammal(String animalType, String animalName, double animalWeight, String livingRegion) {
        super (animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return String.format ("%s[%s, %s, %s, %d]",
                animalType,animalName,df.format (animalWeight),
                livingRegion,foodEaten);
    }
}
