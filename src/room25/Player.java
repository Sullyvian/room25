package room25;

public abstract class Player {

    private Character character;

    /**
     * Create a player at pos 0,0 (central room).
     *
     * @param character the character of the player.
     */
    protected Player(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return this.character;
    }

}
