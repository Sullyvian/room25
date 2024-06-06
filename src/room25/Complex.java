package room25;

import room25.room.*;

import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

/*
 *  0  1  2  3  4
 *  5  6  7  8  9
 * 10 11 12 13 14
 * 15 16 17 18 19
 * 20 21 22 23 24
 */

public class Complex {

    private Room[][] rooms;
    public static final int SIZE = 5;

    /**
     * Construct a complex with the given rooms (no room25, no centralRoom)
     *
     * @param rooms array of rooms chosen by the player
     */
    protected Complex(Room[] rooms) {
        if (rooms.length != SIZE * SIZE - 2) {
            // TODO handle wrong number of rooms
        }
        shuffleRooms(rooms);
        placeRooms(rooms);
    }

    /**
     * Place rooms in the complex
     * CentralRoom is at the center of the complex.
     * Room25 is in one of 4 corners of the complex.
     *
     * @param rooms array of rooms chosen by the player (no room25, no centralRoom)
     */
    private void placeRooms(Room[] rooms) {
        this.rooms = new Room[SIZE][SIZE];
        for (int i = 0; i < SIZE * SIZE - 2; i++) {
            this.rooms[i / SIZE][i % SIZE] = rooms[i];
        }

        // place CentralRoom at center and move previous room to end
        this.rooms[SIZE - 1][SIZE - 2] = this.rooms[SIZE / 2][SIZE / 2];
        this.rooms[SIZE / 2][SIZE / 2] = new CentralRoom();

        // chose emplacement and place room25, move previous room to end
        int[] room25PossibleLocations = { 0, 1, 5, 3, 4, 9, 11, 15, 20, 21, 19, 23, 24 };
        int room25Location = room25PossibleLocations[(new Random()).nextInt(9)];
        this.rooms[SIZE - 1][SIZE - 1] = this.rooms[room25Location / SIZE][room25Location % SIZE];
        this.rooms[room25Location / SIZE][room25Location % SIZE] = new Room25();
    }

    /**
     * Shuffle rooms
     *
     * @param rooms array of rooms chosen by the player (no room25, no centralRoom)
     */
    private void shuffleRooms(Room[] rooms) {
        List<Room> roomList = Arrays.asList(rooms);
        Collections.shuffle(roomList);
        rooms = roomList.toArray(new Room[roomList.size()]);
    }

    protected Room getRoom(int row, int col) {
        return this.rooms[row][col];
    }

    protected void slide(int rowCol, Direction direction) {
        switch (direction) {
            case UP:
                slideUp(rowCol);
                break;

            case DOWN: // making our way from the bottom to the top
                slideDown(rowCol);
                break;

            case LEFT:
                slideLeft(rowCol);
                break;

            case RIGHT: // making our way from the right to the left
                slideRight(rowCol);
                break;

            default:
                // TODO handle excpetion
        }
    }

    private void slideUp(int col) {
        Room tempRoom = this.rooms[0][col];
        for (int row = 0; row < this.SIZE - 1; row++) {
            this.rooms[row][col] = this.rooms[row + 1][col];
        }
        this.rooms[this.SIZE - 1][col] = tempRoom;
    }

    private void slideDown(int col) {
        Room tempRoom = this.rooms[this.SIZE - 1][col];
        for (int row = this.SIZE - 1; row > 0; row--) {
            this.rooms[row][col] = this.rooms[row - 1][col];
        }
        this.rooms[0][col] = tempRoom;
    }

    private void slideLeft(int row) {
        Room tempRoom = this.rooms[row][0];
        for (int col = 0; col < this.SIZE - 1; col++) {
            this.rooms[row][col] = this.rooms[row][col + 1];
        }
        this.rooms[row][this.SIZE - 1] = tempRoom;
    }

    private void slideRight(int row) {
        Room tempRoom = this.rooms[row][this.SIZE - 1];
        for (int col = this.SIZE - 1; col > 0; col--) {
            this.rooms[row][col] = this.rooms[row][col - 1];
        }
        this.rooms[row][0] = tempRoom;
    }
}
