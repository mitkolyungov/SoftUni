import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName (name);
        this.players = new ArrayList<> ();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (!name.trim ().isEmpty ()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException ("A name should not be empty.");
        }
    }

    public void addPlayer(Player player) {
        this.players.add (player);
    }

    public void removePlayer(String name) {
        if (this.players.stream ().anyMatch (p -> p.getName ().equalsIgnoreCase (name))) {
            Player player = this.players.stream ()
                    .filter (p -> p.getName ().equalsIgnoreCase (name))
                    .findAny ().get ();

            this.players.remove (player);
        } else {
            throw new IllegalArgumentException ("Player " + name + " is not in " + this.name + " team.");
        }

    }

    public double getRating() {
        return this.players.stream ().map (Player::overallSkillLevel)
                .collect (Collectors.averagingDouble (n -> n));
    }

}
