package room25;

import room25.room.*; // get room constructors
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Room[] rooms = new Room[Complex.SIZE * Complex.SIZE -2];
        for (int i = 0; i < Complex.SIZE * Complex.SIZE - 2; i++) {
                switch (i % 3) {
                    case 0:
                        rooms[i] = new GreenRoom();
                        break;
                    case 1:
                        rooms[i] = new RedRoom();
                        break;

                    case 2:
                        rooms[i] = new YellowRoom();
                        break;
                    default:
                        break;
                }
        }

        Complex complex = new Complex(rooms);
        Scanner scanner = new Scanner(System.in);
        Boolean stop = false;

        while (!stop) {
            try {
                Displayer.display(complex);

                System.out.print("\ndirection ? (UP/DOWN/LEFT/RIGHT) : ");
                Direction direction = Direction.valueOf(scanner.nextLine().toUpperCase());

                System.out.print("\nrow/col (0/1/2/3/4) : ");
                int rowCol = Integer.parseInt(scanner.nextLine());
                complex.slide(rowCol, direction);
            } catch (Exception e) {
                stop = true;
            }
        }

        scanner.close();
    }
}
