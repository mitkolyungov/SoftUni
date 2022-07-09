public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName (name);
        setAge (age);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.length () < 1) {
            throw new IllegalArgumentException ("Name cannot be empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException ("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay ();
    }

    private double calculateProductPerDay() {
        if (getAge () <= 5) {
            return 2.00;
        } else if (getAge () <= 10) {
            return 1.00;
        }
        return 0.75;
    }

    @Override
    public String toString() {
        return String.format ("Chicken %s (age %d) can produce %.2f eggs per day."
                , getName (), getAge (), calculateProductPerDay ());
    }
}
