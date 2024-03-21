package room25;

public class Complex {

    private Room[][] rooms;
    private final int SIZE = 5;

    protected Complex(Room[][] rooms) {
        this.rooms = rooms;
    }

    protected Room getRoom(int row, int col) {
        return this.rooms[row][col];
    }

    protected Room[][] getRooms() {
        return this.rooms;
    }

    protected int getSIZE() {
        return this.SIZE;
    }

    protected void slide(int rowCol, Direction direction){
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
