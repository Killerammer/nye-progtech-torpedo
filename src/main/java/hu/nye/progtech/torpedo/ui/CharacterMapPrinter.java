package hu.nye.progtech.torpedo.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharacterMapPrinter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CharacterMapPrinter.class);

    public void printMap(char[][] map) {
        LOGGER.info("Printing charactermap");
        System.out.print("   ");
        for (int i = 'A'; i <= 'J'; i++) {
            System.out.print((char) i + "  ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
