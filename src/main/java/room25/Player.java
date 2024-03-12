package room25;

public abstract class Player {

    private Character character;

    private int posX;
    private int posY;

    /**
     * Create a player at pos 0,0 (central room).
     *
     * @param character the character of the player.
     */
    protected Player(Character character) {
        this.character = character;
        this.posX = 0;
        this.posY = 0;
    }

    protected int getPosX() {
        return this.posX;
    }

    protected int getPosY() {
        return this.posY;
    }

    public Character getCharacter() {
        return this.character;
    }

}
