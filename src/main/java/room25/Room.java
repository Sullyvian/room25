package room25;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {

    private String name;
    private State state;
    private List<Player> occupants;

    protected enum State {
        HIDDEN, VISIBLE, INACCESSIBLE
    }

    protected Room(String name) {
        this.name = name;
        this.state = State.HIDDEN;
        this.occupants = new ArrayList<>();
    }

    protected String getName() {
        return this.name;
    }

    protected State getState() {
        return this.state;
    }

    protected List<Player> getOccupants() {
        return this.occupants;
    }

    protected void addOccupant(Player player) {
        this.occupants.add(player);
    }

    protected void removeOccupant(Player player) {
        this.occupants.remove(player);
    }

}
