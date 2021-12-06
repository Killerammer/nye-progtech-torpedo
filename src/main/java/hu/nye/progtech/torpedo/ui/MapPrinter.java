package hu.nye.progtech.torpedo.ui;

import hu.nye.progtech.torpedo.model.MapVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapPrinter {

    /**
     * Outdated egy másik osztály miatt.
     */

    /*
    private static final Logger LOGGER = LoggerFactory.getLogger(MapPrinter.class);

    public void printMap(MapVO mapVO) {
        LOGGER.info("Printing map");
        System.out.print("   ");
        for (int i = 'A'; i <= 'J'; i++) {
            System.out.print((char) i + "  ");
        }
        System.out.println();
        for (int i = 0; i < mapVO.getMapLength(); i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < mapVO.getMapLength(); j++) {
                System.out.print((mapVO.getMap()[i][j]) ? "*  " : "_  ");
            }
            System.out.println();
        }
        System.out.println();
    }*/
}
