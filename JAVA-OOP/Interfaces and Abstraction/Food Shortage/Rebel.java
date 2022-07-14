import java.util.HashSet;
import java.util.Set;

public class Rebel implements Person, Buyer {
    private String name;
    private int age;
    private String group;
    private int food;

    private Set<String> rebelName = new HashSet<> ();

    public Rebel(String name, int age, String group) {
        setName (name);
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    private void setName(String name) {
        if (!rebelName.contains (name)) {
            this.name = name;
            rebelName.add (name);
        }
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public int getAge() {
        return age;


    }
}
