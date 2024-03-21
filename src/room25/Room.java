package room25;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public abstract class Room {

    private Safety safety;
    private String name;
    private State state;
    private List<Player> occupants;

    protected enum State {
        HIDDEN, VISIBLE, INACCESSIBLE
    }

    protected Room(String name, Safety safety) {
        this.name = name;
        this.state = State.HIDDEN;
        this.occupants = new ArrayList<>();
        this.safety = safety;
    }

    protected String getName() {
        return this.name;
    }

    protected State getState() {
        return this.state;
    }

    protected Color getSafetyColor() {
        return this.safety.getColor();
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

    protected static enum Safety {
        SAFE, OBSTACLE, MORTALDANGER, COMPLEX;

        protected Color getColor() {
            switch (this) {
                case SAFE:
                    return Color.GREEN;
                case OBSTACLE:
                    return Color.YELLOW;
                case MORTALDANGER:
                    return Color.RED;
                case COMPLEX:
                    return Color.BLUE;
                default:
                    // TODO handle this case
                    return Color.BLACK;
            }
        }
    }

}
