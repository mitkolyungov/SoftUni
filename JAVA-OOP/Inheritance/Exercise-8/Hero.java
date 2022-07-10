package hero;

public class Hero {
    protected String username;
    protected int level;

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    public Hero(String name, int age) {
        this.username = name;
        this.level = age;
    }

    @Override
    public String toString() {
        return String.format ("Type: %s Username: %s Level: %d",
                this.getClass ().getName (),
                this.getUsername (),
                this.getLevel ());
    }
}
