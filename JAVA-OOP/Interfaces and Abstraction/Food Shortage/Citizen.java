import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Citizen implements Identifiable, Buyer, Person {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;
    private Set<String> citizenName = new HashSet<> ();

    public Citizen(String name, int age, String id, String birthDate) {
        setName (name);
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = 0;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if (!citizenName.contains (name)) {
            this.name = name;
            citizenName.add (name);
        }
    }
}
