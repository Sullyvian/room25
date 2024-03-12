package room25;

public class Complex {

    private Room[][] rooms;
    private final int SIZE = 5;

    protected Room getRoom(int row, int col) {
        return this.rooms[row][col];
    }

    protected void slide(int rowCol, Direction dir) {
        Room tempRoom; // to store a overwritten room

        switch (dir) {
            case UP: {
                int col = rowCol;
                tempRoom = this.rooms[0][col];
                for (int row = 0; row < this.SIZE - 1; row++) {
                    this.rooms[row][col] = this.rooms[row + 1][col];
                }
                this.rooms[this.SIZE - 1][col] = tempRoom;
                break;
            }

            case DOWN: { // making our way from the bottom to the top
                int col = rowCol;
                tempRoom = this.rooms[this.SIZE - 1][col];
                for (int row = this.SIZE - 1; row > 0; row--) {
                    this.rooms[row][col] = this.rooms[row - 1][col];
                }
                this.rooms[0][col] = tempRoom;
                break;
            }

            case LEFT: {
                int row = rowCol;
                tempRoom = this.rooms[row][0];
                for (int col = 0; col < this.SIZE - 1; col++) {
                    this.rooms[row][col] = this.rooms[row][col + 1];
                }
                this.rooms[row][this.SIZE - 1] = tempRoom;
                break;
            }

            case RIGHT: { // making our way from the right to the left
                int row = rowCol;
                tempRoom = this.rooms[row][this.SIZE - 1];
                for (int col = this.SIZE - 1; col > 0; col--) {
                    this.rooms[row][col] = this.rooms[row][col - 1];
                }
                this.rooms[row][0] = tempRoom;
                break;
            }

            default:
                break;
        }
    }

}
