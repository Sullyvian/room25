package room25;

public class Game {

    /**
     * Compex of the game.
     */
    private Complex complex;

    /**
     * Players of the game.
     */
    private Player[] players;

    /**
     * Lap counter of the game.
     */
    private LapCounter lapCounter;

    protected Game(Complex complex, Player[] players, GameMode gameMode){
        this.complex = complex;
        this.players = players;
        // int t = gameMode.getLaps();
        // this.lapCounter = new LapCounter(this.players, t);
    }

    protected Room getRoom(int row, int col) {
        return this.complex.getRoom(row, col);
    }

}
