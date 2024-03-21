package room25;

import java.awt.Color;

public class Displayer {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";

    protected static void display(Room room) {
        String colorCode;
        if (room == null) {
            System.out.println("BBBBBBBBBB");
        }
        Color safetyColor = room.getSafetyColor();
        if (safetyColor == null) {
            System.err.println("AAAAAAAAAAA");
        }
        if (safetyColor.equals(Color.GREEN)) {
                colorCode = ANSI_GREEN;}
        else if (safetyColor.equals(Color.YELLOW)) {
                colorCode = ANSI_YELLOW;
        } else if (safetyColor.equals(Color.RED)) {
                colorCode = ANSI_RED;
        } else {
                colorCode = "\u001B[0m";
        }
        System.out.print(colorCode + '\u2588' + ANSI_RESET);
    }

    protected static void display(Complex complex) {
        for (Room[] roomRow : complex.getRooms()) {
            for (Room room : roomRow) {
                display(room);
            }
            System.out.println();
        }
    }

}
