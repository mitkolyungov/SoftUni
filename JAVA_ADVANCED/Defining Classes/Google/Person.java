import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<> ();
        this.children = new ArrayList<> ();
        this.pokemons = new ArrayList<> ();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCompany() {
        if (this.company == null){
            return "";
        }
        return company;
    }

    public Person setCompany(Company company) {
        this.company = company;
        return this;
    }

    public Object getCar() {
        if (this.car == null){
            return "";
        }
        return car;
    }

    public Person setCar(Car car) {
        this.car = car;
        return this;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return String.format ("%s%n" +
                        "%s:%n" +
                        "%s" +
                        "%s:%n" +
                        "%s" +
                        "%s:%n" +
                        "%s" +
                        "%s:%n" +
                        "%s" +
                        "%s:%n" +
                        "%s",
                getName (),
                Company.class.getSimpleName (),
                getCompany (),
                Car.class.getSimpleName (),
                getCar (),
                Pokemon.class.getSimpleName (),
                print (getPokemons ()),
                Parents.class.getSimpleName (),
                print (getParents ()),
                Children.class.getSimpleName (),
                print (getChildren ()));
    }

    private <T> String print(List<T> objects) {
        StringBuilder sb = new StringBuilder ();

        for (T object : objects) {
            sb.append (object).append (System.lineSeparator ());
        }

        return sb.toString ();
    }
}
