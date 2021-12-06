package hu.nye.progtech.torpedo.model;

import java.util.Arrays;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "game_save")
public class CharacterMap {

    private int mapLength;
    private char[][] map;

    public CharacterMap(int mapLength, char[][] map) {
        this.mapLength = mapLength;
        this.map = map;
    }

    @Override
    public String toString() {
        return "charMap{" +
                "mapLength=" + mapLength +
                ", map=" + Arrays.toString(map) +
                '}';
    }

    public int getMapLength() {
        return mapLength;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

}
