package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.CharacterMap;

public class CharacterMapGenerator {

    /**
     * Alap karakter mapot generáltat.
     *
     * @param mapLength vagyis a map hossza.
     * @return visszaad egy új karakter mapot.
     */

    public CharacterMap generateMap(int mapLength) {
        char[][] map = new char[mapLength][mapLength];
        for (int i = 0; i < mapLength; i++) {
            for (int j = 0; j < mapLength; j++) {
                map[i][j] = '_';
            }
        }

        return new CharacterMap(mapLength, map);
    }

}
