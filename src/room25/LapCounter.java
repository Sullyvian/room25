package room25;

public class LapCounter {

    /**
     * Lap counter.
     * Starts at a negative and goes up till 0 is reached and game is over.
     */
    private int countdown;

    /**
     * The maximum number of laps.
     */
    private int maxNbOfLaps;

    /**
     * sliding window of players.
     */
    private Player[] players;

    /**
     * number of players in the game.
     */
    private int numPlayers;

    /**
     * Create a new Lap counter with players and initial countdown.
     * @param players players of the game.
     * @param initialCountdown initial countdown.
     */
    protected LapCounter(Player[] players, int initialCountdown) {
        this.countdown = initialCountdown;
        this.maxNbOfLaps = -initialCountdown;
        this.numPlayers = players.length;


        this.players = new Player[this.maxNbOfLaps + this.numPlayers - 1];
        for (int i = 0; i < this.numPlayers; i++) {
            this.players[i] = players[i];
        }
    }

    protected int getCountdown() {
        return this.countdown;
    }

    protected int getLap() {
        return this.maxNbOfLaps + this.countdown;
    }

    /**
     * Moves the rightmost player to the leftmost position in the next lap and
     * increments the lap counter.
     */
    protected void nextLap() {
        this.players[this.getLap() + 1] = this.players[this.getLap() - this.numPlayers + 1];
        this.players[this.getLap() - this.numPlayers + 1] = null;
        this.countdown++;
    }

}
