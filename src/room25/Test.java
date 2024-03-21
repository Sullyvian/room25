package room25;

public class Test {

    public static void main(String[] args) {
        Room[][] rooms = new Room[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i+j)%2 == 0) {
                    rooms[i][j] = new GreenRoom();
                } else {
                    rooms[i][j] = new RedRoom();
                }
            }
        }

        Complex complex = new Complex(rooms);

        while (true) {
            Displayer.display(complex);

            System.out.print("\ndirection ? (UP/DOWN/LEFT/RIGHT) : ");
            Direction direction = Direction.valueOf(System.console().readLine());

            System.out.print("\nrow/col (0/1/2/3/4) : ");
            int rowCol = Integer.parseInt(System.console().readLine());
            complex.slide(rowCol, direction);
        }
    }
}
