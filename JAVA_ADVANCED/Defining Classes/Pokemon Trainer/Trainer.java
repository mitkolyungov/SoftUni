import java.util.*;
import java.util.stream.Collectors;

public class Trainer implements Comparable<Trainer> {
    private String name;
    private int numberOfBadges;
    private Set<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new HashSet<> ();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void addBadges() {
        this.numberOfBadges++;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public int compareTo(Trainer trainer) {
        if (this.getNumberOfBadges () > trainer.getNumberOfBadges ()) {
            return 1;
        } else if (this.getNumberOfBadges () < trainer.getNumberOfBadges ()) {
            return -1;
        }
        return 0;
    }

    public void checkHealth() {
        setPokemons (this.pokemons.stream ()
                .filter (p -> p.getHealth () > 0)
                .collect (Collectors.toCollection (HashSet::new)));
    }
}

