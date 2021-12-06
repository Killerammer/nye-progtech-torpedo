package hu.nye.progtech.torpedo.service;

import java.util.Random;

import hu.nye.progtech.torpedo.model.CharacterMap;
import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.ui.CharacterMapPrinter;

public class Enemy {

    MapGenerator mapGenerator = new MapGenerator();

    CharacterMapGenerator characterMapGenerator = new CharacterMapGenerator();

    MapVO playerMap = mapGenerator.generateMap(10);

    CharacterMap playerCharMap = characterMapGenerator.generateMap(10);

    CharacterMapPrinter characterMapPrinter = new CharacterMapPrinter();

    Random random = new Random();

    /**
     * Itt történnek az ellenség lépései.
     */

    public void turn() {

        int column;
        int row;

        do {
            row = random.nextInt(9);
            column = random.nextInt(9);
        } while ((playerCharMap.getMap()[row][column] == '+' || playerCharMap.getMap()[row][column] == 'X'));
        System.out.println("Enemy shot at " + (char) (column + 65) + "" + row);

        if (playerMap.getMap()[row][column]) {
            playerCharMap.getMap()[row][column] = '+';
            int hit = playerMap.getHit();
            playerMap.setHit(hit + 1);
            System.out.println("One of our ships has been hit!\nHits: " + playerMap.getHit());
        } else {
            playerCharMap.getMap()[row][column] = 'X';
        }

        characterMapPrinter.printMap(playerCharMap.getMap());
        if (playerMap.getHit() == 15) {
            System.out.println("The enemy sadly won.");
            System.exit(0);
        }
    }
}
